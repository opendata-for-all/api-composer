package edu.uoc.som.apicomposer.rest.odata;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.util.UMLUtil;

import edu.uoc.som.apicomposer.rest.uml.ModelLoader;
import edu.uoc.som.apicomposer.rest.util.ModelUtil;

@ApplicationScoped
public class ODataMapper implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<FullQualifiedName,Class> entityTypeMap = null;
	private Map<FullQualifiedName,DataType> complexTypeMap = null;
	private Map<String,FullQualifiedName> entitySetMap = null;
	private String namespace = null;
	private String containerName = null;
	private FullQualifiedName container = null;
	
	@Inject
	private ModelLoader modelLoader;
	
	@Inject
	private ModelUtil modelUtil;
	
	@PostConstruct
	private void init() {
		Model globalModel = modelLoader.getGlobalModel();
		entitySetMap = new HashMap<String, FullQualifiedName>();
		entityTypeMap = new HashMap<FullQualifiedName, Class>();
		complexTypeMap = new HashMap<FullQualifiedName, DataType>();
		
		try {
			if(globalModel.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODService"))) {
			namespace = (String) UMLUtil.getTaggedValue(globalModel, "ODataProfile::ODService", "schemaNamespace");
			containerName = (String) UMLUtil.getTaggedValue(globalModel, "ODataProfile::ODService", "entityContainerName");
			container = new FullQualifiedName(namespace,containerName);
		
		
		
		for (Iterator<EObject> it = globalModel.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class) {
				Class clazz = (Class) child;
				if(clazz.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODEntityType"))) {
					FullQualifiedName entityTypeQN = new FullQualifiedName(namespace,(String) UMLUtil.getTaggedValue(clazz, "ODataProfile::ODEntityType", "name"));
					entityTypeMap.put(entityTypeQN, clazz);
					if(clazz.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODEntitySet"))) {
						entitySetMap.put((String) UMLUtil.getTaggedValue(clazz, "ODataProfile::ODEntitySet", "name"), entityTypeQN);
					}
				}
				
				}
			if (child instanceof DataType) {
				DataType dataType = (DataType) child;
				if(dataType.isStereotypeApplied(modelUtil.getStereotypeByName("ODataProfile::ODComplexType"))) {
					FullQualifiedName complexTypeQN = new FullQualifiedName(namespace,(String) UMLUtil.getTaggedValue(dataType, "ODataProfile::ODComplexType", "name"));
					complexTypeMap.put(complexTypeQN, dataType);
				
				}
				
				}
			
		}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 
	public Map<FullQualifiedName, Class> getEntityTypeMap() {
		return entityTypeMap;
	}

	public void setEntityTypeMap(Map<FullQualifiedName, Class> entityTypeMap) {
		this.entityTypeMap = entityTypeMap;
	}

	public Map<String, FullQualifiedName> getEntitySetMap() {
		return entitySetMap;
	}

	public void setEntitySetMap(Map<String, FullQualifiedName> entitySetMap) {
		this.entitySetMap = entitySetMap;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public FullQualifiedName getContainer() {
		return container;
	}

	public void setContainer(FullQualifiedName contrainer) {
		this.container = contrainer;
	}

	public Map<FullQualifiedName,DataType> getComplexTypeMap() {
		return complexTypeMap;
	}

	public void setComplexTypeMap(Map<FullQualifiedName,DataType> complexTyepMap) {
		this.complexTypeMap = complexTyepMap;
	}
	
	public String getEntitySetName(FullQualifiedName fullQualifiedName) {
		for(Entry<String, FullQualifiedName> entry: entitySetMap.entrySet() ) {
			if(entry.getValue().equals(fullQualifiedName))
				return  entry.getKey();
		}
		return null;
		
	}
	  
}
