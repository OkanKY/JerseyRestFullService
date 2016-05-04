package com.ok.datamining.algorithm;

import com.ok.datamining.folder.ContractFolder;

import weka.core.Instances;

public class FactoryDataMiningAlgorithm {

	public IDataMiningAlgorithm create(String trainFolder, Instances testDataset) {
		IDataMiningAlgorithm dataMiningAlgorithm = null;
		try {

			dataMiningAlgorithm = new MultilayerPerceptronAlgorithm(
					trainFolder, testDataset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataMiningAlgorithm;
	}
}
