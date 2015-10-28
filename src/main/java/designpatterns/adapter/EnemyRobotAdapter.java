package designpatterns.adapter;

public class EnemyRobotAdapter implements EnemyAttacker {
	
	// Composition
	EnemyRobot theRobot;
	
	
	public EnemyRobotAdapter(EnemyRobot newRobot) {
		this.theRobot = newRobot;
	}
	
	@Override
	public void fireWeapon() {
		theRobot.smashWithHands();
	}
	
	@Override
	public void driveForward() {
		theRobot.walksForward();
	}
	
	@Override
	public void assignDriver(String driverName) {
		theRobot.reactToHuman(driverName);
	}
}
