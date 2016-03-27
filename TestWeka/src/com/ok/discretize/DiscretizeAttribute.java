package com.ok.discretize;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("./Query/X_Training.arff");
		Instances dataset = source.getDataSet();		
		//set options
		String[] options = new String[4];
		//choose the number of intervals, e.g. 2 :
		options[0] = "-B"; options[1] = "2";
		//choose the range of attributes on which to apply the filter:
		options[2] = "-R";
		options[3] = "last";
		//options[4] = "-V";
		//Apply discretization:
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);

		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("./Query/dis2.arff"));
		saver.writeBatch();
	}
}