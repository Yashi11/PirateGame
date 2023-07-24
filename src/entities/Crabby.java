package entities;
import static utils.Constants.Directions.*;

import static utils.Constants.EnemyConstants.*;
import static utils.HelpMethods.CanMoveHere;
import static utils.HelpMethods.GetEntityYPosUnderRoofOrAboveFloor;
import static utils.HelpMethods.IsEntityOnFloor;
import static utils.HelpMethods.IsFloor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import main.Game;
public class Crabby extends Enemy{
	private int attackBoxOffsetX;
	public Crabby(float x, float y) {
		super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
		initHitbox(22,19);
		initAttackBox(82,19,30);
	}
	public void update(int[][] lvlData,Player player)
	{
		updateBehavior(lvlData, player);
		updateAnimationTick();
		updateAttackBox();
	}
	private void updateAttackBox() {
		attackBox.x=hitbox.x-attackBoxOffsetX;
		attackBox.y=hitbox.y;
	}
	private void updateBehavior(int[][] lvlData, Player player) {
		if (firstUpdate)
			firstUpdateCheck(lvlData);

		if (inAir)
			inAirUpdate(lvlData);
		else {
			switch (state) {
			case IDLE:
				newState(RUNNING);
				break;
			case RUNNING:
				if (canSeePlayer(lvlData, player)) {
					turnTowardsPlayer(player);
					if (isPlayerCloseForAttack(player))
						newState(ATTACK);
				}
					move(lvlData);
				break;
			case ATTACK:
				if (aniIndex == 0)
					attackChecked = false;

				// Changed the name for checkEnemyHit to checkPlayerHit
				if (aniIndex == 3 && !attackChecked)
					checkEnemyHit(attackBox, player);

				break;
			case HIT:
				break;
			}
		}

	}

	public int flipX() {
		if(walkDir==RIGHT) 
			return width;
		else 
			return 0;
	}
	public int flipW() {
		if(walkDir==RIGHT) 
			return -1;
		else 
			return 1;
		
	}
}
