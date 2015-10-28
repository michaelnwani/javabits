package designpatterns.command;

// DeviceButton is the 'Invoker'
// It knows nothing.
public class DeviceButton {
	
	Command theCommand;
	
	public DeviceButton(Command newCommand) {
		this.theCommand = newCommand;
	}
	
	public void press() {
		theCommand.execute();
	}
	
	public void pressUndo() {
		theCommand.undo();
	}
}
