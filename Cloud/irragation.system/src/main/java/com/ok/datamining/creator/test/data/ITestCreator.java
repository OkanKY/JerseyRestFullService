package com.ok.datamining.creator.test.data;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

import com.ok.datamining.item.BestItem;

public abstract class ITestCreator {
	protected BestItem bestItem;
	protected Integer attributeCount;

	public ITestCreator(BestItem bestItem) {
		this.bestItem = bestItem;
	}

	public abstract Instances createTestData() throws Exception;

	public abstract Instances addAttribute(Instances data,Integer instanceDBCount) throws Exception;

	public Instances discretize(Instances data,Integer instanceDBCount) throws Exception {
		Instances newData = null;
		try {
			// set options
			String[] options = new String[4];
			// choose the number of intervals, e.g. 2 :
			options[0] = "-B";
			options[1] = "" + (instanceDBCount);
			// choose the range of attributes on which to apply the filter:
			options[2] = "-R";
			options[3] = "last";
			// Apply discretization:
			Discretize discretize = new Discretize();
			discretize.setOptions(options);
			discretize.setInputFormat(data);
		    newData = Filter.useFilter(data, discretize);

		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		return newData;
	}

	public void saveFolder(Instances data,String saveFolder) throws Exception {
		try {

			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File(saveFolder));
			saver.writeBatch();

		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

}
