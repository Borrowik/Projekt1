package pl.sortAlgorithms;

public class StopWatch {

	private long startTime;
	private long stopTime;
	private boolean running;
	private boolean innitalized;

	// StopWatch timer = new StopWatch();
	// timer.start();
	// timer.stop();
	// System.out.println("Wartoœæ timera w ms :" + timer.getElapsedTime());

	// List<StopWatch> Timers = new ArrayList<StopWatch>();
	// Timers.add(new StopWatch());
	// Timers.get(0).start();
	// Timers.get(0).stop();
	// System.out.println("Value:" + Timers.get(0).getElapsedTime());

	public StopWatch() {
		super();
		this.startTime = -1;
		this.stopTime = -1;
		this.running = false;
		this.innitalized = false;
	}

	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
		this.innitalized = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}

	// elaspsed time in milliseconds
	public long getElapsedTime() {
		if (!innitalized) {
			System.out.println("Timer not started");
			return -1;
		} else {
			long elapsed;
			if (running) {
				elapsed = (System.currentTimeMillis() - startTime);
			} else {
				elapsed = (stopTime - startTime);
			}
			return elapsed;
		}

	}

	// elaspsed time in seconds
	public long getElapsedTimeSecs() {
		if (!innitalized) {
			System.out.println("Timer not started");
			return -1;
		} else {
			long elapsed;
			if (running) {
				elapsed = ((System.currentTimeMillis() - startTime) / 1000);
			} else {
				elapsed = ((stopTime - startTime) / 1000);
			}
			return elapsed;
		}
	}
}