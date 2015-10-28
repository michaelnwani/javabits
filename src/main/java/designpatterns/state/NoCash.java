package designpatterns.state;

public class NoCash implements ATMState {
	
	ATMMachine atmMachine;
	
	// Passing around the same ATM object
	public NoCash(ATMMachine newATMMachine) {
		this.atmMachine = newATMMachine;
	}
	
	@Override
	public void insertCard() {
		// If the ATM has a card (one has already been entered)
		// and the user tries entering another
		System.out.println("We Don't Have Money");
		
	}
	
	@Override
	public void ejectCard() {
		System.out.println("We Don't Have Money. You Didn't Enter a Card");
	}
	
	@Override
	public void insertPin(int pinEntered) {
		
		System.out.println("We Don't Have Money");
		
	}
	
	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("We Don't Have Money");
	}
}