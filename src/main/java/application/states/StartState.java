package application.states;

import application.events.TimerStop;

public class StartState extends GameState {
private static StartState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StartState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static StartState instance() {
		if (instance == null) {
			instance = new StartState();
		}
		return instance;
	}
	
	/**
	 * Entering start state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		//TODO
	}
	@Override
	public void leave() {
		System.out.println("Your score is: " + GameContext.instance().getTimer().getTimeValue());	
	}
	
	public void handleEvent(TimerStop event ) {
		GameContext.instance().changeState(StopState.instance());
	}
}
