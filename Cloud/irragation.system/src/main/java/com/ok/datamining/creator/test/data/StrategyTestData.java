package com.ok.datamining.creator.test.data;

import weka.core.Instances;

import com.ok.jpa.controller.JpaInstanceCountController;

public class StrategyTestData {
	private JpaInstanceCountController jpaInstanceCountController;
	public StrategyTestData()
	{
		jpaInstanceCountController=new JpaInstanceCountController();
	}

	public Instances getTestDataInFolder(ITestCreator creator) {
		Instances dataDiscretize = null;
		Integer instanceDBCount=null;
		try {
			instanceDBCount=(int)(long)jpaInstanceCountController.getPlantInstanceCount();
			Instances data = creator.createTestData();
			Instances dataAttribute = creator.addAttribute(data,instanceDBCount);
			dataDiscretize = creator.discretize(dataAttribute,instanceDBCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return dataDiscretize;
	}
}
