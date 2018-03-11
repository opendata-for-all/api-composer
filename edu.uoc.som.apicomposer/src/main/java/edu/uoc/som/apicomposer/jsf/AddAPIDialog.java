package edu.uoc.som.apicomposer.jsf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import core.Root;
import edu.uoc.som.apicomposer.rest.openapi.OpenAPIGenerator;
import edu.uoc.som.apicomposer.rest.uml.ClassDiagramGenerator;
import edu.uoc.som.apicomposer.rest.uml.GlobalModelGenerator;
import edu.uoc.som.apicomposer.rest.uml.ModelLoader;
import edu.uoc.som.apicomposer.rest.uml.ModelLoaderJSF;
import edu.uoc.som.apicomposer.rest.util.FileUtil;
import edu.uoc.som.apicomposer.rest.util.ODataUtil;

@Named
@ViewScoped
public class AddAPIDialog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String openAPIFileName;
	private boolean finishDisabled;
	private boolean backDisabled;
	private boolean nextDisabled;
	private UploadedFile openAPIFile;
	private JsonObject openAPIJson;
	private Root openAPIModel;
	private Model umlModel;
	private OpenAPIGenerator openAPIGenerator;
	private ClassDiagramGenerator classDiagramGenerator;
	private GlobalModelGenerator globalModelGenerator;
	private String apiName;
	private TreeNode umlTree;
	private TreeNode globalModelTree;
	private Properties configProperties;
	private Model globalModel;
	private List<String> types;
	private List<String> globalClasses;
	private String selectedElement;
	private String newType;
	private String newTypeName;
	private List<Element> newElements;
	private String selectedFirstClass;
	private String selectedSecondClass;
	private String selectedClass;
	private String selectedFirstProperty;
	private String selectedSecondProperty;
	private List<String> attributes;
	private boolean apiKey;
	
	@Inject
	private ModelLoaderJSF modelLoaderJSF;
	
	@Inject
	private ODataUtil odataUtil;
	
	@Inject
	private ComposedAPIsView composedAPIsView;
	
	@Inject
	private GlobalAPIView globalAPIView;

	@PostConstruct
	public void init() {
		modelLoaderJSF.init();
		configProperties = modelLoaderJSF.getConfigProperties();
		globalModel = modelLoaderJSF.getGlobalModel();
		openAPIFileName = "";
		apiName = "";
		finishDisabled = true;
		backDisabled = true;
		nextDisabled = false;
		openAPIGenerator = new OpenAPIGenerator();
		classDiagramGenerator = new ClassDiagramGenerator();
		globalModelGenerator = new GlobalModelGenerator(globalModel);
		openAPIFile = null;
		openAPIJson = null;
		openAPIModel = null;
		umlModel = null;
		umlTree = new DefaultTreeNode();
		globalModelTree = new DefaultTreeNode();
		types = new ArrayList<String>();
		globalClasses = new ArrayList<String>();
		newElements = new ArrayList<Element>();
		attributes = new ArrayList<String>();
		
	
		
	}

	public void handleFileUpload(FileUploadEvent event) {

		try {
			openAPIFile = event.getFile();
			openAPIFileName = event.getFile().getFileName();
			apiName = FilenameUtils.removeExtension(openAPIFileName);
			InputStream in = openAPIFile.getInputstream();
			Reader reader = new InputStreamReader(in, "UTF-8");
			JsonParser parser = new JsonParser();
			openAPIJson = parser.parse(reader).getAsJsonObject();
			openAPIModel = openAPIGenerator.createOpenAPIModelFromJson(openAPIJson);
			if(!openAPIModel.getApi().getSecurityDefinitions().isEmpty()) {
				 apiKey = true;
			}
			FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void generateModels() {
		openAPIModel = openAPIGenerator.createOpenAPIModelFromJson(openAPIJson);
		umlModel = classDiagramGenerator.generateClassDiagramFromOpenAPI(openAPIModel, apiName);
		umlModel = classDiagramGenerator.refine(umlModel);
		updateTypes();
	}
	private void updateTypes() {
		for(Type type :umlModel.getOwnedTypes())
			if(type instanceof Class || type instanceof DataType)
			types.add(type.getName());
	}
	public void saveNewType(ActionEvent event) {
		Type type = umlModel.getOwnedType(selectedElement);
		if(newType.equals("DataType")) {
			classDiagramGenerator.class2DataType(umlModel, (Class)type, newElements);
			umlTree = PrimeFacesUtils.createUMLTree(umlModel,newElements);
		}
	}
	public void saveNewTypeName(ActionEvent event) {
		Type type = umlModel.getOwnedType(selectedElement);
		type.setName(newTypeName);
		newElements.add(type);
			umlTree = PrimeFacesUtils.createUMLTree(umlModel,newElements);
		
	}
	private void updateGlobalModel() {
		globalModel = globalModelGenerator.addModel(umlModel, apiName);
	}

	public void cancel(ActionEvent event) {
		init();

	}

	public void addAPIKey(ActionEvent event) {
		apiKey = false;
		FacesMessage message = new FacesMessage("Succesful", "API key added");
		FacesContext.getCurrentInstance().addMessage(null, message);

	}
	public void save(ActionEvent event) {
		try {

			ExternalContext externalContext = (ExternalContext) FacesContext.getCurrentInstance().getExternalContext();
			FileUtil.saveFile(openAPIFile.getInputstream(),
					new File(configProperties.getProperty("upload.location") + File.separator + apiName + ".json"));
			FileUtil.saveFile(openAPIFile.getInputstream(),
					new File(externalContext.getRealPath("/resources/json") + File.separator + apiName + ".json"));
			FileUtil.saveOpenAPIModel(openAPIModel, URI.createFileURI(
					configProperties.getProperty("upload.location")+ File.separator + apiName + ".oas"));
			FileUtil.saveUMLModel(umlModel, URI.createFileURI(
					configProperties.getProperty("upload.location") + File.separator + apiName + ".uml"));
			odataUtil.applyProfile(globalModel);
			FileUtil.saveGlobalModel(globalModel);
			modelLoaderJSF.init();
			
			
			FacesMessage message = new FacesMessage("Succesful", "API added!");
			composedAPIsView.init();
			globalAPIView.init();
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String onFlowProcess(FlowEvent event) {
		if (event.getNewStep().equals("globalAPITab")) {
			finishDisabled = false;
			nextDisabled = true;
			updateGlobalModel();
			globalModelTree = PrimeFacesUtils.createUMLTree(globalModel, globalModelGenerator.getAddedElements());
			
		} else {
			finishDisabled = true;
			nextDisabled = false;
		}
		if (event.getNewStep().equals("dataModelTab") && event.getOldStep().equals("fileUploadTab")) {
			generateModels();
			umlTree = PrimeFacesUtils.createUMLTree(umlModel, newElements);
		}
		if (event.getNewStep().equals("fileUploadTab"))
			backDisabled = true;
		else
			backDisabled = false;

		return event.getNewStep();

	}

	public void mergeClasses(ActionEvent event) {
		globalModelGenerator.mergeClasses((Class)globalModel.getPackagedElement(selectedFirstClass),(Class)globalModel.getPackagedElement(selectedSecondClass));
		globalModelTree = PrimeFacesUtils.createUMLTree(globalModel, globalModelGenerator.getAddedElements());
	}
	public void mergeAttributes(ActionEvent event) {
		globalModelGenerator.mergeProperties((Class)globalModel.getPackagedElement(selectedClass),selectedFirstProperty, selectedSecondProperty);
		globalModelTree = PrimeFacesUtils.createUMLTree(globalModel, globalModelGenerator.getAddedElements());
	}
	public void classSelectionChanged(AjaxBehaviorEvent event)  {
		attributes = new ArrayList<String>();
		if(selectedClass != "") {
			Class clazz = (Class) globalModel.getPackagedElement(selectedClass);
			for(Property property : clazz.getOwnedAttributes()) {
				attributes.add(property.getName());
			}
		}
	}
	public String getOpenAPIFileName() {
		return openAPIFileName;
	}

	public void setOpenAPIFileName(String openAPIFileName) {
		this.openAPIFileName = openAPIFileName;
	}

	public boolean isFinishDisabled() {
		return finishDisabled;
	}

	public void setFinishDisabled(boolean finishDisabled) {
		this.finishDisabled = finishDisabled;
	}

	public boolean isBackDisabled() {
		return backDisabled;
	}

	public void setBackDisabled(boolean backDisabled) {
		this.backDisabled = backDisabled;
	}

	public boolean isNextDisabled() {
		return nextDisabled;
	}

	public void setNextDisabled(boolean nextDisabled) {
		this.nextDisabled = nextDisabled;
	}

	public UploadedFile getOpenAPIFile() {
		return openAPIFile;
	}

	public void setOpenAPIFile(UploadedFile openAPIFile) {
		this.openAPIFile = openAPIFile;
	}

	public TreeNode getUmlTree() {
		return umlTree;
	}

	public void setUmlTree(TreeNode umlTree) {
		this.umlTree = umlTree;
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}

	public Model getGlobalModel() {
		return globalModel;
	}

	public void setGlobalModel(Model globalModel) {
		this.globalModel = globalModel;
	}

	public TreeNode getGlobalModelTree() {
		return globalModelTree;
	}

	public void setGlobalModelTree(TreeNode globalModelTree) {
		this.globalModelTree = globalModelTree;
	}

	public GlobalModelGenerator getGlobalModelGenerator() {
		return globalModelGenerator;
	}

	public void setGlobalModelGenerator(GlobalModelGenerator globalModelGenerator) {
		this.globalModelGenerator = globalModelGenerator;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	


	public String getSelectedElement() {
		return selectedElement;
	}

	public void setSelectedElement(String selectedElement) {
		this.selectedElement = selectedElement;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public String getNewTypeName() {
		return newTypeName;
	}

	public void setNewTypeName(String newTypeName) {
		this.newTypeName = newTypeName;
	}

	public String getSelectedFirstClass() {
		return selectedFirstClass;
	}

	public void setSelectedFirstClass(String selectedFirstClass) {
		this.selectedFirstClass = selectedFirstClass;
	}

	public String getSelectedSecondClass() {
		return selectedSecondClass;
	}

	public void setSelectedSecondClass(String selectedSecondClass) {
		this.selectedSecondClass = selectedSecondClass;
	}

	public List<String> getGlobalClasses() {
		globalClasses = new ArrayList<String>();
		for(Type type :globalModel.getOwnedTypes())
			if(type instanceof Class )
				globalClasses.add(type.getName());
		return globalClasses;
	}

	public void setGlobalClasses(List<String> globalClasses) {
		this.globalClasses = globalClasses;
	}

	public String getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}

	public String getSelectedFirstProperty() {
		return selectedFirstProperty;
	}

	public void setSelectedFirstProperty(String selectedFirstProperty) {
		this.selectedFirstProperty = selectedFirstProperty;
	}

	public String getSelectedSecondProperty() {
		return selectedSecondProperty;
	}

	public void setSelectedSecondProperty(String selectedSecondProperty) {
		this.selectedSecondProperty = selectedSecondProperty;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	public boolean isApiKey() {
		return apiKey;
	}

	public void setApiKey(boolean apiKey) {
		this.apiKey = apiKey;
	}


}
