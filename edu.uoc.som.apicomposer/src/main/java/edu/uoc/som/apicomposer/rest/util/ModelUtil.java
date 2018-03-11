package edu.uoc.som.apicomposer.rest.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.edm.EdmNavigationProperty;
import org.apache.olingo.server.api.uri.UriParameter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import core.API;
import core.Parameter;
import edu.uoc.som.apicomposer.rest.model.APIRequest;
import edu.uoc.som.apicomposer.rest.uml.ModelLoader;

@ApplicationScoped
public class ModelUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ModelLoader modelLoader;
	
	public  Stereotype getStereotypeByName(String name) throws FileNotFoundException, IOException {
		switch (name) {
		case "ODataProfile::ODService":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_F6AskPOCEeapod9Ch20uSQ");
		case "ODataProfile::ODEntityType":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_JL5pMPOEEeapod9Ch20uSQ");
		case "ODataProfile::ODComplexType":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_O_L2cPOEEeapod9Ch20uSQ");
		case "ODataProfile::ODEnumType":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_at9xwPOEEeapod9Ch20uSQ");
		case "ODataProfile::ODProperty":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_vOXjoPOYEeapod9Ch20uSQ");
		case "ODataProfile::ODNavigationProperty":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_YiGXUPOpEeapod9Ch20uSQ");
		case "ODataProfile::ODEntitySet":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_W3xsoPQvEeapod9Ch20uSQ");
		case "ODataProfile::ODNavigationPropertyBinding":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_me6kIPQwEeapod9Ch20uSQ");
		case "ODataProfile::ODKey":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_Pb33kPQ2Eeapod9Ch20uSQ");
		case "ODataProfile::ODSingleton":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("__AdE0PRzEea9bLy5EKANsQ");
		case "ODataProfile::ODAnnotations":
			return (Stereotype) modelLoader.getOdataProfileResource().getEObject("_2kyqYPUTEeal8KyBIrKCwg");
		default:
			break;
		}
		return null;

	}

	public static List<Class> getInterClasses(Class clazz, Map<String, Model> interModels) {
		List<Class> classes = new ArrayList<Class>();
		for (Entry<String, String> details : clazz.getEAnnotation("api").getDetails().entrySet()) {
			classes.add(getClassByName(details.getValue(), interModels.get(details.getKey())));
		}
		return classes;
	}

	public static List<Property> getInterProperties(Property property, Map<String, Model> interModels) {
		List<Property> properties = new ArrayList<Property>();
		
		for (Entry<String, String> details : property.getEAnnotation("api").getDetails().entrySet()) {
			Class clazz = (Class) property.getOwner();
			Class interClazz = getClassByName(clazz.getEAnnotation("api").getDetails().get(details.getKey()),interModels.get(details.getKey()));
		for(Property interProperty: interClazz.getAttributes()) {
			if(interProperty.getName().contentEquals(details.getValue()))
					properties.add(interProperty);
		}
		}
		return properties;
	}
	public static String  getSchemaProperty (Property property) {
		return property.getEAnnotation("openapi").getDetails().get("schema");
	}

	public static Association getInterAssociation(Association association, Map<String, Model> interModels) {
		Entry<String, String> details = association.getEAnnotation("api").getDetails().entrySet().iterator().next();
		return getAssociationByName(details.getValue(), interModels.get(details.getKey()));

	}

	public static Class getClassByName(String name, Model model) {
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Class) {
				if (((Class) child).getName().equals(name))
					return (Class) child;
			}
		}
		return null;

	}

	public static Association getAssociationByName(String name, Model model) {
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			if (child instanceof Association) {
				if (((Association) child).getName().equals(name))
					return (Association) child;
			}
		}
		return null;

	}

	public static String getAPIName(Class clazz) {
		return clazz.getModel().getEAnnotation("openapi").getDetails().get("source");
	}

	public static String getAPIName(Association association) {
		return association.getModel().getEAnnotation("openapi").getDetails().get("source");
	}

	public List<APIRequest> createRequestsFromAnnotation(Class clazz, API api)
			throws FileNotFoundException, IOException {
		List<APIRequest> apiRequests = new ArrayList<APIRequest>();
		if (clazz.getEAnnotation("openapi").getDetails().get("operations") != null) {
			String[] operations = clazz.getEAnnotation("openapi").getDetails().get("operations").split("\\r?\\n");
			for (String operationLine : operations) {
				APIRequest apiRequest = new APIRequest();
				apiRequest.setInterClass(clazz);
				String[] segments = operationLine.split(" ");
				apiRequest.setOperation(OpenAPIUtils.getOperationByMethod(segments[0],
						OpenAPIUtils.getPathByPattern(api, segments[1])));
				String name = getAPIName(clazz);
				Properties params = modelLoader.getPropertiesMap().get(name);

				if (params != null) {
					for (Parameter parameter : apiRequest.getOperation().getParameters()) {
						if (!params.getProperty(parameter.getName(), "default").equals("default")) {
							apiRequest.getParameters().put(parameter, params.getProperty(parameter.getName()));
						}
					}
				}
				if (segments.length > 2) {
					if (segments[2].indexOf("union") != -1) {
						apiRequest.setInnerPath(
								segments[2].substring(segments[2].indexOf("(") + 1, segments[2].indexOf(")")));
					}
				}
				apiRequests.add(apiRequest);
			}
		}

		return apiRequests;

	}

	public static String getQualifiedName(String name) {
		return "ODataProfile::" + name;

	}

	public static Class getSourceAPIClass(Class clazz) {
		return clazz;

	}

	public  List<APIRequest> createRequestsFromAnnotation(Class interClass, API api, UriParameter uriParameter)
			throws FileNotFoundException, IOException {

		List<APIRequest> apiRequests = new ArrayList<APIRequest>();
		Property property = null;
		for (Property p : interClass.getOwnedAttributes()) {
			if (p.getName().equals(uriParameter.getName())) {
				property = p;
			}
		}
		if (property != null && property.getEAnnotation("openapi").getDetails().get("filter") != null) {

			String[] operations = property.getEAnnotation("openapi").getDetails().get("filter").split("\\r?\\n");

			for (String operationLine : operations) {

				if (operationLine.equals("runtime")) {
					apiRequests = createRequestsFromAnnotation(interClass, api);
					for (APIRequest apiRequest : apiRequests) {
						apiRequest.setRuntime(true);
						apiRequest.getRuntimeVariables().put(
								property.getEAnnotation("openapi").getDetails().get("schema"),
								uriParameter.getText().replaceAll("'", ""));
					}

				} else {
					APIRequest apiRequest = new APIRequest();
					String[] segments = operationLine.split(" ");
					apiRequest.setOperation(OpenAPIUtils.getOperationByMethod(segments[0],
							OpenAPIUtils.getPathByPattern(api, segments[1])));
					String name = getAPIName(interClass);
					Properties params =modelLoader.getPropertiesMap().get(name);

					if (segments.length > 2) {
						String[] paramInits = segments[2].split(",");
						for (String paramInit : paramInits) {
							String[] keyVaule = paramInit.split("->");
							for (Parameter parameter : apiRequest.getOperation().getParameters()) {
								if (parameter.getName().equals(keyVaule[0])) {
									apiRequest.getParameters().put(parameter,
											uriParameter.getText().replaceAll("'", ""));
								}
							}
						}
					}

					if (params != null) {
						for (Parameter parameter : apiRequest.getOperation().getParameters()) {
							if (!params.getProperty(parameter.getName(), "default").equals("default")) {
								apiRequest.getParameters().put(parameter, params.getProperty(parameter.getName()));
							}
						}
					}
					apiRequests.add(apiRequest);
				}
			}
		}

		return apiRequests;
	}
	
	public static Association getAssociationByNavigationProperty(EdmNavigationProperty edmNavigationProperty, Class clazz) {
		for(Association association: clazz.getAssociations()) {
			for(Property property: association.getAllAttributes()) {
				if(property.getName()!=null && edmNavigationProperty.getName() != null )
				if(property.getName().equals(edmNavigationProperty.getName()))
					return association;
			}
		}
		return null;
	}

	public APIRequest createRequestsFromAnnotation(Association interAssociation, API api,
			EdmNavigationProperty edmNavigationProperty, Entity entity) throws FileNotFoundException, IOException {

		Property property = null;
		APIRequest apiRequest = new APIRequest();
		for (Property p : interAssociation.getAllAttributes()) {
			if (p.getName().equals(edmNavigationProperty.getName())) {
				property = p;
			}
		}
		if (property != null && property.getEAnnotation("openapi").getDetails().get("operations") != null) {

			String operation = property.getEAnnotation("openapi").getDetails().get("operations");

			
			String[] segments = operation.split(" ");
			apiRequest.setOperation(
					OpenAPIUtils.getOperationByMethod(segments[0], OpenAPIUtils.getPathByPattern(api, segments[1])));
			String name = getAPIName(interAssociation);
			Properties params =modelLoader.getPropertiesMap().get(name);

			if (segments.length > 2) {
				String[] paramInits = segments[2].split(",");
				for (String paramInit : paramInits) {
					String[] keyVaule = paramInit.split("->");
					for (Parameter parameter : apiRequest.getOperation().getParameters()) {
						if (parameter.getName().equals(keyVaule[0])) {
							apiRequest.getParameters().put(parameter, entity.getProperty(keyVaule[1]).getValue().toString());
						}
					}
				}
			}

			if (params != null) {
				for (Parameter parameter : apiRequest.getOperation().getParameters()) {
					if (!params.getProperty(parameter.getName(), "default").equals("default")) {
						apiRequest.getParameters().put(parameter, params.getProperty(parameter.getName()));
					}
				}
			}

		}

		return apiRequest;
	}

}
