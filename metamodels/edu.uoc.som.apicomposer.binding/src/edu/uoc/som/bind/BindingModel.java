/**
 */
package edu.uoc.som.bind;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.BindingModel#getBindingElements <em>Binding Elements</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.bind.BindPackage#getBindingModel()
 * @model
 * @generated
 */
public interface BindingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Binding Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Elements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Elements</em>' containment reference.
	 * @see #setBindingElements(BindingElement)
	 * @see edu.uoc.som.bind.BindPackage#getBindingModel_BindingElements()
	 * @model containment="true"
	 * @generated
	 */
	BindingElement getBindingElements();

	/**
	 * Sets the value of the '{@link edu.uoc.som.bind.BindingModel#getBindingElements <em>Binding Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Elements</em>' containment reference.
	 * @see #getBindingElements()
	 * @generated
	 */
	void setBindingElements(BindingElement value);

} // BindingModel
