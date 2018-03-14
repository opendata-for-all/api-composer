/**
 */
package edu.uoc.som.xopenapi.util;

import edu.uoc.som.xopenapi.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.uoc.som.xopenapi.XOpenAPIPackage
 * @generated
 */
public class XOpenAPIValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final XOpenAPIValidator INSTANCE = new XOpenAPIValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "edu.uoc.som.xopenapi";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XOpenAPIValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return XOpenAPIPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case XOpenAPIPackage.JSON_SCHEMA_SUBSET:
				return validateJSONSchemaSubset((JSONSchemaSubset)value, diagnostics, context);
			case XOpenAPIPackage.ROOT:
				return validateRoot((Root)value, diagnostics, context);
			case XOpenAPIPackage.API:
				return validateAPI((API)value, diagnostics, context);
			case XOpenAPIPackage.INFO:
				return validateInfo((Info)value, diagnostics, context);
			case XOpenAPIPackage.CONTACT:
				return validateContact((Contact)value, diagnostics, context);
			case XOpenAPIPackage.LICENSE:
				return validateLicense((License)value, diagnostics, context);
			case XOpenAPIPackage.PATH:
				return validatePath((Path)value, diagnostics, context);
			case XOpenAPIPackage.OPERATION:
				return validateOperation((Operation)value, diagnostics, context);
			case XOpenAPIPackage.EXTERNAL_DOCS:
				return validateExternalDocs((ExternalDocs)value, diagnostics, context);
			case XOpenAPIPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case XOpenAPIPackage.ITEMS_DEFINITION:
				return validateItemsDefinition((ItemsDefinition)value, diagnostics, context);
			case XOpenAPIPackage.SCHEMA:
				return validateSchema((Schema)value, diagnostics, context);
			case XOpenAPIPackage.RESPONSE:
				return validateResponse((Response)value, diagnostics, context);
			case XOpenAPIPackage.HEADER:
				return validateHeader((Header)value, diagnostics, context);
			case XOpenAPIPackage.TAG:
				return validateTag((Tag)value, diagnostics, context);
			case XOpenAPIPackage.SECURITY_SCHEMA:
				return validateSecuritySchema((SecuritySchema)value, diagnostics, context);
			case XOpenAPIPackage.EXAMPLE:
				return validateExample((Example)value, diagnostics, context);
			case XOpenAPIPackage.XML_ELEMENT:
				return validateXMLElement((XMLElement)value, diagnostics, context);
			case XOpenAPIPackage.SECURITY_SCOPE:
				return validateSecurityScope((SecurityScope)value, diagnostics, context);
			case XOpenAPIPackage.PARAMTER_DECLARING_CONTEXT:
				return validateParamterDeclaringContext((ParamterDeclaringContext)value, diagnostics, context);
			case XOpenAPIPackage.SCHEMA_DECLARING_CONTEXT:
				return validateSchemaDeclaringContext((SchemaDeclaringContext)value, diagnostics, context);
			case XOpenAPIPackage.RESPONSE_DECLARING_CONTEXT:
				return validateResponseDeclaringContext((ResponseDeclaringContext)value, diagnostics, context);
			case XOpenAPIPackage.JSON_POINTER:
				return validateJSONPointer((JSONPointer)value, diagnostics, context);
			case XOpenAPIPackage.SECURITY_CONTEXT:
				return validateSecurityContext((SecurityContext)value, diagnostics, context);
			case XOpenAPIPackage.PARAMETER_CONTEXT:
				return validateParameterContext((ParameterContext)value, diagnostics, context);
			case XOpenAPIPackage.SCHEMA_CONTEXT:
				return validateSchemaContext((SchemaContext)value, diagnostics, context);
			case XOpenAPIPackage.EXTERNAL_DOCS_CONTEXT:
				return validateExternalDocsContext((ExternalDocsContext)value, diagnostics, context);
			case XOpenAPIPackage.ARRAY_CONTEXT:
				return validateArrayContext((ArrayContext)value, diagnostics, context);
			case XOpenAPIPackage.SECURITY_REQUIREMENT:
				return validateSecurityRequirement((SecurityRequirement)value, diagnostics, context);
			case XOpenAPIPackage.SCHEMA_EXTENSION:
				return validateSchemaExtension((SchemaExtension)value, diagnostics, context);
			case XOpenAPIPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case XOpenAPIPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case XOpenAPIPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case XOpenAPIPackage.NAVIGATION_PROPERTY:
				return validateNavigationProperty((NavigationProperty)value, diagnostics, context);
			case XOpenAPIPackage.TYPED_ELEMENT:
				return validateTypedElement((TypedElement)value, diagnostics, context);
			case XOpenAPIPackage.SCHEME_TYPE:
				return validateSchemeType((SchemeType)value, diagnostics, context);
			case XOpenAPIPackage.PARAMETER_LOCATION:
				return validateParameterLocation((ParameterLocation)value, diagnostics, context);
			case XOpenAPIPackage.COLLECTION_FORMAT:
				return validateCollectionFormat((CollectionFormat)value, diagnostics, context);
			case XOpenAPIPackage.OAUTH2_FLOW_TYPE:
				return validateOAuth2FlowType((OAuth2FlowType)value, diagnostics, context);
			case XOpenAPIPackage.API_KEY_LOCATION:
				return validateAPIKeyLocation((APIKeyLocation)value, diagnostics, context);
			case XOpenAPIPackage.SECURITY_SCHEME_TYPE:
				return validateSecuritySchemeType((SecuritySchemeType)value, diagnostics, context);
			case XOpenAPIPackage.JSON_DATA_TYPE:
				return validateJSONDataType((JSONDataType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJSONSchemaSubset(JSONSchemaSubset jsonSchemaSubset, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jsonSchemaSubset, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRoot(Root root, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(root, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPI(API api, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(api, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(api, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(api, diagnostics, context);
		if (result || diagnostics != null) result &= validateAPI_requiredSwaggerVersion(api, diagnostics, context);
		if (result || diagnostics != null) result &= validateAPI_correctSwaggerVersion(api, diagnostics, context);
		if (result || diagnostics != null) result &= validateAPI_requiredInfoReference(api, diagnostics, context);
		if (result || diagnostics != null) result &= validateAPI_requiredPaths(api, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requiredSwaggerVersion constraint of '<em>API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPI_requiredSwaggerVersion(API api, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredSwaggerVersion", getObjectLabel(api, context) },
						 new Object[] { api },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the correctSwaggerVersion constraint of '<em>API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPI_correctSwaggerVersion(API api, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "correctSwaggerVersion", getObjectLabel(api, context) },
						 new Object[] { api },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the requiredInfoReference constraint of '<em>API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPI_requiredInfoReference(API api, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredInfoReference", getObjectLabel(api, context) },
						 new Object[] { api },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the requiredPaths constraint of '<em>API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPI_requiredPaths(API api, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredPaths", getObjectLabel(api, context) },
						 new Object[] { api },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfo(Info info, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(info, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(info, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(info, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfo_requiredTitle(info, diagnostics, context);
		if (result || diagnostics != null) result &= validateInfo_requiredAPIVerison(info, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requiredTitle constraint of '<em>Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfo_requiredTitle(Info info, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredTitle", getObjectLabel(info, context) },
						 new Object[] { info },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the requiredAPIVerison constraint of '<em>Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInfo_requiredAPIVerison(Info info, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredAPIVerison", getObjectLabel(info, context) },
						 new Object[] { info },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContact(Contact contact, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contact, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLicense(License license, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(license, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(license, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(license, diagnostics, context);
		if (result || diagnostics != null) result &= validateLicense_requiredName(license, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requiredName constraint of '<em>License</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLicense_requiredName(License license, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredName", getObjectLabel(license, context) },
						 new Object[] { license },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePath(Path path, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(path, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_oneBodyParameterAllowed(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_oneFormDataParameterAllowed(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_hasUniqueParameters(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_xorFormAndBody(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_requiredResponses(operation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the oneBodyParameterAllowed constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_oneBodyParameterAllowed(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "oneBodyParameterAllowed", getObjectLabel(operation, context) },
						 new Object[] { operation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the oneFormDataParameterAllowed constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_oneFormDataParameterAllowed(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "oneFormDataParameterAllowed", getObjectLabel(operation, context) },
						 new Object[] { operation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the hasUniqueParameters constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_hasUniqueParameters(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "hasUniqueParameters", getObjectLabel(operation, context) },
						 new Object[] { operation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the xorFormAndBody constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_xorFormAndBody(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "xorFormAndBody", getObjectLabel(operation, context) },
						 new Object[] { operation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the requiredResponses constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_requiredResponses(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredResponses", getObjectLabel(operation, context) },
						 new Object[] { operation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalDocs(ExternalDocs externalDocs, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalDocs, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(externalDocs, diagnostics, context);
		if (result || diagnostics != null) result &= validateExternalDocs_requiredURL(externalDocs, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requiredURL constraint of '<em>External Docs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalDocs_requiredURL(ExternalDocs externalDocs, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredURL", getObjectLabel(externalDocs, context) },
						 new Object[] { externalDocs },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_requiredName(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameter_requiredLocation(parameter, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requiredName constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_requiredName(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredName", getObjectLabel(parameter, context) },
						 new Object[] { parameter },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the requiredLocation constraint of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter_requiredLocation(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "requiredLocation", getObjectLabel(parameter, context) },
						 new Object[] { parameter },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateItemsDefinition(ItemsDefinition itemsDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(itemsDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchema(Schema schema, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schema, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponse(Response response, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(response, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHeader(Header header, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(header, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTag(Tag tag, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tag, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSecuritySchema(SecuritySchema securitySchema, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(securitySchema, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExample(Example example, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(example, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateXMLElement(XMLElement xmlElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(xmlElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSecurityScope(SecurityScope securityScope, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(securityScope, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParamterDeclaringContext(ParamterDeclaringContext paramterDeclaringContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(paramterDeclaringContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemaDeclaringContext(SchemaDeclaringContext schemaDeclaringContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schemaDeclaringContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResponseDeclaringContext(ResponseDeclaringContext responseDeclaringContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(responseDeclaringContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJSONPointer(JSONPointer jsonPointer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(jsonPointer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSecurityContext(SecurityContext securityContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(securityContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterContext(ParameterContext parameterContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemaContext(SchemaContext schemaContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schemaContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalDocsContext(ExternalDocsContext externalDocsContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(externalDocsContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrayContext(ArrayContext arrayContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(arrayContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSecurityRequirement(SecurityRequirement securityRequirement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(securityRequirement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemaExtension(SchemaExtension schemaExtension, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(schemaExtension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(entity, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationProperty(NavigationProperty navigationProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(navigationProperty, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSchemeType(SchemeType schemeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterLocation(ParameterLocation parameterLocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionFormat(CollectionFormat collectionFormat, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOAuth2FlowType(OAuth2FlowType oAuth2FlowType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAPIKeyLocation(APIKeyLocation apiKeyLocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSecuritySchemeType(SecuritySchemeType securitySchemeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJSONDataType(JSONDataType jsonDataType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //XOpenAPIValidator
