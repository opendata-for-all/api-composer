package edu.uoc.som.apicomposer.jsf;

import java.util.List;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import edu.uoc.som.apicomposer.rest.model.TreeNodeWithTracking;

public class PrimeFacesUtils {
	public static TreeNode createUMLTree(Model umlModel, List<Element> newElements) {
		TreeNode umlTree = new DefaultTreeNode(new TreeNodeWithTracking("Root", false), null);
		umlTree.setExpanded(true);
		if (umlModel != null) {
			
			DefaultTreeNode modelNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(umlModel),false), umlTree);
			for (PackageableElement packedElement : umlModel.getPackagedElements()) {

				if (packedElement instanceof org.eclipse.uml2.uml.Class) {
					Class clazz = (Class) packedElement;
					DefaultTreeNode classNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(clazz),newElements.contains(clazz)?true:false), modelNode);
					for (org.eclipse.uml2.uml.Property property : clazz.getOwnedAttributes()) {
						DefaultTreeNode propertyNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(property),newElements.contains(property)?true:false), classNode);
					}
				}
				if (packedElement instanceof DataType) {
					DataType dataType = (DataType) packedElement;
					DefaultTreeNode classNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(dataType),newElements.contains(dataType)?true:false), modelNode);
					for (org.eclipse.uml2.uml.Property property : dataType.getOwnedAttributes()) {
						DefaultTreeNode propertyNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(property),newElements.contains(property)?true:false), classNode);
					}
				}
				if (packedElement instanceof Association) {
					Association association = (Association) packedElement;
					DefaultTreeNode classNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(association),newElements.contains(association)?true:false), modelNode);
					for (org.eclipse.uml2.uml.Property ownedEnd : association.getOwnedEnds()) {
						DefaultTreeNode propertyNode = new DefaultTreeNode(new TreeNodeWithTracking(printUMLElement(ownedEnd),newElements.contains(ownedEnd)?true:false), classNode);
					}
				}
			}
		}
		return umlTree;
	}
	public static String printUMLElement(Element element) {
		String formatedName = "";
		if (element instanceof Model) {
			Model model = (Model) element;
			formatedName = "<Model> ";
			if (model.isSetName())
				formatedName += model.getName();
		}
		if (element instanceof Class) {
			Class clazz = (Class) element;
			formatedName = "<Class> ";
			if (clazz.isSetName())
				formatedName += clazz.getName();
		}
		if (element instanceof DataType) {
			DataType dataType = (DataType) element;
			formatedName = "<DataType> ";
			if (dataType.isSetName())
				formatedName += dataType.getName();
		}
		if (element instanceof Association) {
			Association association = (Association) element;
			formatedName = "<Association> ";
			if (association.isSetName())
				formatedName += association.getName();
		}
		if (element instanceof org.eclipse.uml2.uml.Property) {
			org.eclipse.uml2.uml.Property property = (org.eclipse.uml2.uml.Property) element;
			formatedName = "<Property> ";
			if (property.isSetName()) {
				formatedName += property.getName();

			}
			if (property.getType() != null) {
				formatedName += ": " + property.getType().getName();

			}
			if (property.getUpper() != 0 && property.getUpper() != 1) {
				formatedName += " [" + property.getLower() + ".."
						+ ((property.getUpper() == -1) ? "*" : property.getUpper()) + "]";
			}
		}
		return formatedName;

	}
}
