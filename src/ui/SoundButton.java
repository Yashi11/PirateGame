package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.LoadSave;
import static utils.Constants.UI.PauseButtons.*;

public class SoundButton extends PauseButton{
	private BufferedImage[][] soundImage;
	private boolean mouseOver,mousePressed;
	private boolean muted;
	private int rowIndex,columnIndex;
	public boolean isMouseOver() {
		return mouseOver;
	}

	
	public SoundButton(int x, int y, int width, int height) {
		super(x, y, width, height);
		loadSoundImgs();
	}

	private void loadSoundImgs() {
		BufferedImage temp=LoadSave.loadSpriteAtlas(LoadSave.SOUND_BUTTONS);
		soundImage = new BufferedImage[2][3];
		for(int i=0;i<soundImage.length;i++)
		{
			for(int j=0;j<soundImage[i].length;j++)
			{
				soundImage[i][j]=temp.getSubimage(j*SOUND_SIZE_DEFAULT, i*SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT);
			}
		}
		
	}
	public void update()
	{
		if(muted)
			rowIndex=1;
		else 
			rowIndex=0;
		columnIndex=0;
		if(mouseOver)
			columnIndex=1;
		if(mousePressed)
			columnIndex=2;
	}
	public void resetBools() {
		mouseOver=false;
		mousePressed=false;
	}
	public void draw(Graphics g) {
		g.drawImage(soundImage[rowIndex][columnIndex], x, y, width, height, null);
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean muted) {
		this.muted = muted;
	}

	
}
