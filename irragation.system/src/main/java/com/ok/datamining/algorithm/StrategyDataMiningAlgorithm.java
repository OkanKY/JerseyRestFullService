package com.ok.datamining.algorithm;

import java.util.ArrayList;

public class StrategyDataMiningAlgorithm {
	
	public Double getBest(IDataMiningAlgorithm dataMiningAlgorithm)
	{
		Double bestClass=null;
		try {
			dataMiningAlgorithm.setData();
			
			ArrayList<Double> list=dataMiningAlgorithm.getPrediction();
			bestClass=dataMiningAlgorithm.getBestClass(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bestClass;
	}
}
