package edu.uoc.som.apicomposer.rest.uml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.jboss.weld.bean.NewManagedBean;

import edu.uoc.som.apicomposer.rest.util.ODataUtil;

public class GlobalModelGenerator implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Model globalModel;
private List<Element> addedElements;



public GlobalModelGenerator(Model globalModel) {
	this.setGlobalModel(globalModel);
	addedElements = new ArrayList<Element>();
	
}

public Model addModel(Model model, String modelName) {
	if(globalModel.getEAnnotation("api")  == null) {
		globalModel.createEAnnotation("api");
		globalModel.getEAnnotation("api").getDetails().put("sources", modelName);
		for (PackageableElement packedElement : model.getPackagedElements()) {

			if (packedElement instanceof DataType) {
				DataType dataType = (DataType) packedElement;
				DataType copy = EcoreUtil.copy(dataType);
				copy.getEAnnotations().clear();
				copy.createEAnnotation("api");
				copy.getEAnnotation("api").getDetails().put(modelName, dataType.getName());
				globalModel.getPackagedElements().add(copy);
				addedElements.add(copy);
				for(Property property: copy.getOwnedAttributes()) {
					property.getEAnnotations().clear();
					property.createEAnnotation("api");
					property.getEAnnotation("api").getDetails().put(modelName, property.getName());
					addedElements.add(property);
				}
				
			}
		}
		for (PackageableElement packedElement : model.getPackagedElements()) {

			if (packedElement instanceof org.eclipse.uml2.uml.Class) {
				Class clazz = (Class) packedElement;
				Class copy = EcoreUtil.copy(clazz);
				copy.getEAnnotations().clear();
				copy.createEAnnotation("api");
				copy.getEAnnotation("api").getDetails().put(modelName, clazz.getName());
				globalModel.getPackagedElements().add(copy);
				addedElements.add(copy);
				for(Property property: copy.getOwnedAttributes()) {
					property.getEAnnotations().clear();
					property.createEAnnotation("api");
					if(!(property.getType() instanceof PrimitiveType)) {
						property.setType(globalModel.getOwnedType(property.getType().getName()));
					}
					property.getEAnnotation("api").getDetails().put(modelName, property.getName());
					addedElements.add(property);
				}
				
			}
			if (packedElement instanceof Association) {
				Association association = (Association) packedElement;
				Association copy = EcoreUtil.copy(association);
				addedElements.add(copy);
				copy.getOwnedEnds().clear();
				for(Property property: association.getOwnedEnds()) {
				 Property propertyCopy = EcoreUtil.copy(property);
				 propertyCopy.setType(getClass(property.getType().getName()));
				 addedElements.add(propertyCopy);
				 copy.getOwnedEnds().add(propertyCopy);
				}
				globalModel.getPackagedElements().add(copy);
				copy.getEAnnotations().clear();
				copy.createEAnnotation("api");
				copy.getEAnnotation("api").getDetails().put(modelName, association.getName());
			}
		}
	}
	else {
		globalModel.getEAnnotation("api").getDetails().put("sources", globalModel.getEAnnotation("api").getDetails().get("sources")+" "+modelName);
		for (PackageableElement packedElement : model.getPackagedElements()) {

			if (packedElement instanceof org.eclipse.uml2.uml.Class) {
				if(getClass(packedElement.getName()) == null) {
				Class clazz = (Class) packedElement;
				Class copy = EcoreUtil.copy(clazz);
				copy.getEAnnotations().clear();
				copy.createEAnnotation("api");
				copy.getEAnnotation("api").getDetails().put(modelName, clazz.getName());
				addedElements.add(copy);
				globalModel.getPackagedElements().add(copy);
				for(Property property: copy.getOwnedAttributes()) {
					property.getEAnnotations().clear();
					property.createEAnnotation("api");
					property.getEAnnotation("api").getDetails().put(modelName, property.getName());
					addedElements.add(property);
				}
				}
				else {
					Class clazz = (Class) packedElement;
					Class globalClass = (Class) getClass(packedElement.getName());
				for(Property property : clazz.getOwnedAttributes()) {
					if(globalClass.getOwnedMember(property.getName()) == null) {
						Property copy = EcoreUtil.copy(property);
						copy.getEAnnotations().clear();
						copy.createEAnnotation("api");
						copy.getEAnnotation("api").getDetails().put(modelName, property.getName());
						globalClass.getOwnedAttributes().add(copy);
						addedElements.add(copy);
						
					}
				}
				}
		
			
			}
		
		}
		for (PackageableElement packedElement : model.getPackagedElements()) {
		if (packedElement instanceof Association) {
			Association association = (Association) packedElement;
			Association copy = EcoreUtil.copy(association);
			copy.getOwnedEnds().clear();
			addedElements.add(copy);
			for(Property property: association.getOwnedEnds()) {
			 Property propertyCopy = EcoreUtil.copy(property);
			 propertyCopy.setType(getClass(property.getType().getName()));
			 addedElements.add(propertyCopy);
			 copy.getOwnedEnds().add(propertyCopy);
			}
			globalModel.getPackagedElements().add(copy);
			copy.getEAnnotations().clear();
			copy.createEAnnotation("api");
			copy.getEAnnotation("api").getDetails().put(modelName, association.getName());
		}
		}
	}
	
	return globalModel;
}
private Type getClass(String className) {
	for(PackageableElement element : globalModel.getPackagedElements()) {
		if(element instanceof Class && element.getName().equals(className))
			return (Type) element;
	}
	return null;
}


public Model getGlobalModel() {
	return globalModel;
}
public void setGlobalModel(Model globalModel) {
	this.globalModel = globalModel;
}

public List<Element> getAddedElements() {
	return addedElements;
}

public void setAddedElements(List<Element> addedElements) {
	this.addedElements = addedElements;
}

public void mergeClasses(Class class1, Class class2) {
	for(Property property: class2.allAttributes())
		if(class1.getMember(property.getName()) == null) {
			class1.getOwnedAttributes().add(property);
			addedElements.add(property);
		}
	EcoreUtil.remove(class2);
	
	
}

public void mergeProperties(Class clazz, String selectedFirstProperty, String selectedSecondProperty) {
Property firstProperty = 	(Property) clazz.getMember(selectedFirstProperty);
Property secondProperty =(Property) clazz.getMember(selectedSecondProperty);
//TODO update annotations
EcoreUtil.remove(secondProperty);
}
}
