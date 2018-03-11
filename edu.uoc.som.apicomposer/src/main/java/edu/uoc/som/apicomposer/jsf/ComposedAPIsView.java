package edu.uoc.som.apicomposer.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmSchema;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

import edu.uoc.som.apicomposer.rest.model.TreeNodeEntry;
import edu.uoc.som.apicomposer.rest.odata.ODataApplication;
import edu.uoc.som.apicomposer.rest.uml.ModelLoader;
import edu.uoc.som.apicomposer.rest.uml.ModelLoaderJSF;

@Named
@ViewScoped
public class ComposedAPIsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuModel model;
	private String doc;
	private boolean renderDoc;
	private Model umlModel;
	private TreeNode umlTree;

	@Inject
	private ModelLoaderJSF modelLoaderJSF;



	@PostConstruct
	public void init() {

		model = new DefaultMenuModel();
		umlTree = new DefaultTreeNode();

		for (Entry<String, Model> entry : modelLoaderJSF.getInterModels().entrySet()) {

			DefaultSubMenu submenu = new DefaultSubMenu(entry.getKey());

			DefaultMenuItem viewDoc = new DefaultMenuItem("view");
			viewDoc.setCommand("#{composedAPIsView.showDoc}");
			viewDoc.setParam("api", entry.getKey());
			viewDoc.setUpdate("details");
			viewDoc.setOncomplete("Redoc.init('http://petstore.swagger.io/v2/swagger.json', {})");
			submenu.addElement(viewDoc);
//			submenu.addElement(visit);
//			submenu.addElement(delete);
			model.addElement(submenu);

		}

	}

	public MenuModel getModel() {
		return model;
	}

	public void showDoc(ActionEvent event) {
		renderDoc = true; 
	    MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
	   String api = menuItem.getParams().get("api").get(0);

    setDoc("http://localhost:8080/OpenDataForAll/resources/json/"+api+".json");
  umlModel =  modelLoaderJSF.getInterModels().get(api);
  umlTree = PrimeFacesUtils.createUMLTree(umlModel, new ArrayList<Element>());
		
	}
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public boolean isRenderDoc() {
		return renderDoc;
	}

	public void setRenderDoc(boolean renderDoc) {
		this.renderDoc = renderDoc;
	}

	public Model getUmlModel() {
		return umlModel;
	}

	public void setUmlModel(Model umlModel) {
		this.umlModel = umlModel;
	}

	public TreeNode getUmlTree() {
		return umlTree;
	}

	public void setUmlTree(TreeNode umlTree) {
		this.umlTree = umlTree;
	}
}