package com.nopcommerce.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotation {
	
	@Test
	public void TC_01() {
		System.out.println("Run testcase");
	}
  
    @BeforeClass
  public void beforeClass() {
    	System.out.println("Run BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Run AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Run BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Run AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Run BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Run AfterSuite");
  }

}
