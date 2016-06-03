package com.ok.datamining.algorithm;

import java.util.ArrayList;
import java.util.Collections;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;

public class MultilayerPerceptronAlgorithm extends IDataMiningAlgorithm {

	private MultilayerPerceptron mlp;

	public MultilayerPerceptronAlgorithm(Instances trainDataset,
			Instances testDataset) throws Exception {
		super(trainDataset, testDataset);
		// TODO Auto-generated constructor stub
	}

	public MultilayerPerceptronAlgorithm(String trainFolder,
			Instances testDataset) {
		// TODO Auto-generated constructor stub
		super(trainFolder, testDataset);
	}

	@Override
	public void setData() throws Exception {
		// TODO Auto-generated method stub
		// Setting Parameters
		try {
			mlp = new MultilayerPerceptron();
			mlp.setLearningRate(0.1);
			mlp.setMomentum(0.1);
			mlp.setTrainingTime(2000);
			mlp.setHiddenLayers("3");

			mlp.buildClassifier(super.trainDataset);

		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

	@Override
	public Double getPrediction() throws Exception {
		// TODO Auto-generated method stub
		double pred=0;
		try {
			for (int i = 0; i < super.testDataset.numInstances(); i++) {
				// get Instance object of current instance
				Instance newInst = super.testDataset.instance(i);
				// call classifyInstance, which returns a double value for the
				// class
				System.out.println("Pre:"+newInst.numAttributes());
				System.out.println("Pre value:"+ newInst.toString(4));
				 pred = mlp.classifyInstance(newInst);
				System.out.println("test:+"+pred);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
		return pred;
	}

	@Override
	public void getError() throws Exception {
		// TODO Auto-generated method stub
		try {

		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

}
