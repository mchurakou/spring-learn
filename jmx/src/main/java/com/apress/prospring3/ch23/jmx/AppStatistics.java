
package com.apress.prospring3.ch23.jmx;

import java.util.List;

public interface AppStatistics {

	public int getTotalContactCount();
	
	public int getLoggedInUserCount();
	
	public List<Object> getLoggedInUsers();	
	
}
