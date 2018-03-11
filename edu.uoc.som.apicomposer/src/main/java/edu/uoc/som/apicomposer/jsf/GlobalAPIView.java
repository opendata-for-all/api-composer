package edu.uoc.som.apicomposer.jsf;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmSchema;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import edu.uoc.som.apicomposer.rest.model.TreeNodeEntry;
import edu.uoc.som.apicomposer.rest.odata.ODataApplication;
import edu.uoc.som.apicomposer.rest.uml.ModelLoader;
import edu.uoc.som.apicomposer.rest.uml.ModelLoaderJSF;

 

@Named
@ViewScoped
public class GlobalAPIView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeNode globalAPI;
	

	@Inject
	private ModelLoaderJSF modelLoaderJSF; 
	
	private Model globalModel;
	private TreeNode umlTree;
 
    @PostConstruct
    public void init() {

    	globalModel = modelLoaderJSF.getGlobalModel();
    	umlTree = PrimeFacesUtils.createUMLTree(globalModel, new ArrayList<Element>());
         
      
    }
 


	
   
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public TreeNode getGlobalAPI() {
		return globalAPI;
	}

	public void setGlobalAPI(TreeNode globalAPI) {
		
		this.globalAPI = globalAPI;
	}

	public Model getGlobalModel() {
		return globalModel;
	}

	public void setGlobalModel(Model globalModel) {
		this.globalModel = globalModel;
	}

	public TreeNode getUmlTree() {
		
		return umlTree;
	}

	public void setUmlTree(TreeNode umlTree) {
		this.umlTree = umlTree;
	}
}