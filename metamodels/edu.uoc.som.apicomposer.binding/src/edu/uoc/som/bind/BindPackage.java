/**
 */
package edu.uoc.som.bind;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.uoc.som.bind.BindFactory
 * @model kind="package"
 * @generated
 */
public interface BindPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bind";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://som.uoc.edu/bind/2.0.0/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bind";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BindPackage eINSTANCE = edu.uoc.som.bind.impl.BindPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.uoc.som.bind.impl.BindingModelImpl <em>Binding Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.uoc.som.bind.impl.BindingModelImpl
	 * @see edu.uoc.som.bind.impl.BindPackageImpl#getBindingModel()
	 * @generated
	 */
	int BINDING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Binding Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_MODEL__BINDING_ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Binding Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Binding Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.uoc.som.bind.impl.BindingElementImpl <em>Binding Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.uoc.som.bind.impl.BindingElementImpl
	 * @see edu.uoc.som.bind.impl.BindPackageImpl#getBindingElement()
	 * @generated
	 */
	int BINDING_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Binding Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Binding Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.uoc.som.bind.impl.EntityBindingImpl <em>Entity Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.uoc.som.bind.impl.EntityBindingImpl
	 * @see edu.uoc.som.bind.impl.BindPackageImpl#getEntityBinding()
	 * @generated
	 */
	int ENTITY_BINDING = 2;

	/**
	 * The feature id for the '<em><b>Binded</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING__BINDED = BINDING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING_FEATURE_COUNT = BINDING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_BINDING_OPERATION_COUNT = BINDING_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.uoc.som.bind.impl.PropertyBindingImpl <em>Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.uoc.som.bind.impl.PropertyBindingImpl
	 * @see edu.uoc.som.bind.impl.BindPackageImpl#getPropertyBinding()
	 * @generated
	 */
	int PROPERTY_BINDING = 3;

	/**
	 * The feature id for the '<em><b>Binded</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING__BINDED = BINDING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_FEATURE_COUNT = BINDING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_OPERATION_COUNT = BINDING_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.uoc.som.bind.impl.NavigationPropertyBindingImpl <em>Navigation Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.uoc.som.bind.impl.NavigationPropertyBindingImpl
	 * @see edu.uoc.som.bind.impl.BindPackageImpl#getNavigationPropertyBinding()
	 * @generated
	 */
	int NAVIGATION_PROPERTY_BINDING = 4;

	/**
	 * The feature id for the '<em><b>Binded</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PROPERTY_BINDING__BINDED = BINDING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Navigation Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PROPERTY_BINDING_FEATURE_COUNT = BINDING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Navigation Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PROPERTY_BINDING_OPERATION_COUNT = BINDING_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.uoc.som.bind.BindingModel <em>Binding Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Model</em>'.
	 * @see edu.uoc.som.bind.BindingModel
	 * @generated
	 */
	EClass getBindingModel();

	/**
	 * Returns the meta object for the containment reference '{@link edu.uoc.som.bind.BindingModel#getBindingElements <em>Binding Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding Elements</em>'.
	 * @see edu.uoc.som.bind.BindingModel#getBindingElements()
	 * @see #getBindingModel()
	 * @generated
	 */
	EReference getBindingModel_BindingElements();

	/**
	 * Returns the meta object for class '{@link edu.uoc.som.bind.BindingElement <em>Binding Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Element</em>'.
	 * @see edu.uoc.som.bind.BindingElement
	 * @generated
	 */
	EClass getBindingElement();

	/**
	 * Returns the meta object for class '{@link edu.uoc.som.bind.EntityBinding <em>Entity Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Binding</em>'.
	 * @see edu.uoc.som.bind.EntityBinding
	 * @generated
	 */
	EClass getEntityBinding();

	/**
	 * Returns the meta object for the reference list '{@link edu.uoc.som.bind.EntityBinding#getBinded <em>Binded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binded</em>'.
	 * @see edu.uoc.som.bind.EntityBinding#getBinded()
	 * @see #getEntityBinding()
	 * @generated
	 */
	EReference getEntityBinding_Binded();

	/**
	 * Returns the meta object for class '{@link edu.uoc.som.bind.PropertyBinding <em>Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Binding</em>'.
	 * @see edu.uoc.som.bind.PropertyBinding
	 * @generated
	 */
	EClass getPropertyBinding();

	/**
	 * Returns the meta object for the reference list '{@link edu.uoc.som.bind.PropertyBinding#getBinded <em>Binded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binded</em>'.
	 * @see edu.uoc.som.bind.PropertyBinding#getBinded()
	 * @see #getPropertyBinding()
	 * @generated
	 */
	EReference getPropertyBinding_Binded();

	/**
	 * Returns the meta object for class '{@link edu.uoc.som.bind.NavigationPropertyBinding <em>Navigation Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Property Binding</em>'.
	 * @see edu.uoc.som.bind.NavigationPropertyBinding
	 * @generated
	 */
	EClass getNavigationPropertyBinding();

	/**
	 * Returns the meta object for the reference list '{@link edu.uoc.som.bind.NavigationPropertyBinding#getBinded <em>Binded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binded</em>'.
	 * @see edu.uoc.som.bind.NavigationPropertyBinding#getBinded()
	 * @see #getNavigationPropertyBinding()
	 * @generated
	 */
	EReference getNavigationPropertyBinding_Binded();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BindFactory getBindFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.uoc.som.bind.impl.BindingModelImpl <em>Binding Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.uoc.som.bind.impl.BindingModelImpl
		 * @see edu.uoc.som.bind.impl.BindPackageImpl#getBindingModel()
		 * @generated
		 */
		EClass BINDING_MODEL = eINSTANCE.getBindingModel();

		/**
		 * The meta object literal for the '<em><b>Binding Elements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_MODEL__BINDING_ELEMENTS = eINSTANCE.getBindingModel_BindingElements();

		/**
		 * The meta object literal for the '{@link edu.uoc.som.bind.impl.BindingElementImpl <em>Binding Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.uoc.som.bind.impl.BindingElementImpl
		 * @see edu.uoc.som.bind.impl.BindPackageImpl#getBindingElement()
		 * @generated
		 */
		EClass BINDING_ELEMENT = eINSTANCE.getBindingElement();

		/**
		 * The meta object literal for the '{@link edu.uoc.som.bind.impl.EntityBindingImpl <em>Entity Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.uoc.som.bind.impl.EntityBindingImpl
		 * @see edu.uoc.som.bind.impl.BindPackageImpl#getEntityBinding()
		 * @generated
		 */
		EClass ENTITY_BINDING = eINSTANCE.getEntityBinding();

		/**
		 * The meta object literal for the '<em><b>Binded</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_BINDING__BINDED = eINSTANCE.getEntityBinding_Binded();

		/**
		 * The meta object literal for the '{@link edu.uoc.som.bind.impl.PropertyBindingImpl <em>Property Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.uoc.som.bind.impl.PropertyBindingImpl
		 * @see edu.uoc.som.bind.impl.BindPackageImpl#getPropertyBinding()
		 * @generated
		 */
		EClass PROPERTY_BINDING = eINSTANCE.getPropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Binded</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_BINDING__BINDED = eINSTANCE.getPropertyBinding_Binded();

		/**
		 * The meta object literal for the '{@link edu.uoc.som.bind.impl.NavigationPropertyBindingImpl <em>Navigation Property Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.uoc.som.bind.impl.NavigationPropertyBindingImpl
		 * @see edu.uoc.som.bind.impl.BindPackageImpl#getNavigationPropertyBinding()
		 * @generated
		 */
		EClass NAVIGATION_PROPERTY_BINDING = eINSTANCE.getNavigationPropertyBinding();

		/**
		 * The meta object literal for the '<em><b>Binded</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_PROPERTY_BINDING__BINDED = eINSTANCE.getNavigationPropertyBinding_Binded();

	}

} //BindPackage
