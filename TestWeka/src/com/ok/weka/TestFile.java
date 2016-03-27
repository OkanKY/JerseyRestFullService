package com.ok.weka;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TestFile {
    public static void main(String[] args) throws Exception {
        Instances training_data = new Instances(new BufferedReader(
                new FileReader("./Query/X_Training.arff")));
        training_data.setClassIndex(training_data.numAttributes() - 1);
        Instances testing_data = new Instances(new BufferedReader(
        		new FileReader("./Query/test.arff")));
        testing_data.setClassIndex(training_data.numAttributes() - 1);
        String summary = training_data.toSummaryString();
        int number_samples = training_data.numInstances();
        int number_attributes_per_sample = training_data.numAttributes();
//        System.out.println("Number of attributes in model = "
//                + number_attributes_per_sample);
//        System.out.println("Number of samples = " + number_samples);
//        System.out.println("Summary: " + summary);
//        System.out.println();
//        
      //Instance of NN
        MultilayerPerceptron mlp = new MultilayerPerceptron();
      //Setting Parameters
        mlp.setLearningRate(0.1);
        mlp.setMomentum(0.2);
        mlp.setTrainingTime(100);
        mlp.setHiddenLayers("3");

        mlp.buildClassifier(training_data);
        
        Evaluation eval = new Evaluation(training_data); 
        eval.evaluateModel(mlp, testing_data);
        FilteredClassifier fc = new FilteredClassifier();
//        Remove rm = new Remove();
//        fc.setFilter(rm);
//        fc.setClassifier(mlp);
//        fc.buildClassifier(training_data);
        
        Instances datapredict = new Instances(
        		new BufferedReader(
        		new FileReader("./Query/X_Training.arff")));
        		datapredict.setClassIndex(datapredict.numAttributes()-1);
       Instances predicteddata = new Instances(datapredict);
       
       for (int i = 0; i < datapredict.numInstances(); i++) {
    	   double clsLabel = mlp.classifyInstance(datapredict.instance(i));
    	   predicteddata.instance(i).setClassValue(clsLabel);
    	   System.out.println("test :"+clsLabel);
           System.out.print("given value: "
                 + testing_data.classAttribute().value(
                         (int) testing_data.instance(i).classValue()));
         double pred = testing_data.instance(i).classValue();
//         System.out.print("given value: "
//                 + testing_data.classAttribute().value(
//                         (int) testing_data.instance(i).classValue()));
         System.out.println(". predicted value: "
                 + testing_data.classAttribute().value((int) pred));

    	   }
        		
        System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 
        System.out.println(eval.errorRate()); 
        testing_data.instance(0);
//        for (int i = 0; i < testing_data.numInstances(); i++) {
//            double pred = fc.classifyInstance(testing_data.instance(i));
//            System.out.print("given value: "
//                    + testing_data.classAttribute().value(
//                            (int) testing_data.instance(i).classValue()));
//            System.out.println(". predicted value: "
//                    + testing_data.classAttribute().value((int) pred));
//
//        }
        
//        Evaluation eval = new Evaluation(training_data);
//        eval.evaluateModel(mlp, training_data);
//        
//        System.out.println(eval.precision(1)+" "+ eval.recall(1));

//        System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
//        System.out.println(eval.toSummaryString()); //Summary of Training
//		 NaiveBayes nB = new NaiveBayes();
//		 nB.buildClassifier(training_data);	
		 
//		 
//		 Evaluation e = new Evaluation(testing_data);
//		 e.crossValidateModel (nB, testing_data, 10,new Random(1));
//		 System.out.println(e.toSummaryString("/nResults/n=====/n",true));
//		 System.out.println(e.fMeasure(1) +" "+e.precision(1)+" "+ e.recall(1));
       /* J48 j48 = new J48();
        //ADTree adt = new ADTree();
        Remove rm = new Remove();
        rm.setAttributeIndices("1");
        FilteredClassifier fc = new FilteredClassifier();
        fc.setFilter(rm);
        fc.setClassifier(j48);
        fc.buildClassifier(training_data);

        for (int i = 0; i < testing_data.numInstances(); i++) {
            double pred = fc.classifyInstance(testing_data.instance(i));
            System.out.print("given value: "
                    + testing_data.classAttribute().value(
                            (int) testing_data.instance(i).classValue()));
            System.out.println(". predicted value: "
                    + testing_data.classAttribute().value((int) pred));

        }*/
    }
}
