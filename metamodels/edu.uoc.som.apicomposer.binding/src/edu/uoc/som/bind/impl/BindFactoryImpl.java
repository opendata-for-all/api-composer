/**
 */
package edu.uoc.som.bind.impl;

import edu.uoc.som.bind.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BindFactoryImpl extends EFactoryImpl implements BindFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BindFactory init() {
		try {
			BindFactory theBindFactory = (BindFactory)EPackage.Registry.INSTANCE.getEFactory(BindPackage.eNS_URI);
			if (theBindFactory != null) {
				return theBindFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BindFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BindPackage.BINDING_MODEL: return createBindingModel();
			case BindPackage.ENTITY_BINDING: return createEntityBinding();
			case BindPackage.PROPERTY_BINDING: return createPropertyBinding();
			case BindPackage.NAVIGATION_PROPERTY_BINDING: return createNavigationPropertyBinding();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingModel createBindingModel() {
		BindingModelImpl bindingModel = new BindingModelImpl();
		return bindingModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityBinding createEntityBinding() {
		EntityBindingImpl entityBinding = new EntityBindingImpl();
		return entityBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyBinding createPropertyBinding() {
		PropertyBindingImpl propertyBinding = new PropertyBindingImpl();
		return propertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationPropertyBinding createNavigationPropertyBinding() {
		NavigationPropertyBindingImpl navigationPropertyBinding = new NavigationPropertyBindingImpl();
		return navigationPropertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindPackage getBindPackage() {
		return (BindPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BindPackage getPackage() {
		return BindPackage.eINSTANCE;
	}

} //BindFactoryImpl
