/**
 */
package edu.uoc.som.xopenapi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.NavigationProperty#getMultivalued <em>Multivalued</em>}</li>
 *   <li>{@link edu.uoc.som.xopenapi.NavigationProperty#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getNavigationProperty()
 * @model
 * @generated
 */
public interface NavigationProperty extends SchemaExtension {
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
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getNavigationProperty_Multivalued()
	 * @model
	 * @generated
	 */
	Boolean getMultivalued();

	/**
	 * Sets the value of the '{@link edu.uoc.som.xopenapi.NavigationProperty#getMultivalued <em>Multivalued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multivalued</em>' attribute.
	 * @see #getMultivalued()
	 * @generated
	 */
	void setMultivalued(Boolean value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Entity)
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getNavigationProperty_Target()
	 * @model
	 * @generated
	 */
	Entity getTarget();

	/**
	 * Sets the value of the '{@link edu.uoc.som.xopenapi.NavigationProperty#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Entity value);

} // NavigationProperty
