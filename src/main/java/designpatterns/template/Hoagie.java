package designpatterns.template;

public abstract class Hoagie {
	
	// the Template Method. subclasses can't change this method.
	final void makeSandwich() {
		cutBun();
		
		if (customerWantsMeat()) {
			addMeat();
		}
		
		if (customerWantsCheese()) {
			addCheese();
		}
		
		if (customerWantsVegetables()) {
			addVegetables();
		}
		
		if (customerWantsCondiments()) {
			addCondiments();
		}
		
		wrapTheHoagie();
		
		System.out.println();
	}
	
	public void cutBun() {
		System.out.println("The Hoagie is Cut");
	}
	
	abstract void addMeat();
	abstract void addCheese();
	abstract void addVegetables();
	abstract void addCondiments();
	
	// called a 'hook'; if the user wants to override these they can
	boolean customerWantsMeat() {
		return true;
	}
	
	boolean customerWantsCheese() {
		return true;
	}
	
	boolean customerWantsVegetables() {
		return true;
	}
	
	boolean customerWantsCondiments() {
		return true;
	}
	
	public void wrapTheHoagie() {
		System.out.println("Wrap the Hoagie");
	}
}





