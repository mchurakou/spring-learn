
package com.mikalai.spring.service.async;

import java.util.concurrent.Future;


public interface AsyncService {

	public void asyncTask();
	
	public Future<String> asyncWithReturn(String name);
	
}
