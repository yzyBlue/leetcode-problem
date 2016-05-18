package com.leetcode.problem;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.leetcode.util.LogUtil;

public class ZigZagConversionTest {
	
	protected final static Logger logger=Logger.getLogger(ReconstructItineraryTest.class);
	
	private static final String input="PAYPALISHIRING";
	
	private static final String output="PAHNAPLSIIGYIR";
	
	@Test
	public void test(){
		//logger.debug(input);
		ZigZagConversion zig=new ZigZagConversion();
		int numRows=3;
		LogUtil.printLog("Begin");
		String result=zig.convert(input, numRows);
		LogUtil.printLog("End");
		//logger.debug(result);
		//logger.debug(output);
		//logger.debug(output.toString().equals(result.toString()));
	}
}
