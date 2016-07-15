package com.ok.datamining.database;

public class ContractDataBase {
	public static final String plantQuery="SELECT "
			+ "f.addressID,f.area,f.climateID,f.soilID,fp.profitValue,p.plantID "
			+"FROM Field AS f "
			+"LEFT JOIN Product AS p "
			+"ON f.fieldID = p.fieldID "
			+"LEFT JOIN FinishedProduct AS fp "
			+"ON p.productID = fp.productID "  
			+"GROUP BY p.productID;";
}
