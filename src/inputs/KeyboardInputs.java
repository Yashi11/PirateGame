package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import static utils.Constants.Directions.*;
import gamestates.Gamestate;

public class KeyboardInputs implements KeyListener {
	private GamePanel gamepanel;
	public KeyboardInputs(GamePanel gamepanel)
	{
		this.gamepanel=gamepanel;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamepanel.getGame().getMenu().keyPressed(e);
			break;
		case PLAYING:
			gamepanel.getGame().getPlaying().keyPressed(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().keyPressed(e);
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamepanel.getGame().getMenu().keyReleased(e);
			break;
		case PLAYING:
			gamepanel.getGame().getPlaying().keyReleased(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().keyReleased(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
