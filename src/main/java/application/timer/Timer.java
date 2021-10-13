package application.timer;

import java.beans.*;

import application.events.TimerTickedEvent;

public class Timer implements PropertyChangeListener {
	private int timeValue;
	private Notifiable client;

	public Timer(Notifiable client, int timeValue) {
		this.client = client;
		this.timeValue = timeValue;
	}

	public void addTimeValue(int value) {
		timeValue += value;
	}

	public int getTimeValue() {
		return timeValue;
	}

	public void start() {
		Clock.instance().addPropertyChangeListener(this);
	}

	public int stop() {
		int finalScore;
		finalScore = timeValue;
		timeValue = 0;
		Clock.instance().removePropertyChangeListener(this);
		return finalScore;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		++timeValue;
		client.handleEvent(new TimerTickedEvent(timeValue));

	}
}
