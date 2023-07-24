package gamestates;

import entities.EnemyManager;
import ui.GameOverOverlay;
import ui.LevelCompletedOverlay;
import entities.Player;
import levels.LevelManager;
import main.Game;
import objects.ObjectManager;
import ui.PauseOverlay;
import utils.LoadSave;


import static main.Game.SCALE;
import static utils.Constants.Environment.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Playing extends State implements Statemethods {
	private Player player;
	private LevelManager levelmanager;
	private ObjectManager objectmanager;
	private EnemyManager enemymanager;
	private PauseOverlay pauseoverlay;
	private GameOverOverlay gameoverOverlay;
	private LevelCompletedOverlay levelcompletedoverlay;
	private boolean paused=false;
	
	private int xLvlOffset;
	private int leftBorder = (int) (0.3*Game.GAME_WIDTH);
	private int rightBorder = (int) (0.7*Game.GAME_WIDTH);
	private int maxLvlOffsetX;
	
	private BufferedImage bgImage,bigCloud,smallCloud;
	private int[] smallCloudsPos;
	private Random rnd = new Random();
	
	private boolean gameOver;
	private boolean lvlcompleted;
	private boolean playerDying;
	
	public Playing(Game game) {
		super(game);
		initClasses();
		bgImage=LoadSave.loadSpriteAtlas(LoadSave.PLAYING_BACKGROUND);
		bigCloud=LoadSave.loadSpriteAtlas(LoadSave.BIG_CLOUDS);
		smallCloud=LoadSave.loadSpriteAtlas(LoadSave.SMALL_CLOUDS);
		smallCloudsPos=new int[8];
		for(int i=0;i<smallCloudsPos.length;i++)
		{
			smallCloudsPos[i]=(int)(100*Game.SCALE+rnd.nextInt((int)(150*Game.SCALE)));
		}
		calcLvlOffset();
		loadStartLevel();
	}
	
	
	public void loadNextLevel() {
		resetAll();
		levelmanager.loadNextLevel();
		player.setSpawn(levelmanager.getCurrentLevel().getPlayerSpawn());
	}


	private void loadStartLevel() {
		enemymanager.loadEnemies(levelmanager.getCurrentLevel());
		objectmanager.loadObjects(levelmanager.getCurrentLevel());
	}

	private void calcLvlOffset() {
		maxLvlOffsetX = levelmanager.getCurrentLevel().getLvlOffset();
	}

	private void initClasses() {
		levelmanager=new LevelManager(game);
		enemymanager=new EnemyManager(this);
		objectmanager = new ObjectManager(this);
		
		player=new Player(200,200,(int) (64*SCALE),(int) (40*SCALE),this);
		player.loadLvlData(levelmanager.getCurrentLevel().getLevelData());
		player.setSpawn(levelmanager.getCurrentLevel().getPlayerSpawn());
		
		pauseoverlay = new PauseOverlay(this);
		gameoverOverlay=new GameOverOverlay(this);
		levelcompletedoverlay=new LevelCompletedOverlay(this);
	}
	
	@Override
	public void update() {
		if(paused)
			pauseoverlay.update();
		else if(lvlcompleted)
			levelcompletedoverlay.update();
		else if(gameOver) {
			gameoverOverlay.update();
		}
		else if(playerDying) {
			player.update();
		}
		else if(!gameOver) {
			levelmanager.update();
			objectmanager.update(levelmanager.getCurrentLevel().getLevelData(),player);
			player.update();
			enemymanager.update(levelmanager.getCurrentLevel().getLevelData(),player);
			checkCloseToBorder();
		}
	}


	private void checkCloseToBorder() {
		int playerX = (int) player.getHitbox().x;
		int diff = playerX - xLvlOffset;
		if(diff>rightBorder)
			xLvlOffset += diff-rightBorder;
		else if(diff<leftBorder)
			xLvlOffset += diff-leftBorder;
		
		if(xLvlOffset > maxLvlOffsetX)
			xLvlOffset = maxLvlOffsetX;
		else if(xLvlOffset<0)
			xLvlOffset =0;
	}


	@Override
	public void draw(Graphics g) {
		g.drawImage(bgImage, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		drawClouds(g);
		levelmanager.draw(g, xLvlOffset);
		player.render(g,xLvlOffset);
		enemymanager.draw(g,xLvlOffset);
		objectmanager.draw(g, xLvlOffset);
		if(paused) {
			g.setColor(new Color(0,0,0,150));
			g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
			pauseoverlay.draw(g);
		}else if(gameOver)
		{
			gameoverOverlay.draw(g);
		}
		else if(lvlcompleted)
			levelcompletedoverlay.draw(g);	
		
	}

	
	
	private void drawClouds(Graphics g) {
		for(int i=0;i<3;i++)
			g.drawImage(bigCloud, i*BIG_CLOUD_WIDTH-(int)(xLvlOffset*0.3),(int)(204*Game.SCALE), BIG_CLOUD_WIDTH, BIG_CLOUD_HEIGHT, null);
		for(int i=0;i<smallCloudsPos.length;i++)
			g.drawImage(smallCloud, SMALL_CLOUD_WIDTH*4*i-(int)(xLvlOffset*0.7),smallCloudsPos[i], SMALL_CLOUD_WIDTH, SMALL_CLOUD_HEIGHT,null);
	}

	public void resetAll()
	{
		gameOver = false;
		paused = false;
		lvlcompleted=false;
		playerDying=false;
		player.resetAll();
		enemymanager.resetAllEnemies();
		objectmanager.resetAllObjects();
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void checkEnemyHit(Rectangle2D.Float attackBox)
	{
		enemymanager.checkEnemyHit(attackBox);
	}
    public void checkPotionTouched(Float hitbox) {
		objectmanager.checkObjectTouched(hitbox);
	}
    public void checkSpikesTouched(Player p) {
		objectmanager.checkSpikesTouched(p);
	}
	public void mouseDragged(MouseEvent e) {
		if (!gameOver)
			if(paused)
				pauseoverlay.mouseDragged(e);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (!gameOver) {
			if(paused)
				pauseoverlay.mousePressed(e);
			else if(lvlcompleted)
				levelcompletedoverlay.mousePressed(e);
			}else
				gameoverOverlay.mousePressed(e);
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		if (!gameOver) {
			if(paused)
				pauseoverlay.mouseReleased(e);
			else if(lvlcompleted)
				levelcompletedoverlay.mouseReleased(e);
			}else
				gameoverOverlay.mouseReleased(e);
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		if (!gameOver) {
			if(paused)
				pauseoverlay.mouseMoved(e);
			else if(lvlcompleted)
				levelcompletedoverlay.mouseMoved(e);
			}else
				gameoverOverlay.mouseMoved(e);

	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(gameOver)
			gameoverOverlay.keyPressed(e);
		else {
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_A:
				player.setLeft(true);
				break;
			case KeyEvent.VK_D:
				player.setRight(true);
				break;
			case KeyEvent.VK_SPACE:
				player.setJump(true);
				break;
			case KeyEvent.VK_BACK_SPACE:
				Gamestate.state = Gamestate.MENU;
			case KeyEvent.VK_ESCAPE:
				paused=!paused;
			case KeyEvent.VK_Z:
				if(!gameOver)
					player.powerAttack();
			case KeyEvent.VK_X:
				if (!gameOver)
						player.setAttacking(true);	
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(!gameOver) {
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_A:
				player.setLeft(false);
				break;
			case KeyEvent.VK_D:
				player.setRight(false);
				break;
			case KeyEvent.VK_SPACE:
				player.setJump(false);
				break;
			}
		}
		
	}
	public void setLevelCompleted(boolean levelCompleted) {
		this.lvlcompleted = levelCompleted;
		if(levelCompleted)
			game.getAudioPlayer().lvlCompleted();
	}

	public void setMaxLvlOffset(int lvlOffset) {
		this.maxLvlOffsetX = lvlOffset;
	}

	public void unpauseGame() {
		paused=false;
	}
	public void windowFocusLost()
	{
		player.resetDirBooleans();
	}
	public Player getPlayer() {
		return player;
	}
	public EnemyManager getEnemyManager() {
		return enemymanager;
	}
	public ObjectManager getObjectManager() {
		return objectmanager;
	}
	public LevelManager getLevelManager() {
		return levelmanager;
	}

	public void checkObjectHit(Float attackBox) {
		objectmanager.checkObjectHit(attackBox);
	}

	public void setPlayerDying(boolean playerDying) {
		this.playerDying = playerDying;

	}
	


	
}
