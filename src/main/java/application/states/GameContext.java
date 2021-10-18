package application.states;

import application.events.TimerStop;
import application.events.TimerStart;
import application.events.TimerTickedEvent;
import application.timer.Notifiable;
import application.timer.Timer;

public class GameContext implements Notifiable{
	private GameState currentState;
	private static GameContext instance;
	private Timer timer;
	
	public Timer getTimer() {
		return timer;
	}
	
	/**
	 * Timer method.
	 * Will set the time for the timer.
	 * 
	 * @param timer - timer object that sets the time
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	/**
	 * Making the class a singleton
	 */
	private GameContext() {
		instance = this;
		currentState = StopState.instance();
	}

	public static GameContext instance() {
		if (instance == null) {
			instance = new GameContext();
		}
		return instance;
	}

	// These are temporary methods used to find the current state
	// Meant for debugging
	public GameState getCurrentState() {
		return currentState;
	}

	// These are temporary methods used to find the current state
	// Meant for debugging.
	public void setCurrentState(GameState currentState) {
		this.currentState = currentState;
	}

	/**
	 * Initializing StopState as the default state
	 */
	public void initialize() {
		instance.changeState(StopState.instance());
	}

	/**
	 * ChangeState. Method used to change the current state to the next available
	 * state.
	 * 
	 * @param nextState object
	 * @throws InterruptedException
	 */
	public void changeState(GameState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * handleEvent for when the the level starts. 
	 * @param event
	 */
	public void handleEvent(TimerStart event) {
		currentState.handleEvent(event);
	}

	/**
	 * handleEvent for when the Timer stops
	 * 
	 * @param event
	 */
	public void handleEvent(TimerStop event) {
		currentState.handleEvent(event);
	}


	@Override
	public void handleEvent(TimerTickedEvent event) {
		currentState.handleEvent(event);
		
	}


}

