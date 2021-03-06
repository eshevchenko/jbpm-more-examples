package com.test;

import java.util.Map;

public class MyService {

    public static final String MY_SERVICE_VAR = "com.test.MyService.input";
    
	public boolean execute(Map<String, Object> inputMap) {
	    boolean success = false;
	
	    try { 
	        String [] input = (String []) inputMap.get(MY_SERVICE_VAR);
	    
	        int [] output = new int[input.length];
	        for( int i = 0; i < input.length; ++i ) { 
	            output[i] = Integer.parseInt(input[i]);
	        }
	        inputMap.put(MY_SERVICE_VAR, output);
	       
	        success = true;
	    } catch(Throwable t) { 
	        String reason = "MyService.execute failed with exception: " + t.getClass().getSimpleName() + " [" + t.getMessage() + "]";
	        inputMap.put(HandleExceptionServiceTaskHandler.FAILURE_REASON, reason); 
		}
		
		return success;
	}
	

}
