package com.ok.datamining;

import weka.core.Instances;

import com.ok.datamining.algorithm.FactoryDataMiningAlgorithm;
import com.ok.datamining.algorithm.IDataMiningAlgorithm;
import com.ok.datamining.algorithm.StrategyDataMiningAlgorithm;
import com.ok.datamining.creator.test.data.FactoryTestData;
import com.ok.datamining.creator.test.data.ITestCreator;
import com.ok.datamining.creator.test.data.StrategyTestData;
import com.ok.datamining.creator.train.data.FactoryTrainData;
import com.ok.datamining.creator.train.data.ITrainCreator;
import com.ok.datamining.creator.train.data.PlantTrainCreator;
import com.ok.datamining.creator.train.data.StrategyTrainData;
import com.ok.datamining.folder.ContractFolder;
import com.ok.datamining.item.BestItem;

public class BaseFactoryDataMining {

	private FactoryTestData factoryTestData;
	private FactoryTrainData factoryTrainData;
	private StrategyTestData strategyTestData;
	private StrategyTrainData strategyTrainData;
	private FactoryDataMiningAlgorithm factoryDataMiningAlgorithm;
	private StrategyDataMiningAlgorithm strategyDataMiningAlgorithm;

	public BaseFactoryDataMining() {
		this.factoryTestData = new FactoryTestData();
		this.factoryTrainData = new FactoryTrainData();
		this.strategyTestData = new StrategyTestData();
		this.strategyTrainData = new StrategyTrainData();
		this.factoryDataMiningAlgorithm= new FactoryDataMiningAlgorithm();
		this.strategyDataMiningAlgorithm= new StrategyDataMiningAlgorithm();
		// first declare to plant 
		generateTrainPlant();
	}

	public Double getBestPlant(BestItem bestItem) {
		ITestCreator creatorTest = factoryTestData.create(bestItem);
		Instances testDataset = strategyTestData.getTestDataInFolder(creatorTest);
		String trainFolder=ContractFolder.plantTrainFolder;
		return generateMLP(trainFolder,testDataset);

	}
	private void generateTrainPlant()
	{
		// Creator degismeli
		ITrainCreator creatorTrain = factoryTrainData
				.create(new PlantTrainCreator());
		strategyTrainData.saveFolderTrainData(creatorTrain);
	}

	private Double generateMLP(String trainFolder, Instances testDataset) {
		IDataMiningAlgorithm dataMiningAlgorithm=factoryDataMiningAlgorithm.create(trainFolder,testDataset);
		return strategyDataMiningAlgorithm.getBest(dataMiningAlgorithm);
	}

}
