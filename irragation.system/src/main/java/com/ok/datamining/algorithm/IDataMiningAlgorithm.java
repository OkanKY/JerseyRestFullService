package com.ok.datamining.algorithm;

import java.util.ArrayList;
import java.util.Collections;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public abstract class IDataMiningAlgorithm {
	protected Instances trainDataset;
	protected Instances testDataset;

	public IDataMiningAlgorithm(Instances trainDataset, Instances testDataset) {
		this.trainDataset = trainDataset;
		this.testDataset = testDataset;
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
	}
	public IDataMiningAlgorithm(String trainFolder, Instances testDataset) {
		this.trainDataset = getInstances(trainFolder);
		this.testDataset = testDataset;
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
	}
	public IDataMiningAlgorithm(Instances trainDataset, String testFolder) {
		this.trainDataset = trainDataset;
		this.testDataset = getInstances(testFolder);
		trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
		testDataset.setClassIndex(testDataset.numAttributes() - 1);
	}

	private Instances getInstances(String folder) {
		Instances dataset = null;

		try {
			// load training dataset
			DataSource source = new DataSource(folder);
			dataset = source.getDataSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;

	}

	public abstract void setData() throws Exception;

	public abstract ArrayList<Double> getPrediction() throws Exception;

	public abstract void getError() throws Exception;

	public Double getBestClass(ArrayList<Double> list) {
		/* Sorting of arraylist using Collections.sort */
		Collections.sort(list);
		return list.get(list.size() - 1);
	}

}
