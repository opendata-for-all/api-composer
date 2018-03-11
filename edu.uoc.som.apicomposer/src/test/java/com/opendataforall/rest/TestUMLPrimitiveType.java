package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.jupiter.api.Test;

public class TestUMLPrimitiveType {

	
	@Test
	public void assertUMLPrimitiveType() {
		ClassLoader classLoader = getClass().getClassLoader();
		File odataProfile = new File(classLoader.getResource("imported/odata.profile.uml").getFile());
		File primitiveType = new File(classLoader.getResource("imported/UMLPrimitiveTypes.library.uml").getFile());
		
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		set.getURIConverter().getURIMap().put(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"), URI.createFileURI(odataProfile.getAbsolutePath()));
		set.getURIConverter().getURIMap().put(URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"), URI.createFileURI(primitiveType.getAbsolutePath()));
		File annotatedUMLModel = new File(classLoader.getResource("models/examples/addedODataAnnotations.uml").getFile());
		Resource annotatedResource = set.getResource(URI.createFileURI(annotatedUMLModel.getAbsolutePath()), true);
		Property property  = (Property) annotatedResource.getEObject("_guN0IL_AEee6sJ5lvxiu9w");
		System.out.println(UMLUtil.isString(property.getType()));
		assertTrue(UMLUtil.isString(property.getType()));
	
		
	
	}

	
}
