package org.asuscomm.gr1ml0ck.slingtemplate.servlets;

import static org.junit.Assert.assertEquals;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;


/**
 * Unit tests for {@link HelloWordServlet}.
 */
public class HelloWorldServletTest {

  @Rule
  public final SlingContext context = new SlingContext();

 private HelloWordServlet servlet = new HelloWordServlet();

  @Test
  public void testDoGet() throws IOException {
    SlingHttpServletRequest request = new MockSlingHttpServletRequest(this.context.bundleContext());
    MockSlingHttpServletResponse response = new MockSlingHttpServletResponse();
    this.servlet.doGet(request, response);

    assertEquals("{\"value\":\"Hello World\"}", response.getOutputAsString());
  }
}
