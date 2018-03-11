package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.jupiter.api.Test;

public class TestODataProfile {

	@Test
	public void assertLoadODataProfile() {

		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);

		ClassLoader classLoader = getClass().getClassLoader();
		File odataProfile = new File(classLoader.getResource("imported/odata.profile.uml").getFile());
		Resource profileResource = set.getResource(URI.createFileURI(odataProfile.getAbsolutePath()), true);
		Profile profile = (Profile) profileResource.getEObject("_pWtvsO-mEeaLcvwqpORGRg");

		assertTrue(profile != null);
	}
	
}
