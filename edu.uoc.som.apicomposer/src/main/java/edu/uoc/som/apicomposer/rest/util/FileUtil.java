package edu.uoc.som.apicomposer.rest.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import core.OpenAPIPackage;
import core.Root;

public class FileUtil {
	public static Root loadOpenAPIModel(URI uri) {
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getPackageRegistry().put(OpenAPIPackage.eNS_URI, OpenAPIPackage.eINSTANCE);
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put("oas", new XMIResourceFactoryImpl());
		Resource resource = resSet.getResource(uri, true);
		return (Root) resource.getContents().get(0);
	}

	public static void saveOpenAPIModel(Root apiRoot, URI uri) throws FileNotFoundException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("oas", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(uri);
		resource.getContents().add(apiRoot);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public static void saveFile(InputStream input, File location) throws IOException {
		  Files.copy(input, location.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
	}
	public static void saveUMLModel(Model model, URI uri) throws FileNotFoundException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		ResourceSet resSet = new ResourceSetImpl();
		ClassLoader classLoader = FileUtil.class.getClassLoader();
		resSet.getURIConverter().getURIMap().put(URI.createFileURI(new File(classLoader.getResource("imported/UMLPrimitiveTypes.library.uml").getFile()).getAbsolutePath()), URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml"));
		Resource resource = resSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveGlobalModel(Model globalModel) {
		try {
			globalModel.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
