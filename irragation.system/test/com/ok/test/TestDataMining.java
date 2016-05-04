package com.ok.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
import com.ok.datamining.item.BestPlant;

public class TestDataMining {
	public FactoryTestData factoryTestData;
	public FactoryTrainData factoryTrainData;
	public StrategyTestData strategyTestData;
	public StrategyTrainData strategyTrainData;
	public FactoryDataMiningAlgorithm factoryDataMiningAlgorithm;
	public StrategyDataMiningAlgorithm strategyDataMiningAlgorithm;

	@Before
	public void generate() {
		this.factoryTestData = new FactoryTestData();
		this.factoryTrainData = new FactoryTrainData();
		this.strategyTestData = new StrategyTestData();
		this.strategyTrainData = new StrategyTrainData();
		this.factoryDataMiningAlgorithm = new FactoryDataMiningAlgorithm();
		this.strategyDataMiningAlgorithm = new StrategyDataMiningAlgorithm();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void trainData() {
		Boolean result = false;
		try {
			// Creator degismeli
			ITrainCreator creatorTrain = factoryTrainData
					.create(new PlantTrainCreator());
			result = strategyTrainData.saveFolderTrainData(creatorTrain);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			fail();
		}
		Assert.assertTrue(result);
	}

	@Test
	public void testData() {
		try {

			BestItem bestItem = new BestPlant(1, 1, 1, 1, 1, 1);
			ITestCreator creatorTest = factoryTestData.create(bestItem);
			Instances testDataset = strategyTestData
					.getTestDataInFolder(creatorTest);
			String trainFolder = ContractFolder.plantTrainFolder;
			Double classNumber= generateMLP(trainFolder,testDataset);
			System.out.println("Class :"+classNumber);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			fail();
		}

	}

	private Double generateMLP(String trainFolder, Instances testDataset) {
		IDataMiningAlgorithm dataMiningAlgorithm=factoryDataMiningAlgorithm.create(trainFolder,testDataset);
		return strategyDataMiningAlgorithm.getBest(dataMiningAlgorithm);
	}

	@After
	public void After() {
		System.out.println("Finish  Testing");
	}

}
