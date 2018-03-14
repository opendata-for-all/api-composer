/**
 */
package edu.uoc.som.xopenapi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.Property#getMultivalued <em>Multivalued</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends SchemaExtension, TypedElement {
	/**
	 * Returns the value of the '<em><b>Multivalued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multivalued</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multivalued</em>' attribute.
	 * @see #setMultivalued(Boolean)
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getProperty_Multivalued()
	 * @model
	 * @generated
	 */
	Boolean getMultivalued();

	/**
	 * Sets the value of the '{@link edu.uoc.som.xopenapi.Property#getMultivalued <em>Multivalued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multivalued</em>' attribute.
	 * @see #getMultivalued()
	 * @generated
	 */
	void setMultivalued(Boolean value);

} // Property
