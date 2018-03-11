package edu.uoc.som.apicomposer.rest.odata;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.debug.DefaultDebugSupport;


@ApplicationScoped
public class ODataApplication implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	  
	  @Inject
	  private ODataCollectionProcessor oDataCollectionProcessor;
	  
	  @Inject
	  private ODataEnityProcessor oDataEnityProcessor;
	  
	  @Inject
	  private EdmProvider edmProvider;
	  
	  
	  private ServiceMetadata edm;
	  
	  private   ODataHttpHandler handler;
	  
	  @PostConstruct
	  public void init() {
		  OData odata = OData.newInstance();
		  edm = odata.createServiceMetadata(edmProvider, new ArrayList<EdmxReference>());
	      handler = odata.createHandler(edm);
	      handler.register(oDataCollectionProcessor);
	      handler.register(oDataEnityProcessor);
	      handler.register(new DefaultDebugSupport());
	  }
	  
	  public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  handler.process(req,resp);
		  
	  }



	public ODataCollectionProcessor getoDataCollectionProcessor() {
		return oDataCollectionProcessor;
	}

	public void setoDataCollectionProcessor(ODataCollectionProcessor oDataCollectionProcessor) {
		this.oDataCollectionProcessor = oDataCollectionProcessor;
	}

	public ODataEnityProcessor getoDataEnityProcessor() {
		return oDataEnityProcessor;
	}

	public void setoDataEnityProcessor(ODataEnityProcessor oDataEnityProcessor) {
		this.oDataEnityProcessor = oDataEnityProcessor;
	}

	public EdmProvider getEdmProvider() {
		return edmProvider;
	}

	public void setEdmProvider(EdmProvider edmProvider) {
		this.edmProvider = edmProvider;
	}

	public ServiceMetadata getEdm() {
		return edm;
	}

	public void setEdm(ServiceMetadata edm) {
		this.edm = edm;
	}

	public ODataHttpHandler getHandler() {
		return handler;
	}

	public void setHandler(ODataHttpHandler handler) {
		this.handler = handler;
	}
	  
}
