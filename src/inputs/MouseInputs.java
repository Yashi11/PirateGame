package inputs;

import java.awt.event.MouseMotionListener;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import  gamestates.Gamestate;


public class MouseInputs implements MouseListener,MouseMotionListener{
	private GamePanel gamepanel;
	public MouseInputs(GamePanel gamepanel)
	{
		this.gamepanel=gamepanel;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		switch(Gamestate.state) {
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseDragged(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().mouseDragged(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamepanel.getGame().getMenu().mouseMoved(e);
			break;
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseMoved(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().mouseMoved(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(Gamestate.state) {
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseClicked(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamepanel.getGame().getMenu().mousePressed(e);
			break;
		case PLAYING:
			gamepanel.getGame().getPlaying().mousePressed(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().mousePressed(e);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			gamepanel.getGame().getMenu().mouseReleased(e);
			break;
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseReleased(e);
			break;
		case OPTIONS:
			gamepanel.getGame().getGameOptions().mouseReleased(e);
			break;
		default:
			break;
		}
		
	}

}
