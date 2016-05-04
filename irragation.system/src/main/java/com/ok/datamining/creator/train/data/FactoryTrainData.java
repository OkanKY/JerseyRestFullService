package com.ok.datamining.creator.train.data;

public class FactoryTrainData {
	public ITrainCreator create(ITrainCreator creator)
	{
		if(creator instanceof PlantTrainCreator)
			return new PlantTrainCreator();
		return null;
	}
}
