package com.ok.datamining.creator.train.data;

import weka.core.Instances;

public class PlantTrainCreator extends ITrainCreator{

	@Override
	public Instances getDatasetDB(String tableName,String query) throws Exception {
		// TODO Auto-generated method stub
		return super.getDatasetDB(tableName,query);
	}

	@Override
	public Instances addAttributes(Instances data) throws Exception {
		// TODO Auto-generated method stub
		return super.addAttributes(data);
	}

	@Override
	public Instances discretize(Instances data,Integer instanceDBCount) throws Exception {
		// TODO Auto-generated method stub
		return super.discretize(data,instanceDBCount);
	}

	
}
