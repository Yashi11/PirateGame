package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.net.URISyntaxException;
import java.net.URL;

import entities.Crabby;
import main.Game;
import static utils.Constants.EnemyConstants.CRABBY;
public class LoadSave {
	public static String PLAYER_ATLAS="player_sprites.png";
	public static String LEVEL_ATLAS="outside_sprites.png";
	public static String CRABBY_ATLAS="crabby_sprite.png";
	public static String POTION_ATLAS = "potions_sprites.png";
	public static String CONTAINER_ATLAS = "objects_sprites.png";
	public static String TRAP_ATLAS = "trap_atlas.png";
	public static String CANNON_ATLAS = "cannon_atlas.png";
	public static String CANNON_BALL = "ball.png";
	public static String DEATH_SCREEN = "death_screen.png";
	public static String OPTIONS_MENU = "options_background.png";

	public static String MENU_BUTTONS="button_atlas.png";
	public static String MENU_BACKGROUND="menu_background.png";
	public static String PAUSE_BACKGROUND="pause_menu.png";
	public static String COMPLETED_BACKGROUND = "completed_sprite.png";
	
	public static String SOUND_BUTTONS="sound_button.png";
	public static String URM_BUTTONS="urm_buttons.png";
	public static String VOLUME_BUTTONS="volume_buttons.png";
	
	public static String MENU_BACKGROUND_IMG="main_background.jpg";
	public static String PLAYING_BACKGROUND = "playing_bg_img.png";
	public static String BIG_CLOUDS = "big_clouds.png";
	public static String SMALL_CLOUDS = "small_clouds.png";
	public static String STATUS_BAR = "health_power_bar.png";


	public static BufferedImage loadSpriteAtlas(String FileName) {
		BufferedImage img=null;
		InputStream is = LoadSave.class.getResourceAsStream("/"+FileName);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public static BufferedImage[] GetAllLevels() {
		URL url = LoadSave.class.getResource("/lvls");
		File file = null;

		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		File[] files = file.listFiles();
		File[] filesSorted = new File[files.length];

		for (int i = 0; i < filesSorted.length; i++)
			for (int j = 0; j < files.length; j++) {
				if (files[j].getName().equals((i + 1) + ".png"))
					filesSorted[i] = files[j];

			}

		BufferedImage[] imgs = new BufferedImage[filesSorted.length];

		for (int i = 0; i < imgs.length; i++)
			try {
				imgs[i] = ImageIO.read(filesSorted[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}

		return imgs;
	}

}
