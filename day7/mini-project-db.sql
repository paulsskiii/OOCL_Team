DROP DATABASE GROUP3_MINIPROJECT;

CREATE DATABASE GROUP3_MINIPROJECT;

USE GROUP3_MINIPROJECT;

CREATE TABLE `CUSTOMERS` (
`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL,
`contact_number` VARCHAR(45) NOT NULL UNIQUE,
`email_address` VARCHAR(45) NOT NULL UNIQUE,
`address_line1` VARCHAR(100) NOT NULL,
`address_line2` VARCHAR(100) NOT NULL,
`barangay` VARCHAR(45) NOT NULL,
`city` VARCHAR(45) NOT NULL,
`postal_code` INT NOT NULL,
`region` VARCHAR(45) NOT NULL,
`country` VARCHAR(45) NOT NULL,
`created_at` DATETIME NOT NULL,
`updated_at` DATETIME
);

CREATE TABLE COURIERS (
`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL,
`contact_number` VARCHAR(20) NOT NULL,
`vehicle_type` VARCHAR(45) NOT NULL,
`license_number` VARCHAR(30) NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE LOCATIONS (
    id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    location_name VARCHAR(100) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME );



CREATE TABLE `DELIVERY_DETAILS` (
`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
`sender_id` INT NOT NULL,
`recipient_id` INT NOT NULL,
`created_at` DATETIME NOT NULL,
`updated_at`DATETIME,
`created_by` INT,
`updated_by` INT,
 
FOREIGN KEY (sender_id) REFERENCES CUSTOMERS(id),
FOREIGN KEY (recipient_id) REFERENCES CUSTOMERS(id),
FOREIGN KEY (updated_by) REFERENCES CUSTOMERS(id),
FOREIGN KEY (created_by) REFERENCES CUSTOMERS(id)
);
 
 CREATE TABLE PACKAGES (
	id int not null auto_increment primary key,
    pickup_date datetime not null ,
    delivery_date datetime not null ,
    package_type varchar(50),
    weight float(7,2),
    contents_description varchar(100),
    delivery_details_id int not null,
    courier_id int,
    
    FOREIGN KEY (delivery_details_id)
                REFERENCES DELIVERY_DETAILS(id),
    FOREIGN KEY (courier_id)
                REFERENCES COURIERS(id)
);

-- updated tracking_events table
CREATE TABLE TRACKING_EVENTS (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    event_description VARCHAR(100), -- description is an SQL keyword
    package_status VARCHAR(100),
    package_id INT NOT NULL,
    location_id INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (package_id) REFERENCES packages(id),
    FOREIGN KEY (location_id) REFERENCES locations(id)
);

INSERT INTO CUSTOMERS(first_name,last_name,contact_number,email_address,address_line1,address_line2,barangay,city,postal_code,region,country,created_at,updated_at)
VALUES
 ('James','Martin','09173459821','martinjames@gmail.com','124 Mabini St.','Poblacion','Barangay 101','Quezon City',1101,'National Capital Region (NCR)','Philippines','2024-01-15 8:23:45','2024-02-02 14:56:10')
,('Maria','Santos','09286124730','mariasantos@yahoo.com','56 Rizal Ave.','San Isidro','Barangay 15','Manila',1000,'National Capital Region (NCR)','Philippines','2024-02-28 11:40:12','2024-03-03 16:29:50')
,('John','Garcia','09057841236','johngarcia@yahoo.com','89 Aguinaldo Hwy.','Anabu','Barangay 27','Pasig City',1600,'National Capital Region (NCR)','Philippines','2024-03-19 9:18:33','2024-03-22 12:44:05')
,('Angela','Cruz','09984502379','angelacruz@gmail.com','210 Bonifacio St.','Bagumbayan','Barangay 88','Caloocan City',1400,'National Capital Region (NCR)','Philippines','2024-04-02 15:07:54','2024-04-04 18:35:41')
,('Robert','Johnson','09196238457','robertjohnson@yahoo.com','78 Del Pilar St.','Mabolo','Barangay 42','Makati City',1200,'National Capital Region (NCR)','Philippines','2024-05-11 7:22:16','2024-05-12 9:48:59')
,('Liza','Mendoza','09218354021','lizamendoza@gmail.com','305 Luna St.','San Roque','Barangay 19','Mandaluyong City',1550,'National Capital Region (NCR)','Philippines','2024-06-03 10:44:28','2024-06-06 14:19:42')
,('Michael','Brown','09364578910','michaelbrown@yahoo.com','47 Kalayaan Ave.','Kamuning','Barangay 76','Valenzuela City',1440,'National Capital Region (NCR)','Philippines','2024-06-25 13:12:55','2024-06-30 17:05:31')
,('Alexis','Cao','09087612493','alexiscao@gmail.com','92 General Malvar St.','Malate','Barangay 58','Parañaque City',1700,'National Capital Region (NCR)','Philippines','2024-07-14 8:56:19','2024-07-16 10:39:48')
,('Sophia','Reyes','09185234795','sophiareyes@yahoo.com','63 MacArthur Hwy.','Salapungan','Barangay 32','Taguig City',1630,'National Capital Region (NCR)','Philippines','2024-08-05 6:41:22','2024-08-07 9:58:15')
,('Daniel','Anderson','09276105842','danielanderson@gmail.com','184 Roxas Blvd.','Baclaran','Barangay 71','Pasay City',1300,'National Capital Region (NCR)','Philippines','2024-08-23 17:33:44','2024-08-26 20:14:37')
,('Joshua','Villanueva','09068457923','joshuavillanueva@yahoo.com','219 P. Burgos St.','Zone 5','Barangay 54','Marikina City',1800,'National Capital Region (NCR)','Philippines','2024-09-11 11:21:05','2024-09-12 14:55:27')
,('Camille','Fernandez','09972345871','camillefernandez@gmail.com','331 Gen. Santos Ave.','Lower Bicutan','Barangay 8','Las Piñas City',1740,'National Capital Region (NCR)','Philippines','2024-09-27 9:18:56','2024-09-30 12:40:13')
,('William','Davis','09156983740','williamdavis@yahoo.com','77 Magallanes St.','Zone 3','Barangay 93','Antipolo City',1870,'CALABARZON (Region IV-A)','Philippines','2024-10-12 7:49:33','2024-10-15 10:11:02')
,('Patrick','Bautista','09384265812','patrickbautista@gmail.com','15 M. H. Del Pilar St.','Sabang','Barangay 39','Cainta',1900,'CALABARZON (Region IV-A)','Philippines','2024-11-01 14:02:11','2024-11-03 18:22:25')
,('Kimberly','Ramirez','09073598246','kimberlyramirez@yahoo.com','94 Ortigas Ave. Ext.','San Isidro','Barangay 25','San Juan City',1500,'National Capital Region (NCR)','Philippines','2024-11-18 8:34:47','2024-11-20 13:59:56')
,('Ethan','Thompson','09234875921','ethanthompson@gmail.com','53 F. Manalo St.','Sta. Elena','Barangay 64','Malabon City',1470,'National Capital Region (NCR)','Philippines','2024-12-05 6:15:28','2024-12-07 9:44:33')
,('Hannah','Gonzales','09176504329','hannahgonzales@yahoo.com','110 Commonwealth Ave.','Batasan Hills','Barangay 49','Muntinlupa City',1770,'National Capital Region (NCR)','Philippines','2024-12-22 11:58:44','2024-12-23 15:26:10')
,('Christian','Navarro','09327851694','christiannavarro@gmail.com','88 P. Tuazon Blvd.','Socorro','Barangay 11','Navotas City',1485,'National Capital Region (NCR)','Philippines','2025-01-09 7:23:19','2025-01-12 10:41:58')
,('Olivia','Walker','09958341207','oliviawalker@yahoo.com','172 San Jose St.','San Jose','Barangay 84','Mandaluyong City',1550,'National Capital Region (NCR)','Philippines','2025-01-27 14:18:52','2025-01-29 16:39:27')
,('Ryan','Lim','09092735486','ryanlim@gmail.com','245 Gov. Pack Rd.','Salud Mitra','Barangay 23','Bacoor City',4102,'CALABARZON (Region IV-A)','Philippines','2025-02-15 8:42:30','2025-02-18 12:07:16')
,('Jessica','Lee','09265913074','jessicalee@yahoo.com','301 National Hwy.','Ibabang Dupay','Barangay 14','Imus City',4103,'CALABARZON (Region IV-A)','Philippines','2025-03-03 13:55:48','2025-03-06 15:27:34')
,('Francis','Perez','09134625789','francisperez@gmail.com','41 Quirino Ave.','Tambo','Barangay 6','Dasmariñas City',4114,'CALABARZON (Region IV-A)','Philippines','2025-03-21 10:11:56','2025-03-23 13:49:12')
,('Emily','Taylor','09318476205','emilytaylor@yahoo.com','138 P. Gomez St.','Mabini','Barangay 90','Cavite City',4100,'CALABARZON (Region IV-A)','Philippines','2025-04-07 7:26:33','2025-04-10 10:40:55')
,('Monique','Aira','09253098741','mnqaira@gmail.com','55 Burgos St.','Alangilan','Barangay 33','Trece Martires City',4109,'CALABARZON (Region IV-A)','Philippines','2025-04-25 16:19:44','2025-04-27 19:56:38')
,('Katrina','Vergara','09165832097','katrinavergara@yahoo.com','99 C. Raymundo Ave.','Rosario','Barangay 59','General Trias City',4117,'CALABARZON (Region IV-A)','Philippines','2025-05-12 8:54:18','2025-05-15 12:33:42')
,('Lucas','Harris','09927483164','lucasharris@gmail.com','212 Marcos Hwy.','Mayamot','Barangay 46','Batangas City',4200,'CALABARZON (Region IV-A)','Philippines','2025-05-28 9:37:22','2025-05-30 13:45:59')
,('Bianca','Salvador','09082547693','biancasalvador@yahoo.com','74 Lapu-Lapu St.','Cogon','Barangay 72','Lipa City',4217,'CALABARZON (Region IV-A)','Philippines','2025-06-14 6:29:55','2025-06-17 9:41:23')
,('Samuel','Brooks','09248139570','samuelbrooks@gmail.com','186 E. Aguinaldo St.','Catbangen','Barangay 18','San Pablo City',4000,'CALABARZON (Region IV-A)','Philippines','2025-06-29 14:42:41','2025-07-02 17:18:50')
,('Paolo','Abad','09126438051','paoloabad@yahoo.com','68 Mabuhay St.','Dalahican','Barangay 99','Lucena City',4301,'CALABARZON (Region IV-A)','Philippines','2025-07-15 8:31:29','2025-07-18 10:55:38')
,('Chloe','Rogers','09359812406','chloerogers@gmail.com','150 Panganiban Dr.','Sta. Cruz','Barangay 3','Calamba City',4029,'CALABARZON (Region IV-A)','Philippines','2025-07-30 12:48:11','2025-08-02 15:19:57')
,('Anthony','Del Rosario','09064379852','anthonydelrosario@yahoo.com','38 P. Zamora St.','Ibaba','Barangay 41','Santa Rosa City',4026,'CALABARZON (Region IV-A)','Philippines','2025-08-16 7:22:40','2025-08-19 9:59:18')
,('Grace','Evangelista','09147053298','graceevangelista@gmail.com','275 Ilang-Ilang St.','San Nicolas','Barangay 77','Biñan City',2200,'Central Luzon (Region III)','Philippines','2025-08-31 17:13:33','2025-09-02 20:41:09')
,('Aaron','Campbell','09293517608','aaroncampbell@yahoo.com','120 F. Reyes St.','Sto. Niño','Barangay 26','Olongapo City',2009,'Central Luzon (Region III)','Philippines','2025-09-15 10:58:26','2025-09-18 14:22:40')
,('Rhandel','Calingasan','09916208743','rhandelcal@gmail.com','195 Magsaysay Ave.','Zone 2','Barangay 12','Angeles City',2000,'Central Luzon (Region III)','Philippines','2025-09-30 8:40:55','2025-10-03 11:11:27')
,('Jason','Castillo','09187051934','jasoncastillo@yahoo.com','81 Sampaguita St.','Sta. Monica','Barangay 65','San Fernando City',2300,'Central Luzon (Region III)','Philippines','2025-10-14 6:19:38','2025-10-17 8:57:56')
,('Andrea','Cruzado','09334928510','andreacruzado@gmail.com','230 G. Araneta Ave.','Tatalon','Barangay 4','Tarlac City',3500,'Cagayan Valley (Region II)','Philippines','2025-10-29 15:44:21','2025-11-01 18:25:33')
,('Benjamin','Miller','09228375190','benjaminmiller@yahoo.com','66 Yakal St.','Maligaya','Barangay 35','Tuguegarao City',4400,'Bicol Region (Region V)','Philippines','2025-11-13 9:55:12','2025-11-16 12:39:47')
,('Jerome','Villarin','09075893412','jeromevillarin@gmail.com','142 Katipunan Ave.','Loyola Heights','Barangay 17','Naga City',4500,'Bicol Region (Region V)','Philippines','2025-11-28 7:18:45','2025-12-01 9:53:21')
,('Sophia','White','09152637840','sophiawhite@yahoo.com','93 Molave St.','San Vicente','Barangay 53','Legazpi City',2600,'Cordillera Admin Region (CAR)','Philippines','2025-12-14 13:27:56','2025-12-16 15:59:44')
,('Mark','Torres','09961843572','marktorres@gmail.com','58 Dahlia St.','Fairview','Barangay 30','Baguio City',1102,'National Capital Region (NCR)','Philippines','2024-08-05 14:12:47','2024-08-06 9:33:21')
,('Patrick','Soriano','09187593421','patricksoriano@gmail.com','102 Mabini St.','Balibago','Barangay 92','Quezon City',1103,'National Capital Region (NCR)','Philippines','2025-01-16 18:47:55','2025-01-17 8:15:39')
,('Julian','Park','09276821459','julianpark@yahoo.com','76 Rizal Ave.','San Miguel','Barangay 7','Manila',1104,'National Capital Region (NCR)','Philippines','2024-07-29 11:59:13','2024-07-30 16:44:00')
,('Katrina','Gomez','09058437926','katrinagomez@gmail.com','58 Aguinaldo Hwy.','Talon','Barangay 68','Pasig City',1105,'National Capital Region (NCR)','Philippines','2025-02-08 21:22:04','2025-02-09 12:31:18')
,('Elijah','dela Peña','09985236147','elijahdelapena@yahoo.com','214 Bonifacio St.','San Rafael','Barangay 55','Caloocan City',1106,'National Capital Region (NCR)','Philippines','2024-11-15 9:03:25','2024-11-16 14:55:37')
,('Christine','Villanueva','09194752863','christinevillanueva@gmail.com','87 Del Pilar St.','Merville','Barangay 36','Makati City',1107,'National Capital Region (NCR)','Philippines','2024-10-28 7:41:59','2024-10-29 13:22:40')
,('Matthew','Thompson','09219364785','matthewthompson@yahoo.com','305 Luna St.','San Vicente','Barangay 13','Mandaluyong City',1108,'National Capital Region (NCR)','Philippines','2025-03-19 15:27:44','2025-03-20 10:51:02')
,('Veronica','Alcaraz','09365974281','veronicaalcaraz@gmail.com','44 Kalayaan Ave.','New Era','Barangay 40','Valenzuela City',1109,'National Capital Region (NCR)','Philippines','2024-09-23 12:35:48','2024-09-24 19:12:36')
,('Rhonin','Philip','09087251643','rhoninphilip@yahoo.com','97 General Malvar St.','San Isidro','Barangay 24','Parañaque City',1110,'National Capital Region (NCR)','Philippines','2025-04-11 8:17:29','2025-04-11 20:40:55')
,('Joanne','Villafuerte','09185793264','joannevillafuerte@gmail.com','69 MacArthur Hwy.','San Juan','Barangay 83','Taguig City',1111,'National Capital Region (NCR)','Philippines','2024-08-14 22:44:10','2024-08-15 15:18:32')
,('Gabriel','Martin','09276394158','gabrielmartin@yahoo.com','192 Roxas Blvd.','Don Galo','Barangay 10','Pasay City',1201,'National Capital Region (NCR)','Philippines','2025-05-27 13:03:11','2025-05-28 7:42:50')
,('Stephanie','Velasco','09068372591','stephanievelasco@gmail.com','243 P. Burgos St.','Bagong Bayan','Barangay 62','Marikina City',1202,'National Capital Region (NCR)','Philippines','2024-12-09 19:39:45','2024-12-10 8:56:14')
,('Alexander','Cruz','09973482561','alexandercruz@yahoo.com','325 Gen. Santos Ave.','Upper Bicutan','Barangay 5','Las Piñas City',1203,'National Capital Region (NCR)','Philippines','2025-02-23 11:48:06','2025-02-24 17:21:38')
,('Isabelle','Morales','09156284793','isabellemorales@gmail.com','79 Magallanes St.','Zone 1','Barangay 95','Antipolo City',1204,'National Capital Region (NCR)','Philippines','2024-07-18 20:15:53','2024-07-19 14:29:02')
,('Brandon','Flores','09384629175','brandonflores@yahoo.com','19 M. H. Del Pilar St.','Libis','Barangay 28','Cainta',1301,'National Capital Region (NCR)','Philippines','2025-03-01 10:26:34','2025-03-02 9:13:46')
,('Carla','Santiago','09073295184','carlasantiago@gmail.com','96 Ortigas Ave. Ext.','Mayamot','Barangay 21','San Juan City',1302,'National Capital Region (NCR)','Philippines','2024-09-05 6:38:51','2024-09-06 12:40:24')
,('Christopher','Hughes','09234598271','christopherhughes@yahoo.com','51 F. Manalo St.','Concepcion Uno','Barangay 66','Malabon City',1401,'National Capital Region (NCR)','Philippines','2025-04-25 14:49:15','2025-04-26 18:03:47')
,('Mariel','Mendoza','09176952483','marielmendoza@gmail.com','118 Commonwealth Ave.','Holy Spirit','Barangay 43','Muntinlupa City',1402,'National Capital Region (NCR)','Philippines','2024-10-10 17:11:39','2024-10-11 8:44:52')
,('Jonathan','Price','09327184569','jonathanprice@yahoo.com','85 P. Tuazon Blvd.','Immaculate Concepcion','Barangay 9','Navotas City',1403,'National Capital Region (NCR)','Philippines','2025-01-03 23:07:02','2025-01-04 10:29:58')
,('Trisha','Pascual','09958473216','trishapascual@gmail.com','176 San Jose St.','Mabini','Barangay 80','Mandaluyong City',1501,'National Capital Region (NCR)','Philippines','2024-08-22 4:29:46','2024-08-22 18:57:31')
,('Samuel','Ocampo','09092631847','samuelocampo@yahoo.com','249 Gov. Pack Rd.','Burnham-Legarda','Barangay 29','Bacoor City',1502,'National Capital Region (NCR)','Philippines','2025-02-14 16:52:08','2025-02-15 9:45:44')
,('Clarisse','Mercado','09265478931','clarissemercado@gmail.com','307 National Hwy.','Gulang-Gulang','Barangay 2','Imus City',1601,'National Capital Region (NCR)','Philippines','2024-12-28 7:33:27','2024-12-28 20:59:56')
,('Leonard','Wilson','09134297568','leonardwilson@yahoo.com','48 Quirino Ave.','La Huerta','Barangay 87','Dasmariñas City',1602,'National Capital Region (NCR)','Philippines','2025-05-06 18:18:35','2025-05-07 12:20:11')
,('April','Aquino','09318647925','aprilaquino@gmail.com','133 P. Gomez St.','Wawa','Barangay 20','Cavite City',1701,'National Capital Region (NCR)','Philippines','2024-07-07 15:14:40','2024-07-08 9:27:58')
,('Justin','Baker','09253791846','justinbaker@yahoo.com','57 Burgos St.','San Pedro','Barangay 31','Trece Martires City',1702,'National Capital Region (NCR)','Philippines','2025-03-30 21:36:49','2025-03-31 7:15:14')
,('Hannah','Lopez','09165327498','hannahlopez@gmail.com','94 C. Raymundo Ave.','Manggahan','Barangay 38','General Trias City',1801,'National Capital Region (NCR)','Philippines','2024-09-12 5:28:18','2024-09-13 16:49:00')
,('Kyle','Villarin','09927864513','kylevillarin@yahoo.com','215 Marcos Hwy.','Sta. Cruz','Barangay 50','Batangas City',1802,'National Capital Region (NCR)','Philippines','2025-04-17 9:21:44','2025-04-18 14:12:29')
,('Shaina','Cortez','09082375914','shainacortez@gmail.com','71 Lapu-Lapu St.','Barretto','Barangay 16','Lipa City',4101,'CALABARZON (Region IV-A)','Philippines','2024-10-21 20:04:56','2024-10-22 11:31:47')
,('Martin','Bautista','09248619357','martinbautista@yahoo.com','188 E. Aguinaldo St.','Sevilla','Barangay 48','San Pablo City',4104,'CALABARZON (Region IV-A)','Philippines','2025-01-26 7:59:33','2025-01-26 18:45:21')
,('Rica','Fernandez','09126943857','ricafernandez@gmail.com','66 Mabuhay St.','Domoit','Barangay 85','Lucena City',4105,'CALABARZON (Region IV-A)','Philippines','2024-08-30 19:07:55','2024-08-31 8:59:14')
,('Russel','Derpo','09359742180','derporussel@yahoo.com','154 Panganiban Dr.','Triangulo','Barangay 1','Calamba City',4106,'CALABARZON (Region IV-A)','Philippines','2025-02-05 6:41:28','2025-02-05 17:12:36')
,('Denise','Lim','09064783512','deniselim@gmail.com','42 P. Zamora St.','Camilmil','Barangay 75','Santa Rosa City',4107,'CALABARZON (Region IV-A)','Philippines','2024-12-04 13:52:19','2024-12-05 9:03:15')
,('Carlo','Ramirez','09147639528','carloramirez@yahoo.com','279 Ilang-Ilang St.','Sta. Catalina','Barangay 37','Biñan City',4108,'CALABARZON (Region IV-A)','Philippines','2025-05-15 22:28:53','2025-05-16 14:49:02')
,('Angela','Padilla','09293751486','angelapadilla@gmail.com','122 F. Reyes St.','Maliwalo','Barangay 34','Olongapo City',4109,'CALABARZON (Region IV-A)','Philippines','2024-07-26 11:04:06','2024-07-27 15:22:57')
,('Dominic','Cruzado','09916843275','dominiccruzado@yahoo.com','199 Magsaysay Ave.','Ugac Sur','Barangay 56','Angeles City',4110,'CALABARZON (Region IV-A)','Philippines','2025-03-08 4:16:31','2025-03-08 19:47:05')
,('Janine','Ortega','09187426359','janineortega@gmail.com','83 Sampaguita St.','Sto. Niño','Barangay 45','San Fernando City',4111,'CALABARZON (Region IV-A)','Philippines','2024-09-17 17:43:22','2024-09-18 8:15:18')
,('Paul','Richards','09334581762','paulrichards@yahoo.com','232 G. Araneta Ave.','Masambong','Barangay 63','Tarlac City',4112,'CALABARZON (Region IV-A)','Philippines','2025-04-04 23:54:17','2025-04-05 13:48:36')
,('Aira','Salazar','09228457913','airasalazar@gmail.com','61 Yakal St.','Pandan','Barangay 78','Tuguegarao City',4113,'CALABARZON (Region IV-A)','Philippines','2024-10-05 8:37:51','2024-10-05 20:26:30')
,('Kenneth','Young','09075289431','kennethyoung@yahoo.com','148 Katipunan Ave.','Old Balara','Barangay 44','Naga City',4115,'CALABARZON (Region IV-A)','Philippines','2025-01-12 16:45:29','2025-01-13 7:58:49')
,('Rhea','Navarro','09152378469','rheanavarro@gmail.com','95 Molave St.','Ligtasan','Barangay 61','Legazpi City',4107,'CALABARZON (Region IV-A)','Philippines','2025-04-04 23:54:17','2025-04-05 13:48:36')
,('Vincent','Castillo','09961478253','vincentcastillo@yahoo.com','62 Dahlia St.','Pasong Tamo','Barangay 22','Baguio City',4108,'CALABARZON (Region IV-A)','Philippines','2024-10-05 8:37:51','2024-10-05 20:26:30');

-- SELECT * FROM CUSTOMERS;

INSERT INTO couriers (first_name, last_name, contact_number, vehicle_type, license_number) VALUES
('Liam', 'Dela Cruz', '09173450001', 'Motorbike', 'LIC90001A'),
('Emma', 'Reyes', '09173450002', 'SUV', 'LIC90002B'),
('Oliver', 'Alcantara', '09173450003', 'Van', 'LIC90003C'),
('Ava', 'Santos', '09173450004', 'Truck', 'LIC90004D'),
('Noah', 'Garcia', '09173450005', 'Motorbike', 'LIC90005E'),
('Ella', 'Soriano', '09173450006', 'SUV', 'LIC90006F'),
('Henry', 'Mendoza', '09173450007', 'Van', 'LIC90007G'),
('Zoe', 'De Guzman', '09173450008', 'Truck', 'LIC90008H'),
('Levi', 'Velasco', '09173450009', 'Motorbike', 'LIC90009I'),
('Scarlett', 'Lazaro', '09173450010', 'SUV', 'LIC90010J'),
('Mason', 'Torres', '09173450011', 'Van', 'LIC90011K'),
('Harper', 'Ramos', '09173450012', 'Truck', 'LIC90012L'),
('Ethaniel', 'Bautista', '09173450013', 'Motorbike', 'LIC90013M'),
('Violet', 'Miranda', '09173450014', 'SUV', 'LIC90014N'),
('Finn', 'Agbayani', '09173450015', 'Van', 'LIC90015O'),
('Aurora', 'Gallardo', '09173450016', 'Truck', 'LIC90016P'),
('Caleb', 'Tagle', '09173450017', 'Motorbike', 'LIC90017Q'),
('Luna', 'Quizon', '09173450018', 'SUV', 'LIC90018R'),
('Miles', 'Jacinto', '09173450019', 'Van', 'LIC90019S'),
('Ivy', 'Austria', '09173450020', 'Truck', 'LIC90020T'),
('Sebastian', 'Tolentino', '09173450021', 'Motorbike', 'LIC90021U'),
('Stella', 'Buenaventura', '09173450022', 'SUV', 'LIC90022V'),
('Eli', 'San Pedro', '09173450023', 'Van', 'LIC90023W'),
('Nora', 'Ilustre', '09173450024', 'Truck', 'LIC90024X'),
('Wyatt', 'Rosario', '09173450025', 'Motorbike', 'LIC90025Y'),
('Hazel', 'Espiritu', '09173450026', 'SUV', 'LIC90026Z'),
('Jasper', 'Vergara', '09173450027', 'Van', 'LIC90027A'),
('Isla', 'Dimaculangan', '09173450028', 'Truck', 'LIC90028B'),
('Rowan', 'Macaraeg', '09173450029', 'Motorbike', 'LIC90029C'),
('Clara', 'Navarro', '09173450030', 'SUV', 'LIC90030D'),
('Asher', 'Rosales', '09173450031', 'Van', 'LIC90031E'),
('Lydia', 'Vallejo', '09173450032', 'Truck', 'LIC90032F'),
('Owen', 'Calumpang', '09173450033', 'Motorbike', 'LIC90033G'),
('Maya', 'Bacalso', '09173450034', 'SUV', 'LIC90034H'),
('Declan', 'Lopez', '09173450035', 'Van', 'LIC90035I'),
('Freya', 'Ocampo', '09173450036', 'Truck', 'LIC90036J'),
('Kai', 'Yap', '09173450037', 'Motorbike', 'LIC90037K'),
('Amelia', 'Davidson', '09173450038', 'SUV', 'LIC90038L'),
('Logan', 'Manalo', '09173450039', 'Van', 'LIC90039M'),
('Ruby', 'Bartolome', '09173450040', 'Truck', 'LIC90040N'),
('Gavin', 'Lagman', '09173450041', 'Motorbike', 'LIC90041O'),
('Lila', 'Ramirez', '09173450042', 'SUV', 'LIC90042P'),
('Theo', 'Mabini', '09173450043', 'Van', 'LIC90043Q'),
('Iris', 'Panganiban', '09173450044', 'Truck', 'LIC90044R'),
('Archer', 'Del Rosario', '09173450045', 'Motorbike', 'LIC90045S'),
('Sienna', 'Carpio', '09173450046', 'SUV', 'LIC90046T'),
('Reid', 'Villanueva', '09173450047', 'Van', 'LIC90047U'),
('Elise', 'Llamas', '09173450048', 'Truck', 'LIC90048V'),
('Tristan', 'Cabrera', '09173450049', 'Motorbike', 'LIC90049W'),
('Madeline', 'Talusan', '09173450050', 'SUV', 'LIC90050X'),
('Zachary', 'Revilla', '09173450051', 'Van', 'LIC90051Y'),
('Ariana', 'Padilla', '09173450052', 'Truck', 'LIC90052Z'),
('Cole', 'Jimenez', '09173450053', 'Motorbike', 'LIC90053A'),
('Sasha', 'Domingo', '09173450054', 'SUV', 'LIC90054B'),
('Dorian', 'Agustin', '09173450055', 'Van', 'LIC90055C'),
('Leona', 'Del Mundo', '09173450056', 'Truck', 'LIC90056D'),
('Everett', 'Galvez', '09173450057', 'Motorbike', 'LIC90057E'),
('Camilla', 'Buenafe', '09173450058', 'SUV', 'LIC90058F'),
('Hugo', 'Tiamzon', '09173450059', 'Van', 'LIC90059G'),
('Adeline', 'Gatchalian', '09173450060', 'Truck', 'LIC90060H'),
('Silas', 'Carandang', '09173450061', 'Motorbike', 'LIC90061I'),
('Elena', 'Obispo', '09173450062', 'SUV', 'LIC90062J'),
('Bennett', 'Marquez', '09173450063', 'Van', 'LIC90063K'),
('Molly', 'Almario', '09173450064', 'Truck', 'LIC90064L'),
('Dawson', 'Santiago', '09173450065', 'Motorbike', 'LIC90065M'),
('Georgia', 'Ligaya', '09173450066', 'SUV', 'LIC90066N'),
('Corbin', 'Jose', '09173450067', 'Van', 'LIC90067O'),
('Phoebe', 'Mercado', '09173450068', 'Truck', 'LIC90068P'),
('Nathan', 'Palencia', '09173450069', 'Motorbike', 'LIC90069Q'),
('Bianca', 'Fontanilla', '09173450070', 'SUV', 'LIC90070R'),
('Jude', 'Salvador', '09173450071', 'Van', 'LIC90071S'),
('Celeste', 'Aquino', '09173450072', 'Truck', 'LIC90072T'),
('Andres', 'Delos Reyes', '09173450073', 'Motorbike', 'LIC90073U'),
('Tessa', 'Fajardo', '09173450074', 'SUV', 'LIC90074V'),
('Roman', 'Soriano', '09173450075', 'Van', 'LIC90075W'),
('Isabel', 'Quiambao', '09173450076', 'Truck', 'LIC90076X'),
('Marco', 'Evangelista', '09173450077', 'Motorbike', 'LIC90077Y'),
('Serena', 'Mangubat', '09173450078', 'SUV', 'LIC90078Z'),
('Joaquin', 'Manlapig', '09173450079', 'Van', 'LIC90079A'),
('Clarisse', 'De Leon', '09173450080', 'Truck', 'LIC90080B');

-- select * from couriers;

INSERT INTO LOCATIONS (location_name, contact_number, created_at, updated_at) VALUES
('124 Mabini St.', '245133622', '2023-01-15 10:00:00', '2023-01-20 14:30:00'),
('56 Rizal Ave.', '522511202', '2022-11-10 9:15:00', '2023-02-12 16:00:00'),
('89 Aguinaldo Hwy.', '14258631', '2023-04-05 14:30:00', '2023-05-01 13:45:00'),
('210 Bonifacio St.', '45665656512', '2023-03-25 11:45:00', '2023-06-18 12:30:00'),
('78 Del Pilar St.', '1142011556', '2022-12-20 8:20:00', '2023-05-22 17:00:00'),
('305 Luna St.', '5526699', '2022-07-15 15:00:00', '2023-01-05 10:00:00'),
('47 Kalayaan Ave.', '55511245', '2023-01-10 16:30:00', '2023-03-17 14:30:00'),
('92 General Malvar St.', '55523344', '2023-03-02 9:10:00', '2023-06-07 11:00:00'),
('63 MacArthur Hwy.', '87000542', '2022-11-12 14:40:00', '2023-02-25 15:15:00'),
('184 Roxas Blvd.', '6565965989', '2023-02-28 16:00:00', '2023-04-10 9:20:00'),
('219 P. Burgos St.', '8613912345678', '2023-04-03 12:20:00', '2023-05-06 10:50:00'),
('331 Gen. Santos Ave.', '080-12345678', '2022-12-01 10:00:00', '2023-02-20 14:30:00'),
('77 Magallanes St.', '821012345678', '2023-05-04 8:10:00', '2023-07-15 13:10:00'),
('15 M. H. Del Pilar St.', '919876543210', '2022-10-25 12:20:00', '2023-06-14 15:45:00'),
('94 Ortigas Ave. Ext.', '61423123456', '2022-06-18 13:00:00', '2023-04-12 18:00:00'),
('53 F. Manalo St.', '64211234567', '2022-09-10 17:30:00', '2023-01-25 14:00:00'),
('110 Commonwealth Ave.', '79001234567', '2023-02-05 14:45:00', '2023-06-20 12:40:00'),
('88 P. Tuazon Blvd.', '27721234567', '2023-03-01 10:10:00', '2023-05-13 13:00:00'),
('172 San Jose St.', '201001234567', '2022-07-25 16:00:00', '2023-01-30 9:30:00'),
('245 Gov. Pack Rd.', '2348031234567', '2022-11-15 14:30:00', '2023-04-28 11:00:00'),
('301 National Hwy.', '254701234567', '2022-12-10 10:30:00', '2023-01-15 18:00:00'),
('41 Quirino Ave.', '905551234567', '2022-08-22 13:20:00', '2023-03-05 9:00:00'),
('138 P. Gomez St.', '966501234567', '2023-03-11 15:00:00', '2023-04-02 13:10:00'),
('55 Burgos St.', '971501234567', '2022-10-12 11:15:00', '2023-02-27 8:50:00'),
('99 C. Raymundo Ave.', '972521234567', '2023-01-08 14:30:00', '2023-04-14 16:00:00'),
('212 Marcos Hwy.', '6281234567890', '2022-11-18 9:00:00', '2023-03-07 10:20:00'),
('74 Lapu-Lapu St.', '66812345678', '2023-01-23 13:45:00', '2023-05-11 11:30:00'),
('186 E. Aguinaldo St.', '84912345678', '2023-04-22 16:00:00', '2023-06-16 12:40:00'),
('68 Mabuhay St.', '639123456789', '2022-12-01 11:00:00', '2023-04-25 14:00:00'),
('150 Panganiban Dr.', '60123456789', '2023-03-30 8:10:00', '2023-05-12 13:30:00'),
('38 P. Zamora St.', '6591234567', '2022-06-10 10:00:00', '2023-02-11 9:15:00'),
('275 Ilang-Ilang St.', '4790012345', '2023-04-01 10:30:00', '2023-05-07 11:50:00'),
('120 F. Reyes St.', '46701234567', '2023-02-15 12:15:00', '2023-03-25 14:00:00'),
('195 Magsaysay Ave.', '358401234567', '2022-09-05 9:30:00', '2023-01-17 10:20:00'),
('81 Sampaguita St.', '4520123456', '2022-10-13 13:45:00', '2023-05-21 16:30:00'),
('230 G. Araneta Ave.', '31612345678', '2023-01-12 14:00:00', '2023-02-17 10:10:00'),
('66 Yakal St.', '32495123456', '2023-05-05 15:30:00', '2023-07-01 12:00:00'),
('142 Katipunan Ave.', '41791234567', '2022-12-30 17:00:00', '2023-06-06 8:30:00'),
('93 Molave St.', '436501234567', '2023-03-15 11:20:00', '2023-06-10 14:45:00'),
('58 Dahlia St.', '48601234567', '2023-02-22 12:30:00', '2023-03-18 10:40:00'),
('102 Mabini St.', '420602123456', '2022-11-28 14:00:00', '2023-05-03 11:30:00'),
('76 Rizal Ave.', '36301234567', '2023-01-29 10:00:00', '2023-03-22 13:15:00'),
('58 Aguinaldo Hwy.', '306912345678', '2022-12-11 9:30:00', '2023-05-10 8:00:00'),
('214 Bonifacio St.', '351912345678', '2023-02-09 12:40:00', '2023-04-04 10:15:00'),
('87 Del Pilar St.', '353861234567', '2023-01-16 13:50:00', '2023-02-21 17:00:00'),
('305 Luna St.', '441311234567', '2023-05-14 11:00:00', '2023-06-02 14:30:00'),
('44 Kalayaan Ave.', '442912345678', '2022-10-17 12:30:00', '2023-04-01 9:20:00'),
('97 General Malvar St.', '380671234567', '2022-09-08 14:00:00', '2023-03-11 10:40:00'),
('69 MacArthur Hwy.', '40720123456', '2023-02-20 16:20:00', '2023-05-30 12:30:00'),
('192 Roxas Blvd.', '56912345678', '2022-12-22 10:40:00', '2023-04-13 13:30:00'),
('243 P. Burgos St.', '573001234567', '2023-03-03 9:30:00', '2023-06-12 11:00:00'),
('325 Gen. Santos Ave.', '51912345678', '2023-01-27 12:00:00', '2023-04-16 8:30:00'),
('79 Magallanes St.', '584121234567', '2022-10-19 14:10:00', '2023-02-26 15:30:00'),
('19 M. H. Del Pilar St.', '923001234567', '2022-08-15 16:00:00', '2023-01-09 10:00:00'),
('96 Ortigas Ave. Ext.', '8801712345678', '2023-03-17 14:00:00', '2023-05-27 16:40:00'),
('51 F. Manalo St.', '94771234567', '2023-02-07 15:10:00', '2023-03-19 12:10:00'),
('118 Commonwealth Ave.', '9779841234567', '2023-01-21 11:30:00', '2023-04-09 10:30:00'),
('85 P. Tuazon Blvd.', '975171234567', '2022-12-18 10:00:00', '2023-03-30 15:20:00'),
('176 San Jose St.', '3548612345', '2023-03-06 14:00:00', '2023-05-04 9:50:00'),
('249 Gov. Pack Rd.', '352621123456', '2022-11-09 9:00:00', '2023-02-14 13:30:00'),
('307 National Hwy.', '423123456', '2023-01-04 16:00:00', '2023-05-02 10:00:00'),
('48 Quirino Ave.', '385911234567', '2022-08-30 12:00:00', '2023-03-14 17:00:00'),
('133 P. Gomez St.', '38631123456', '2022-10-23 11:30:00', '2023-04-21 14:30:00'),
('57 Burgos St.', '421902123456', '2022-09-11 10:00:00', '2023-05-15 13:10:00'),
('94 C. Raymundo Ave.', '3725123456', '2022-11-05 14:10:00', '2023-02-28 11:50:00'),
('215 Marcos Hwy.', '3712912345', '2023-02-01 12:30:00', '2023-05-09 9:10:00'),
('71 Lapu-Lapu St.', '37061234567', '2022-07-28 15:00:00', '2023-03-23 10:00:00'),
('188 E. Aguinaldo St.', '212612345678', '2023-04-19 10:40:00', '2023-06-21 13:20:00'),
('66 Mabuhay St.', '213550123456', '2022-11-07 9:30:00', '2023-05-23 16:30:00'),
('154 Panganiban Dr.', '21625123456', '2023-01-04 12:00:00', '2023-03-02 11:00:00'),
('42 P. Zamora St.', '233241234567', '2022-10-05 14:30:00', '2023-05-06 15:50:00'),
('279 Ilang-Ilang St.', '22501234567', '2023-02-13 9:00:00', '2023-04-05 10:00:00'),
('122 F. Reyes St.', '251911234567', '2023-03-09 10:00:00', '2023-06-04 13:20:00'),
('199 Magsaysay Ave.', '255712345678', '2022-12-29 17:10:00', '2023-04-04 16:10:00'),
('83 Sampaguita St.', '256774123456', '2023-01-22 16:00:00', '2023-03-17 14:00:00'),
('232 G. Araneta Ave.', '260971234567', '2023-03-13 10:30:00', '2023-05-01 12:20:00'),
('61 Yakal St.', '263771234567', '2023-04-07 14:00:00', '2023-06-14 10:40:00'),
('148 Katipunan Ave.', '85512123456', '2022-09-18 11:40:00', '2023-02-24 16:30:00'),
('95 Molave St.', '856201234567', '2022-11-04 10:00:00', '2023-04-15 13:00:00'),
('62 Dahlia St.', '9591234567', '2022-10-28 12:30:00', '2023-03-09 11:20:00');

-- select * from locations;

INSERT INTO DELIVERY_DETAILS(sender_id,recipient_id,created_at,updated_at) VALUES
 (1,45,'2024-01-05 8:15:00','2024-01-05 11:48:00')
,(2,11,'2024-02-10 14:23:00','2024-02-10 20:17:00')
,(3,60,'2024-03-14 9:45:00','2024-03-14 12:52:00')
,(4,72,'2024-04-22 16:10:00','2024-04-22 21:30:00')
,(5,30,'2024-05-03 7:35:00','2024-05-03 13:22:00')
,(6,14,'2024-06-18 13:48:00','2024-06-18 18:59:00')
,(7,36,'2024-07-26 11:26:00','2024-07-26 19:15:00')
,(8,27,'2024-08-09 6:14:00','2024-08-09 9:47:00')
,(9,64,'2024-09-12 17:55:00','2024-09-12 22:50:00')
,(10,50,'2024-10-03 8:40:00','2024-10-03 14:22:00')
,(11,33,'2024-11-11 12:22:00','2024-11-11 19:55:00')
,(12,68,'2024-12-20 9:44:00','2024-12-20 13:11:00')
,(13,7,'2025-01-06 14:32:00','2025-01-06 18:19:00')
,(14,56,'2025-02-15 7:16:00','2025-02-15 13:58:00')
,(15,79,'2025-03-21 16:47:00','2025-03-21 21:09:00')
,(16,25,'2025-04-02 8:02:00','2025-04-02 14:38:00')
,(17,2,'2025-05-13 11:33:00','2025-05-13 18:45:00')
,(18,38,'2025-06-24 15:27:00','2025-06-24 19:51:00')
,(19,66,'2025-07-05 9:10:00','2025-07-05 12:22:00')
,(20,55,'2025-08-01 10:48:00','2025-08-01 15:56:00')
,(21,3,'2024-01-17 7:28:00','2024-01-17 9:35:00')
,(22,46,'2024-02-21 13:40:00','2024-02-21 19:18:00')
,(23,19,'2024-03-29 8:56:00','2024-03-29 13:03:00')
,(24,58,'2024-04-17 15:37:00','2024-04-17 20:40:00')
,(25,8,'2024-05-28 11:24:00','2024-05-28 18:14:00')
,(26,40,'2024-06-11 7:55:00','2024-06-11 10:37:00')
,(27,73,'2024-07-20 12:18:00','2024-07-20 19:45:00')
,(28,32,'2024-08-25 9:46:00','2024-08-25 16:33:00')
,(29,9,'2024-09-30 13:05:00','2024-09-30 19:42:00')
,(30,63,'2024-10-19 8:11:00','2024-10-19 14:28:00')
,(31,16,'2024-11-23 7:42:00','2024-11-23 10:29:00')
,(32,4,'2024-12-29 14:15:00','2024-12-29 21:37:00')
,(33,48,'2025-01-12 9:55:00','2025-01-12 13:41:00')
,(34,20,'2025-02-23 15:49:00','2025-02-23 19:59:00')
,(35,59,'2025-03-10 11:31:00','2025-03-10 17:52:00')
,(36,26,'2025-04-19 6:47:00','2025-04-19 10:26:00')
,(37,70,'2025-05-24 17:12:00','2025-05-24 22:25:00')
,(38,13,'2025-06-15 13:59:00','2025-06-15 18:03:00')
,(39,1,'2025-07-29 10:18:00','2025-07-29 16:52:00')
,(40,62,'2025-08-04 7:33:00','2025-08-04 12:48:00')
,(41,28,'2024-01-08 15:41:00','2024-01-08 18:50:00')
,(42,15,'2024-02-12 10:54:00','2024-02-12 17:06:00')
,(43,71,'2024-03-25 14:02:00','2024-03-25 20:31:00')
,(44,21,'2024-04-14 9:15:00','2024-04-14 15:44:00')
,(45,78,'2024-05-20 12:25:00','2024-05-20 18:40:00')
,(46,5,'2024-06-06 8:07:00','2024-06-06 13:59:00')
,(47,39,'2024-07-13 16:33:00','2024-07-13 22:50:00')
,(48,18,'2024-08-21 11:49:00','2024-08-21 17:29:00')
,(49,31,'2024-09-07 7:22:00','2024-09-07 13:42:00')
,(50,41,'2024-10-27 15:15:00','2024-10-27 20:48:00')
,(51,22,'2024-11-16 13:34:00','2024-11-16 16:55:00')
,(52,17,'2024-12-07 9:41:00','2024-12-07 13:58:00')
,(53,74,'2025-01-19 8:29:00','2025-01-19 14:57:00')
,(54,12,'2025-02-28 16:44:00','2025-02-28 22:00:00')
,(55,34,'2025-03-14 7:51:00','2025-03-14 13:17:00')
,(56,29,'2025-04-23 14:35:00','2025-04-23 18:03:00')
,(57,52,'2025-05-16 10:42:00','2025-05-16 17:29:00')
,(58,61,'2025-06-27 6:54:00','2025-06-27 12:39:00')
,(59,42,'2025-07-14 15:48:00','2025-07-14 20:30:00')
,(60,6,'2025-08-06 9:29:00','2025-08-06 14:50:00')
,(61,77,'2024-01-25 11:18:00','2024-01-25 14:39:00')
,(62,24,'2024-02-14 7:41:00','2024-02-14 12:15:00')
,(63,47,'2024-03-06 14:57:00','2024-03-06 20:49:00')
,(64,53,'2024-04-25 10:20:00','2024-04-25 14:33:00')
,(65,35,'2024-05-08 7:16:00','2024-05-08 10:29:00')
,(66,23,'2024-06-19 15:22:00','2024-06-19 19:59:00')
,(67,51,'2024-07-30 12:44:00','2024-07-30 18:22:00')
,(68,75,'2024-08-16 6:37:00','2024-08-16 12:15:00')
,(69,54,'2024-09-23 16:59:00','2024-09-23 21:28:00')
,(70,37,'2024-10-08 11:23:00','2024-10-08 16:57:00')
,(71,10,'2024-11-28 9:44:00','2024-11-28 14:18:00')
,(72,80,'2024-12-15 7:36:00','2024-12-15 13:51:00')
,(73,44,'2025-01-03 15:27:00','2025-01-03 21:43:00')
,(74,57,'2025-02-19 6:55:00','2025-02-19 13:07:00')
,(75,49,'2025-03-26 14:14:00','2025-03-26 19:39:00')
,(76,65,'2025-04-06 7:45:00','2025-04-06 12:50:00')
,(77,67,'2025-05-20 16:21:00','2025-05-20 22:10:00')
,(78,76,'2025-06-11 13:29:00','2025-06-11 18:43:00')
,(79,43,'2025-07-18 8:52:00','2025-07-18 13:20:00')
,(80,69,'2025-08-09 10:11:00','2025-08-09 14:29:00');

-- select * from delivery_details;

select * from packages;
INSERT INTO `packages` (pickup_date, delivery_date, package_type, weight,contents_description,delivery_details_id,courier_id)
VALUES 
		('2025-01-10 08:00:00','2025-01-10 15:00:00','Documents',0.75,'Legal contract papers',9,63),
        ('2025-01-12 14:00:00','2025-01-13 10:00:00','Electronics',1.5,'Smartwatch and charger',50,18),
        ('2025-01-14 09:30:00','2025-01-14 17:00:00','Clothing',2.3,'Winter jacket and pants',71,12),
        ('2025-01-15 10:00:00','2025-01-16 12:00:00','Books',4.5,'Book collection on business strategy',3,76),
        ('2025-01-17 13:00:00','2025-01-18 11:30:00','Furniture',15,'Dining table set',57,9),
        ('2025-01-19 16:00:00','2025-01-20 10:00:00','Food',3.2,'Fresh fruits and vegetables',54,80),
        ('2025-01-21 09:15:00','2025-01-22 13:00:00','Electronics',5,'Laptop and accessories',55,33),
        ('2025-01-22 08:00:00','2025-01-23 09:00:00','Cosmetics',0.9,'Perfumes and skincare products',36,30),
        ('2025-01-24 12:30:00','2025-01-25 17:00:00','Clothing',1.2,'Summer clothes for women',22,2),
        ('2025-01-25 10:00:00','2025-01-26 08:00:00','Food',2.5,'Imported chocolates and snacks',24,64),
        ('2025-01-27 14:30:00','2025-01-28 16:00:00','Books',3,'Children’s storybook set',52,39),
        ('2025-01-30 15:00:00','2025-01-31 11:30:00','Electronics',8,'LED TV and remote',41,26),
        ('2025-02-01 08:45:00','2025-02-02 14:00:00','Documents',0.5,'Legal paperwork for signing',17,2),
        ('2025-02-03 10:30:00','2025-02-04 13:00:00','Food',4,'Frozen meats and seafood',47,25),
        ('2025-02-06 11:00:00','2025-02-07 09:30:00','Clothing',2,'Men’s jackets and jeans',51,12),
        ('2025-02-08 14:00:00','2025-02-09 10:00:00','Furniture',20,'Couch and living room furniture',44,63),
        ('2025-02-10 13:00:00','2025-02-11 11:00:00','Electronics',0.8,'Earphones and phone accessories',15,53),
        ('2025-02-12 09:00:00','2025-02-13 17:00:00','Toys',3.1,'Playsets and toys for children',46,52),
        ('2025-02-14 14:30:00','2025-02-15 10:30:00','Clothing',1.5,'Winter coats and scarves',33,41),
        ('2025-02-17 08:00:00','2025-02-18 16:00:00','Food',2.8,'Packaged snacks and beverages',62,8),
        ('2025-02-19 15:00:00','2025-02-20 09:30:00','Documents',1,'Company reports and files',63,36),
        ('2025-02-21 12:00:00','2025-02-22 14:30:00','Electronics',7.5,'Gaming console and accessories',15,14),
        ('2025-02-23 11:30:00','2025-02-24 13:30:00','Books',3.3,'Cookbooks and recipe guides',9,73),
        ('2025-02-26 10:15:00','2025-02-27 17:00:00','Furniture',12,'Bookshelf and display case',22,5),
        ('2025-02-28 14:00:00','2025-03-01 09:00:00','Clothing',4,'Women’s summer dresses and shoes',69,34),
        ('2025-03-02 08:30:00','2025-03-03 11:00:00','Electronics',9,'Portable speakers and cables',80,9),
        ('2025-03-04 10:30:00','2025-03-05 16:00:00','Food',2.1,'Organic produce and herbs',64,59),
        ('2025-03-06 13:30:00','2025-03-07 14:00:00','Documents',0.6,'Business contracts and proposals',24,44),
        ('2025-03-09 11:00:00','2025-03-10 15:00:00','Electronics',6,'Headphones and sound equipment',6,49),
        ('2025-03-11 09:00:00','2025-03-12 13:30:00','Furniture',18,'Office desk and chair',39,45),
        ('2025-03-13 10:15:00','2025-03-14 14:00:00','Clothing',3.1,'Baby clothes and accessories',56,8),
        ('2025-03-15 15:00:00','2025-03-16 11:00:00','Books',1.8,'Historical fiction novels',10,56),
        ('2025-03-18 08:30:00','2025-03-19 17:00:00','Food',5,'Frozen fruits and vegetables',34,17),
        ('2025-03-20 11:30:00','2025-03-21 10:00:00','Clothing',2.2,'Casual shirts and pants',35,16),
        ('2025-03-23 09:00:00','2025-03-24 14:30:00','Furniture',10,'Bookshelf and chair set',44,56),
        ('2025-03-25 13:00:00','2025-03-26 08:00:00','Documents',1.1,'Official documents for signing',5,72),
        ('2025-03-27 12:00:00','2025-03-28 15:00:00','Electronics',3.5,'Bluetooth speakers and accessories',14,25),
        ('2025-03-29 10:00:00','2025-03-30 14:00:00','Food',4,'Imported candies and snacks',45,68),
        ('2025-04-01 15:00:00','2025-04-02 17:00:00','Clothing',2.9,'Winter gloves and hats',62,31),
        ('2025-04-03 09:30:00','2025-04-04 11:30:00','Toys',1.8,'Toy cars and puzzles',20,57),
        ('2025-04-05 14:00:00','2025-04-06 13:00:00','Furniture',17,'Living room couch set',67,10),
        ('2025-04-07 10:00:00','2025-04-08 15:00:00','Food',3.6,'Fresh bakery products',48,69),
        ('2025-04-10 09:00:00','2025-04-11 13:00:00','Electronics',6.2,'Smartphone and accessories',43,21),
        ('2025-04-12 13:30:00','2025-04-13 10:30:00','Clothing',1.8,'Hats, scarves, and gloves',13,53),
        ('2025-04-14 11:00:00','2025-04-15 12:00:00','Documents',0.7,'Important bank documents',52,33),
        ('2025-04-16 14:00:00','2025-04-17 10:00:00','Electronics',4.5,'Tablet and stylus',67,54),
        ('2025-04-18 08:00:00','2025-04-19 11:00:00','Clothing',2.4,'Shoes and jackets',41,68),
        ('2025-04-20 09:30:00','2025-04-21 17:00:00','Books',3.5,'Biographies and historical books',72,47),
        ('2025-04-22 11:30:00','2025-04-23 13:00:00','Food',2.3,'Packaged organic snacks',27,65),
        ('2025-04-25 08:30:00','2025-04-26 14:00:00','Clothing',3.2,'Shirts and jackets for men',3,66),
        ('2025-04-27 10:00:00','2025-04-28 15:00:00','Furniture',22,'Wooden cabinet and dresser',46,13),
        ('2025-04-30 09:00:00','2025-05-01 13:30:00','Electronics',3,'Smartphone charger and accessories',29,15),
        ('2025-05-02 14:00:00','2025-05-03 10:00:00','Toys',1.7,'Board games and toys for children',70,35),
        ('2025-05-04 08:30:00','2025-05-05 11:00:00','Food',3.9,'Frozen vegetables and fruits',16,40),
        ('2025-05-07 11:30:00','2025-05-08 09:00:00','Clothing',2.1,'New clothes for a family',75,31),
        ('2025-05-09 13:00:00','2025-05-10 16:00:00','Furniture',18,'Home office furniture',61,29),
        ('2025-05-12 08:30:00','2025-05-13 15:00:00','Electronics',9.5,'Smartwatch and fitness tracker',49,6),
        ('2025-05-14 10:00:00','2025-05-15 12:00:00','Books',4.2,'Business and management books',38,67),
        ('2025-05-16 14:00:00','2025-05-17 10:30:00','Clothing',3.5,'Winter coat and gloves',53,39),
        ('2025-05-18 08:00:00','2025-05-19 11:00:00','Food',5,'Packaged meats and fish',35,77),
        ('2025-05-20 14:30:00','2025-05-21 12:00:00','Clothing',1.6,'Winter boots and jackets',53,19),
        ('2025-05-23 08:30:00','2025-05-24 14:00:00','Books',2.8,'Inspirational and self-help books',1,75),
        ('2025-05-25 13:00:00','2025-05-26 10:00:00','Documents',1.3,'Real estate paperwork',39,55),
        ('2025-05-27 14:00:00','2025-05-28 17:00:00','Electronics',7.1,'Camera and photography equipment',58,7),
        ('2025-05-29 10:00:00','2025-05-30 09:30:00','Clothing',2.8,'Men’s casual wear',14,7),
        ('2025-06-01 09:00:00','2025-06-02 13:00:00','Food',4.1,'Organic produce',23,50),
        ('2025-06-03 15:00:00','2025-06-04 12:30:00','Books',3.8,'Art and design books',72,58),
        ('2025-06-05 10:00:00','2025-06-06 14:00:00','Furniture',16,'Couch and lounge chair',55,6),
        ('2025-06-07 12:00:00','2025-06-08 13:00:00','Toys',1.6,'Toys for toddlers',12,74),
        ('2025-06-10 08:00:00','2025-06-11 10:30:00','Electronics',6.2,'Digital camera and accessories',19,66),
        ('2025-06-12 13:00:00','2025-06-13 16:00:00','Food',2.6,'Packaged beverages and snacks',73,24),
        ('2025-06-15 08:00:00','2025-06-16 14:00:00','Furniture',14.5,'Dresser and nightstand',17,14),
        ('2025-06-17 10:00:00','2025-06-18 16:00:00','Clothing',3.2,'Summer clothing for women',73,64),
        ('2025-06-20 09:00:00','2025-06-21 11:30:00','Electronics',8.3,'Gaming laptop and accessories',36,41),
        ('2025-06-22 14:30:00','2025-06-23 16:00:00','Toys',3.5,'Children’s educational toys',60,59),
        ('2025-06-25 09:00:00','2025-06-26 12:00:00','Documents',1.4,'Important legal documents',29,61),
        ('2025-06-27 10:00:00','2025-06-28 17:00:00','Clothing',2.1,'Summer wear for men',77,60),
        ('2025-06-29 13:00:00','2025-06-30 16:00:00','Food',5.3,'Fresh seafood and fish',59,48),
        ('2025-07-01 08:00:00','2025-07-02 11:00:00','Electronics',4.6,'Smartphone accessories',11,19),
        ('2025-07-03 14:30:00','2025-07-04 15:00:00','Books',2.7,'Science fiction books',2,20),
        ('2025-07-06 10:00:00','2025-07-07 09:00:00','Clothing',1.8,'Men’s shirts and pants',68,74),
        ('2025-07-09 13:00:00','2025-07-10 11:00:00','Food',3.4,'Canned goods and spices',18,61),
        ('2025-07-11 12:00:00','2025-07-12 13:00:00','Furniture',19,'Bookshelves and cabinets',25,32),
        ('2025-07-14 09:00:00','2025-07-15 14:30:00','Toys',2,'Educational toys for kids',66,1),
        ('2025-07-16 10:30:00','2025-07-17 15:00:00','Clothing',2.3,'Winter jackets and sweaters',65,22),
        ('2025-07-18 08:00:00','2025-07-19 10:30:00','Electronics',7.8,'Bluetooth speakers and headphones',2,70),
        ('2025-07-20 11:00:00','2025-07-21 13:00:00','Books',3.1,'Health and wellness books'');',38,34),
        ('2025-01-10 08:00:00','2025-01-10 15:00:00','Documents',0.75,'Legal contract papers',47,45),
        ('2025-01-12 14:00:00','2025-01-13 10:00:00','Electronics',1.5,'Smartwatch and charger',76,16),
        ('2025-01-14 09:30:00','2025-01-14 17:00:00','Clothing',2.3,'Winter jacket and pants',64,37),
        ('2025-01-15 10:00:00','2025-01-16 12:00:00','Books',4.5,'Book collection on business strategy',37,15),
        ('2025-01-17 13:00:00','2025-01-18 11:30:00','Furniture',15,'Dining table set',10,10),
        ('2025-01-19 16:00:00','2025-01-20 10:00:00','Food',3.2,'Fresh fruits and vegetables',71,51),
        ('2025-01-21 09:15:00','2025-01-22 13:00:00','Electronics',5,'Laptop and accessories',79,54),
        ('2025-01-22 08:00:00','2025-01-23 09:00:00','Cosmetics',0.9,'Perfumes and skincare products',23,28),
        ('2025-01-24 12:30:00','2025-01-25 17:00:00','Clothing',1.2,'Summer clothes for women',21,35),
        ('2025-01-25 10:00:00','2025-01-26 08:00:00','Food',2.5,'Imported chocolates and snacks',5,73),
        ('2025-01-27 14:30:00','2025-01-28 16:00:00','Books',3,'Children’s storybook set',7,20),
        ('2025-01-30 15:00:00','2025-01-31 11:30:00','Electronics',8,'LED TV and remote',74,23),
        ('2025-02-01 08:45:00','2025-02-02 14:00:00','Documents',0.5,'Legal paperwork for signing',33,17),
        ('2025-02-03 10:30:00','2025-02-04 13:00:00','Food',4,'Frozen meats and seafood',50,71),
        ('2025-02-06 11:00:00','2025-02-07 09:30:00','Clothing',2,'Men’s jackets and jeans',34,51),
        ('2025-02-08 14:00:00','2025-02-09 10:00:00','Furniture',20,'Couch and living room furniture',26,18),
        ('2025-02-10 13:00:00','2025-02-11 11:00:00','Electronics',0.8,'Earphones and phone accessories',54,1),
        ('2025-02-12 09:00:00','2025-02-13 17:00:00','Toys',3.1,'Playsets and toys for children',8,23),
        ('2025-02-14 14:30:00','2025-02-15 10:30:00','Clothing',1.5,'Winter coats and scarves',21,29),
        ('2025-02-17 08:00:00','2025-02-18 16:00:00','Food',2.3,'Packaged organic snacks',68,46),
        ('2025-02-19 15:00:00','2025-02-20 09:30:00','Documents',1,'Company reports and files',42,38),
        ('2025-02-21 12:00:00','2025-02-22 14:30:00','Electronics',7.5,'Gaming console and accessories',70,62),
        ('2025-02-23 11:30:00','2025-02-24 13:30:00','Books',3.3,'Cookbooks and recipe guides',30,58),
        ('2025-02-26 10:15:00','2025-02-27 17:00:00','Furniture',12,'Bookshelf and display case',49,50),
        ('2025-02-28 14:00:00','2025-03-01 09:00:00','Clothing',4,'Women’s summer dresses and shoes',56,42),
        ('2025-03-02 08:30:00','2025-03-03 11:00:00','Electronics',9,'Portable speakers and cables',42,43),
        ('2025-03-04 10:30:00','2025-03-05 16:00:00','Food',2.1,'Organic produce and herbs',28,30),
        ('2025-03-06 13:30:00','2025-03-07 14:00:00','Documents',0.6,'Business contracts and proposals',32,79),
        ('2025-03-09 11:00:00','2025-03-10 15:00:00','Electronics',6,'Headphones and sound equipment',12,4),
        ('2025-03-11 09:00:00','2025-03-12 13:30:00','Furniture',18,'Office desk and chair',4,40),
        ('2025-03-13 10:15:00','2025-03-14 14:00:00','Clothing',3.1,'Baby clothes and accessories',30,71),
        ('2025-03-15 15:00:00','2025-03-16 11:00:00','Books',1.8,'Historical fiction novels',19,72),
        ('2025-03-18 08:30:00','2025-03-19 17:00:00','Food',5,'Frozen fruits and vegetables',4,22),
        ('2025-03-20 11:30:00','2025-03-21 10:00:00','Clothing',2.2,'Casual shirts and pants',57,26),
        ('2025-03-23 09:00:00','2025-03-24 14:30:00','Furniture',10,'Bookshelf and chair set',40,32),
        ('2025-03-25 13:00:00','2025-03-26 08:00:00','Documents',1.1,'Official documents for signing',6,13),
        ('2025-03-27 12:00:00','2025-03-28 15:00:00','Electronics',3.5,'Bluetooth speakers and accessories',60,55),
        ('2025-03-29 10:00:00','2025-03-30 14:00:00','Food',4,'Imported candies and snacks',28,42),
        ('2025-04-01 15:00:00','2025-04-02 17:00:00','Clothing',2.9,'Winter gloves and hats',1,65),
        ('2025-04-03 09:30:00','2025-04-04 11:30:00','Toys',1.8,'Toy cars and puzzles',40,3),
        ('2025-04-05 14:00:00','2025-04-06 13:00:00','Furniture',17,'Living room couch set',26,36),
        ('2025-04-07 10:00:00','2025-04-08 15:00:00','Food',3.6,'Fresh bakery products',58,28),
        ('2025-04-10 09:00:00','2025-04-11 13:00:00','Electronics',6.2,'Smartphone and accessories',7,3),
        ('2025-04-12 13:30:00','2025-04-13 16:00:00','Books',3.9,'Mystery novels and thrillers',32,11),
        ('2025-04-15 08:00:00','2025-04-16 14:00:00','Clothing',4.5,'Shoes and dresses',74,48),
        ('2025-04-17 10:00:00','2025-04-18 11:00:00','Electronics',4.5,'Tablet and stylus',8,43),
        ('2025-04-18 08:00:00','2025-04-19 11:00:00','Clothing',2.4,'Shoes and jackets',31,78),
        ('2025-04-20 09:30:00','2025-04-21 17:00:00','Books',3.5,'Biographies and historical books',20,38),
        ('2025-04-22 11:30:00','2025-04-23 13:00:00','Food',2.3,'Packaged organic snacks',51,27),
        ('2025-04-25 08:00:00','2025-04-26 10:30:00','Electronics',7.5,'Gaming console',59,52),
        ('2025-04-27 12:00:00','2025-04-28 14:00:00','Furniture',14,'Coffee table set',31,47),
        ('2025-04-29 11:30:00','2025-04-30 16:00:00','Clothing',3.2,'Dresses and accessories',48,37),
        ('2025-05-01 10:00:00','2025-05-02 13:00:00','Documents',0.8,'Office documents',16,49),
        ('2025-05-03 12:15:00','2025-05-04 14:30:00','Food',3.5,'Organic snacks',25,4),
        ('2025-05-05 15:30:00','2025-05-06 16:00:00','Toys',2.1,'Stuffed toys and dolls',78,27),
        ('2025-05-07 10:45:00','2025-05-08 12:00:00','Electronics',6,'Smart home devices',66,70),
        ('2025-05-09 14:30:00','2025-05-10 11:30:00','Books',2.7,'Non-fiction books',13,62),
        ('2025-05-11 16:00:00','2025-05-12 13:00:00','Furniture',13,'Study table and chair',37,21),
        ('2025-05-13 09:30:00','2025-05-14 17:00:00','Food',3,'Imported cheese and meat',65,11),
        ('2025-05-15 10:00:00','2025-05-16 11:30:00','Clothing',1.9,'Men’s shirts and jackets',43,69),
        ('2025-05-17 14:00:00','2025-05-18 15:30:00','Electronics',4,'Power bank and chargers',11,67),
        ('2025-05-19 13:00:00','2025-05-20 14:30:00','Toys',3.3,'Action figures and puzzles',27,5),
        ('2025-05-21 15:30:00','2025-05-22 09:00:00','Books',4,'Educational books',63,46),
        ('2025-05-23 14:00:00','2025-05-24 10:00:00','Furniture',16,'Sofa set and pillows',69,24),
        ('2025-05-25 10:30:00','2025-05-26 13:00:00','Electronics',7.5,'Tablet and accessories',18,60),
        ('2025-05-27 13:00:00','2025-05-28 10:00:00','Food',5.2,'Packaged pasta and sauces',61,57),
        ('2025-05-29 16:00:00','2025-05-30 09:30:00','Clothing',3.1,'Casual wear for men',45,44),
        ('2025-08-01 08:30:00', '2025-08-03 14:15:00', 'Box', 2.50, 'Local snacks from Cebu', 1, 45),
		('2025-08-02 09:00:00', '2025-08-04 10:45:00', 'Envelope', 0.20, 'Legal documents', 2, 3),
		('2025-08-03 14:20:00', '2025-08-05 17:00:00', 'Crate', 10.00, 'Medical supplies', 3, 12),
		('2025-08-04 11:10:00', '2025-08-07 13:30:00', 'Box', 5.25, 'Dried mangoes', 4, 25),
		('2025-08-05 15:45:00', '2025-08-06 20:00:00', 'Tube', 1.10, 'Architectural plans', 5, 68),
		('2025-08-06 07:30:00', '2025-08-08 09:30:00', 'Envelope', 0.50, 'School papers', 6, 18),
		('2025-08-07 16:00:00', '2025-08-09 12:00:00', 'Box', 3.75, 'Books for donation', 7, 60),
		('2025-08-08 10:20:00', '2025-08-10 15:30:00', 'Box', 4.10, 'Pasalubong items', 8, 33),
		('2025-08-09 12:00:00', '2025-08-12 11:00:00', 'Crate', 8.90, 'Small furniture', 9, 7),
		('2025-08-10 09:45:00', '2025-08-13 10:15:00', 'Envelope', 0.15, 'Government forms', 10, 80),
		('2025-08-11 13:30:00', '2025-08-12 18:00:00', 'Box', 6.50, 'Kape from Batangas', 11, 22),
		('2025-08-12 08:00:00', '2025-08-14 14:45:00', 'Box', 2.90, 'Home goods', 12, 77),
		('2025-08-13 10:10:00', '2025-08-15 13:30:00', 'Tube', 0.90, 'Maps and charts', 13, 5),
		('2025-08-14 14:15:00', '2025-08-16 17:45:00', 'Envelope', 0.25, 'Photos', 14, 48),
		('2025-08-15 12:30:00', '2025-08-17 15:00:00', 'Box', 3.30, 'Organic soaps', 15, 26),
		('2025-08-16 11:45:00', '2025-08-18 18:30:00', 'Crate', 12.00, 'Kitchen appliances', 16, 38),
		('2025-08-17 07:20:00', '2025-08-19 08:45:00', 'Box', 1.60, 'Printed shirts', 17, 11),
		('2025-08-18 15:30:00', '2025-08-20 16:30:00', 'Envelope', 0.40, 'Business contract', 18, 71),
		('2025-08-19 09:00:00', '2025-08-21 10:00:00', 'Box', 4.80, 'Shoes', 19, 36),
		('2025-08-20 13:50:00', '2025-08-22 19:00:00', 'Crate', 9.25, 'Lamps and fixtures', 20, 59),
		('2025-08-21 10:25:00', '2025-08-23 14:15:00', 'Box', 3.55, 'Office supplies', 21, 6),
		('2025-08-22 08:40:00', '2025-08-24 12:00:00', 'Envelope', 0.30, 'Bank papers', 22, 74),
		('2025-08-23 12:15:00', '2025-08-25 15:45:00', 'Box', 2.20, 'School supplies', 23, 1),
		('2025-08-24 14:00:00', '2025-08-26 17:00:00', 'Box', 6.75, 'Food containers', 24, 15),
		('2025-08-25 11:30:00', '2025-08-27 13:00:00', 'Tube', 1.05, 'Blueprints', 25, 53),
		('2025-08-26 13:10:00', '2025-08-28 18:30:00', 'Envelope', 0.35, 'Certificates', 26, 42),
		('2025-08-27 16:45:00', '2025-08-29 20:00:00', 'Box', 5.10, 'Accessories', 27, 65),
		('2025-08-28 09:30:00', '2025-08-30 11:45:00', 'Crate', 11.00, 'Home décor', 28, 30),
		('2025-08-29 12:00:00', '2025-08-31 15:00:00', 'Box', 7.20, 'Cookware', 29, 69),
		('2025-08-30 15:10:00', '2025-09-01 17:30:00', 'Envelope', 0.18, 'Receipts', 30, 17);

-- select * from packages;-- 

-- UPDATED tracking_events dummy data
INSERT INTO tracking_events (event_description, package_status, package_id, location_id, created_at) VALUES
('Out for delivery', 'In Transit', 17, 16, '2024-06-04 10:06:00'),
('Package received at facility', 'Pending', 10, 20, '2024-04-11 15:47:00'),
('Awaiting pickup', 'Pending', 19, 3, '2024-04-07 01:43:00'),
('Package received at facility', 'Pending', 1, 6, '2024-05-20 06:37:00'),
('Delivered', 'Delivered', 18, 5, '2024-03-23 05:57:00'),
('Package delayed', 'In Transit', 3, 19, '2024-01-18 11:35:00'),
('Cancelled', 'Cancelled', 19, 7, '2024-04-13 15:22:00'),
('Awaiting pickup', 'Pending', 13, 15, '2024-04-21 15:33:00'),
('Delivered', 'Delivered', 4, 17, '2024-04-07 02:13:00'),
('Package received at facility', 'Pending', 7, 6, '2024-01-17 20:55:00'),
('Package received at facility', 'Pending', 4, 16, '2024-03-29 12:47:00'),
('Awaiting pickup', 'Pending', 14, 18, '2024-05-06 19:07:00'),
('Out for delivery', 'In Transit', 16, 4, '2024-03-07 21:49:00'),
('Delivered', 'Delivered', 17, 10, '2024-06-09 17:37:00'),
('Cancelled', 'Cancelled', 15, 1, '2024-02-07 09:40:00'),
('Package received at facility', 'Pending', 19, 6, '2024-04-10 18:59:00'),
('Package received at facility', 'Pending', 16, 9, '2024-02-27 01:18:00'),
('Package received at facility', 'Pending', 18, 2, '2024-03-21 19:26:00'),
('Awaiting pickup', 'Pending', 16, 15, '2024-02-24 08:21:00'),
('Awaiting pickup', 'Pending', 17, 18, '2024-06-01 09:05:00'),
('Package received at facility', 'Pending', 11, 9, '2024-05-25 13:04:00'),
('Delivered', 'Delivered', 8, 13, '2024-03-17 06:32:00'),
('Package received at facility', 'Pending', 14, 20, '2024-05-09 21:40:00'),
('Awaiting pickup', 'Pending', 2, 10, '2024-04-10 10:51:00'),
('Package delayed', 'In Transit', 20, 1, '2024-01-13 19:06:00'),
('Awaiting pickup', 'Pending', 12, 5, '2024-03-27 02:33:00'),
('Delivered', 'Delivered', 1, 1, '2024-06-02 09:15:00'),
('In transit', 'In Transit', 8, 3, '2024-03-14 17:08:00'),
('Package delayed', 'In Transit', 5, 7, '2024-01-21 21:43:00'),
('Package lost', 'Cancelled', 5, 5, '2024-01-28 07:16:00'),
('Awaiting pickup', 'Pending', 5, 12, '2024-01-16 20:11:00'),
('Delivered', 'Delivered', 10, 4, '2024-04-20 03:59:00'),
('In transit', 'In Transit', 1, 2, '2024-05-26 17:42:00'),
('Out for delivery', 'In Transit', 10, 8, '2024-04-15 06:52:00'),
('Package received at facility', 'Pending', 20, 15, '2024-01-15 06:15:00'),
('In transit', 'In Transit', 19, 14, '2024-04-08 14:03:00'),
('Returned to sender', 'Returned', 3, 4, '2024-01-21 08:52:00'),
('Package received at facility', 'Pending', 3, 9, '2024-01-15 01:47:00'),
('In transit', 'In Transit', 12, 9, '2024-03-29 04:50:00'),
('Package received at facility', 'Pending', 8, 8, '2024-03-10 16:43:00'),
('In transit', 'In Transit', 14, 12, '2024-05-10 06:05:00'),
('Package received at facility', 'Pending', 15, 20, '2024-01-27 17:12:00'),
('Out for delivery', 'In Transit', 8, 14, '2024-03-16 08:33:00'),
('Out for delivery', 'In Transit', 1, 4, '2024-05-28 22:02:00'),
('Out for delivery', 'In Transit', 2, 1, '2024-04-12 19:37:00'),
('Delivered', 'Delivered', 2, 5, '2024-04-15 05:18:00'),
('In transit', 'In Transit', 17, 6, '2024-06-06 02:51:00'),
('Package received at facility', 'Pending', 2, 12, '2024-04-11 03:31:00'),
('Delivered', 'Delivered', 12, 2, '2024-04-01 17:48:00'),
('Delivered', 'Delivered', 13, 13, '2024-04-24 00:46:00'),
('Out for delivery', 'In Transit', 3, 8, '2024-01-19 23:29:00'),
('Delivered', 'Delivered', 16, 7, '2024-03-09 20:50:00'),
('Awaiting pickup', 'Pending', 7, 18, '2024-01-16 08:26:00'),
('Delivered', 'Delivered', 7, 10, '2024-01-21 14:57:00'),
('Out for delivery', 'In Transit', 14, 4, '2024-05-08 11:40:00'),
('Package delayed', 'In Transit', 18, 15, '2024-03-22 17:22:00'),
('In transit', 'In Transit', 20, 16, '2024-01-16 09:58:00'),
('Delivered', 'Delivered', 20, 6, '2024-01-18 21:39:00'),
('Awaiting pickup', 'Pending', 9, 11, '2024-02-13 20:54:00'),
('Package received at facility', 'Pending', 6, 3, '2024-01-19 18:35:00'),
('In transit', 'In Transit', 9, 2, '2024-02-15 12:48:00'),
('Delivered', 'Delivered', 9, 15, '2024-02-18 23:29:00'),
('Awaiting pickup', 'Pending', 11, 11, '2024-05-22 14:11:00'),
('Package received at facility', 'Pending', 13, 14, '2024-04-23 02:48:00'),
('In transit', 'In Transit', 13, 9, '2024-04-25 01:59:00'),
('Out for delivery', 'In Transit', 13, 20, '2024-04-28 06:43:00'),
('Awaiting pickup', 'Pending', 4, 9, '2024-03-25 00:10:00'),
('Awaiting pickup', 'Pending', 18, 4, '2024-03-20 04:06:00'),
('In transit', 'In Transit', 6, 2, '2024-01-22 04:43:00'),
('Delivered', 'Delivered', 6, 19, '2024-01-26 14:21:00'),
('Package received at facility', 'Pending', 15, 3, '2024-01-28 14:47:00'),
('Awaiting pickup', 'Pending', 10, 14, '2024-04-09 06:22:00'),
('Package received at facility', 'Pending', 5, 16, '2024-01-18 12:04:00'),
('Out for delivery', 'In Transit', 6, 10, '2024-01-24 23:59:00'),
('Awaiting pickup', 'Pending', 20, 8, '2024-01-12 14:37:00'),
('Out for delivery', 'In Transit', 11, 5, '2024-05-28 01:02:00'),
('Delivered', 'Delivered', 19, 1, '2024-04-12 03:38:00');


-- select * from tracking_events;