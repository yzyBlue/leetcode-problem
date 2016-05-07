/**
 * 
 */
package com.leetcode.problem;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yuan.Ziyang
 *
 */
public class ReconstructItineraryTest {
	
	private static String[][] tickets1={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
	
	private static String[][] tickets2={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
	
	//special case
	private static String[][] tickets3={{"JFK","LHR"} ,{"JFK","MUC"}};
	
	private ReconstructItinerary solution;
	
	protected final static Logger logger=Logger.getLogger(ReconstructItineraryTest.class);
	
	@Before
	public void beforeTest(){
		//this.tickets1={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		logger.debug(tickets1[0][0]);
		//this.tickets2={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		logger.debug(tickets2[0][0]);
		solution=new ReconstructItinerary();
	}
	@Test
	public void test(){
		List<String> path1= solution.findItinerary(tickets1);
		logger.debug(path1);
		List<String> path2= solution.findItinerary(tickets2);
		logger.debug(path2);
		List<String> path3= solution.findItinerary(tickets3);
		logger.debug(path3);
		
	}
	
}
