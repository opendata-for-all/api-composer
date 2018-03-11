package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;

import core.OpenAPIPackage;



public class TestLoadOpenAPIModel {

	@Test
	public void assertLoadOpenAPIModel() {
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(OpenAPIPackage.eNS_URI, OpenAPIPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put("oas", new XMIResourceFactoryImpl());
		

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("models/openapi/battuta.oas").getFile());
		Resource resource = set.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		assertTrue(resource.getAllContents().hasNext());
	}

	
}
