/**
 */
package edu.uoc.som.xopenapi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.SecurityContext#getSecurityRequirements <em>Security Requirements</em>}</li>
 * </ul>
 *
 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getSecurityContext()
 * @model abstract="true"
 * @generated
 */
public interface SecurityContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Security Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.uoc.som.xopenapi.SecurityRequirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Requirements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Requirements</em>' containment reference list.
	 * @see edu.uoc.som.xopenapi.XOpenAPIPackage#getSecurityContext_SecurityRequirements()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecurityRequirement> getSecurityRequirements();

} // SecurityContext
