package numguess;

import static numguess.Constants.FORWARD_RIGHT;
import static numguess.Constants.FORWARD_WRONG;
import static numguess.Constants.PARAMETER_GUESS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * This action is invoked when the user submits a guess. It acts as glue that
 * connects the UI and the game logic without one knowing about the other.
 * Communication with the UI (the views) is done entirely via the form bean
 * GuessResult.
 */
public class GuessAction extends GameModelAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// obtain arguments from form bean
		DynaActionForm guessForm = (DynaActionForm) form;
		int guess = ((Integer) guessForm.get(PARAMETER_GUESS)).intValue();

		// interact with model
		GuessResult result = getGameModel().guess(guess);

		// populate form with outgoing info from model
		BeanUtils.copyProperties(guessForm, result);

		// choose forwarding target
		if (result.getComparison() == 0) {
			return mapping.findForward(FORWARD_RIGHT);
		} else {
			return mapping.findForward(FORWARD_WRONG);
		}
	}
}