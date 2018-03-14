/**
 */
package edu.uoc.som.bind.impl;

import edu.uoc.som.bind.BindPackage;
import edu.uoc.som.bind.PropertyBinding;

import edu.uoc.som.xopenapi.Property;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.uoc.som.bind.impl.PropertyBindingImpl#getBinded <em>Binded</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyBindingImpl extends BindingElementImpl implements PropertyBinding {
	/**
	 * The cached value of the '{@link #getBinded() <em>Binded</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinded()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> binded;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BindPackage.Literals.PROPERTY_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getBinded() {
		if (binded == null) {
			binded = new EObjectResolvingEList<Property>(Property.class, this, BindPackage.PROPERTY_BINDING__BINDED);
		}
		return binded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BindPackage.PROPERTY_BINDING__BINDED:
				return getBinded();
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
			case BindPackage.PROPERTY_BINDING__BINDED:
				getBinded().clear();
				getBinded().addAll((Collection<? extends Property>)newValue);
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
			case BindPackage.PROPERTY_BINDING__BINDED:
				getBinded().clear();
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
			case BindPackage.PROPERTY_BINDING__BINDED:
				return binded != null && !binded.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyBindingImpl
