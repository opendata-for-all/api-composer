/**
 */
package edu.uoc.som.bind;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.uoc.som.bind.BindPackage
 * @generated
 */
public interface BindFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BindFactory eINSTANCE = edu.uoc.som.bind.impl.BindFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binding Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Model</em>'.
	 * @generated
	 */
	BindingModel createBindingModel();

	/**
	 * Returns a new object of class '<em>Entity Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Binding</em>'.
	 * @generated
	 */
	EntityBinding createEntityBinding();

	/**
	 * Returns a new object of class '<em>Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Binding</em>'.
	 * @generated
	 */
	PropertyBinding createPropertyBinding();

	/**
	 * Returns a new object of class '<em>Navigation Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Property Binding</em>'.
	 * @generated
	 */
	NavigationPropertyBinding createNavigationPropertyBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BindPackage getBindPackage();

} //BindFactory
