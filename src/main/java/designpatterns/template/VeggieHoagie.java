package designpatterns.template;

public class VeggieHoagie extends Hoagie {

	String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
	String[] condimentsUsed = {"Oil", "Vinegar"};
	
	@Override
	boolean customerWantsMeat() {
		return false;
	}
	
	@Override
	boolean customerWantsCheese() {
		return false;
	}
	
	@Override
	void addMeat() {
		// nothing.
	}
	
	@Override
	void addCheese() {
		// nothing.
	}
	
	@Override
	void addVegetables() {
		System.out.println("Adding the Veggies: ");
		
		for (String veggie : veggiesUsed) {
			System.out.print(veggie + " ");
		}
		
		System.out.println();
	}
	
	@Override
	void addCondiments() {
		System.out.println("Adding the Condiments: ");
		
		for (String condiment : condimentsUsed) {
			System.out.print(condiment + " ");
		}
		
		System.out.println();
	}
}