package pl.edu.agh.northwind.NorthwindApp.performance;

import java.util.ArrayList;
import java.util.HashMap;

public class PerformanceManager {
	
	private static PerformanceManager shared;
	private HashMap<String, PerformanceTest> tests = new HashMap<>();
	
	private PerformanceManager()
	{
		
	}
	
	public static PerformanceManager shared()
	{
		if(shared == null)
		{
			shared = new PerformanceManager();
		}
		return shared;
	}
	
	public PerformanceTest getTest(String name)
	{
		if(tests.containsKey(name)) return tests.get(name);
		
		PerformanceTest performanceTest = new PerformanceTest(name);
		
		tests.put(name, performanceTest);
		
		return performanceTest;
	}
	
	public static PerformanceTestHelper getTestHelper(String name)
	{
		return new PerformanceTestHelper(name);
	}

	public ArrayList<PerformanceTest> getAllTests() {
		// TODO Auto-generated method stub
		ArrayList<PerformanceTest> testsArr = new ArrayList<>();
		System.out.println(tests);
		for (String name : tests.keySet()) {
			testsArr.add(tests.get(name));
		}
		
		return testsArr;
	}
}
