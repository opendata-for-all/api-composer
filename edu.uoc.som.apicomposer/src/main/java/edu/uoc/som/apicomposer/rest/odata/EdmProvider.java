package edu.uoc.som.apicomposer.rest.odata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.provider.CsdlAbstractEdmProvider;
import org.apache.olingo.commons.api.edm.provider.CsdlComplexType;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainer;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainerInfo;
import org.apache.olingo.commons.api.edm.provider.CsdlEntitySet;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityType;
import org.apache.olingo.commons.api.edm.provider.CsdlNavigationProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlNavigationPropertyBinding;
import org.apache.olingo.commons.api.edm.provider.CsdlProperty;
import org.apache.olingo.commons.api.edm.provider.CsdlPropertyRef;
import org.apache.olingo.commons.api.edm.provider.CsdlSchema;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import edu.uoc.som.apicomposer.rest.uml.ModelLoader;
import edu.uoc.som.apicomposer.rest.util.ModelUtil;
import edu.uoc.som.apicomposer.rest.util.ODataUtil;

@ApplicationScoped
public class EdmProvider extends CsdlAbstractEdmProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModelUtil modelUtil;
	
	@Inject
	private ODataMapper oDataMapper;
	
	@Inject
	private ODataUtil ODataUtil;
	


	

	@Override
	public List<CsdlSchema> getSchemas() {

		CsdlSchema schema = new CsdlSchema();
		schema.setNamespace(oDataMapper.getNamespace());

		List<CsdlEntityType> entityTypes = new ArrayList<CsdlEntityType>();
		List<CsdlComplexType> complexTypes = new ArrayList<CsdlComplexType>();
		for (Map.Entry<FullQualifiedName, Class> entry : oDataMapper.getEntityTypeMap().entrySet())
			entityTypes.add(getEntityType(entry.getKey()));
		for (Map.Entry<FullQualifiedName, DataType> entry : oDataMapper.getComplexTypeMap().entrySet())
			complexTypes.add(getComplexType(entry.getKey()));

		schema.setEntityTypes(entityTypes);
		schema.setComplexTypes(complexTypes);
		schema.setEntityContainer(getEntityContainer());

		List<CsdlSchema> schemas = new ArrayList<CsdlSchema>();
		schemas.add(schema);

		return schemas;
	}

	@Override
	public CsdlEntityType getEntityType(FullQualifiedName entityTypeName) {

		Class clazz = oDataMapper.getEntityTypeMap().get(entityTypeName);
		CsdlEntityType entityType = new CsdlEntityType();

		List<CsdlProperty> properties = new ArrayList<CsdlProperty>();
		List<CsdlNavigationProperty> navigationProperties = new ArrayList<CsdlNavigationProperty>();
		List<CsdlPropertyRef> propertyRefs = new ArrayList<CsdlPropertyRef>();
		entityType.setName(entityTypeName.getName());
		Stereotype odProperty = null;
		Stereotype odKey = null;
		Stereotype odNavigationProperty = null;
		try {
			odProperty = modelUtil.getStereotypeByName("ODataProfile::ODProperty");
			odKey =modelUtil.getStereotypeByName("ODataProfile::ODKey");
			odNavigationProperty = modelUtil.getStereotypeByName("ODataProfile::ODNavigationProperty");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Property attritute : clazz.getOwnedAttributes()) {
			if (attritute.isStereotypeApplied(odKey)) {
				CsdlProperty csdlProperty = new CsdlProperty();
				CsdlPropertyRef propertyRef = new CsdlPropertyRef();
				csdlProperty.setName((String) UMLUtil.getTaggedValue(attritute, "ODataProfile::ODKey", "name"));
				if(attritute.isMultivalued()) {
					csdlProperty.setCollection(true);
				}
				if (attritute.getType() instanceof PrimitiveType)
					csdlProperty.setType(
							ODataUtil.getODataPrimitiveTypeFromUMLPrimitiveType((PrimitiveType) attritute.getType())
									.getFullQualifiedName());
				propertyRef.setName((String) UMLUtil.getTaggedValue(attritute, "ODataProfile::ODKey", "name"));
				properties.add(csdlProperty);
				propertyRefs.add(propertyRef);
			}
			if (attritute.isStereotypeApplied(odProperty)) {
				CsdlProperty csdlProperty = new CsdlProperty();
				csdlProperty.setName((String) UMLUtil.getTaggedValue(attritute, "ODataProfile::ODProperty", "name"));
				if(attritute.isMultivalued()) {
					csdlProperty.setCollection(true);
				}
				if (attritute.getType() instanceof PrimitiveType)
					csdlProperty.setType(
							ODataUtil.getODataPrimitiveTypeFromUMLPrimitiveType((PrimitiveType) attritute.getType())
									.getFullQualifiedName());
				else
					if(attritute.getType() instanceof DataType)
						try {
							csdlProperty.setType(ODataUtil.getODataQualifiedName((DataType) attritute.getType()));
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				properties.add(csdlProperty);
			}

		}
		for(Association association: clazz.getAssociations()) {
			for(Property memberEnd: association.getMemberEnds()) {
				if(!memberEnd.getType().equals(clazz) && memberEnd.isStereotypeApplied(odNavigationProperty)) {
					CsdlNavigationProperty navigationProperty = new CsdlNavigationProperty();
					navigationProperty.setName((String) UMLUtil.getTaggedValue(memberEnd, "ODataProfile::ODNavigationProperty", "name"));
					try {
						navigationProperty.setType(ODataUtil.getODataQualifiedName((Class) memberEnd.getType()));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(memberEnd.isMultivalued())
						navigationProperty.setCollection(true);
					navigationProperties.add(navigationProperty);
					
				}
			}
		}
		entityType.setProperties(properties);
		entityType.setKey(propertyRefs);
		entityType.setNavigationProperties(navigationProperties);
		return entityType;
	}

	@Override
	  public CsdlComplexType getComplexType(FullQualifiedName complexTypeName) {

	    

		DataType dataType = oDataMapper.getComplexTypeMap().get(complexTypeName);
		CsdlComplexType complexType = new CsdlComplexType();

		List<CsdlProperty> properties = new ArrayList<CsdlProperty>();
		complexType.setName(complexTypeName.getName());
		Stereotype odProperty = null;
		try {
			odProperty = modelUtil.getStereotypeByName("ODataProfile::ODProperty");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Property attritute : dataType.getOwnedAttributes()) {
			
			if (attritute.isStereotypeApplied(odProperty)) {
				CsdlProperty csdlProperty = new CsdlProperty();
				csdlProperty.setName((String) UMLUtil.getTaggedValue(attritute, "ODataProfile::ODProperty", "name"));
				if (attritute.getType() instanceof PrimitiveType)
					csdlProperty.setType(
							ODataUtil.getODataPrimitiveTypeFromUMLPrimitiveType((PrimitiveType) attritute.getType())
									.getFullQualifiedName());
				properties.add(csdlProperty);
			}

		}
		complexType.setProperties(properties);
		return complexType;
	  }
	@Override
	public CsdlEntitySet getEntitySet(FullQualifiedName entityContainer, String entitySetName) {
		Stereotype odNavigationPropertyBinding = null;
		try {
			odNavigationPropertyBinding = modelUtil.getStereotypeByName("ODataProfile::ODNavigationPropertyBinding");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CsdlNavigationPropertyBinding> navigationPropertyBindings = new ArrayList<CsdlNavigationPropertyBinding>();
		if (entityContainer.equals(oDataMapper.getContainer())) {
			FullQualifiedName entityTypeQN = oDataMapper.getEntitySetMap().get(entitySetName);
			if (entityTypeQN != null) {
				CsdlEntitySet entitySet = new CsdlEntitySet();
				entitySet.setName(entitySetName);
				entitySet.setType(entityTypeQN);
				Class clazz = oDataMapper.getEntityTypeMap().get(entityTypeQN);
				for(Association association: clazz.getAssociations()) {
					for(Property memberEnd: association.getMemberEnds()) {
						if(!memberEnd.getType().equals(clazz) && memberEnd.isStereotypeApplied(odNavigationPropertyBinding)) {
							CsdlNavigationPropertyBinding navigationPropertyBinding = new CsdlNavigationPropertyBinding();
							navigationPropertyBinding.setPath((String) UMLUtil.getTaggedValue(memberEnd, "ODataProfile::ODNavigationPropertyBinding", "path"));
							navigationPropertyBinding.setTarget((String) UMLUtil.getTaggedValue(memberEnd, "ODataProfile::ODNavigationPropertyBinding", "target"));
							navigationPropertyBindings.add(navigationPropertyBinding);
							
						}
					}
				}
				if(!navigationPropertyBindings.isEmpty())
					entitySet.setNavigationPropertyBindings(navigationPropertyBindings);
				return entitySet;
			}

		}
		return null;
	}

	@Override
	public CsdlEntityContainer getEntityContainer() {
		List<CsdlEntitySet> entitySets = new ArrayList<CsdlEntitySet>();
		for (Map.Entry<String, FullQualifiedName> entry : oDataMapper.getEntitySetMap().entrySet()) {
			entitySets.add(getEntitySet(oDataMapper.getContainer(), entry.getKey()));
		}
		CsdlEntityContainer entityContainer = new CsdlEntityContainer();
		entityContainer.setName(oDataMapper.getContainerName());
		entityContainer.setEntitySets(entitySets);

		return entityContainer;
	}

	@Override
	public CsdlEntityContainerInfo getEntityContainerInfo(FullQualifiedName entityContainerName) {

		if (entityContainerName == null || entityContainerName.equals(oDataMapper.getContainer())) {
			CsdlEntityContainerInfo entityContainerInfo = new CsdlEntityContainerInfo();
			entityContainerInfo.setContainerName(oDataMapper.getContainer());
			return entityContainerInfo;
		}

		return null;
	}
}
