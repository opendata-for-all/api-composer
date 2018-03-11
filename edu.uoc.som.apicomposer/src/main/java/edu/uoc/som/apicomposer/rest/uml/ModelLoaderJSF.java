package edu.uoc.som.apicomposer.rest.uml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

import core.OpenAPIPackage;
import core.Root;
import edu.uoc.som.apicomposer.rest.util.ModelUtil;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;


@SessionScoped
public class ModelLoaderJSF  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    
    
    private ResourceSet resourceSet = null;
    private Resource globalModelResource = null;
    private Resource oDataProfileResource = null;
    private Model globalModel = null;
    private Map<String, Model> interModels = null;
    private Map<String, Root> openAPIModels = null;
    private Map<String, Swagger> swaggerModels = null;
    private Map<String,Properties> propertiesMap = null;
    private Properties configProperties = null;
    
    @Inject
    private ModelUtil modelUtil;
    

    @PostConstruct
    public void init() {
    	ClassLoader classLoader = getClass().getClassLoader();
	
    	configProperties = new Properties();
			 try {
				 configProperties.load(classLoader.getResource("config.properties").openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
			 
    	interModels = new HashMap<String, Model>();
    	openAPIModels = new HashMap<String, Root>();
    	swaggerModels = new HashMap<String, Swagger>();
    	propertiesMap = new HashMap<String, Properties>();
    	
		File odataProfileFile = new File(classLoader.getResource("imported/odata.profile.uml").getFile());
		File baseURIFolder = new File(classLoader.getResource("imported/").getFile());
		File globalModelFile = new File(configProperties.getProperty("upload.location")+File.separator+"global.uml");
		File primitiveType = new File(classLoader.getResource("imported/UMLPrimitiveTypes.library.uml").getFile());
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		resourceSet.getPackageRegistry().put(OpenAPIPackage.eNS_URI, OpenAPIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put("oas", new XMIResourceFactoryImpl());
		
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"), URI.createFileURI(odataProfileFile.getAbsolutePath()));
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"), URI.createFileURI(primitiveType.getAbsolutePath()));
URI baseUri = URI.createFileURI(baseURIFolder.getAbsolutePath());
		//		URI baseUri = URI.createURI(
//				"jar:file:/C:\\Users\\hamza\\work\\eclipse-oxygen\\eclipse\\plugins\\org.eclipse.uml2.uml.resources_5.3.0.v20170605-1616.jar!/");
		resourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
				baseUri.appendSegment("libraries").appendSegment(""));
		resourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
				baseUri.appendSegment("metamodels").appendSegment(""));
		resourceSet.getURIConverter().getURIMap().put(URI.createURI(UMLResource.PROFILES_PATHMAP),
				baseUri.appendSegment("profiles").appendSegment(""));
		globalModelResource = resourceSet.getResource(URI.createFileURI(globalModelFile.getAbsolutePath()), true);
		globalModel = (Model) globalModelResource.getContents().get(0);	
		oDataProfileResource = resourceSet.getResource(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"), true);
		Profile profile = (Profile) oDataProfileResource.getEObject("_pWtvsO-mEeaLcvwqpORGRg");
		if(!globalModel.isProfileApplied(profile))
		globalModel.applyProfile(profile);
		EAnnotation apiAnnotation = globalModel.getEAnnotation("api");
		if(apiAnnotation!= null)
		for(String apiName :Arrays.asList(apiAnnotation.getDetails().get("sources").split(" "))) {
			File apiUMLFile = new File(configProperties.getProperty("upload.location")+File.separator+apiName+".uml");
			File apiOASFile = new File(configProperties.getProperty("upload.location")+File.separator+apiName+".oas");
			File swaggerFile =new File(configProperties.getProperty("upload.location")+File.separator+apiName+".json");
			
			interModels.put(apiName,(Model) resourceSet.getResource(URI.createFileURI(apiUMLFile.getAbsolutePath()), true).getContents().get(0));
			openAPIModels.put(apiName, (Root) resourceSet.getResource(URI.createFileURI(apiOASFile.getAbsolutePath()), true).getContents().get(0));
			 swaggerModels.put(apiName, new SwaggerParser().read(swaggerFile.getAbsolutePath()));
			 
			 URL paramsURL= classLoader.getResource("params/"+apiName+".properties");
			 if(paramsURL != null) {
				 Properties properties = new Properties();
				 try {
					properties.load(paramsURL.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 propertiesMap.put(apiName, properties);
				 
			 }
		
		}
    	
    }

	public  String getNamespace () throws FileNotFoundException, IOException {
		Stereotype odService = modelUtil.getStereotypeByName("ODataProfile::ODService");
		if( globalModel.isStereotypeApplied(odService)){
			return (String) UMLUtil.getTaggedValue(globalModel,ModelUtil.getQualifiedName("ODService"), "schemaNamespace");
			
		}
		return null;
	}
	public List<Class> getAllEntityTypes() throws FileNotFoundException, IOException{
	
	List<Class> entityTypes = new ArrayList<Class>();
		for (Iterator<EObject> it = globalModel.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class) {
				Class clazz = (Class) child;
				if(clazz.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODEntitySet")))
				entityTypes.add(clazz);
			}
			
	}
		return entityTypes;
	}
	public List<Class> getAllEntitySets() throws FileNotFoundException, IOException{
		
	List<Class> entitySets = new ArrayList<Class>();
		for (Iterator<EObject> it = globalModel.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class) {
				Class clazz = (Class) child;
				if(clazz.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODEntitySet")))
					entitySets.add(clazz);
			}
			
	}
		return entitySets;
	}

    

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public Resource getGlobalModelResource() {
		return globalModelResource;
	}

	public void setGlobalModelResource(Resource globalModelResource) {
		this.globalModelResource = globalModelResource;
	}

	public Resource getOdataProfileResource() {
		return oDataProfileResource;
	}

	public void setOdataProfileResource(Resource odataProfileResource) {
		this.oDataProfileResource = odataProfileResource;
	}

	public Model getGlobalModel() {
		return globalModel;
	}

	public void setGlobalModel(Model globalModel) {
		this.globalModel = globalModel;
	}

	public Resource getoDataProfileResource() {
		return oDataProfileResource;
	}

	public void setoDataProfileResource(Resource oDataProfileResource) {
		this.oDataProfileResource = oDataProfileResource;
	}

	public Map<String, Model> getInterModels() {
		return interModels;
	}

	public void setInterModels(Map<String, Model> interModels) {
		this.interModels = interModels;
	}

	public Map<String, Root> getOpenAPIModels() {
		return openAPIModels;
	}

	public void setOpenAPIModels(Map<String, Root> openAPIModels) {
		this.openAPIModels = openAPIModels;
	}

	public Map<String, Swagger> getSwaggerModels() {
		return swaggerModels;
	}

	public void setSwaggerModels(Map<String, Swagger> swaggerModels) {
		this.swaggerModels = swaggerModels;
	}

	public Map<String,Properties> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(Map<String,Properties> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}
	
    
}