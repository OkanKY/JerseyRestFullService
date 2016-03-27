package com.ok.classifier;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SMOreg;

public class MultilayerPerceptronPer{
	public static void main(String args[]) throws Exception{
		//load training dataset
		DataSource mlpsource = new DataSource("./Query/dis2.arff");
		Instances mlptrainDataset = mlpsource.getDataSet();	
		//set class index to the last attribute
		mlptrainDataset.setClassIndex(mlptrainDataset.numAttributes()-1);
		
		//load new dataset
		DataSource mlptestsource = new DataSource("./Query/dis2.arff");
		Instances mlptestDataset = mlptestsource.getDataSet();	
		//set class index to the last attribute
		mlptestDataset.setClassIndex(mlptestDataset.numAttributes()-1);

	      //Instance of NN
        MultilayerPerceptron mlp = new MultilayerPerceptron();
      //Setting Parameters
        mlp.setLearningRate(0.1);
        mlp.setMomentum(0.1);
        mlp.setTrainingTime(2000);
        mlp.setHiddenLayers("3");

        mlp.buildClassifier(mlptrainDataset);
        /*
		//build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(trainDataset);
		//output model
		System.out.println(smo);*/



		//loop through the new dataset and make predictions
		System.out.println("===================");
		System.out.println("Actual Class, SMO Predicted");
		for (int i = 0; i < mlptestDataset.numInstances(); i++) {
			//get class double value for current instance 
			double actualValue = mlptestDataset.instance(i).classValue();

			//get Instance object of current instance
			Instance newInst = mlptestDataset.instance(i);
			//call classifyInstance, which returns a double value for the class
			double predSMO =  mlp.classifyInstance(newInst);

			System.out.println(actualValue+", "+predSMO);
		}
        Evaluation eval = new Evaluation(mlptrainDataset); 
        eval.evaluateModel(mlp, mlptestDataset);
        System.out.println(eval.errorRate());
        System.out.println(eval.avgCost());
        System.out.println(eval.meanAbsoluteError());

	}
}