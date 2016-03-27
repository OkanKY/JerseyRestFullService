CREATE TABLE IF NOT EXISTS User(
    userID INT NOT NULL primary key  AUTO_INCREMENT,
	userName nvarchar(25) NOT NULL,
	password nvarchar(25) NOT NULL,
	status Bit 
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test User Create
*/
INSERT INTO User (userName,password,status) VALUES ('okan','1234',1);
INSERT INTO User (userName,password,status) VALUES ('kaya','1234',1);
Select * FROM User; 
--
-- Table structure for table `Address`
--
CREATE TABLE IF NOT EXISTS Address (
  addressID INT NOT NULL AUTO_INCREMENT,
  address nvarchar(50) DEFAULT NULL,
  postcode INT DEFAULT NULL,
  PRIMARY KEY (addressID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;
/*
Test Address Create
*/
INSERT INTO Address (address,postcode) VALUES ('turkey izmir',1234);

CREATE TABLE IF NOT EXISTS Field(
	fieldID INT NOT NULL primary key  AUTO_INCREMENT,
	fieldName nvarchar(25) NOT NULL,
    addressID INT NOT NULL,
	userID INT NOT NULL,
	createdDate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	fieldUrl nvarchar(50) NOT NULL,
    fieldInfo nvarchar(50) DEFAULT NULL,
    area Long DEFAULT NULL,
	centerLongitude Long DEFAULT NULL,
    centerLatitude Long DEFAULT NULL,
	climateType enum('humid_tropical','tropical_savanna','dessert','steppe','mediterranean',
    'humid_subtropical', 'marine_west_coast','humid_continental','subartic', 'tundra','ice_cap','highland') NOT NULL,
    soilType enum('sand','clay','silt','loam','coarse_soil','fine_soil') NOT NULL,
	CONSTRAINT Address
	FOREIGN  KEY (addressID) REFERENCES Address (addressID)
	ON DELETE CASCADE,	CONSTRAINT User
	FOREIGN  KEY (userID) REFERENCES User (userID)
	ON DELETE CASCADE 
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test Field Create
*/
INSERT INTO Field (fieldName,addressID,userID,fieldUrl,fieldInfo,area,centerLongitude,centerLatitude,climateType,soilType) 
VALUES ('xxx',1,1,'xxx','xxx',1.1,1,1,'dessert','clay');


CREATE TABLE IF NOT EXISTS Product(
	productID INT NOT NULL primary key  AUTO_INCREMENT ,
    fieldID INT NOT NULL,
    createdDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	productName nvarchar(25) NOT NULL,
	productInfo nvarchar(50) NOT NULL,
	CONSTRAINT Field
	FOREIGN  KEY (fieldID) REFERENCES Field (fieldID)
	ON DELETE CASCADE
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;

/*
Test PRODUCT Create
*/
INSERT INTO Product (fieldID,productName,productInfo) VALUES (1,'product','xxx');
Select * FROM Product; 

CREATE TABLE IF NOT EXISTS FinishedProduct(
	productID INT NOT NULL primary key,
    profitValue INT NOT NULL,
    finishDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT Product
	FOREIGN  KEY (productID) REFERENCES Product (productID)
	ON DELETE CASCADE
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test PRODUCT Create
*/
INSERT INTO FinishedProduct (productID,profitValue) VALUES (1,1);
Select * FROM FinishedProduct; 

CREATE TABLE IF NOT EXISTS Startirregationinfo(
	startIrregationInfoID INT NOT NULL primary key AUTO_INCREMENT,
	dateInformation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    humidity int NOT NULL,
	temperature int NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test STARTIRREGATIONINFO Create
*/
INSERT INTO Startirregationinfo (humidity,temperature) VALUES (1,1);
Select * FROM Startirregationinfo; 

CREATE TABLE IF NOT EXISTS Finishirregationinfo(
	finishIrregationInfoID INT NOT NULL primary key AUTO_INCREMENT,
	dateInformation timestamp,
    humidity int NOT NULL,
	temperature int NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test FINISHIRREGATIONINFO Create
*/
INSERT INTO Finishirregationinfo (humidity,temperature) VALUES (1,1);
Select * FROM Finishirregationinfo; 

CREATE TABLE IF NOT EXISTS Otherirregationinfo(
	otherIrregationInfoID INT NOT NULL primary key AUTO_INCREMENT,
	dateInformation timestamp,
    growthValue int NOT NULL,
    avarageHumidity int NOT NULL,
	avarageTemperature int NOT NULL,
    limitValueOutHumidity int NOT NULL,
    limitValueOutTemperature int NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test OTHERIRREGATIONINFO Create
*/
INSERT INTO Otherirregationinfo (growthValue,avarageHumidity,avarageTemperature,
limitValueOutHumidity,limitValueOutTemperature) VALUES (1,1,1,1,1);
Select growthValue,avarageHumidity,avarageTemperature,
limitValueOutHumidity,limitValueOutTemperature FROM Otherirregationinfo; 

CREATE TABLE IF NOT EXISTS Irregation(
	irregationID INT NOT NULL primary key AUTO_INCREMENT,
    productID INT NOT NULL,
    startIrregationInfoID  INT NOT NULL,
    finishIrregationInfoID  INT,
    otherIrregationInfoID INT,
    irregationAmount INT NOT NULL,
    CONSTRAINT Product
	FOREIGN  KEY (productID) REFERENCES Product (productID)
	ON DELETE CASCADE,
	CONSTRAINT Startirregationinfo
	FOREIGN  KEY (startIrregationInfoID) REFERENCES Startirregationinfo (startIrregationInfoID)
	ON DELETE CASCADE,
	CONSTRAINT Finishirregationinfo
	FOREIGN  KEY (finishIrregationInfoID) REFERENCES Finishirregationinfo (finishIrregationInfoID)
	ON DELETE CASCADE,
	CONSTRAINT Otherirregationinfo
	FOREIGN  KEY (otherIrregationInfoID) REFERENCES Otherirregationinfo (otherIrregationInfoID)
	ON DELETE CASCADE 
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;
/*
Test IRREGATION Create
*/
INSERT INTO Irregation (productID,startIrregationInfoID,irregationAmount) VALUES (1,1,1);
Select * FROM Irregation; 

CREATE TABLE IF NOT EXISTS Otherfertilizationinfo(
	otherFertılızatıonInfoID INT NOT NULL primary key AUTO_INCREMENT,
	dateInformation timestamp,
    growthValue int NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;
/*
Test OTHERFERTILIZATIONINFO Create
*/
INSERT INTO Otherfertilizationinfo (growthValue) VALUES (1);
Select * FROM otherfertilizationinfo; 

CREATE TABLE IF NOT EXISTS Fertilization(
	fertilizationID INT NOT NULL primary key AUTO_INCREMENT,
    productID INT NOT NULL,
	fertilizationAmount INT NOT NULL,
	otherFertılızatıonInfoID INT,
	createdDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT Product
	FOREIGN  KEY (productID) REFERENCES Product (productID)
	ON DELETE CASCADE,
	CONSTRAINT Otherfertilizationinfo
	FOREIGN  KEY (otherFertılızatıonInfoID) REFERENCES Otherfertilizationinfo (otherFertılızatıonInfoID)
	ON DELETE CASCADE
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test FERTILIZATION Create
*/
INSERT INTO Fertilization (productID,fertilizationAmount,otherFertılızatıonInfoID) VALUES (1,1,1);
Select * FROM Fertilization; 

/*
Check User Account
*/
SELECT UserID FROM User WHERE userName='okan' AND password='1234';
/*
Get Field information
*/
SELECT * FROM Field AS F WHERE F.fieldID=1; 
/*
Get User Fields List
*/
SELECT F.fieldName,F.fieldID FROM Field AS F WHERE F.userID IN
					 ( SELECT U.userID FROM User AS U WHERE U.userName ='okan'
                     AND U.Password='1234'
                     AND U.Status=1) ;
                     
/*
 to best product select
*/
SELECT p.productID,fp.profitValue,fp.finishDate,p.createdDate,f.addressID,f.area,f.climateType,f.soilType 
FROM Field AS f
LEFT JOIN Product AS p
ON f.fieldID = p.fieldID
LEFT JOIN FinishedProduct AS fp
ON p.productID = fp.productID  
GROUP BY p.productID;