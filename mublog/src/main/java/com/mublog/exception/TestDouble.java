package com.mublog.exception;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.apache.log4j.Logger;
public class TestDouble {

	private static DecimalFormat df2 = new DecimalFormat("#.00");

	 private static final Logger logger = Logger.getLogger(TestDouble.class);
	 
	public static void main(String[] args) {

		double input = 32.123456;
		logger.info("double : " + input);
		logger.info("double (default) : " + df2.format(input));

		df2.setRoundingMode(RoundingMode.UP);
		logger.info("double (UP) : " + df2.format(input));

		df2.setRoundingMode(RoundingMode.DOWN);
		logger.info("double (DOWN) : " + df2.format(input));

	}

}
