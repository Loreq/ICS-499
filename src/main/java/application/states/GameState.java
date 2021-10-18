package application.states;

import application.events.TimerStart;
import application.events.TimerStop;
import application.events.TimerTickedEvent;

public abstract class GameState {

	/**
	 * Initializing the state
	 */
	public abstract void enter();
	
	/**
	 * Leaving the state
	 */
	public abstract void leave();
	
	/**
	 * handleEvent method for when TimerStart
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(TimerStart event) {
	}
	
	/**
	 * handleEvent method for when TimerStop
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(TimerStop event) {
	}

	/**
	 * handleEvent method for when TimerTicketEvent
	 * occurs. 
	 * @param event
	 */
	public  void handleEvent(TimerTickedEvent event) {
	}
}
