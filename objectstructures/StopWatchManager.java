package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {
	
	
	private Map<String,StopWatch> nameDict = 
			new HashMap<String,StopWatch>();;

	public StopWatch newStopWatch(String name) {
		StopWatch stopWatch = new StopWatch();
		nameDict.put(name,stopWatch);
		return stopWatch;
	}
	
	public void removeStopWatch(String name) {
		nameDict.remove(name);
	}
	
	public void tick(int ticks) {
		for(StopWatch sw:nameDict.values()) {
			sw.tick(ticks);
		}
	}
	
	public StopWatch getStopWatch(String name) {
		return nameDict.get(name);
	}
	
	public Collection<StopWatch> getAllWatches() {
		return nameDict.values();
	}
	
	public Collection<StopWatch> getStartedWatches() {
		Collection<StopWatch> list = new ArrayList<>();
		for(StopWatch sw:nameDict.values()) {
			if(sw.isStarted()) {
				list.add(sw);
			}
		}
		return list;
	}
	
	public Collection<StopWatch> getStoppedWatches() {
		Collection<StopWatch> list = new ArrayList<>();
		for(StopWatch sw:nameDict.values()) {
			if(sw.isStopped()) {
				list.add(sw);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
