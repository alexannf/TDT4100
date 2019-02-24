package objectstructures;

public class StopWatch {
	
	int ticks = 0;

	public int getTicks() {
		return ticks;
	}

	public void tick(int milliSeconds) {
		ticks += milliSeconds;
	}

	int startTime = -1;
	int stopTime = -1;

	int lapStartTime = -1;
	int lapTime = -1;

	public void start() {
		startTime = ticks;
		lap();
	}
	public boolean isStarted() {
		return startTime >= 0;
	}

	public void lap() {
		if (lapStartTime >= 0) {
			lapTime = ticks - lapStartTime;
		}
		lapStartTime = ticks;
	}

	public void stop() {
		stopTime = ticks;
		lap();
	}
	public boolean isStopped() {
		return stopTime >= 0;
	}

	public int getTime() {
		if (isStopped()) {
			return stopTime - startTime;
		} else if (isStarted()) {
			return ticks - startTime;
		} else {
			return -1;
		}
	}

	public int getLapTime() {
		if (lapStartTime >= 0) {
			return ticks - lapStartTime;
		} else {
			return -1;
		}
	}

	public int getLastLapTime() {
		return lapTime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
