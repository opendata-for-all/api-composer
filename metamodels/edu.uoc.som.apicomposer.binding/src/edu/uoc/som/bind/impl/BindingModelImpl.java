/**
 */
package edu.uoc.som.bind.impl;

import edu.uoc.som.bind.BindPackage;
import edu.uoc.som.bind.BindingElement;
import edu.uoc.som.bind.BindingModel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.impl.BindingModelImpl#getBindingElements <em>Binding Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingModelImpl extends MinimalEObjectImpl.Container implements BindingModel {
	/**
	 * The cached value of the '{@link #getBindingElements() <em>Binding Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingElements()
	 * @generated
	 * @ordered
	 */
	protected BindingElement bindingElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindPackage.Literals.BINDING_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingElement getBindingElements() {
		return bindingElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindingElements(BindingElement newBindingElements, NotificationChain msgs) {
		BindingElement oldBindingElements = bindingElements;
		bindingElements = newBindingElements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BindPackage.BINDING_MODEL__BINDING_ELEMENTS, oldBindingElements, newBindingElements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingElements(BindingElement newBindingElements) {
		if (newBindingElements != bindingElements) {
			NotificationChain msgs = null;
			if (bindingElements != null)
				msgs = ((InternalEObject)bindingElements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BindPackage.BINDING_MODEL__BINDING_ELEMENTS, null, msgs);
			if (newBindingElements != null)
				msgs = ((InternalEObject)newBindingElements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BindPackage.BINDING_MODEL__BINDING_ELEMENTS, null, msgs);
			msgs = basicSetBindingElements(newBindingElements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindPackage.BINDING_MODEL__BINDING_ELEMENTS, newBindingElements, newBindingElements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BindPackage.BINDING_MODEL__BINDING_ELEMENTS:
				return basicSetBindingElements(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BindPackage.BINDING_MODEL__BINDING_ELEMENTS:
				return getBindingElements();
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
			case BindPackage.BINDING_MODEL__BINDING_ELEMENTS:
				setBindingElements((BindingElement)newValue);
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
			case BindPackage.BINDING_MODEL__BINDING_ELEMENTS:
				setBindingElements((BindingElement)null);
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
			case BindPackage.BINDING_MODEL__BINDING_ELEMENTS:
				return bindingElements != null;
		}
		return super.eIsSet(featureID);
	}

} //BindingModelImpl
