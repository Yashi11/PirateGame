package utils;

import main.Game;
public class Constants {
	public static final float GRAVITY = 0.04f*Game.SCALE;
	public static final int ANISPEED=25;
	
	public static class Projectiles{
		public static final int CANNON_BALL_DEFAULT_WIDTH=15;
		public static final int CANNON_BALL_DEFAULT_HEIGHT=15;
		
		public static final int CANNON_BALL_WIDTH=(int)(CANNON_BALL_DEFAULT_WIDTH*Game.SCALE);
		public static final int CANNON_BALL_HEIGHT=(int)(CANNON_BALL_DEFAULT_HEIGHT*Game.SCALE);
		public static final int SPEED=(int)(0.75f*Game.SCALE);
	}
	public static class ObjectConstants {

		public static final int RED_POTION = 0;
		public static final int BLUE_POTION = 1;
		public static final int BARREL = 2;
		public static final int BOX = 3;
		public static final int SPIKE = 4;
		public static final int CANNON_LEFT = 5;
		public static final int CANNON_RIGHT = 6;

		public static final int RED_POTION_VALUE = 15;
		public static final int BLUE_POTION_VALUE = 20;

		public static final int CONTAINER_WIDTH_DEFAULT = 40;
		public static final int CONTAINER_HEIGHT_DEFAULT = 30;
		public static final int CONTAINER_WIDTH = (int) (Game.SCALE * CONTAINER_WIDTH_DEFAULT);
		public static final int CONTAINER_HEIGHT = (int) (Game.SCALE * CONTAINER_HEIGHT_DEFAULT);

		public static final int POTION_WIDTH_DEFAULT = 12;
		public static final int POTION_HEIGHT_DEFAULT = 16;
		public static final int POTION_WIDTH = (int) (Game.SCALE * POTION_WIDTH_DEFAULT);
		public static final int POTION_HEIGHT = (int) (Game.SCALE * POTION_HEIGHT_DEFAULT);
		
		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32  ;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);
		
		public static final int CANNON_WIDTH_DEFAULT = 40;
		public static final int CANNON_HEIGHT_DEFAULT = 26  ;
		public static final int CANNON_WIDTH = (int) (Game.SCALE * CANNON_WIDTH_DEFAULT);
		public static final int CANNON_HEIGHT = (int) (Game.SCALE * CANNON_HEIGHT_DEFAULT);

		public static int getSpriteAmount(int object_type) {
			switch (object_type) {
			case RED_POTION:
			case BLUE_POTION:
				return 7;
			case BARREL:
			case BOX:
				return 8;
			case CANNON_LEFT:
			case CANNON_RIGHT:
				return 7;
			}
			return 1;
		}
	}
	public static class Environment{
		public static final int BIG_CLOUD_WIDTH_DEFAULT=448;
		public static final int BIG_CLOUD_HEIGHT_DEFAULT=101;
		public static final int BIG_CLOUD_WIDTH=(int)(BIG_CLOUD_WIDTH_DEFAULT*Game.SCALE);
		public static final int BIG_CLOUD_HEIGHT=(int)(BIG_CLOUD_HEIGHT_DEFAULT*Game.SCALE);

		public static final int SMALL_CLOUD_WIDTH_DEFAULT=74;
		public static final int SMALL_CLOUD_HEIGHT_DEFAULT=24;
		public static final int SMALL_CLOUD_WIDTH=(int)(SMALL_CLOUD_WIDTH_DEFAULT*Game.SCALE);
		public static final int SMALL_CLOUD_HEIGHT=(int)(SMALL_CLOUD_HEIGHT_DEFAULT*Game.SCALE);	}
	public static class UI{
	public static class Buttons{
		public static final int B_WIDTH_DEFAULT = 140;
		public static final int B_HEIGHT_DEFAULT = 56;
		public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT*Game.SCALE);
		public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT*Game.SCALE);

	}
	public static class PauseButtons{
		public static final int SOUND_SIZE_DEFAULT = 42;
		public static final int SOUND_SIZE=(int) (SOUND_SIZE_DEFAULT*Game.SCALE);
	}
	public static class URMButtons{
		public static final int URM_SIZE_DEFAULT=50;
		public static final int URM_SIZE = (int) (URM_SIZE_DEFAULT*Game.SCALE);
	}
	public class VolumeButtons{
		public static final int VOLUME_WIDTH_DEFAULT=28;
				public static final int VOLUME_HEIGHT_DEFAULT=44;
				public static final int SLIDER_WIDTH_DEFAULT=215;
				
				public static final int VOLUME_WIDTH=(int)(VOLUME_WIDTH_DEFAULT*Game.SCALE);
				public static final int VOLUME_HEIGHT=(int)(VOLUME_HEIGHT_DEFAULT*Game.SCALE);
				public static final int SLIDER_WIDTH=(int)(SLIDER_WIDTH_DEFAULT*Game.SCALE);
	}
	}
	public static class Directions{
		public static final int LEFT=0;
		public static final int UP=1;
		public static final int RIGHT=3;
		public static final int DOWN=4;

	}
	public static class EnemyConstants{
		public static final int CRABBY=0;
		public static final int IDLE=0;
		public static final int RUNNING=1;
		public static final int ATTACK=2;
		public static final int HIT=3;
		public static final int DEAD=4;
		
		public static final int CRABBY_WIDTH_DEFAULT=72;
		public static final int CRABBY_HEIGHT_DEFAULT=32;
		public static final int CRABBY_WIDTH=(int)(CRABBY_WIDTH_DEFAULT*Game.SCALE);
		public static final int CRABBY_HEIGHT=(int)(CRABBY_HEIGHT_DEFAULT*Game.SCALE);
		public static final int CRABBY_DRAW_OFFSET_X=(int)(26*Game.SCALE);
		public static final int CRABBY_DRAW_OFFSET_Y=(int)(9*Game.SCALE);

		public static int getSpriteAmount(int enemyType,int enemyState) {
			switch(enemyType) {
			case CRABBY:
				switch(enemyState) {
				case IDLE:
					return 9;
				case RUNNING:
					return 6;
				case ATTACK:
					return 7;
				case HIT:
					return 4;
				case DEAD:
					return 5;
				}
			}
			return 0;
		}

		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case CRABBY:
				return 10;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case CRABBY:
				return 15;
			default:
				return 0;
			}

		}
	}
	public static class PlayerConstants{
		public static final int IDLE=0;
		public static final int RUNNING=1;  
		public static final int JUMP=2; 
		public static final int FALLING=3;  
		public static final int ATTACK=4;
		public static final int HIT=5;
		public static final int DEAD=6;
		
		
		public static int GetSpriteAmount(int player_action) {
			switch(player_action) {
			case DEAD: return 8;
			case RUNNING: return 6;
			case IDLE: return 5;
			case HIT: return 4;
			case JUMP:
			case ATTACK:
				return 3;
			case FALLING:
			default:
				return 1;
			}
		}


	}
}