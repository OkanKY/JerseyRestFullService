package com.ok.weka;

public class Config {
    
    public static final String projectFolder = "C:\\Users\\Quan\\Desktop\\KDDCup2013\\Kdd2013AuthorPaperIdentification\\JavaBenchmark\\";
    
    public static String modelPath = projectFolder + "model.model";
    public static String submFilePath = projectFolder + "subm.csv";
    public static String sqlFilePath = projectFolder + "feature_query.sql";
    public static String arffTrainingPath = projectFolder + "X_Training.arff";
    public static String arffValidationPath = projectFolder + "X_Validation.arff";
    public static String esTempWorkingFolderPath = projectFolder + "es_working\\";
     
    public static String connString = "jdbc:postgresql://localhost:3306/irrigation";
    public static String connUser = "root";
    public static String connPassword = "okan"; 

}