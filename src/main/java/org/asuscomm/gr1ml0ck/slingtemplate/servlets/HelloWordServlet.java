package org.asuscomm.gr1ml0ck.slingtemplate.servlets;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;

import org.asuscomm.gr1ml0ck.slingtemplate.models.HelloWorldModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;


/**
 * Sling Servlet Example
 * @see <a href='https://sling.apache.org/documentation/the-sling-engine/servlets.html">Docs</a>
 */
@Component(
    service = Servlet.class,
    property = {
        SLING_SERVLET_PATHS + "=/api/hello-world",
        SLING_SERVLET_METHODS + "=GET"
    }
)
public class HelloWordServlet extends SlingSafeMethodsServlet {
  private static final String CONTENT_TYPE_JSON = "application/json";

  private static final String HELLO_WORLD = "Hello World";

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Override
  protected void doGet(SlingHttpServletRequest request,
                       SlingHttpServletResponse response) throws IOException {
    HelloWorldModel helloWorld = new HelloWorldModel(HELLO_WORLD);
    String json = MAPPER.writeValueAsString(helloWorld);
    response.setStatus(SC_OK);
    response.setContentType(CONTENT_TYPE_JSON);
    response.getWriter().write(json);
  }
}
