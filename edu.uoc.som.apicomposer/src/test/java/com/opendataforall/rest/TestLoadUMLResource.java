package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.jupiter.api.Test;


public class TestLoadUMLResource {

	@Test
	public void assertLoadUMLResource() {
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("models/examples/model.uml").getFile());
		Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		assertTrue(resource.getAllContents().hasNext());
	}

	@Test
	public void assertLoadUMLModel() {
		
	
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("models/examples/model.uml").getFile());
		Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		Model model = (Model) resource.getContents().get(0);
		assertTrue(model.getName().equals("uml"));
	}

	@Test
	public void assertReadUMLClass() {
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
	

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("models/examples/model.uml").getFile());
		Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		Model model = (Model) resource.getContents().get(0);
		boolean classFound = false;
		for (Iterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject child = it.next();

			if (child instanceof Class) {
				Class clazz = (Class) child;
				if (clazz.getName().equals("Country"))
					classFound = true;

			}

		}
		assertTrue(classFound);
	}
}
