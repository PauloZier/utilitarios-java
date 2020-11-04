package utilitarios.timer;

import java.util.TimerTask;
import utilitarios.functional.Action;

public class Timer {

	private Long interval;
	private java.util.Timer timer;
	private Action action;
	private TimerTask task;
	
	public Timer(Long interval) {
		
		this.interval = interval;
	}
	
	public Timer(Action action, Long interval) {
		
		this.interval = interval;
		
		this.action = action;
		
		this.setTask(this.action);
	}
	
	public void setAction(Action action) {
		
		this.action = action;
		
		this.setTask(this.action);
	}
	
	public void start() {
		
		this.timer = new java.util.Timer();
		
		this.timer.schedule(this.task, 0L, interval);
	}
	
	public void stop() {
		
		this.timer.cancel();
	}
	
	private void setTask(Action action) {
		
		this.task = new TimerTask() {
			
			@Override
			public void run() {
				
				action.invoke();
			}
		};
	}
}
