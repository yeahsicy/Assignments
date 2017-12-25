package Jerry_Robot;
import robocode.*;
import robocode.Robot;
import java.awt.*;


//OP - a robot by (Ziwei Ye)
public class OP extends Robot {

    double FieldMax = 0;

    public void run() {

        FieldMax = Math.max(getBattleFieldHeight(), getBattleFieldWidth());

        setColors(Color.gray, Color.lightGray, Color.white);


        while (true) {
            ahead(FieldMax);
			turnGunRight(360);
        }
    }

    public void onHitRobot(HitRobotEvent event) {
        if (event.getBearing() > 0) turnLeft(90);
        else turnRight(90);
    }

    public void onHitWall(HitWallEvent event) {
        if (event.getBearing() > 0) turnLeft(90);
        else turnRight(90);
    }

    public void onScannedRobot(ScannedRobotEvent event) {
        if (getEnergy() < 10) fire(getEnergy() / 10);
        else fire(Rules.MAX_BULLET_POWER);
    }
}

