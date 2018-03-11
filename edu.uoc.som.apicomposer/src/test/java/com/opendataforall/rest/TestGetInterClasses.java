package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.jupiter.api.Test;

public class TestGetInterClasses {
	
	
	@Test
	public void assertGetInerClasses() {
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("models/global.uml").getFile());
		Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		Class clazz = (Class) resource.getEObject("_IHkWYLmdEeeF_PzGoMjwJg");
	}

}
