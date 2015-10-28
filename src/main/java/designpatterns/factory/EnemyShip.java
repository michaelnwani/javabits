package designpatterns.factory;

public abstract class EnemyShip {
	
	private String name;
	private double amtDamage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public double getAmtDamage() {
		return amtDamage;
	}
	
	public void setAmtDamage(double newDamage) {
		this.amtDamage = newDamage;
	}
	
	public void followHeroShip() {
		System.out.println(getName() + " is following the hero");
	}
	
	public void displayEnemyShip() {
		System.out.println(getName() + " is on the screen");
	}
	
	public void enemyShipShoots() {
		System.out.println(getName() + " attacks and does " + getAmtDamage());
	}
}
