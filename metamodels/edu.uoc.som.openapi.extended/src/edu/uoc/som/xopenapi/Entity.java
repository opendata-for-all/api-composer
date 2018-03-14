/**
 */
package edu.uoc.som.xopenapi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.Entity#getProperties <em>Properties</em>}</li>
 *   <li>{@link edu.uoc.som.xopenapi.Entity#getNavigationProperties <em>Navigation Properties</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends SchemaExtension {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getEntity_Properties()
	 * @model
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Navigation Properties</b></em>' reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.NavigationProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation Properties</em>' reference list.
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getEntity_NavigationProperties()
	 * @model
	 * @generated
	 */
	EList<NavigationProperty> getNavigationProperties();

} // Entity
