package application.states;

import application.events.TimerStart;
import application.timer.Timer;

public class StopState extends GameState {
private static StopState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StopState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static StopState instance() {
		if (instance == null) {
			instance = new StopState();
		}
		return instance;
	}
	
	/**
	 * Entering stop state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		//TODO
	}
	@Override
	public void leave() {
		//TODO		
	}
	
	public void handleEvent(TimerStart event ) {
		GameContext.instance().setTimer(new Timer(GameContext.instance(), 0));
		GameContext.instance().changeState(StartState.instance());
		GameContext.instance().getTimer().start();
	}

}
