package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.jupiter.api.Test;

public class TestAnnotatedUMLModel {

	@Test
	public void assertReadModel() {

		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);

		ClassLoader classLoader = getClass().getClassLoader();
		File odataProfile = new File(classLoader.getResource("models/examples/addedODataAnnotations.uml").getFile());
		Resource annotatedResource = set.getResource(URI.createFileURI(odataProfile.getAbsolutePath()), true);
		Model model = (Model) annotatedResource.getContents().get(0);

		assertTrue(model.getName().equals("addedODataAnnotations"));
	}

	@Test
	public void assertReadAppiedProfile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File odataProfile = new File(classLoader.getResource("imported/odata.profile.uml").getFile());
		URIConverter.URI_MAP.put(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"),
				URI.createFileURI(odataProfile.getAbsolutePath()));
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);

		File annotatedUMLModel = new File(
				classLoader.getResource("models/examples/addedODataAnnotations.uml").getFile());
		Resource annotatedResource = set.getResource(URI.createFileURI(annotatedUMLModel.getAbsolutePath()), true);
		Model model = (Model) annotatedResource.getContents().get(0);

		System.out.println("appliedProfile: " + model.getAppliedProfiles().get(0).getName());

		assertTrue(model.getAppliedProfiles().get(0).getName().equals("ODataProfile"));
	}

	@Test
	public void assertReadAppiedStereotype() {
		ClassLoader classLoader = getClass().getClassLoader();
		File odataProfile = new File(classLoader.getResource("imported/odata.profile.uml").getFile());
		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		set.getURIConverter().getURIMap().put(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"),
				URI.createFileURI(odataProfile.getAbsolutePath()));
		File annotatedUMLModel = new File(
				classLoader.getResource("models/examples/addedODataAnnotations.uml").getFile());
		Resource annotatedResource = set.getResource(URI.createFileURI(annotatedUMLModel.getAbsolutePath()), true);
		Model model = (Model) annotatedResource.getContents().get(0);

		Resource profileResource = set.getResource(URI.createFileURI(odataProfile.getAbsolutePath()), true);
		Stereotype odService = (Stereotype) profileResource.getEObject("_F6AskPOCEeapod9Ch20uSQ");
		assertTrue(model.isStereotypeApplied(odService));
		assertTrue(UMLUtil.getTaggedValue(model, "ODataProfile::ODService", "version").equals("0.0.1"));

	}

	@Test
	public void assertApplyStereotype() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File profile = new File(classLoader.getResource("imported/profile.test.profile.uml").getFile());
		UMLPackage.eINSTANCE.eClass();
		ResourceSet set = new ResourceSetImpl();
		URI baseUri = URI.createURI(
				"jar:file:/C:\\Users\\hamza\\work\\eclipse-oxygen\\eclipse\\plugins\\org.eclipse.uml2.uml.resources_5.3.0.v20170605-1616.jar!/");
		set.getURIConverter().getURIMap().put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
				baseUri.appendSegment("libraries").appendSegment(""));
		set.getURIConverter().getURIMap().put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
				baseUri.appendSegment("metamodels").appendSegment(""));
		set.getURIConverter().getURIMap().put(URI.createURI(UMLResource.PROFILES_PATHMAP),
				baseUri.appendSegment("profiles").appendSegment(""));
		
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);

		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.PROFILE_FILE_EXTENSION, UMLResource.Factory.INSTANCE );
		// set.getURIConverter().getURIMap().put(URI.createURI("pathmap://ODA_PROFILES/odata.profile.uml"),
		// URI.createFileURI(odataProfile.getAbsolutePath()));
		File modelFile = new File(classLoader.getResource("models/examples/model.uml").getFile());
		Resource annotatedResource = set.getResource(URI.createFileURI(modelFile.getAbsolutePath()), true);
		Model model = (Model) annotatedResource.getContents().get(0);

		Resource profileResource = set.getResource(URI.createFileURI(profile.getAbsolutePath()), true);
		Profile pro = (Profile) profileResource.getEObject("__IfG0N7QEeeL1tAmWd0VXg");
		model.applyProfile(pro);
		pro = model.getAppliedProfiles().get(0);
		for(PackageableElement element : model.getPackagedElements()) {
			if(element instanceof  org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class clazz = (Class) element;
				System.out.println(model.getAllAppliedProfiles());
				System.out.println(clazz.getApplicableStereotype("profile::Test"));
				Stereotype test = (Stereotype) profileResource.getEObject("_I97h8N7REeeL1tAmWd0VXg");
				clazz.applyStereotype(test);
			}
		}
		
		
	

	}
	
	@Test
	public void assertApplyStaticStereotype() throws IOException {
		

	}

}
