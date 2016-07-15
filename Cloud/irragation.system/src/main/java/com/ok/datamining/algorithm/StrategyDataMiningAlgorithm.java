package com.ok.datamining.algorithm;


public class StrategyDataMiningAlgorithm {
	
	public Double getBest(IDataMiningAlgorithm dataMiningAlgorithm)
	{
		Double bestClass=null;
		try {
			dataMiningAlgorithm.setData();
			bestClass=dataMiningAlgorithm.getPrediction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bestClass;
	}
}
