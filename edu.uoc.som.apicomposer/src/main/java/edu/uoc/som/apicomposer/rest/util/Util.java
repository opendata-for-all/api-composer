package edu.uoc.som.apicomposer.rest.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.olingo.commons.api.data.ComplexValue;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.data.ValueType;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.constants.ODataServiceVersion;
import org.apache.olingo.commons.api.ex.ODataRuntimeException;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.apache.olingo.server.api.uri.UriResourceNavigation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.uoc.som.apicomposer.rest.model.APIRequest;
import edu.uoc.som.apicomposer.rest.odata.ODataMapper;
import edu.uoc.som.apicomposer.rest.uml.ModelLoader;

@ApplicationScoped
public class Util implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ODataMapper oDataMapper; 

	@Inject
	private ModelUtil modelUtil;
	
	@Inject
	private ModelLoader modelLoader;
	
	@Inject
	private Util util;
	
	public  EntityCollection getEntityCollection(EdmEntityType entityType, List<APIRequest> apiRequests)
			throws FileNotFoundException, IOException {
		EntityCollection collection = new EntityCollection();
		List<Entity> list = collection.getEntities();
		Class clazz = oDataMapper.getEntityTypeMap().get(entityType.getFullQualifiedName());

		Stereotype odProperty = null;
		Stereotype odKey = null;

		try {
			odProperty = modelUtil.getStereotypeByName("ODataProfile::ODProperty");
			odKey = modelUtil.getStereotypeByName("ODataProfile::ODKey");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		APIRequest apiRequest = apiRequests.get(0);

		Set<JsonElement> content = new TreeSet<JsonElement>(new Comparator<JsonElement>() {

			@Override
			public int compare(JsonElement o1, JsonElement o2) {

				return o1.toString().equals(o2.toString()) ? 0 : 1;
			}
		});

		if (apiRequest.getResponseAsJson().isJsonArray()) {
			JsonArray jsonArray = apiRequest.getResponseAsJson().getAsJsonArray();

			if (apiRequest.getInnerPath() != null) {
				for (JsonElement jsonElement : jsonArray) {
					if (jsonElement.getAsJsonObject().get(apiRequest.getInnerPath()).isJsonObject())
						content.add(jsonElement.getAsJsonObject().get(apiRequest.getInnerPath()));
					else if (jsonElement.getAsJsonObject().get(apiRequest.getInnerPath()).isJsonArray()) {
						for (JsonElement innerElement : jsonElement.getAsJsonObject().get(apiRequest.getInnerPath())
								.getAsJsonArray()) {
							content.add(innerElement);
						}
					}
				}
			} else {
				for (JsonElement jsonElement : jsonArray) {
					content.add(jsonElement);
				}
			}
		}
		for (JsonElement record : content) {

			JsonObject jsonObject = record.getAsJsonObject();
			Entity entity = new Entity();

			for (org.eclipse.uml2.uml.Property umlProperty : clazz.getOwnedAttributes()) {
				if (umlProperty.isStereotypeApplied(odProperty) || umlProperty.isStereotypeApplied(odKey)) {
					String propertyName = null;
					if (umlProperty.isStereotypeApplied(odProperty)) {
						propertyName = (String) UMLUtil.getTaggedValue(umlProperty, "ODataProfile::ODProperty", "name");
					}
					if (umlProperty.isStereotypeApplied(odKey)) {
						propertyName = (String) UMLUtil.getTaggedValue(umlProperty, "ODataProfile::ODKey", "name");
					}
					for (org.eclipse.uml2.uml.Property p : ModelUtil.getInterProperties(umlProperty,
							modelLoader.getInterModels())) {
						if (jsonObject.has(ModelUtil.getSchemaProperty(p))) {
							Property property = new Property();
							entity.addProperty(property);
							property.setName(propertyName);
							if (umlProperty.getType() instanceof PrimitiveType && !umlProperty.isMultivalued()) {
								if (UMLUtil.isString(umlProperty.getType()))
									property.setValue(ValueType.PRIMITIVE,
											jsonObject.get(ModelUtil.getSchemaProperty(p)).isJsonNull() ? null
													: jsonObject.get(ModelUtil.getSchemaProperty(p)).getAsString());
								if (UMLUtil.isInteger(umlProperty.getType()))
									property.setValue(ValueType.PRIMITIVE,
											jsonObject.get(ModelUtil.getSchemaProperty(p)).isJsonNull() ? null
													: jsonObject.get(ModelUtil.getSchemaProperty(p)).getAsInt());
								if (UMLUtil.isReal(umlProperty.getType()))
									property.setValue(ValueType.PRIMITIVE,
											jsonObject.get(ModelUtil.getSchemaProperty(p)).isJsonNull() ? null
													: jsonObject.get(ModelUtil.getSchemaProperty(p)).getAsDouble());

							}
							if (umlProperty.getType() instanceof PrimitiveType && umlProperty.isMultivalued()) {
								if (UMLUtil.isString(umlProperty.getType())) {
									List<String> collection1 = new ArrayList<String>();
									for (JsonElement jsonElement : jsonObject.get(ModelUtil.getSchemaProperty(p))
											.getAsJsonArray())
										collection1.add(jsonElement.getAsString());

									property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
								}
								if (UMLUtil.isInteger(umlProperty.getType())) {
									List<Integer> collection1 = new ArrayList<Integer>();
									for (JsonElement jsonElement : jsonObject.get(ModelUtil.getSchemaProperty(p))
											.getAsJsonArray())
										collection1.add(jsonElement.getAsInt());

									property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
								}
								if (UMLUtil.isReal(umlProperty.getType())) {
									List<Double> collection1 = new ArrayList<Double>();
									for (JsonElement jsonElement : jsonObject.get(ModelUtil.getSchemaProperty(p))
											.getAsJsonArray())
										collection1.add(jsonElement.getAsDouble());

									property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
								}
							}
							if (!(umlProperty.getType() instanceof PrimitiveType) && !umlProperty.isMultivalued()) {
								ComplexValue complexProperty = new ComplexValue();
								JsonObject jsonProperty = jsonObject.get(ModelUtil.getSchemaProperty(p))
										.getAsJsonObject();

								for (org.eclipse.uml2.uml.Property prop : ((DataType) umlProperty.getType())
										.getOwnedAttributes()) {
									String porpName = (String) UMLUtil.getTaggedValue(prop, "ODataProfile::ODProperty",
											"name");
									complexProperty.getValue()
											.add(new Property(null, porpName, ValueType.PRIMITIVE,
													jsonProperty.get(porpName).isJsonNull() ? null
															: jsonProperty.get(porpName).getAsString()));
									// TODO deal with formats other than String
								}
								property.setValue(ValueType.COMPLEX, complexProperty);

							}
							if (!(umlProperty.getType() instanceof PrimitiveType) && umlProperty.isMultivalued()) {
								// TODO to implement
							}
							if (umlProperty.isStereotypeApplied(odKey)) {
								 propertyName = (String) UMLUtil.getTaggedValue(umlProperty,
								 "ODataProfile::ODKey", "name");
								if (!jsonObject.get(ModelUtil.getSchemaProperty(p)).isJsonNull())
									entity.setId(createId(
											oDataMapper
													.getEntitySetName(entityType.getFullQualifiedName()),
											jsonObject.get(ModelUtil.getSchemaProperty(p)).getAsString()));
							}
						}
					}
				}
			}

			list.add(entity);
		}

		return collection;
	}

	public Entity getEntity(EdmEntityType edmEntityType, List<APIRequest> apiRequests)
			throws FileNotFoundException, IOException {
		Class clazz = oDataMapper.getEntityTypeMap()
				.get(edmEntityType.getFullQualifiedName());
		Entity entity = new Entity();
		APIRequest apiRequest = apiRequests.get(0);
		JsonObject jsonObject = null;

		Stereotype odProperty = null;
		Stereotype odKey = null;
		if (apiRequest.isRuntime()) {
			EntityCollection entityCollection = getEntityCollection(edmEntityType, apiRequests);
			for (Entity e : entityCollection.getEntities()) {
				Entry<String, String> variable = apiRequest.getRuntimeVariables().entrySet().iterator().next();
				if (e.getProperty(variable.getKey()).getValue().equals(variable.getValue()))
					return e;
			}
		}

		try {
			odProperty = modelUtil.getStereotypeByName("ODataProfile::ODProperty");
			odKey = modelUtil.getStereotypeByName("ODataProfile::ODKey");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (apiRequest.getResponseAsJson().isJsonArray()) {
			jsonObject = apiRequest.getResponseAsJson().getAsJsonArray().get(0).getAsJsonObject();
		}
		if (apiRequest.getResponseAsJson().isJsonObject()) {
			jsonObject = apiRequest.getResponseAsJson().getAsJsonObject();
		}

		for (org.eclipse.uml2.uml.Property umlProperty : clazz.getOwnedAttributes()) {
			if (umlProperty.isStereotypeApplied(odProperty) || umlProperty.isStereotypeApplied(odKey)) {
				String propertyName = null;
				if (umlProperty.isStereotypeApplied(odProperty)) {
					propertyName = (String) UMLUtil.getTaggedValue(umlProperty, "ODataProfile::ODProperty", "name");
				}
				if (umlProperty.isStereotypeApplied(odKey)) {
					propertyName = (String) UMLUtil.getTaggedValue(umlProperty, "ODataProfile::ODKey", "name");
				}

				if (jsonObject.has(propertyName)) {
					Property property = new Property();
					entity.addProperty(property);
					property.setName(propertyName);
					if (umlProperty.getType() instanceof PrimitiveType && !umlProperty.isMultivalued()) {
						if (UMLUtil.isString(umlProperty.getType()))
							property.setValue(ValueType.PRIMITIVE, jsonObject.get(propertyName).isJsonNull() ? null
									: jsonObject.get(propertyName).getAsString());
						if (UMLUtil.isInteger(umlProperty.getType()))
							property.setValue(ValueType.PRIMITIVE, jsonObject.get(propertyName).isJsonNull() ? null
									: jsonObject.get(propertyName).getAsInt());
						if (UMLUtil.isReal(umlProperty.getType()))
							property.setValue(ValueType.PRIMITIVE, jsonObject.get(propertyName).isJsonNull() ? null
									: jsonObject.get(propertyName).getAsDouble());

					}
					if (umlProperty.getType() instanceof PrimitiveType && umlProperty.isMultivalued()) {
						if (UMLUtil.isString(umlProperty.getType())) {
							List<String> collection1 = new ArrayList<String>();
							for (JsonElement jsonElement : jsonObject.get(propertyName).getAsJsonArray())
								collection1.add(jsonElement.getAsString());

							property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
						}
						if (UMLUtil.isInteger(umlProperty.getType())) {
							List<Integer> collection1 = new ArrayList<Integer>();
							for (JsonElement jsonElement : jsonObject.get(propertyName).getAsJsonArray())
								collection1.add(jsonElement.getAsInt());

							property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
						}
						if (UMLUtil.isReal(umlProperty.getType())) {
							List<Double> collection1 = new ArrayList<Double>();
							for (JsonElement jsonElement : jsonObject.get(propertyName).getAsJsonArray())
								collection1.add(jsonElement.getAsDouble());

							property.setValue(ValueType.COLLECTION_PRIMITIVE, collection1);
						}
					}
					if (!(umlProperty.getType() instanceof PrimitiveType) && !umlProperty.isMultivalued()) {
						ComplexValue complexProperty = new ComplexValue();
						JsonObject jsonProperty = jsonObject.get(propertyName).getAsJsonObject();

						for (org.eclipse.uml2.uml.Property prop : ((DataType) umlProperty.getType())
								.getOwnedAttributes()) {
							String porpName = (String) UMLUtil.getTaggedValue(prop, "ODataProfile::ODProperty", "name");
							complexProperty.getValue()
									.add(new Property(null, porpName, ValueType.PRIMITIVE,
											jsonProperty.get(porpName).isJsonNull() ? null
													: jsonProperty.get(porpName).getAsString()));
							// TODO deal with formats other than String
						}
						property.setValue(ValueType.COMPLEX, complexProperty);

					}
					if (!(umlProperty.getType() instanceof PrimitiveType) && umlProperty.isMultivalued()) {
						// TODO to implement
					}
					if (umlProperty.isStereotypeApplied(odKey)) {
						propertyName = (String) UMLUtil.getTaggedValue(umlProperty, "ODataProfile::ODKey", "name");
						entity.setId(createId(oDataMapper.getEntitySetName(edmEntityType.getFullQualifiedName()),
								jsonObject.get(propertyName).getAsString()));
					}
				}
			}
		}

		return entity;

	}

	public Entity getEntity(UriResourceEntitySet uriResource)
			throws FileNotFoundException, IOException, UnirestException {
		Entity entity;
		List<APIRequest> apiRequests = new ArrayList<APIRequest>();
		UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) uriResource;
		Class clazz = oDataMapper.getEntityTypeMap().get(uriResourceEntitySet.getEntityType().getFullQualifiedName());
		List<Class> interClasses = ModelUtil.getInterClasses(clazz, modelLoader.getInterModels());
		for (Class interClass : interClasses) {
			if (uriResourceEntitySet.getKeyPredicates() != null && !uriResourceEntitySet.getKeyPredicates().isEmpty()) {

				apiRequests.addAll(modelUtil.createRequestsFromAnnotation(interClass,
						modelLoader.getOpenAPIModels().get(ModelUtil.getAPIName(interClass)).getApi(),
						uriResourceEntitySet.getKeyPredicates().get(0)));

			}

		}
		for (APIRequest apiRequest : apiRequests) {
			apiRequest.send();
			// addLog(apiRequest.getResponse().getStatus() + " " +
			// apiRequest.getRequest().getUrl() + " "
			// + apiRequest.getResponseType());

		}
		entity = util.getEntity(uriResourceEntitySet.getEntityType(), apiRequests);
		// addLog(request.getRawRequestUri() + " yes");
		return entity;
	}

	public EntityCollection getEntityCollection(UriResourceEntitySet uriResource)
			throws FileNotFoundException, IOException, UnirestException {
		EntityCollection entityCollection;
		List<APIRequest> apiRequests = new ArrayList<APIRequest>();
		UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) uriResource;
		Class clazz = oDataMapper.getEntityTypeMap().get(uriResourceEntitySet.getEntityType().getFullQualifiedName());
		List<Class> interClasses = ModelUtil.getInterClasses(clazz, modelLoader.getInterModels());
		for (Class interClass : interClasses) {
			apiRequests.addAll(modelUtil.createRequestsFromAnnotation(interClass,
					modelLoader.getOpenAPIModels().get(ModelUtil.getAPIName(interClass)).getApi()));

		}
		for (APIRequest apiRequest : apiRequests) {
			apiRequest.send();
			// addLog(apiRequest.getResponse().getStatus()+"
			// "+apiRequest.getRequest().getUrl()+" "+apiRequest.getResponseType());

		}
		entityCollection = util.getEntityCollection(uriResourceEntitySet.getEntityType(), apiRequests);
		return entityCollection;
	}

	public static URI createId(String entitySetName, Object id) {
		try {
			return new URI(entitySetName + "(" + String.valueOf(id).replaceAll(" ", "") + ")");
		} catch (URISyntaxException e) {
			throw new ODataRuntimeException("Unable to create id for entity: " + entitySetName, e);
		}
	}
	public EdmEntitySet getEnitySetFromEntityType(EdmEntityType edmEntityType, ServiceMetadata metadata) throws FileNotFoundException, IOException {
			return metadata.getEdm().getEntityContainer().getEntitySet(oDataMapper.getEntitySetName(edmEntityType.getFullQualifiedName()));

	}

	public  Entity getEntity(UriResourceNavigation uriResourceNavigation) throws FileNotFoundException, IOException, UnirestException {
		Entity entity;
		List<APIRequest> apiRequests = new ArrayList<APIRequest>();
		Class clazz = oDataMapper.getEntityTypeMap().get(uriResourceNavigation.getProperty().getType().getFullQualifiedName());
		List<Class> interClasses = ModelUtil.getInterClasses(clazz, modelLoader.getInterModels());
		for (Class interClass : interClasses) {
			if (uriResourceNavigation.getKeyPredicates() != null && !uriResourceNavigation.getKeyPredicates().isEmpty()) {

				apiRequests.addAll(modelUtil.createRequestsFromAnnotation(interClass,
						modelLoader.getOpenAPIModels().get(ModelUtil.getAPIName(interClass)).getApi(),
						uriResourceNavigation.getKeyPredicates().get(0)));

			}

		}
		for (APIRequest apiRequest : apiRequests) {
			apiRequest.send();
			// addLog(apiRequest.getResponse().getStatus() + " " +
			// apiRequest.getRequest().getUrl() + " "
			// + apiRequest.getResponseType());

		}
		entity = util.getEntity(uriResourceNavigation.getProperty().getType(), apiRequests);
		// addLog(request.getRawRequestUri() + " yes");
		return entity;
	}
}
