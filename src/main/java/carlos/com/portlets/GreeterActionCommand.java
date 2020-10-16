package carlos.com.portlets;

import com.liferay.petra.string.StringPool;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=carlos_com_portlets_GreeterPortlet",
		"mvc.command.name=greet"
	},
	service = MVCActionCommand.class
)
public class GreeterActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		_handleActionCommand(actionRequest);

		return true;
	}

	private void _handleActionCommand(ActionRequest actionRequest) {
		String name = ParamUtil.get(actionRequest, "name", StringPool.BLANK);

		if (_log.isInfoEnabled()) {
			_log.info("GreeterActionCommand: Hello " + name);
		}

		String greetingMessage = "GreeterActionCommand: Hello " + name + "! Welcome to OSGi";

		actionRequest.setAttribute("GREETER_MESSAGE", greetingMessage);

		SessionMessages.add(actionRequest, "greetingMessage", greetingMessage);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		GreeterActionCommand.class);

}
