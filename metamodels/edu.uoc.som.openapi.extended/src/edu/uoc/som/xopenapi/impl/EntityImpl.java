/**
 */
package edu.uoc.som.xopenapi.impl;

import edu.uoc.som.xopenapi.Entity;
import edu.uoc.som.xopenapi.NavigationProperty;
import edu.uoc.som.xopenapi.Property;
import edu.uoc.som.xopenapi.XOpenAPIPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.impl.EntityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link edu.uoc.som.xopenapi.impl.EntityImpl#getNavigationProperties <em>Navigation Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends SchemaExtensionImpl implements Entity {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getNavigationProperties() <em>Navigation Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigationProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigationProperty> navigationProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XOpenAPIPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<Property>(Property.class, this, XOpenAPIPackage.ENTITY__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NavigationProperty> getNavigationProperties() {
		if (navigationProperties == null) {
			navigationProperties = new EObjectResolvingEList<NavigationProperty>(NavigationProperty.class, this, XOpenAPIPackage.ENTITY__NAVIGATION_PROPERTIES);
		}
		return navigationProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XOpenAPIPackage.ENTITY__PROPERTIES:
				return getProperties();
			case XOpenAPIPackage.ENTITY__NAVIGATION_PROPERTIES:
				return getNavigationProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XOpenAPIPackage.ENTITY__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case XOpenAPIPackage.ENTITY__NAVIGATION_PROPERTIES:
				getNavigationProperties().clear();
				getNavigationProperties().addAll((Collection<? extends NavigationProperty>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XOpenAPIPackage.ENTITY__PROPERTIES:
				getProperties().clear();
				return;
			case XOpenAPIPackage.ENTITY__NAVIGATION_PROPERTIES:
				getNavigationProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XOpenAPIPackage.ENTITY__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case XOpenAPIPackage.ENTITY__NAVIGATION_PROPERTIES:
				return navigationProperties != null && !navigationProperties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntityImpl
