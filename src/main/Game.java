package main;

import java.awt.Graphics;

import audio.AudioPlayer;
import gamestates.GameOptions;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;
import ui.AudioOptions;
import utils.LoadSave;

public class Game implements Runnable{
	private GameWindow gamewindow;
	private GamePanel gamepanel;
	private AudioOptions audioOption;
	private AudioPlayer audioPlayer;
	
	private Thread gamethread;
	private final int SET_FPS=120;
	private final int SET_UPS=200;
	
	private Playing playing;
	private Menu menu;
	private GameOptions gameoptions;
	public final static int DEFAULT_TILE_SIZE=32;
	public final static float SCALE=2f;
	public final static int TILES_IN_WIDTH=26;
	public final static int TILES_IN_HEIGHT=14;
	public final static int TILES_SIZE=(int)(DEFAULT_TILE_SIZE*SCALE);
	public final static int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;
	public final static int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;

	
	public  Game() {
		LoadSave.GetAllLevels();
		initClasses();
		gamepanel = new GamePanel(this);
		gamewindow=new GameWindow(gamepanel);
		gamepanel.setFocusable(true);
		gamepanel.requestFocus();
		startGameLoop();
	}
	
	private void initClasses() {
		audioOption = new AudioOptions(this);
		audioPlayer = new AudioPlayer();
		menu = new Menu(this);
		playing = new Playing(this);
		gameoptions=new GameOptions(this);
		
	}
	private void startGameLoop()
	{
		gamethread = new Thread(this);
		gamethread.start();
	}
	
	public void update() {		
		switch(Gamestate.state)
		{
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case OPTIONS:
			gameoptions.update();
			break;
		case QUIT:
		default:
			System.exit(0);
			break;
		}
	}
	public void render(Graphics g)
	{
		switch(Gamestate.state)
		{
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
			playing.draw(g);
			break;
		case OPTIONS:
			gameoptions.draw(g);
		default:
			break;
		}
		
	}
	@Override
	public void run() {
		double timePerFrame=1000000000/SET_FPS;
		double timePerUpdate=1000000000/SET_UPS;
		
		long previousTime=System.nanoTime();
		
		int frames=0;
		int updates=0;
		long lastCheck=System.currentTimeMillis();
		double deltaU=0;
		double deltaF=0;
		while(true)
		{
			long currentTime=System.nanoTime();
			deltaU+=(currentTime-previousTime)/timePerUpdate;
			deltaF+=(currentTime-previousTime)/timePerFrame;
			previousTime=currentTime;
			if(deltaU>=1)
			{
				update();
				updates++;
				deltaU--;
			}
			if(deltaF>=1)
			{
				gamepanel.repaint();
				frames++;
				deltaF--;
			}
//			if(now-lastFrame>=timePerFrame)
//			{
//				gamepanel.repaint();
//				lastFrame=now;
//				frames++;
//			}
		
			if(System.currentTimeMillis()-lastCheck>=1000) {
				lastCheck=System.currentTimeMillis();
				System.out.println("FPS is "+ frames +" | UPS is "+updates);
				updates=0;
				frames=0;
			}
		}
		
	}
	public void windowFocusLost()
	{
		if(Gamestate.state == Gamestate.PLAYING)
			playing.getPlayer().resetDirBooleans();
	}
	public Menu getMenu() {
		return menu;
	}
	public Playing getPlaying() {
		return playing;
	}
	public AudioOptions getAudioOption() {
		return audioOption;
	}
	public GameOptions getGameOptions() {
		return gameoptions;
	}
	public AudioPlayer getAudioPlayer() {
		return audioPlayer;
	}
	
}
