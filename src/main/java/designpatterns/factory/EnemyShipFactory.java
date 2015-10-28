package designpatterns.factory;

public class EnemyShipFactory {
	
	public EnemyShip makeEnemyShip(String newShipType) {
		EnemyShip newShip = null;
		
		if ("U".equals(newShipType)) {
			return new UFOEnemyShip();
		} else if ("R".equals(newShipType)) {
			return new RocketEnemyShip();
		} else if ("B".equals(newShipType)) {
			return new BigUFOEnemyShip();
		} else return null;
	}
}
