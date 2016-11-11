package comMonitores;

public class Philosopher implements Runnable{

	private int id;
	private PhilosopherMonitor monitor;
	private String name;
	
	public Philosopher(int id, PhilosopherMonitor monitor, String name) {
		super();
		this.id = id;
		this.monitor = monitor;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
			monitor.takeForks(id);
			eating();
			monitor.returnForks(id);
			thinking();
		}
	}

	private void thinking() {
		System.out.println(name + " está pensando");
		SleepUtilities.nap();
	}

	private void eating() {
		System.out.println(name + " está comendo");
		SleepUtilities.nap();
	}

}
