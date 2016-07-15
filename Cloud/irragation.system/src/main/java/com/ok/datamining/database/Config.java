package com.ok.datamining.database;

public class Config {

	public static final String projectFolder = "./Query/";

	public static String modelPath = projectFolder + "model.model";
	public static String submFilePath = projectFolder + "subm.csv";
	public static String sqlFilePath = projectFolder + "feature_query.sql";
	public static String arffTrainingPath = projectFolder + "X_Training.arff";
	public static String arffValidationPath = projectFolder
			+ "X_Validation.arff";
	public static String esTempWorkingFolderPath = projectFolder
			+ "es_working\\";

	public static String connString = "jdbc:mysql://127.0.0.1:3306/test";
	public static String connUser = "root";
	public static String connPassword = "okan";
	public static String queryBestProduct = "SELECT p.productID,fp.profitValue,f.addressID,f.area"
			+ "FROM Field AS f"
			+ "LEFT JOIN Product AS p"
			+ "ON f.fieldID = p.fieldID"
			+ "LEFT JOIN FinishedProduct AS fp"
			+ "ON p.productID = fp.productID" 
			+ "GROUP BY p.productID;";

}