package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {
	
	 @Test
	 public void retrieveFlightsAddsAppropriateHeader() throws Exception {
	   MuleEvent event = runFlow("retrieveFlights");
	   String contentType = event.getMessage().getOutboundProperty("Content-Type");
	   assertEquals("application/json", contentType);
	 }

    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
        runFlowAndExpect("mavenFlow", "Hello Maven");
    }
    
    @Override
    protected String getConfigFile() {
        return "mvn-project.xml";
    }

}
