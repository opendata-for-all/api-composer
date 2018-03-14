/**
 */
package edu.uoc.som.bind;

import edu.uoc.som.xopenapi.NavigationProperty;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Property Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.NavigationPropertyBinding#getBinded <em>Binded</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.bind.BindPackage#getNavigationPropertyBinding()
 * @model
 * @generated
 */
public interface NavigationPropertyBinding extends BindingElement {
	/**
	 * Returns the value of the '<em><b>Binded</b></em>' reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.NavigationProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binded</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binded</em>' reference list.
	 * @see edu.uoc.som.bind.BindPackage#getNavigationPropertyBinding_Binded()
	 * @model
	 * @generated
	 */
	EList<NavigationProperty> getBinded();

} // NavigationPropertyBinding
