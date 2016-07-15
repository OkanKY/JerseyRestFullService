package com.ok.datamining.creator.train.data;

import com.ok.datamining.database.ContractDataBase;
import com.ok.datamining.folder.ContractFolder;
import com.ok.jpa.controller.JpaInstanceCountController;

import weka.core.Instances;

public class StrategyTrainData {
	private JpaInstanceCountController jpaInstanceCountController;
	public StrategyTrainData()
	{
		jpaInstanceCountController=new JpaInstanceCountController();
	}

	public Boolean saveFolderTrainData(ITrainCreator creator)
	{
		String saveFolder="";
		String tableName ="";
		String query="";
		Integer instanceDBCount = null;
		try {
			if(creator instanceof PlantTrainCreator)
			{
				saveFolder=ContractFolder.plantTrainFolder;
				tableName=ContractFolder.plantTableName;
				query=ContractDataBase.plantQuery;
				instanceDBCount=(int)(long)jpaInstanceCountController.getPlantInstanceCount();
			}
			
			
			Instances data=creator.getDatasetDB(tableName,query);
			Instances dataAttribute=creator.addAttributes(data);
			Instances dataDiscretize=creator.discretize(dataAttribute,instanceDBCount);
			creator.saveFolder(dataDiscretize, saveFolder);
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
