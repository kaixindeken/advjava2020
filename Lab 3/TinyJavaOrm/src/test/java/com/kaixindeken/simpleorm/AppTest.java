package com.kaixindeken.simpleorm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

    public AppTest(String test_name){
        super(test_name);
    }

    public static Test suite(){
        return new TestSuite(AppTest.class);
    }

    public void testApp(){
        assertTrue(true);
    }

}
