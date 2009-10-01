package numguess;

import org.apache.struts.action.Action;

/**
 * An action that depends on a game model instance.
 */
public class GameModelAction extends Action implements GameModelAware {

	private GameModel model;

	@Override
	public void setGameModel(GameModel model) {
		this.model = model;
	}

	protected GameModel getGameModel() {
		return model;
	}
}
