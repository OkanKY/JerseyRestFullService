package com.ok.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ok.jpa.controller.JpaInstanceCountController;

public class TestJpaInstanceCount {
	public JpaInstanceCountController instanceCountController;
	@Before
	public void initialize()
	{
		instanceCountController=new JpaInstanceCountController();
		System.out.println("Start");
	}
	@After
	public void finish()
	{
		System.out.println("Finish");
	}
	@Test
	public void plantInstanceCount()
	{
		Long instanceCount=null;
		try {
			instanceCount=instanceCountController.getPlantInstanceCount();
			System.out.println(instanceCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			fail();
		}
	}
}
