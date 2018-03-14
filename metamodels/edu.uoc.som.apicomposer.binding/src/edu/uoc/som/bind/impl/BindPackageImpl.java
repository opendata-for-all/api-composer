/**
 */
package edu.uoc.som.bind.impl;

import edu.uoc.som.bind.BindFactory;
import edu.uoc.som.bind.BindPackage;
import edu.uoc.som.bind.BindingElement;
import edu.uoc.som.bind.BindingModel;
import edu.uoc.som.bind.EntityBinding;
import edu.uoc.som.bind.NavigationPropertyBinding;
import edu.uoc.som.bind.PropertyBinding;

import edu.uoc.som.xopenapi.XOpenAPIPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BindPackageImpl extends EPackageImpl implements BindPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationPropertyBindingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.uoc.som.bind.BindPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BindPackageImpl() {
		super(eNS_URI, BindFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BindPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BindPackage init() {
		if (isInited) return (BindPackage)EPackage.Registry.INSTANCE.getEPackage(BindPackage.eNS_URI);

		// Obtain or create and register package
		BindPackageImpl theBindPackage = (BindPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BindPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BindPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XOpenAPIPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBindPackage.createPackageContents();

		// Initialize created meta-data
		theBindPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBindPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BindPackage.eNS_URI, theBindPackage);
		return theBindPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingModel() {
		return bindingModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingModel_BindingElements() {
		return (EReference)bindingModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingElement() {
		return bindingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityBinding() {
		return entityBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityBinding_Binded() {
		return (EReference)entityBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyBinding() {
		return propertyBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyBinding_Binded() {
		return (EReference)propertyBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigationPropertyBinding() {
		return navigationPropertyBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigationPropertyBinding_Binded() {
		return (EReference)navigationPropertyBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindFactory getBindFactory() {
		return (BindFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bindingModelEClass = createEClass(BINDING_MODEL);
		createEReference(bindingModelEClass, BINDING_MODEL__BINDING_ELEMENTS);

		bindingElementEClass = createEClass(BINDING_ELEMENT);

		entityBindingEClass = createEClass(ENTITY_BINDING);
		createEReference(entityBindingEClass, ENTITY_BINDING__BINDED);

		propertyBindingEClass = createEClass(PROPERTY_BINDING);
		createEReference(propertyBindingEClass, PROPERTY_BINDING__BINDED);

		navigationPropertyBindingEClass = createEClass(NAVIGATION_PROPERTY_BINDING);
		createEReference(navigationPropertyBindingEClass, NAVIGATION_PROPERTY_BINDING__BINDED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XOpenAPIPackage theXOpenAPIPackage = (XOpenAPIPackage)EPackage.Registry.INSTANCE.getEPackage(XOpenAPIPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entityBindingEClass.getESuperTypes().add(this.getBindingElement());
		propertyBindingEClass.getESuperTypes().add(this.getBindingElement());
		navigationPropertyBindingEClass.getESuperTypes().add(this.getBindingElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(bindingModelEClass, BindingModel.class, "BindingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingModel_BindingElements(), this.getBindingElement(), null, "bindingElements", null, 0, 1, BindingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingElementEClass, BindingElement.class, "BindingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityBindingEClass, EntityBinding.class, "EntityBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityBinding_Binded(), theXOpenAPIPackage.getEntity(), null, "binded", null, 0, -1, EntityBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyBindingEClass, PropertyBinding.class, "PropertyBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyBinding_Binded(), theXOpenAPIPackage.getProperty(), null, "binded", null, 0, -1, PropertyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationPropertyBindingEClass, NavigationPropertyBinding.class, "NavigationPropertyBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationPropertyBinding_Binded(), theXOpenAPIPackage.getNavigationProperty(), null, "binded", null, 0, -1, NavigationPropertyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BindPackageImpl
