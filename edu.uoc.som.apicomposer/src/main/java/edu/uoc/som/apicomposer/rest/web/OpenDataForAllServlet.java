package edu.uoc.som.apicomposer.rest.web;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uoc.som.apicomposer.rest.odata.ODataApplication;


public class OpenDataForAllServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
 
  @Inject
  private ODataApplication oDataApplication;

  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
    
      oDataApplication.process(req, resp);

    } catch (RuntimeException e) {
    
      throw new ServletException(e);
    }
  }
}
