package com.ok.test;


import static org.junit.Assert.fail;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ok.datamining.item.BestPlant;
import com.ok.jpa.controller.JpaController;

public class TestJpaController {
	public JpaController jpaController;
	@Before
	public void initialize()
	{
		jpaController=new JpaController();
		System.out.println("Start");
	}
	@After
	public void finish()
	{
		System.out.println("Finish");
	}
	@Test
	public void getUserFieldList()
	{
		Response response=null;
		try {
			response=jpaController.getUserFieldList("okan", "1234");
			System.out.println(response.getEntity().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Test
	public void checkUser()
	{
		Response res=null;
		try {

		JpaController controller = new JpaController();
		res=controller.checkUserLogin("okan", "1234");
		System.out.println(res.getEntity().toString());
		} catch (Exception e) {
		// TODO: handle exception
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Test
	public void getBestPlant()
	{
		Response res=null;
		BestPlant bestItem = new BestPlant(1, 1, 1, 1, 1, 1);
		try {
		JpaController controller = new JpaController();
		res=controller.getBestPlant("okan","1234",bestItem);
		
		} catch (Exception e) {
		// TODO: handle exception
			System.out.println(e.getMessage());
			fail();
		}
		System.out.println(res.getEntity().toString());
	}
}
