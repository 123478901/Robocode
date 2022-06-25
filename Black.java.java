// Below is the package where you find the robot  
package gaboneS;

// below are imports from the Robocode API that was used for this program
import robocode.*;
import java.awt.Color;

// API link: https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
/* Black - a robot by Sebenzile Gabone
* This is my first robot that I have created to battle in Robocode, a programming game with the goal of developing a robot to battle other robots.
*Black is going to become a robot that can guarantee a win in any situation
*
*
*PS: Robot still in development so it will not deliver satisfactory results all the time
 */
public class Black extends Robot
{
	// this is where the robot is run and its basic function 
	public void run() {

		setColors(Color.black,Color.white,Color.blue); 
		// above is the color of the body,gun, and radar respectively
		// Robot's main loop, when it is not bothered
		while(true) {
			ahead(300);
			turnRight(180);
			fire(1);
			turnRight(-90);
		}
	}

	// this is what happens when my bullet hits another robot
	public void onBulletHit(BulletHitEvent e){
		while(e.getEnergy()> 30 ) fire(4);
	}
	
    public void onBulletMissed(BulletMissedEvent e) {
		turnRight(180);
		ahead(100);
	}

	//When it scans another robot it should determine how far the robot and fire its bullets accordingly
	public void onScannedRobot(ScannedRobotEvent e) {
	    turnGunRight(-1*e.getBearing());
		if(e.getDistance() > 200){
		fire(2 );}
		else{
			fire(4);
		}
	}
	
	

	// This is what  happens when my bot collides with another
	public void onHitRobot(HitRobotEvent e) {
		turnRight(e.getBearing() );
	
		if(getEnergy()>40 ){ 
			fire(5); }
		else{
			fire(2);
		}	ahead(150);
	}
	// When my bot is hit by a bullet it should move forward 100px
	public void onHitByBullet(HitByBulletEvent e) {
		turnGunRight(-180);
		fire(4);
		ahead(200);
		turnLeft(-30+ e.getBearing());
	}
	
	/*
	 * When my bot hits the wall it should turn right then turn the gun 180 degrees and fire when it detects a robot
	 */
	public void onHitWall(HitWallEvent e) {
		turnRight(-120);
		ahead(100);
		turnGunRight(180);
	}	
}
