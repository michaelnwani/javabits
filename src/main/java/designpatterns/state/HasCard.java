package designpatterns.state;

public class HasCard implements ATMState {
	
	ATMMachine atmMachine;
	
	// Passing around the same ATM object
	public HasCard(ATMMachine newATMMachine) {
		this.atmMachine = newATMMachine;
	}
	
	@Override
	public void insertCard() {
		// If the ATM has a card (one has already been entered)
		// and the user tries entering another
		System.out.println("You can't enter more than one card");
	}
	
	@Override
	public void ejectCard() {
		System.out.println("Card Ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
	}
	
	@Override
	public void insertPin(int pinEntered) {
		
		if (pinEntered == 1234) {
			System.out.println("Correct PIN");
			atmMachine.correctPinEntered = true;
			atmMachine.setATMState(atmMachine.getHasPin());
		} else {
			System.out.println("Wrong PIN");
			atmMachine.correctPinEntered = false;
			System.out.println("Card Ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
		}
	}
	
	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("Enter PIN First");
	}
}