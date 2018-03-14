/**
 */
package edu.uoc.som.bind;

import edu.uoc.som.xopenapi.Property;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.PropertyBinding#getBinded <em>Binded</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.bind.BindPackage#getPropertyBinding()
 * @model
 * @generated
 */
public interface PropertyBinding extends BindingElement {
	/**
	 * Returns the value of the '<em><b>Binded</b></em>' reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binded</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binded</em>' reference list.
	 * @see edu.uoc.som.bind.BindPackage#getPropertyBinding_Binded()
	 * @model
	 * @generated
	 */
	EList<Property> getBinded();

} // PropertyBinding
