package entities;

import static utils.Constants.PlayerConstants.IDLE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import main.Game;

public abstract class Entity {
	protected float x,y;
	protected int width,height;
	protected Rectangle2D.Float hitbox;
	protected int aniTick,aniIndex;
	protected int state;
	protected float airSpeed;
	protected boolean inAir = false;
	protected int maxHealth;
	protected int currentHealth;
	protected Rectangle.Float attackBox;
	protected int attackBoxOffsetX;
	protected float walkSpeed;

	public Entity(float x,float y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	protected void initHitbox(int width,int height) {
		hitbox=new Rectangle2D.Float(x,y,(int)(width*Game.SCALE),(int)(height*Game.SCALE));
	}
	protected void initAttackBox(int h,int w,int off) {
		attackBox=new Rectangle2D.Float(x,y,(int)(h*Game.SCALE),(int)(w*Game.SCALE));
		attackBoxOffsetX = (int)(Game.SCALE*off);
	}
	protected void drawHitbox(Graphics g,int xLvlOffset)
	{
		g.setColor(Color.PINK);
		g.drawRect((int)hitbox.x-xLvlOffset,(int)hitbox.y,(int)hitbox.width,(int)hitbox.height);
	}
	protected void drawAttackBox(Graphics g, int lvlOffsetX) {
		g.setColor(Color.red);
		g.drawRect((int)attackBox.x-lvlOffsetX,(int)attackBox.y,(int) attackBox.width,(int)attackBox.height);
		
	}
	
//	protected void updateHitbox() {
//		hitbox.x=(int)x;
//		hitbox.y=(int)y;
//	}
	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
	public int getState()
	{
		return state;
	}
	public int getAniIndex()
	{
		return aniIndex;
	}
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
}
