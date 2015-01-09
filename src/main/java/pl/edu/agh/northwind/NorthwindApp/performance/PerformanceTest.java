package pl.edu.agh.northwind.NorthwindApp.performance;

public class PerformanceTest {

	private String name;
	private long count;
	private long fastest;
	private long slowest;
	
	public PerformanceTest(String name) {
		this.name = name;
		count = 0;
		fastest = 0;
		slowest = 0;
	}

	public void update(long time) {
		count++;
		
		if(time > slowest) slowest = time;
		if(time < fastest || fastest == 0) fastest = time;
	}

	public String getName() {
		return name;
	}

	public long getCount() {
		return count;
	}

	public long getFastest() {
		return fastest;
	}

	public long getSlowest() {
		return slowest;
	}
	
	
	
}
