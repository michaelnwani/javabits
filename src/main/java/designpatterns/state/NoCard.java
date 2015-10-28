package designpatterns.state;

public class NoCard implements ATMState {
	
	ATMMachine atmMachine;
	
	// Passing around the same ATM object
	public NoCard(ATMMachine newATMMachine) {
		this.atmMachine = newATMMachine;
	}
	
	@Override
	public void insertCard() {
		// If the ATM has a card (one has already been entered)
		// and the user tries entering another
		System.out.println("Please Enter a PIN");
		atmMachine.setATMState(atmMachine.getYesCardState());
	}
	
	@Override
	public void ejectCard() {
		System.out.println("Enter a card first");
	}
	
	@Override
	public void insertPin(int pinEntered) {
		
		System.out.println("Enter a card first");
		
	}
	
	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("Enter a card first");
	}
}