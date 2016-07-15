package com.ok.datamining.creator.test.data;

import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

import com.ok.datamining.item.BestItem;
import com.ok.datamining.item.BestPlant;

public class PlantTestDataCreator extends ITestCreator{

	public PlantTestDataCreator(BestItem bestItem) {
		super(bestItem);
		// TODO Auto-generated constructor stub
		//Set Attribute count
		super.attributeCount=6;
	}

	@Override
	public Instances createTestData() throws Exception {
		// TODO Auto-generated method stub
		Instances data=null;
		try {

		String tabloPlant="Plant";
        ArrayList<Attribute> attributesPlant = new ArrayList<Attribute>();

        attributesPlant.add(new Attribute("addressID"));
        attributesPlant.add(new Attribute("area"));
        attributesPlant.add(new Attribute("climateID"));
        attributesPlant.add(new Attribute("soilID"));
        attributesPlant.add(new Attribute("profitValue"));
        attributesPlant.add(new Attribute("plantID"));

         data = new Instances(tabloPlant, attributesPlant, 0);

		} catch (Exception e) {
		// TODO: handle exception
			throw(e);
		}
		return data;
	}

	@Override
	public Instances addAttribute(Instances data,Integer instanceDBCount)
			throws Exception {
		// TODO Auto-generated method stub
		try {

		      //for (int d = 0; d < instanceDBCount; d++) {
		          double[] values = new double[super.attributeCount];
		          values[0]=((BestPlant)super.bestItem).getAddressID();
		          values[1]=((BestPlant)super.bestItem).getArea();
		          values[2]=((BestPlant)super.bestItem).getClimateID();
		          values[3]=((BestPlant)super.bestItem).getSoilID();
		          values[4]=((BestPlant)super.bestItem).getProfitValue();
		          //values[5]=bestPlant.getPlantID();
		          values[5]=instanceDBCount+1;
		          data.add(new DenseInstance(1.0, values));
		      //}
				
			} catch (Exception e) {
				// TODO: handle exception
				throw(e);
			}
		      return data;
	}


}
