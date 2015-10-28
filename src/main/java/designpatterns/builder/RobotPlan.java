package designpatterns.builder;

public interface RobotPlan {
	// to filter out redundancy (if you were making many different
	// robot types)
	public void setRobotHead(String head);
	public void setRobotTorso(String torso);
	public void setRobotArms(String arms);
	public void setRobotLegs(String legs);
}