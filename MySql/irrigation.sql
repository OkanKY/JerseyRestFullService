CREATE TABLE User(
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

CREATE TABLE Field(
	fieldID INT NOT NULL primary key  AUTO_INCREMENT ,
	fieldName nvarchar(25) NOT NULL,
	fieldUrl nvarchar(50) NOT NULL,
    fieldInfo nvarchar(50),
    centerLongitude Long NOT NULL,
    centerLatitude Long NOT NULL,
    area Long NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test Field Create
*/
INSERT INTO Field (fieldName,fieldUrl,fieldInfo,centerLongitude,centerLatitude,area) VALUES ('xxx','xxx','xxx',1.1,1.1,1);

CREATE TABLE Userfield(
	fieldID INT NOT NULL,
	userID INT NOT NULL,
	createdDate  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (fieldID,userID),
	CONSTRAINT FIELDS
	FOREIGN  KEY (fieldID) REFERENCES Field (fieldID)
	ON DELETE CASCADE ,
	CONSTRAINT USER
	FOREIGN  KEY (UserID) REFERENCES USER (UserID)
	ON DELETE CASCADE 
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test User Create
*/
INSERT INTO Userfield (fieldID,userID) VALUES (1,1);
Select * FROM Userfield; 

CREATE TABLE Product(
	productID INT NOT NULL primary key  AUTO_INCREMENT ,
	productName nvarchar(25) NOT NULL,
	prductInfo nvarchar(50) NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test PRODUCT Create
*/
INSERT INTO Product (ProductName,PrductInfo) VALUES ('product','xxx');
Select * FROM Product; 

CREATE TABLE Fieldproduct(
	fieldID INT NOT NULL,
	productID INT NOT NULL,
	createdDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    finishDate timestamp,
	PRIMARY KEY (fieldID,productID),
	CONSTRAINT FIELDS
	FOREIGN  KEY (fieldID) REFERENCES Field (fieldID)
	ON DELETE CASCADE ,
	CONSTRAINT Product
	FOREIGN  KEY (productID) REFERENCES Product (productID)
	ON DELETE CASCADE 
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;
/*
Test FIELDPRODUCT Create
*/
INSERT INTO Fieldproduct (fieldID,productID) VALUES (1,1);
Select * FROM Fieldproduct; 

CREATE TABLE Startirregationinfo(
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

CREATE TABLE Finishirregationinfo(
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

CREATE TABLE Otherirregationinfo(
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
Select * FROM Otherirregationinfo; 

CREATE TABLE Irregation(
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

CREATE TABLE Otherfertilizationinfo(
	otherFertılızatıonInfoID INT NOT NULL primary key AUTO_INCREMENT,
	dateInformation timestamp,
    growthValue int NOT NULL
)ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;
/*
Test OTHERFERTILIZATIONINFO Create
*/
INSERT INTO Otherfertilizationinfo (growthValue) VALUES (1);
Select * FROM otherfertilizationinfo; 

CREATE TABLE Fertilization(
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
SELECT F.fieldName,F.fieldID FROM Field AS F WHERE F.fieldID IN 
					 (SELECT UF.fieldID FROM userfield UF  WHERE UF.userID IN
					 ( SELECT U.userID FROM User AS U WHERE U.userName ='okan'
                     AND U.Password='1234'
                     AND U.Status=1) );