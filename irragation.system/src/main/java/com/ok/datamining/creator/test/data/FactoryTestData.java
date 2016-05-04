package com.ok.datamining.creator.test.data;

import com.ok.datamining.database.DataBaseConnection;
import com.ok.datamining.item.BestItem;
import com.ok.datamining.item.BestPlant;

public class FactoryTestData {

	public ITestCreator create(BestItem bestItem)
	{
		ITestCreator returnCreator=null;
		Integer instanceDBCount;
		if(bestItem instanceof BestPlant)
		{
			instanceDBCount=DataBaseConnection.getPlantCount();
			returnCreator=new PlantTestDataCreator(bestItem);
		}
		return returnCreator;
	}
}
