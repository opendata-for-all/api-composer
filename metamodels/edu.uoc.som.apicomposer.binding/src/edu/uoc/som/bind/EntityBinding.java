/**
 */
package edu.uoc.som.bind;

import edu.uoc.som.xopenapi.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.EntityBinding#getBinded <em>Binded</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.bind.BindPackage#getEntityBinding()
 * @model
 * @generated
 */
public interface EntityBinding extends BindingElement {
	/**
	 * Returns the value of the '<em><b>Binded</b></em>' reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binded</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binded</em>' reference list.
	 * @see edu.uoc.som.bind.BindPackage#getEntityBinding_Binded()
	 * @model
	 * @generated
	 */
	EList<Entity> getBinded();

} // EntityBinding
