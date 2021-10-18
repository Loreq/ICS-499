package application.timer;

import application.events.TimerStart;
import application.events.TimerStop;
import application.events.TimerTickedEvent;

/**
 * An entity that can be notified of timing events
 *
 */
public interface Notifiable {
	
    public void handleEvent(TimerTickedEvent event);
    public void handleEvent(TimerStart event);
    public void handleEvent(TimerStop event);
   
}