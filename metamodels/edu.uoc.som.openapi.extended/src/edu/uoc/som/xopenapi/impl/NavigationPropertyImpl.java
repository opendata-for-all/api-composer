/**
 */
package edu.uoc.som.xopenapi.impl;

import edu.uoc.som.xopenapi.Entity;
import edu.uoc.som.xopenapi.NavigationProperty;
import edu.uoc.som.xopenapi.XOpenAPIPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.xopenapi.impl.NavigationPropertyImpl#getMultivalued <em>Multivalued</em>}</li>
 *   <li>{@link edu.uoc.som.xopenapi.impl.NavigationPropertyImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigationPropertyImpl extends SchemaExtensionImpl implements NavigationProperty {
	/**
	 * The default value of the '{@link #getMultivalued() <em>Multivalued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultivalued()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MULTIVALUED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultivalued() <em>Multivalued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultivalued()
	 * @generated
	 * @ordered
	 */
	protected Boolean multivalued = MULTIVALUED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Entity target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XOpenAPIPackage.Literals.NAVIGATION_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getMultivalued() {
		return multivalued;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultivalued(Boolean newMultivalued) {
		Boolean oldMultivalued = multivalued;
		multivalued = newMultivalued;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XOpenAPIPackage.NAVIGATION_PROPERTY__MULTIVALUED, oldMultivalued, multivalued));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Entity)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Entity newTarget) {
		Entity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XOpenAPIPackage.NAVIGATION_PROPERTY__MULTIVALUED:
				return getMultivalued();
			case XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XOpenAPIPackage.NAVIGATION_PROPERTY__MULTIVALUED:
				setMultivalued((Boolean)newValue);
				return;
			case XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET:
				setTarget((Entity)newValue);
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
			case XOpenAPIPackage.NAVIGATION_PROPERTY__MULTIVALUED:
				setMultivalued(MULTIVALUED_EDEFAULT);
				return;
			case XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET:
				setTarget((Entity)null);
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
			case XOpenAPIPackage.NAVIGATION_PROPERTY__MULTIVALUED:
				return MULTIVALUED_EDEFAULT == null ? multivalued != null : !MULTIVALUED_EDEFAULT.equals(multivalued);
			case XOpenAPIPackage.NAVIGATION_PROPERTY__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (multivalued: ");
		result.append(multivalued);
		result.append(')');
		return result.toString();
	}

} //NavigationPropertyImpl
