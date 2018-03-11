package edu.uoc.som.apicomposer.rest.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.EdmPrimitiveTypeKind;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import edu.uoc.som.apicomposer.rest.odata.ODataMapper;


@ApplicationScoped
public class ODataUtil implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private  ODataMapper oDataMapper;
	

	
	
	public static EdmPrimitiveTypeKind getODataPrimitiveTypeFromUMLPrimitiveType (PrimitiveType type) {
		
		if(UMLUtil.isBoolean(type))
			return EdmPrimitiveTypeKind.Boolean;
		if(UMLUtil.isInteger(type))
			return EdmPrimitiveTypeKind.Int64;
		if(UMLUtil.isString(type))
			return EdmPrimitiveTypeKind.String;
		if(UMLUtil.isReal(type))
			return EdmPrimitiveTypeKind.Double;
		return null;
	
	
}
	

	public  FullQualifiedName getODataQualifiedName(DataType dataType) throws FileNotFoundException, IOException {
		for(Entry<FullQualifiedName, DataType> entry: oDataMapper.getComplexTypeMap().entrySet()) {
			if(entry.getValue().equals(dataType))
				return entry.getKey();
		}
		return null;
	}
	public  FullQualifiedName getODataQualifiedName(org.eclipse.uml2.uml.Class clazz) throws FileNotFoundException, IOException {
		for(Entry<FullQualifiedName, org.eclipse.uml2.uml.Class> entry: oDataMapper.getEntityTypeMap().entrySet()) {
			if(entry.getValue().equals(clazz))
				return entry.getKey();
		}
		return null;
	}
	
	public void applyProfile(Model model) throws FileNotFoundException, IOException{
		applyODServiceStereotype(model);
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class) {
				Class clazz = (Class) child;
				applyODEntityType(clazz);
				applyODEntitySet(clazz);
				
			}
			if (child instanceof Property) {
				Property property = (Property) child;
				applyODProperty(property);
				applyODataNavigationProperty(property);
				applyODataNavigationPropertyBinding(property);
				
			}
			if(child instanceof DataType){
				DataType dataType = (DataType) child;
				if(child instanceof PrimitiveType)
					applyODPrimitiveType(dataType);
				else 
					if (child instanceof Enumeration)
						applyODEnumType(dataType);
					else
						applyODComplexType(dataType);
			}
			
		}
	
	//resolve basetype
	
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class ) {
				Class clazz = (Class) child;
				resolveBaseType(clazz);
				
			}
		
	}
	}
	
	public  void applyODServiceStereotype(Package pkg) throws FileNotFoundException, IOException {
		Stereotype odService = pkg.getApplicableStereotype("ODataProfile::ODService");
		if (!pkg.isStereotypeApplied(odService)) {
			pkg.applyStereotype(odService);
			UMLUtil.setTaggedValue(pkg, odService, "version", "4.0");
			UMLUtil.setTaggedValue(pkg, odService, "entityContainerName", "ODAService");
			UMLUtil.setTaggedValue(pkg, odService, "schemaNamespace", "com.opendataforall");
			UMLUtil.setTaggedValue(pkg, odService, "schemaAlias", "oda");
		}

	}

	public  void applyODEntityType(org.eclipse.uml2.uml.Class clazz) throws FileNotFoundException, IOException {
		Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntityType");
		if (!clazz.isStereotypeApplied(stereotype)) {
			clazz.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(clazz, stereotype, "name", clazz.getName());
			if (clazz.isAbstract()) {
				UMLUtil.setTaggedValue(clazz, stereotype, "abstract", true);
			}

		}
	}
	public void applyODComplexType(DataType dataType) throws FileNotFoundException, IOException {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODComplexType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(dataType, stereotype, "name", dataType.getName());
			if (dataType.isAbstract()) {
				UMLUtil.setTaggedValue(dataType, stereotype, "abstract", true);
			}

		}
	}
	public  void applyODEnumType(DataType dataType) throws FileNotFoundException, IOException {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODEnumType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(dataType, stereotype, "name", dataType.getName());
		}
	}
	public  void applyODPrimitiveType(DataType dataType) throws FileNotFoundException, IOException {
		Stereotype stereotype = dataType.getApplicableStereotype("ODataProfile::ODPrimitiveType");
		if (!dataType.isStereotypeApplied(stereotype)) {
			dataType.applyStereotype(stereotype);
		
		}
	}


	public void applyODEntitySet(org.eclipse.uml2.uml.Class clazz) throws FileNotFoundException, IOException {
		Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntitySet");
		if (!clazz.isStereotypeApplied(stereotype)) {
			clazz.applyStereotype(stereotype);
			UMLUtil.setTaggedValue(clazz, stereotype, "name", getPlural(clazz.getName()));

		}
	}

	

	public void applyODProperty(Property property) throws FileNotFoundException, IOException {
		if (property.getAssociation() == null && !property.isID()) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODProperty");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				if (property.getLower() == 1)
					UMLUtil.setTaggedValue(property, stereotype, "nullable", false);
				else 
					UMLUtil.setTaggedValue(property, stereotype, "nullable", true);
				if (property.getDefault() != null)
					UMLUtil.setTaggedValue(property, stereotype, "defaultValue", property.getDefault());
			}
		}
	}

	public  void applyODKey(Property property) throws FileNotFoundException, IOException {
		if(property.getAssociation() == null && property.isID()){
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODKey");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				
	
	}
}
	}
	
	public void applyODataNavigationProperty(Property property) throws FileNotFoundException, IOException {
		if (property.getAssociation() != null) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODNavigationProperty");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "name", property.getName());
				if (property.getLower() == 1)
					UMLUtil.setTaggedValue(property, stereotype, "nullable", false);
				else
					UMLUtil.setTaggedValue(property, stereotype, "nullable", true);
				if(property.getAggregation().equals(AggregationKind.COMPOSITE_LITERAL))
					UMLUtil.setTaggedValue(property, stereotype, "containsTarget", true);
				
			}
		}
	}
	
	public void applyODataNavigationPropertyBinding(Property property) throws FileNotFoundException, IOException {
		if (property.getAssociation() != null) {
			Stereotype stereotype = property.getApplicableStereotype("ODataProfile::ODNavigationPropertyBinding");
			if (!property.isStereotypeApplied(stereotype)) {
				property.applyStereotype(stereotype);
				UMLUtil.setTaggedValue(property, stereotype, "path", property.getName());
			}
		}
	}
	
	
	public  void resolveBaseType(org.eclipse.uml2.uml.Class clazz) throws FileNotFoundException, IOException {

		if (!clazz.getGeneralizations().isEmpty()) {
			Generalization generalization = clazz.getGeneralizations().get(0);
			Classifier general = generalization.getGeneral();
			if (general instanceof org.eclipse.uml2.uml.Class) {
				Stereotype stereotype = clazz.getApplicableStereotype("ODataProfile::ODEntityType");
				if (((org.eclipse.uml2.uml.Class) general).isStereotypeApplied(stereotype)) {
					Stereotype base = clazz.getApplicableStereotype("ODataProfile::ODEntityType");
					UMLUtil.setTaggedValue(clazz, stereotype, "basetype",
							((org.eclipse.uml2.uml.Class) general).getStereotypeApplication(base));

				}
			}

		}
	}
		public static String getPlural(String word){
			if(word.endsWith("y")){
				return word.substring(0, word.length()- 1)+"ies";
				
			}
			else
				return word+"s";
		}
}
