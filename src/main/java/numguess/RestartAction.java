package numguess;

import static numguess.Constants.FORWARD_RESTART;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * This action is invoked when the game is restarted.
 */
public class RestartAction extends GameModelAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// obtain arguments from form bean
		DynaActionForm rangeForm = (DynaActionForm) form;
		int min = ((Integer) rangeForm.get("min")).intValue();
		int max = ((Integer) rangeForm.get("max")).intValue();

		// interact with model
		getGameModel().reset(min, max);

		// choose forwarding target
		return mapping.findForward(FORWARD_RESTART);
	}
}