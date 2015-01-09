package pl.edu.agh.northwind.NorthwindApp.performance;

public class PerformanceTestHelper {

	private String name;
	private long start;
	private long stop;
	
	public PerformanceTestHelper(String name)
	{
		this.name = name;
		start = 0;
		stop = 0;
	}
	
	public void start()
	{
		start = System.currentTimeMillis();
	}
	
	public void stopAndSave()
	{
		stop = System.currentTimeMillis();
		System.out.println(stop - start);
		PerformanceManager.shared().getTest(name).update(stop - start);
	}
}
