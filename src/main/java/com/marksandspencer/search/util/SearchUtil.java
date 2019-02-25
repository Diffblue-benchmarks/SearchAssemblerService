/**
 * 
 */
package com.marksandspencer.search.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 1574935
 *
 */
public class SearchUtil {

	/**
	 * Method to get the current time stamp
	 * 
	 * @return
	 */
	public static String DateFormat() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
