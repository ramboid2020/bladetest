package carlos.com.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Component( immediate = true,

   property = {
      "com.liferay.portlet.css-class-wrapper=portlet-greeter",
      "com.liferay.portlet.display-category=category.sample",
      "com.liferay.portlet.instanceable=true",
      "javax.portlet.display-name=Greeter Portlet",
      "javax.portlet.init-param.template-path=/",
      "javax.portlet.init-param.view-template=/view.jsp",      
      "javax.portlet.security-role-ref=power-user,user"
   },
   service = Portlet.class
)

//public class GreeterPortlet extends GenericPortlet {
public class GreeterPortlet extends MVCPortlet {
	private static final Log _logger = LogFactoryUtil.getLog(GreeterPortlet.class);

	//@Override
	//protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		_logger.info("************* GreeterPortlet doView ********************");

		PrintWriter printWriter = response.getWriter(); 
		printWriter.print("GreeterPortlet - Hello World!");

		super.render(request, response);

	}

}
