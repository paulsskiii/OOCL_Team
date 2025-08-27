Use cargo_shipping_system;

-- City
insert into City (name) values ('Thị Trấn Nước Hai');
insert into City (name) values ('Altan-Ovoo');
insert into City (name) values ('Clamart');
insert into City (name) values ('Guacarí');
insert into City (name) values ('Babica');
insert into City (name) values ('Xigangzi');
insert into City (name) values ('El Tejocote');
insert into City (name) values ('Urug');
insert into City (name) values ('Dobryanka');
insert into City (name) values ('Lainqu');
insert into City (name) values ('Tlogocilik');
insert into City (name) values ('Gongrong');
insert into City (name) values ('Rizal');
insert into City (name) values ('Hanamaki');
insert into City (name) values ('Sihe');
insert into City (name) values ('Yuhuangding');
insert into City (name) values ('Olszówka');
insert into City (name) values ('Talashkino');
insert into City (name) values ('Ballymun');
insert into City (name) values ('Jauja');
insert into City (name) values ('Chengbei');
insert into City (name) values ('Marmárion');
insert into City (name) values ('Nora');
insert into City (name) values ('Cagliari');
insert into City (name) values ('Petushki');
insert into City (name) values ('Gucun');
insert into City (name) values ('Brusy');
insert into City (name) values ('Maguwon');
insert into City (name) values ('Ang Thong');
insert into City (name) values ('Schaumburg');
insert into City (name) values ('Todorovo');
insert into City (name) values ('Mangero');
insert into City (name) values ('Yunji');
insert into City (name) values ('Banjar Tengah');
insert into City (name) values ('Prelog');
insert into City (name) values ('Kiangan');
insert into City (name) values ('Souziqiu');
insert into City (name) values ('Trakan Phut Phon');
insert into City (name) values ('Santa Paz');
insert into City (name) values ('Qiling');
insert into City (name) values ('El Nido');
insert into City (name) values ('Tielong');
insert into City (name) values ('Oued Laou');
insert into City (name) values ('Saint-Jouan-des-Guérets');
insert into City (name) values ('Buzuluk');
insert into City (name) values ('Ljig');
insert into City (name) values ('Strawczyn');
insert into City (name) values ('Rivne');
insert into City (name) values ('Runting');
insert into City (name) values ('Staffanstorp');
insert into City (name) values ('Ivry-sur-Seine');
insert into City (name) values ('Fatumuti');
insert into City (name) values ('New Orleans');
insert into City (name) values ('Santa Venera');
insert into City (name) values ('Spirovo');
insert into City (name) values ('Rivas');
insert into City (name) values ('Velyki Sorochyntsi');
insert into City (name) values ('Ḩarf al Musaytirah');
insert into City (name) values ('Wailiang');
insert into City (name) values ('Kaédi');
insert into City (name) values ('Nogliki');
insert into City (name) values ('Varkaus');
insert into City (name) values ('Holýšov');
insert into City (name) values ('Huangdi');
insert into City (name) values ('Temuji');
insert into City (name) values ('Berlin');
insert into City (name) values ('Altanbulag');
insert into City (name) values ('São Lourenço da Mata');
insert into City (name) values ('Bislig');
insert into City (name) values ('Qijia');
insert into City (name) values ('Camacupa');
insert into City (name) values ('Brazzaville');
insert into City (name) values ('Ledenice');
insert into City (name) values ('Deje');
insert into City (name) values ('Bato');
insert into City (name) values ('Zmiyëvka');
insert into City (name) values ('Ostroróg');
insert into City (name) values ('Nangalimang');
insert into City (name) values ('Kavadarci');
insert into City (name) values ('Archis');

Select * from city;

-- Address
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (1, '90 Ludington Circle', '8392', 'Dayton', 52, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (2, '32716 Artisan Point', '2739', 'Village', 14, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (3, '25258 Waywood Circle', '65841', 'Mcbride', 41, '628532', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (4, '8 Lillian Court', '85', 'International', 80, null, null, 'Sudan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (5, '2 Petterle Park', '1076', 'Bluestem', 24, null, null, 'Vietnam');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (6, '7161 Lunder Crossing', '01', 'Roth', 8, NULL, null, 'Ireland');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (7, '34 Clemons Lane', '4', 'Stone Corner', 15, '44505', 'Ohio', 'United States');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (8, '47 Anniversary Circle', '18062', 'Tony', 65, '5202541', null, 'Japan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (9, '85 Mayer Terrace', '03657', 'Shelley', 3, null, null, 'Uruguay');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (10, '102 Sutteridge Hill', '05', 'Prairieview', 23, null, null, 'Jamaica');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (11, '705 Carpenter Pass', '35', 'Chive', 15, null, null, 'Honduras');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (12, '4456 Daystar Park', '061', 'Dorton', 35, null, null, 'Syria');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (13, '142 Donald Alley', '8172', 'Bunting', 61, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (14, '446 Ruskin Junction', '237', 'Sunnyside', 60, '152014', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (15, '93 Hoffman Park', '4', 'Portage', 22, '694752', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (16, '229 Waywood Plaza', '4069', 'Di Loreto', 19, null, null, 'Sudan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (17, '49946 Blue Bill Park Plaza', '7', 'Center', 33, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (18, '61 Pankratz Pass', '1', 'Old Shore', 1, null, null, 'Vietnam');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (19, '1 Scott Lane', '10', 'Delaware', 23, null, null, 'Peru');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (20, '181 Summit Street', '82323', 'Corry', 41, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (21, '088 Sunnyside Hill', '3408', 'North', 66, null, null, 'Vietnam');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (22, '1 Atwood Crossing', '25158', 'Hansons', 4, null, null, 'Greece');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (23, '32 4th Court', '223', 'Messerschmidt', 68, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (24, '4 Mosinee Road', '62005', 'Nevada', 23, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (25, '1 Leroy Court', '2', '6th', 7, '40401', null, 'Poland');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (26, '8501 Lien Alley', '186', 'Superior', 53, null, null, 'South Korea');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (27, '19144 Welch Trail', '6', 'Ohio', 50, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (28, '925 Bowman Place', '93', 'Dryden', 50, null, null, 'Djibouti');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (29, '329 Crest Line Hill', '04', 'Pearson', 73, '9634603', null, 'Japan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (30, '74935 Russell Park', '9', 'Oriole', 40, '242622', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (31, '073 Cherokee Avenue', '853', 'Fair Oaks', 56, '630008', null, 'Colombia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (32, '42317 Maple Drive', '1', 'Delaware', 44, '29980000', null, 'Brazil');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (33, '05959 Anhalt Court', '468', 'Ridgeway', 46, '3586', null, 'Argentina');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (34, '7 Kennedy Court', '0', 'Moose', 15, null, null, 'Turkmenistan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (35, '79 Sunfield Parkway', '5', 'Erie', 79, '36520000', null, 'Brazil');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (36, '098 Forest Road', '5', 'Crowley', 32, null, null, 'Botswana');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (37, '2942 Hermina Center', '6166', 'Walton', 60, '627603', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (38, '92 Longview Pass', '51', 'Talmadge', 19, '50730', null, 'Pakistan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (39, '58926 Lakewood Way', '6', 'Village', 43, '26540', 'Skåne', 'Sweden');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (40, '4961 Maple Wood Place', '76776', 'Fuller', 45, '2433', null, 'Philippines');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (41, '771 Arapahoe Parkway', '4987', 'Village', 5, 20, 'Alberta', 'Canada');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (42, '1754 Village Park', '3', 'Sommers', 53, null, null, 'Vietnam');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (43, '04 Warbler Road', '46', 'Forest', 67, null, null, 'Uzbekistan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (44, '71566 Londonderry Trail', '957', 'Del Mar', 57, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (45, '12 Nova Center', '6', 'Eastwood', 35, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (46, '2 Holmberg Plaza', '23', 'Thackeray', 47, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (47, '83658 Oak Valley Road', '0', 'Basil', 49, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (48, '2106 Kennedy Parkway', '147', 'Melrose', 54, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (49, '4998 Waubesa Road', '601', 'Boyd', 67, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (50, '5 Farragut Lane', '0025', 'Village', 72, null, null, 'Peru');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (51, '919 Gale Trail', '991', 'Ridgeway', 17, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (52, '34354 Longview Circle', '8', 'Weeping Birch', 66, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (53, '4 Buhler Avenue', '686', 'Schiller', 15, null, null, 'Peru');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (54, '60230 Old Gate Way', '15927', 'Mallory', 39, '94604', 'Île-de-France', 'France');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (55, '11 Village Terrace', '850', 'Esker', 44, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (56, '62803 Old Gate Alley', '625', 'Portage', 69, '73210', null, 'Pakistan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (57, '26 Fallview Center', '82', 'Heffernan', 22, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (58, '557 Westport Alley', '4604', 'Wayridge', 80, null, null, 'Azerbaijan');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (59, '94829 Tony Avenue', '89187', 'Thompson', 40, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (60, '24980 Butterfield Terrace', '412', 'Melrose', 16, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (61, '6 Bobwhite Center', '9', 'Waubesa', 62, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (62, '7730 Alpine Hill', '1657', '8th', 45, null, null, 'Jamaica');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (63, '17 Gale Point', '82', 'Tomscot', 12, null, null, 'Burundi');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (64, '1 Macpherson Circle', '98', 'Monument', 12, null, null, 'Serbia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (65, '9975 Anthes Crossing', '246', 'Grover', 36, '357329', null, 'Russia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (66, '103 Jenifer Way', '36037', 'Oriole', 54, null, null, 'Indonesia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (67, '5302 Haas Way', '35', 'Shopko', 5, '49544', 'Michigan', 'United States');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (68, '01 Brown Junction', '52589', 'Stone Corner', 34, '5016', null, 'Philippines');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (69, '3201 Jana Way', '31', 'Pleasure', 34, '1100', null, 'Philippines');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (70, '2 Sycamore Circle', '0855', 'Brickson Park', 33, '20706', null, 'Costa Rica');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (71, '9939 Dovetail Park', '11', 'Ridge Oak', 41, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (72, '4816 Dahle Point', '12274', 'Melrose', 19, null, null, 'Peru');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (73, '187 Orin Place', '88', 'Linden', 1, '1225', null, 'Macedonia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (74, '14909 Graedel Junction', '749', 'Independence', 64, '1400', null, 'Macedonia');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (75, '09 Sachs Drive', '646', 'Dennis', 51, '1400', 'British Columbia', 'Canada');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (76, '01 Boyd Parkway', '3733', 'Kenwood', 59, null, null, 'Bosnia and Herzegovina');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (77, '6340 Fallview Terrace', '99', 'Northview', 58, '19360000', null, 'Brazil');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (78, '1 Upham Drive', '5697', 'Veith', 54, null, null, 'Yemen');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (79, '83643 Crowley Park', '8237', 'Arrowood', 18, null, null, 'China');
insert into Address (address_id, address_line1, address_line2, barangay, city_id, postal_code, region, country) values (80, '173 Florence Junction', '1', 'David', 49, null, null, 'Jordan');

SELECT * FROM Address;

-- Customer
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lynda', 'Epinoy', 94681310337, 'lepinoy0@gmail.com', 11, '2025-07-31 00:59:10', '2025-07-20 03:03:01');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Glyn', 'Danelut', 60117971747, 'gdanelut1@biblegateway.com', 19, '2025-04-08 02:34:59', '2025-03-11 07:24:53');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Clemmie', 'Setterthwait', 39988478284, 'csetterthwait2@gmail.com', 79, '2025-03-30 23:00:33', '2025-05-31 15:44:04');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Grange', 'Brimicombe', 26373575406, 'gbrimicombe3@gmail.com', 28, '2025-02-20 22:39:32', '2025-03-21 11:05:49');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Kary', 'Elby', 77807607642, 'kelby4@gmail.com', 36, '2025-07-31 15:49:04', '2025-07-25 01:17:33');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Goldarina', 'Primett', 39137804942, 'gprimett5@gmail.com', 60, '2024-09-15 14:12:18', '2025-05-05 23:17:46');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lyn', 'Dymoke', 39085339278, 'ldymoke6@gmail.com', 3, '2025-02-18 23:41:40', '2025-04-25 08:28:25');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Mari', 'Fright', 91798786678, 'mfright7@gmail.com', 66, '2024-11-09 22:11:26', '2025-02-06 05:39:03');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Ivy', 'Ralestone', 63599551858, 'iralestone8@gmail.com', 57, '2024-11-14 12:15:40', '2025-07-31 03:44:36');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lizzy', 'Geane', 22041672137, 'lgeane9@accuweather.com', 11, '2025-02-09 11:51:17', '2025-03-24 23:33:58');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Shirley', 'Waylett', 65284660953, 'swayletta@flavors.me', 6, '2025-06-03 11:07:08', '2025-05-17 03:51:13');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Zsa zsa', 'Bester', 18890725679, 'zbesterb@gmail.com', 10, '2024-08-15 22:27:49', '2025-03-06 04:02:30');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Moishe', 'Beeckx', 91784304804, 'mbeeckxc@gmail.com', 21, '2024-12-24 04:32:18', '2025-04-13 19:54:06');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Dmitri', 'Stuchbury', 49341264381, 'dstuchburyd@engadget.com', 46, '2025-08-09 11:42:51', '2025-01-13 16:26:39');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Miller', 'Monks', 66632219011, 'mmonkse@toplist.cz', 38, '2025-04-18 08:35:40', '2025-07-25 20:05:37');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Juditha', 'Simoncelli', 24156268116, 'jsimoncellif@gmail.com', 10, '2025-07-11 05:27:25', '2025-07-27 04:12:49');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Odie', 'Bernaldo', 34896465577, 'obernaldog@gmail.com', 59, '2025-04-06 20:59:19', '2025-05-05 18:56:42');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Tabbie', 'Eldrett', 18903584152, 'teldretth@gmail.com', 31, '2025-06-23 04:51:50', '2025-06-21 05:55:40');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Dominique', 'Richardson', 28118436090, 'drichardsoni@gmail.com', 61, '2024-10-02 14:14:23', '2025-02-12 21:08:42');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Mill', 'Duerden', 78436983149, 'mduerdenj@gmail.com', 58, '2025-07-01 03:53:46', '2025-07-30 05:16:04');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Pyotr', 'Cordoba', 91774947463, 'pcordobak@gmail.com', 42, '2025-06-26 23:55:13', '2025-07-29 17:15:09');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Trent', 'Wildash', 31337265544, 'twildashl@gmail.com', 4, '2025-01-02 18:05:57', '2025-05-06 01:17:38');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Erina', 'Yellowlees', 32778370918, 'eyellowleesm@gmail.com', 34, '2025-05-03 16:09:47', '2025-02-10 16:18:51');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Ethelda', 'Peirce', 83560603207, 'epeircen@gmail.com', 7, '2025-02-14 03:17:32', '2025-07-31 23:21:49');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Jo', 'Janousek', 87332211631, 'jjanouseko@gmail.com', 53, '2025-05-26 16:41:24', '2025-03-21 18:31:49');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Orin', 'Bridel', 95993008849, 'obridelp@gmail.com', 22, '2024-12-18 20:33:52', '2025-06-27 08:40:48');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Caz', 'Marvin', 32926974254, 'cmarvinq@telegraph.co.uk', 9, '2025-07-09 21:41:26', '2025-05-08 08:34:35');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Atlanta', 'Sizland', 31277306768, 'asizlandr@prnewswire.com', 2, '2025-04-06 19:51:38', '2025-02-24 06:28:17');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Marigold', 'Crowcombe', 67264949087, 'mcrowcombes@ibm.com', 15, '2025-01-09 03:57:51', '2025-02-25 16:36:17');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Jedediah', 'Afonso', 38355472192, 'jafonsot@nytimes.com', 59, '2024-11-17 18:22:09', '2025-07-21 09:04:40');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Bertie', 'Spraberry', 83553726316, 'bspraberryu@senate.gov', 13, '2025-04-14 00:48:23', '2025-03-10 22:00:37');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Mireille', 'Tett', 73295069866, 'mtettv@unc.edu', 29, '2024-12-24 15:34:01', '2025-06-24 07:09:43');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Madel', 'Marcone', 76610096652, 'mmarconew@house.gov', 76, '2025-06-22 14:57:11', '2025-01-26 19:36:10');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Martainn', 'Pavy', 68269746692, 'mpavyx@taobao.com', 78, '2025-04-17 13:02:07', '2025-05-11 00:13:26');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Carolyn', 'Martignon', 26266059061, 'cmartignony@stumbleupon.com', 50, '2025-01-20 07:34:35', '2025-05-09 10:10:17');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Jermain', 'Dono', 72521531759, 'jdonoz@businessinsider.com', 42, '2024-08-26 13:44:54', '2025-07-15 01:08:26');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('James', 'Fears', 27372555071, 'jfears10@ocn.ne.jp', 25, '2024-10-03 05:33:23', '2025-03-20 06:41:35');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Humphrey', 'Duquesnay', 27302308478, 'hduquesnay11@clickbank.net', 39, '2024-10-19 00:31:15', '2025-05-08 23:24:01');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Rafaelita', 'Schachter', 75463257633, 'rschachter12@t-online.de', 30, '2025-08-06 04:07:48', '2025-04-24 04:37:46');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Nollie', 'Whitecross', 81157188700, 'nwhitecross13@dyndns.org', 41, '2025-05-27 08:56:45', '2025-05-23 21:03:31');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Shelton', 'Strute', 39438908286, 'sstrute14@bbc.co.uk', 48, '2024-08-17 19:19:25', '2025-04-11 18:07:41');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Orsola', 'Ferrario', 31098105947, 'oferrario15@webeden.co.uk', 31, '2025-06-08 21:43:49', '2025-05-20 20:11:06');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Carlie', 'Geraud', 38505151214, 'cgeraud16@nasa.gov', 8, '2025-02-07 03:16:06', '2025-03-18 16:57:56');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Artemas', 'Ruggen', 13824141833, 'aruggen17@gmail.com', 40, '2025-05-11 08:34:00', '2025-06-08 16:04:15');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Westbrook', 'Arber', 38435613542, 'warber18@xing.com', 66, '2025-06-28 22:47:25', '2025-04-04 11:34:03');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Heath', 'Treversh', 56167201127, 'htreversh19@gmail.com', 70, '2025-01-26 00:14:55', '2025-02-28 07:37:18');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Klarika', 'Standage', 94864070889, 'kstandage1a@gmail.com', 66, '2024-09-19 08:22:42', '2025-06-29 13:53:26');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Rhianna', 'Gouldthorp', 82888325304, 'rgouldthorp1b@gmail.com', 4, '2025-02-07 03:39:11', '2025-03-07 21:13:44');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Rufus', 'Robichon', 37895330694, 'rrobichon1c@umn.edu', 4, '2024-08-28 06:16:48', '2025-06-03 06:31:23');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Tamarra', 'Dziwisz', 69723663570, 'tdziwisz1d@gmail.com', 27, '2024-08-24 04:07:50', '2025-03-30 06:56:26');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('William', 'Killiam', 62187565829, 'wkilliam1e@gmail.com', 34, '2025-07-17 14:47:50', '2025-05-07 00:50:52');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Anstice', 'Krugmann', 80220930112, 'akrugmann1f@gmail.com', 64, '2025-04-24 18:34:01', '2025-04-28 12:41:55');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Ave', 'Rundle', 57730280902, 'arundle1g@nifty.com', 73, '2025-05-07 06:00:38', '2025-03-29 21:24:44');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Wait', 'Chugg', 41773344043, 'wchugg1h@gmail.com', 45, '2025-08-11 05:25:16', '2025-07-03 13:32:23');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lenka', 'Loveitt', 81476807911, 'lloveitt1i@gmail.com', 45, '2025-07-10 07:11:36', '2025-02-13 09:32:36');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Octavia', 'Carmo', 66459031076, 'ocarmo1j@psu.edu', 27, '2025-07-28 14:42:52', '2025-05-02 18:51:48');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Kittie', 'Acklands', 33850510650, 'kacklands1k@gmail.com', 44, '2025-01-08 21:48:08', '2025-01-25 23:29:09');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Anneliese', 'Jankovic', 24568405083, 'ajankovic1l@gmail.com', 68, '2025-02-06 22:49:25', '2025-05-22 21:56:34');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Moe', 'Alliker', 16986588087, 'malliker1m@gmail.com', 75, '2025-07-05 03:04:38', '2025-04-16 17:51:58');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lovell', 'Josowitz', 13159195261, 'ljosowitz1n@gmail.com', 10, '2025-03-13 00:19:57', '2025-07-14 05:53:20');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Witty', 'Labat', 11939815446, 'wlabat1o@gmail.com', 75, '2025-03-21 02:35:11', '2025-03-22 21:50:24');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Maxi', 'Voules', 51006887765, 'mvoules1p@gmail.com', 75, '2024-10-07 06:29:18', '2025-04-13 08:20:52');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Nicol', 'Dowrey', 35464515028, 'ndowrey1q@bloomberg.com', 58, '2025-07-17 17:58:33', '2025-06-22 13:11:02');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Sherye', 'Accombe', 42828649192, 'saccombe1r@gmail.com', 79, '2024-10-24 05:29:37', '2025-06-17 16:09:48');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Erhard', 'Lymbourne', 37883195675, 'elymbourne1s@gmail.com', 69, '2025-08-08 09:42:56', '2025-07-20 01:50:55');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Claudius', 'Mariault', 62199623492, 'cmariault1t@gmail.com', 75, '2024-08-25 22:06:24', '2025-03-16 17:50:42');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Malvin', 'Cockshoot', 88220686692, 'mcockshoot1u@gmail.com', 73, '2025-02-11 04:01:32', '2025-08-02 10:57:35');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Warden', 'De la Harpe', 16727801253, 'wdelaharpe1v@gmail.com', 22, '2025-04-30 12:29:25', '2025-05-26 04:02:27');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Laurens', 'Belone', 36801062824, 'lbelone1w@gmail.com', 49, '2024-12-04 16:49:30', '2025-03-04 16:53:01');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Marcel', 'Wilbore', 39794376695, 'mwilbore1x@gmail.com', 30, '2025-01-04 06:59:55', '2025-06-19 10:00:27');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Skipp', 'Tanswill', 61464368652, 'stanswill1y@gmail.com', 66, '2024-09-12 17:22:39', '2025-04-12 02:04:49');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Magdalene', 'Mangion', 85726821175, 'mmangion1z@gmail.com', 57, '2025-02-22 03:24:30', '2025-05-27 10:20:11');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Frankie', 'Veel', 17857496619, 'fveel20@gmail.com', 58, '2024-11-30 16:15:39', '2025-07-08 18:27:45');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Jannel', 'Dobie', 32094497114, 'jdobie21@gmail.com', 36, '2024-11-05 14:40:56', '2025-04-27 03:39:11');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Marvin', 'Pogue', 56062742620, 'mpogue22@gmail.com', 39, '2025-04-22 03:50:55', '2025-02-15 15:59:54');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Lanna', 'Powrie', 78242375856, 'lpowrie23@gmail.com', 32, '2025-06-30 13:53:33', '2025-02-07 22:27:58');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Chickie', 'Muggeridge', 83130581445, 'cmuggeridge24@gmail.com', 52, '2025-07-28 11:54:32', '2025-04-09 08:06:39');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Irvin', 'Mackilpatrick', 26589685188, 'imackilpatrick25@gmail.com', 26, '2025-01-07 12:52:51', '2025-04-01 16:01:26');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Kerrill', 'Wheatman', 52665985111, 'kwheatman26@gmail.com', 45, '2025-06-03 19:55:55', '2025-07-07 22:13:34');
insert into Customer (first_name, last_name, contact_number, email_address, address_id, created_at, updated_at) values ('Stanly', 'Wiffler', 39873653701, 'gmail.com', 33, '2024-08-31 15:57:41', '2025-04-20 14:23:25');

SELECT * FROM Customer;


-- Location
INSERT INTO Location (city_id, contact_number) VALUES
(1, '+639181234001'), (2, '+639181234002'), (3, '+639181234003'), (4, '+639181234004'),
(5, '+639181234005'), (6, '+639181234006'), (7, '+639181234007'), (8, '+639181234008'),
(9, '+639181234009'), (10, '+639181234010'), (11, '+639181234011'), (12, '+639181234012'),
(13, '+639181234013'), (14, '+639181234014'), (15, '+639181234015'), (16, '+639181234016'),
(17, '+639181234017'), (18, '+639181234018'), (19, '+639181234019'), (20, '+639181234020'),
(21, '+639181234021'), (22, '+639181234022'), (23, '+639181234023'), (24, '+639181234024'),
(25, '+639181234025'), (26, '+639181234026'), (27, '+639181234027'), (28, '+639181234028'),
(29, '+639181234029'), (30, '+639181234030'), (31, '+639181234031'), (32, '+639181234032'),
(33, '+639181234033'), (34, '+639181234034'), (35, '+639181234035'), (36, '+639181234036'),
(37, '+639181234037'), (38, '+639181234038'), (39, '+639181234039'), (40, '+639181234040'),
(41, '+639181234041'), (42, '+639181234042'), (43, '+639181234043'), (44, '+639181234044'),
(45, '+639181234045'), (46, '+639181234046'), (47, '+639181234047'), (48, '+639181234048'),
(49, '+639181234049'), (50, '+639181234050'), (51, '+639181234051'), (52, '+639181234052'),
(53, '+639181234053'), (54, '+639181234054'), (55, '+639181234055'), (56, '+639181234056'),
(57, '+639181234057'), (58, '+639181234058'), (59, '+639181234059'), (60, '+639181234060'),
(61, '+639181234061'), (62, '+639181234062'), (63, '+639181234063'), (64, '+639181234064'),
(65, '+639181234065'), (66, '+639181234066'), (67, '+639181234067'), (68, '+639181234068'),
(69, '+639181234069'), (70, '+639181234070'), (71, '+639181234071'), (72, '+639181234072'),
(73, '+639181234073'), (74, '+639181234074'), (75, '+639181234075'), (76, '+639181234076'),
(77, '+639181234077'), (78, '+639181234078'), (79, '+639181234079'), (80, '+639181234080');

SELECT * FROM Location;

-- Courier
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Fidelity', 'Rorke', '214130136', 'Volkswagen', 'WBASN2C54AC101147', '2025-01-16 13:44:41');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Sayers', 'Udy', '831802022', 'Mazda', 'JM1NC2MF4E0731223', '2025-02-12 09:18:55');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Beret', 'Tidbury', '456202602', 'BMW', '5J8TB2H59CA122794', '2024-11-21 01:06:49');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Gavrielle', 'Hadgkiss', '126270454', 'Buick', 'WA1CGAFE7DD511151', '2025-05-22 10:00:09');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Mellisa', 'Mitrovic', '876103527', 'Mazda', '1FMNE1BW4AD881433', '2025-01-21 19:51:13');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Collin', 'Bautiste', '286978281', 'GMC', 'WBXPA93496W204660', '2024-11-07 15:20:06');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Kaile', 'Pluck', '709353942', 'Mercury', '3GYFK66N64G048494', '2025-03-23 11:05:26');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Fitzgerald', 'Sesser', '808903194', 'Audi', 'WBAEP33465P384878', '2025-05-30 00:57:45');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Vivyan', 'Blas', '783574448', 'Volkswagen', 'KMHEC4A47FA975759', '2025-05-08 04:18:20');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Honoria', 'Cosgreave', '177210107', 'Chevrolet', 'WAUCFAFR9EA151957', '2025-01-11 01:11:25');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Danyette', 'Powling', '624303388', 'Mitsubishi', '3D7JV1EP7BG982101', '2025-05-09 14:45:05');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Onfroi', 'Daily', '236420351', 'GMC', '3VW467AT4DM289742', '2025-07-15 05:06:15');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Marris', 'Jedraszek', '971167246', 'Volvo', '2T1BURHE4FC243648', '2024-09-28 23:45:39');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Tam', 'Pidduck', '788091257', 'Volkswagen', 'WBALW7C56CC786575', '2025-07-17 16:06:27');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Ephraim', 'Beevers', '878713449', 'Lamborghini', 'WAUKFAFL6DN038871', '2025-02-25 03:05:36');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Bethany', 'Betz', '683436847', 'Infiniti', 'WAUCH74F79N769072', '2025-05-19 04:55:01');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Belinda', 'Ebbett', '190343389', 'Mercedes-Benz', 'WBAVB73527V336212', '2024-10-08 19:35:55');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Cassius', 'Pawlett', '124388906', 'Ford', '1FTMF1E8XAK014561', '2025-01-19 03:55:12');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Tiffi', 'Muckle', '904284086', 'Mitsubishi', '1D7RE2GKXBS600095', '2025-03-20 05:49:49');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Tobe', 'Patillo', '791662846', 'Mazda', '1N6AF0LX0FN800978', '2025-03-31 19:24:14');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Melodie', 'Raselles', '849403968', 'Volvo', '3N1CN7AP4EL103650', '2024-09-13 10:08:29');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Valerye', 'Crutcher', '323509489', 'Saab', '2G61R5S34D9945000', '2024-08-30 08:10:42');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Chris', 'Deverell', '280074685', 'Ferrari', 'WA1EV74L17D863259', '2024-12-26 00:12:00');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Darnell', 'O''Doogan', '713208517', 'Cadillac', '1GT01XEG2FZ689135', '2025-04-25 20:16:41');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Ailyn', 'Rawlinson', '158742168', 'Hyundai', '1FTSW2A54AE866931', '2025-06-26 05:14:19');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Oriana', 'Di Filippo', '550273870', 'Honda', '1GD22ZCGXDZ437310', '2024-12-17 04:57:28');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Sigismondo', 'Waterhowse', '172751466', 'Bentley', '5GAKRBED4CJ195588', '2025-01-01 21:12:45');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Lolly', 'Blankett', '148128800', 'Chevrolet', '1GD422CG5EF572908', '2025-04-27 05:36:47');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Gerrie', 'Fetherstonhaugh', '868115660', 'Chevrolet', '3D73Y4CL9BG753274', '2024-11-23 16:56:09');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Nick', 'Mannakee', '982745460', 'Mercedes-Benz', '5NPDH4AE5DH559337', '2024-09-16 11:25:03');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Jillene', 'Churms', '602607105', 'Chevrolet', '1C4RDJAGXCC325755', '2025-02-16 23:31:09');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Christy', 'Glasscock', '655435848', 'Cadillac', 'WAUVC68E55A823568', '2025-01-01 14:34:49');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Amelina', 'Conduit', '845792726', 'Chrysler', 'WA1DGAFEXBD749786', '2024-12-25 04:22:39');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Katharina', 'Colmore', '964729282', 'Pontiac', '1G6YV36A675663997', '2025-06-03 07:19:37');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Gale', 'Gerler', '209872287', 'Volkswagen', '4T1BB3EK4AU779519', '2025-04-23 14:22:39');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Rozanne', 'Stonall', '556111291', 'Cadillac', 'WBAUN9C57AV574658', '2024-11-25 06:20:24');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Marty', 'Eatherton', '329962426', 'Mazda', 'WBALW3C50DC089770', '2024-12-27 15:46:07');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Mallorie', 'Dyche', '685555517', 'Lincoln', '5NMSG3AB7AH331326', '2025-06-01 09:53:52');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Guenevere', 'Beves', '624413082', 'Acura', '3D4PH1FG1BT848978', '2025-04-29 10:40:42');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Margarethe', 'Ruzic', '368131023', 'Mercedes-Benz', '1G6KD5EYXAU725112', '2024-11-02 11:08:52');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Avrit', 'Teodorski', '815559725', 'Subaru', 'WAUEFAFL2BA175047', '2024-12-04 11:50:51');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Amandi', 'Hamner', '926387022', 'Mercedes-Benz', '1FTEW1E87AK539310', '2025-02-09 13:40:37');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Arther', 'Blague', '308110514', 'Dodge', 'KMHHT6KD1DU382871', '2025-08-06 19:01:05');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Saunders', 'Brimacombe', '344949885', 'Ford', 'JTEBU4BF6DK125600', '2025-06-19 22:47:03');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Aubrie', 'Meus', '567086920', 'Toyota', 'WBA3B9C50FP137245', '2024-09-18 06:34:26');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Blanch', 'Pavie', '338075881', 'Dodge', '3VW217AU3FM395407', '2025-07-29 20:17:14');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Lanita', 'Felgate', '670291059', 'Lincoln', 'JN1BY1AR5FM607858', '2024-12-23 02:46:35');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Alfy', 'Kenafaque', '239697319', 'Honda', 'WVGAV7AXXAW038601', '2025-04-02 09:03:07');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Windy', 'McWhorter', '117705509', 'Chrysler', '1G6DF8E59C0540327', '2024-11-11 10:18:20');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Ingemar', 'Sullivan', '615057609', 'Saturn', 'JH4KB16698C256618', '2025-04-18 16:12:48');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Jany', 'Badrock', '240746566', 'Oldsmobile', 'WAUDF78E08A576067', '2024-12-09 22:00:27');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Earl', 'Garman', '838517039', 'Mercury', 'ZHWGU6BZ3CL508927', '2024-11-14 10:35:32');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Sioux', 'Legon', '276736609', 'Oldsmobile', '19UUA65515A835632', '2024-12-05 22:59:18');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Thor', 'Rasor', '723764523', 'Toyota', 'WAUVT64B84N307661', '2024-08-31 12:13:25');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Kacey', 'George', '849588199', 'Mitsubishi', 'WAUBF78K19N109490', '2024-09-07 10:39:38');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Stafani', 'Glidden', '375371634', 'Kia', '4T1BD1FK2EU381826', '2025-04-27 15:41:50');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Tommie', 'Hedditch', '681013941', 'Nissan', '1C3CCBCGXDN657619', '2024-12-27 18:44:24');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Matilda', 'Gow', '612314028', 'Nissan', '2G4GR5EK4C9838209', '2025-01-23 05:51:41');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Carola', 'Grotty', '732775360', 'Chrysler', '1D4PT6GX3BW082854', '2025-05-01 11:36:17');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Marje', 'Moyser', '231988228', 'GMC', 'WA1CGBFE4ED847606', '2025-07-06 09:13:19');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Phyllys', 'Triggol', '993911607', 'Chevrolet', 'SAJWA4EC5EM714175', '2024-08-20 00:09:01');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Didi', 'Croxford', '601148276', 'Saturn', '1G6DS1E3XC0340185', '2025-02-24 00:05:10');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Verina', 'Leavens', '175513689', 'Dodge', '1C4RDJEG2EC051013', '2024-11-28 03:28:19');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Lind', 'Rubie', '883659316', 'Volvo', 'SCBLE47K48C171523', '2025-03-21 13:53:32');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Jody', 'Redfearn', '270420986', 'Chevrolet', 'SCBLC37F05C427977', '2025-03-24 11:11:36');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Jerome', 'Collocott', '592238014', 'Buick', 'WAU4GBFBXBN615904', '2025-06-05 16:39:26');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Ulberto', 'Mighele', '717162046', 'Jeep', 'WAU3GBFC2DN164023', '2025-03-27 16:50:55');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Hilda', 'Kopec', '677481630', 'Ford', 'WDDHF5GB8AA295209', '2025-07-02 21:58:28');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Aigneis', 'Lorkin', '616252011', 'Toyota', '1N6AF0KX4FN729396', '2024-11-23 21:13:16');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Mariska', 'Mogie', '249411199', 'Audi', '1G4HJ5EMXAU071172', '2024-11-06 15:09:10');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Drugi', 'Burlay', '192313003', 'Lexus', '1G6DS8ED9B0620888', '2025-02-07 09:27:28');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Geri', 'Crocumbe', '913477285', 'Ford', '1G4HK5ESXBU834580', '2024-08-15 06:24:32');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Antonius', 'Passingham', '958081114', 'Land Rover', 'WA1LGBFEXFD653406', '2025-01-26 00:38:55');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Cornelius', 'Thridgould', '896919398', 'Honda', '1G6DC8E59C0821021', '2024-09-30 18:41:44');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Noel', 'Ownsworth', '661856140', 'Chrysler', 'WBAKF3C53BE178861', '2025-08-10 17:49:29');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Brad', 'Marsden', '326429907', 'Volkswagen', 'WA1CGBFE1BD663252', '2024-10-06 11:39:15');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Waldon', 'Wonfor', '767702583', 'Chevrolet', 'WBA3A5G54CN140338', '2024-12-10 18:07:57');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Roderigo', 'Parncutt', '429094056', 'Lexus', '5FRYD4H82EB180257', '2024-08-29 23:47:48');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Nerte', 'Nappin', '146998464', 'BMW', '1N6AA0CA3AN013820', '2024-09-22 10:55:59');
insert into Courier (first_name, last_name, contact_number, vehicle_type, license_number, created_at) values ('Cristabel', 'Dood', '185304683', 'Mitsubishi', 'SAJWA4FB4EL981402', '2025-02-06 11:55:18');

SELECT * FROM Courier;

-- Package Type
INSERT INTO PackageType (classification_name) VALUES ("GENERAL"), ("DANGEROUS"), ("AWKWARD"), ("REEFER"), ("REEFER DANGEROUS"), ("AWKWARD DANGEROUS");

-- Package Status
INSERT INTO PackageStatus (status_name) VALUES ("PENDING"),("ACCEPTED"),("REJECTED"),("LOADED TO CONTAINER"),("IN TRANSIT"),("IN CUSTOMS PROCESSING"),
("HANDED TO TRUCKING SERVICES"),("OUT FOR DELIVERY"),("DELIVERED"),("PACKAGE LOST"),("FAILED DELIVERY");

-- Package
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-04 18:23:35', '2025-07-22 21:18:18', 3, 4.27, 'Duis mattis egestas metus.', 67, 69, 35, '2024-09-05 16:13:43');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-08-04 04:19:46', '2025-03-05 05:24:49', 3, 1.4, 'Aliquam erat volutpat. In congue.', 67, 64, 56, '2024-08-15 20:55:03');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-11 08:32:10', '2025-02-23 09:17:02', 6, 2.43, 'Phasellus sit amet erat.', 17, 79, 72, '2024-09-10 08:17:01');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-12 21:26:56', '2025-03-24 21:24:15', 1, 4.04, 'Praesent blandit. Nam nulla.', 35, 52, 16, '2024-09-07 19:14:33');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-08-27 10:49:03', '2025-03-22 12:41:55', 3, 3.03, 'Vivamus tortor.', 4, 23, 74, '2024-08-21 22:26:35');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-08 17:31:31', '2025-05-13 10:07:01', 5, 4.8, 'Nulla ut erat id mauris vulputate elementum. Nullam varius.', 45, 55, 55, '2024-08-12 16:56:59');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-22 17:08:08', '2025-04-25 07:51:06', 6, 4.32, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 5, 76, 56, '2024-08-29 21:55:52');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-05 08:10:36', '2025-06-09 13:43:13', 3, 2.76, 'Vivamus tortor. Duis mattis egestas metus.', 52, 31, 58, '2024-09-01 01:28:17');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-20 04:50:58', '2025-07-07 09:46:04', 2, 4.55, 'Proin interdum mauris non ligula pellentesque ultrices.', 23, 58, 59, '2024-08-15 01:39:15');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-08 03:52:11', '2025-03-22 06:32:09', 4, 4.03, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 63, 76, 65, '2024-08-27 23:36:39');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-07 05:19:06', '2025-05-16 18:44:27', 6, 4.75, 'Maecenas tincidunt lacus at velit.', 70, 77, 76, '2024-08-27 12:18:54');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-06-02 01:34:35', '2025-07-12 12:39:57', 6, 2.8, 'Cras non velit nec nisi vulputate nonummy.', 14, 62, 56, '2024-09-09 18:34:19');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-02 07:34:45', '2025-07-21 19:18:41', 2, 4.64, 'Morbi non quam nec dui luctus rutrum. Nulla tellus.', 25, 67, 20, '2024-08-22 19:23:19');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-09-23 19:10:18', '2025-03-02 20:35:01', 3, 1.68, 'In eleifend quam a odio.', 22, 74, 2, '2024-09-02 08:47:14');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-11 09:28:41', '2025-04-30 21:47:05', 6, 4.23, 'Nunc rhoncus dui vel sem. Sed sagittis.', 8, 27, 58, '2024-08-30 04:51:08');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-13 07:02:46', '2025-04-30 15:18:45', 4, 4.03, 'In congue. Etiam justo.', 10, 68, 24, '2024-08-28 01:59:06');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-03 03:35:18', '2025-03-07 23:03:31', 5, 2.63, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', 8, 47, 54, '2024-09-07 05:11:11');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-06 09:48:19', '2025-03-19 09:29:34', 5, 3.82, 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 80, 67, 71, '2024-08-18 08:53:41');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-11 20:34:26', '2025-02-26 21:49:19', 6, 4.19, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 75, 17, 57, '2024-08-25 15:35:50');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-30 17:25:33', '2025-02-23 04:54:22', 5, 3.04, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.', 33, 79, 6, '2024-09-11 12:43:58');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-14 08:30:30', '2025-03-01 22:14:21', 5, 1.05, 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', 80, 8, 43, '2024-08-22 17:58:12');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-08-18 09:42:06', '2025-03-30 14:48:19', 1, 1.53, 'Morbi a ipsum. Integer a nibh.', 6, 43, 27, '2024-08-20 06:29:52');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-08-12 00:20:14', '2025-06-22 23:15:44', 1, 3.51, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 79, 38, 45, '2024-09-01 10:46:47');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-21 07:23:28', '2025-03-15 19:33:28', 4, 1.91, 'Proin risus.', 44, 27, 20, '2024-08-27 03:15:56');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-03 08:53:55', '2025-03-17 22:44:47', 2, 2.41, 'Etiam justo. Etiam pretium iaculis justo.', 78, 16, 18, '2024-08-15 16:00:41');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-13 07:57:23', '2025-05-14 13:26:18', 4, 4.1, 'Sed vel enim sit amet nunc viverra dapibus.', 54, 68, 72, '2024-08-24 07:50:43');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-10 05:43:16', '2025-02-13 12:02:19', 5, 4.56, 'Maecenas ut massa quis augue luctus tincidunt.', 8, 38, 12, '2024-09-07 21:25:30');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-10 00:49:34', '2025-05-11 13:32:47', 4, 3.6, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', 80, 16, 17, '2024-09-02 12:29:55');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-04 18:56:19', '2025-01-27 12:18:34', 3, 3.32, 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 4, 56, 42, '2024-09-02 19:37:28');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-05-09 07:49:47', '2025-07-14 04:02:26', 6, 1.46, 'Nulla ut erat id mauris vulputate elementum. Nullam varius.', 1, 37, 41, '2024-09-06 01:42:05');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-08 10:16:34', '2025-08-03 14:38:00', 4, 3.88, 'Donec vitae nisi.', 41, 13, 40, '2024-08-13 08:27:57');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-03 00:22:19', '2025-07-12 12:51:22', 2, 2.25, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 57, 44, 77, '2024-08-24 05:32:41');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-02 07:40:47', '2025-01-29 21:20:57', 5, 4.33, 'In quis justo. Maecenas rhoncus aliquam lacus.', 15, 45, 3, '2024-08-19 21:16:57');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-14 13:15:22', '2025-06-25 08:31:44', 2, 3.5, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', 46, 62, 26, '2024-08-25 06:42:07');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-26 15:41:48', '2025-03-06 17:11:54', 3, 1.55, 'Morbi quis tortor id nulla ultrices aliquet.', 32, 21, 30, '2024-09-08 12:53:55');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-23 21:19:28', '2025-07-23 16:18:42', 6, 4.72, 'Etiam pretium iaculis justo.', 16, 64, 33, '2024-08-15 13:18:39');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-29 13:17:24', '2025-04-12 02:18:53', 4, 3.34, 'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', 61, 29, 77, '2024-08-29 22:07:08');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-18 19:15:33', '2025-02-19 04:13:37', 2, 1.82, 'In hac habitasse platea dictumst.', 69, 13, 60, '2024-08-20 17:16:51');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-30 05:45:28', '2025-02-19 10:35:35', 6, 1.62, 'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 69, 73, 63, '2024-08-24 22:22:41');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-08-01 07:09:32', '2025-06-29 22:56:01', 4, 3.17, 'Duis mattis egestas metus. Aenean fermentum.', 12, 33, 6, '2024-08-28 15:14:15');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-08-23 21:49:49', '2025-05-25 10:52:23', 5, 4.57, 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 8, 77, 47, '2024-08-17 00:32:45');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-21 16:31:43', '2025-02-17 04:06:21', 3, 1.58, 'Proin at turpis a pede posuere nonummy. Integer non velit.', 58, 27, 60, '2024-08-18 04:31:13');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-22 09:06:56', '2025-03-21 16:03:43', 4, 3.4, 'Vivamus tortor. Duis mattis egestas metus.', 23, 30, 19, '2024-08-30 12:27:48');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-23 04:24:25', '2025-03-06 23:42:22', 3, 4.32, 'Ut at dolor quis odio consequat varius.', 37, 57, 24, '2024-08-16 07:11:23');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-05-10 13:57:16', '2025-04-07 08:50:24', 1, 3.23, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', 18, 51, 1, '2024-09-07 19:29:42');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-08 10:12:24', '2025-03-01 13:22:48', 4, 4.45, 'Quisque ut erat. Curabitur gravida nisi at nibh.', 51, 47, 48, '2024-09-09 00:29:07');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-04 22:58:36', '2025-05-18 12:26:23', 1, 3.21, 'Donec dapibus.', 5, 22, 75, '2024-09-07 14:09:28');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-06-11 10:51:24', '2025-02-15 14:53:48', 1, 3.6, 'Curabitur at ipsum ac tellus semper interdum.', 65, 1, 48, '2024-08-13 23:45:41');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-02 16:52:28', '2025-03-21 11:30:46', 6, 3.03, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 73, 54, 61, '2024-08-31 13:18:44');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-02 16:01:32', '2025-01-24 20:06:21', 2, 2.46, 'Nulla tempus.', 62, 10, 25, '2024-08-25 11:58:04');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-16 10:34:50', '2025-06-22 14:34:39', 6, 4.34, 'Integer ac neque. Duis bibendum.', 17, 61, 3, '2024-08-18 05:05:08');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-30 15:38:33', '2025-02-25 19:39:45', 1, 3.39, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', 26, 57, 35, '2024-08-20 20:16:23');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-06-13 10:31:00', '2025-03-28 13:23:41', 5, 3.94, 'Nulla ut erat id mauris vulputate elementum.', 23, 29, 17, '2024-09-05 14:00:28');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-15 19:17:15', '2025-02-25 19:53:13', 5, 4.17, 'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 39, 9, 28, '2024-08-16 21:21:22');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-07 07:31:34', '2025-04-12 11:29:22', 6, 2.44, 'Nunc purus.', 47, 26, 70, '2024-08-12 13:14:57');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-06-04 07:26:04', '2025-07-03 13:26:09', 1, 3.44, 'Integer ac leo.', 16, 26, 24, '2024-09-10 05:52:04');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-17 07:12:31', '2025-07-16 00:00:39', 2, 4.91, 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', 52, 13, 43, '2024-09-11 19:17:03');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-04 17:46:20', '2025-06-16 12:03:36', 1, 1.19, 'Quisque ut erat. Curabitur gravida nisi at nibh.', 13, 30, 37, '2024-08-17 07:02:23');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-11 05:14:34', '2025-07-14 02:41:02', 4, 2.28, 'Fusce consequat.', 5, 47, 64, '2024-09-09 00:01:10');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-25 09:12:17', '2025-02-11 07:48:13', 3, 2.86, 'Ut tellus. Nulla ut erat id mauris vulputate elementum.', 30, 76, 14, '2024-08-20 00:24:33');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-14 02:53:32', '2025-04-05 17:11:49', 6, 4.75, 'Aenean lectus.', 45, 25, 3, '2024-08-14 22:50:09');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-10 22:04:58', '2025-05-29 11:02:48', 6, 1.72, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', 8, 48, 38, '2024-08-28 00:34:11');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-09-18 16:31:19', '2025-03-02 22:48:54', 2, 1.9, 'Nunc purus. Phasellus in felis.', 10, 10, 69, '2024-08-25 14:34:37');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-14 12:51:19', '2025-01-30 14:42:21', 4, 4.38, 'Praesent blandit.', 57, 14, 22, '2024-08-30 21:58:02');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-28 18:31:22', '2025-02-22 06:02:54', 5, 4.8, 'Cras in purus eu magna vulputate luctus.', 58, 56, 50, '2024-09-11 02:38:30');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-08-16 11:16:40', '2025-02-04 11:43:28', 5, 3.46, 'Cras in purus eu magna vulputate luctus.', 46, 43, 63, '2024-09-10 11:20:47');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-15 17:00:53', '2025-07-22 10:37:19', 3, 4.62, 'Etiam pretium iaculis justo.', 55, 52, 68, '2024-09-08 03:15:39');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-01 13:43:45', '2025-02-17 17:57:17', 2, 1.57, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', 1, 5, 11, '2024-08-13 21:07:54');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-10-12 05:02:41', '2025-01-25 15:06:03', 3, 4.71, 'Etiam pretium iaculis justo. In hac habitasse platea dictumst.', 24, 54, 65, '2024-08-26 23:36:11');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-07-02 19:48:24', '2025-07-02 15:47:03', 6, 4.26, 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 48, 52, 65, '2024-08-17 04:57:33');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-06-12 20:01:10', '2025-03-28 07:01:02', 6, 3.54, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 4, 31, 53, '2024-08-14 05:05:09');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-12-06 11:49:59', '2025-07-16 01:21:12', 1, 2.81, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', 77, 49, 55, '2024-09-05 17:28:15');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-30 13:25:43', '2025-03-24 22:33:27', 4, 2.22, 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 48, 1, 42, '2024-09-08 00:34:22');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-29 06:14:20', '2025-04-29 19:58:49', 6, 4.44, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.', 40, 60, 67, '2024-09-10 21:36:26');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-04 14:49:21', '2025-02-27 07:21:36', 6, 3.27, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 20, 75, 47, '2024-08-16 02:44:53');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-04-29 18:24:34', '2025-06-15 22:41:57', 6, 4.82, 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 31, 14, 36, '2024-08-21 03:51:40');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-01-20 03:01:11', '2025-02-21 03:57:33', 1, 2.22, 'Quisque ut erat. Curabitur gravida nisi at nibh.', 43, 72, 67, '2024-09-03 02:42:32');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2024-11-26 23:01:38', '2025-02-03 05:28:07', 3, 4.76, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', 62, 65, 44, '2024-08-25 01:06:17');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-03-06 17:26:31', '2025-07-09 22:21:28', 1, 4.11, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 8, 30, 66, '2024-08-28 13:19:48');
insert into Package (pickup_date, delivery_date, package_type_id, weight, contents_description, sender_id, recipient_id, courier_id, created_at) values ('2025-02-07 16:16:27', '2025-03-04 12:31:19', 2, 4.39, 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.', 62, 20, 47, '2024-09-11 12:06:11');

-- Tracking Event
INSERT INTO trackingevent (description, package_status_id, package_id, location_id)
VALUES
("Package order has been created and is awaiting processing", 1, 23, 77),
("Package has been accepted at the origin facility", 2, 45, 18),
("Package was rejected due to incomplete documentation", 3, 7, 59),
("Package loaded into shipping container at port", 4, 32, 44),
("Package is currently in transit to the destination", 5, 68, 36),
("Package is undergoing customs inspection", 6, 56, 12),
("Package handed over to trucking company for local delivery", 7, 11, 73),
("Package is out for delivery to the recipient", 8, 78, 5),
("Package has been successfully delivered to the recipient", 9, 42, 64),
("Package reported lost during transit", 10, 14, 40),
("Package order has been created and is awaiting processing", 1, 66, 19),
("Package has been accepted at the origin facility", 2, 58, 8),
("Package was rejected due to incomplete documentation", 3, 25, 55),
("Package loaded into shipping container at port", 4, 12, 39),
("Package is currently in transit to the destination", 5, 37, 4),
("Package is undergoing customs inspection", 6, 20, 67),
("Package handed over to trucking company for local delivery", 7, 73, 9),
("Package is out for delivery to the recipient", 8, 18, 28),
("Package has been successfully delivered to the recipient", 9, 5, 45),
("Package reported lost during transit", 10, 27, 61),
("Package order has been created and is awaiting processing", 1, 80, 16),
("Package has been accepted at the origin facility", 2, 31, 78),
("Package was rejected due to incomplete documentation", 3, 41, 2),
("Package loaded into shipping container at port", 4, 15, 33),
("Package is currently in transit to the destination", 5, 77, 70),
("Package is undergoing customs inspection", 6, 35, 6),
("Package handed over to trucking company for local delivery", 7, 3, 50),
("Package is out for delivery to the recipient", 8, 48, 29),
("Package has been successfully delivered to the recipient", 9, 50, 25),
("Package reported lost during transit", 10, 64, 11),
("Package order has been created and is awaiting processing", 1, 17, 46),
("Package has been accepted at the origin facility", 2, 4, 23),
("Package was rejected due to incomplete documentation", 3, 9, 1),
("Package loaded into shipping container at port", 4, 29, 71),
("Package is currently in transit to the destination", 5, 54, 63),
("Package is undergoing customs inspection", 6, 63, 31),
("Package handed over to trucking company for local delivery", 7, 13, 60),
("Package is out for delivery to the recipient", 8, 36, 32),
("Package has been successfully delivered to the recipient", 9, 22, 75),
("Package reported lost during transit", 10, 47, 15),
("Package order has been created and is awaiting processing", 1, 38, 26),
("Package has been accepted at the origin facility", 2, 39, 54),
("Package was rejected due to incomplete documentation", 3, 71, 3),
("Package loaded into shipping container at port", 4, 75, 27),
("Package is currently in transit to the destination", 5, 55, 41),
("Package is undergoing customs inspection", 6, 19, 68),
("Package handed over to trucking company for local delivery", 7, 49, 42),
("Package is out for delivery to the recipient", 8, 40, 17),
("Package has been successfully delivered to the recipient", 9, 26, 79),
("Package reported lost during transit", 10, 28, 58),
("Package order has been created and is awaiting processing", 1, 60, 52),
("Package has been accepted at the origin facility", 2, 46, 35),
("Package was rejected due to incomplete documentation", 3, 24, 14),
("Package loaded into shipping container at port", 4, 79, 22),
("Package is currently in transit to the destination", 5, 43, 13),
("Package is undergoing customs inspection", 6, 52, 66),
("Package handed over to trucking company for local delivery", 7, 53, 49),
("Package is out for delivery to the recipient", 8, 1, 38),
("Package has been successfully delivered to the recipient", 9, 10, 24),
("Package reported lost during transit", 10, 34, 72),
("Package order has been created and is awaiting processing", 1, 8, 51),
("Package has been accepted at the origin facility", 2, 2, 62),
("Package was rejected due to incomplete documentation", 3, 70, 30),
("Package loaded into shipping container at port", 4, 6, 65),
("Package is currently in transit to the destination", 5, 59, 76),
("Package is undergoing customs inspection", 6, 30, 48),
("Package handed over to trucking company for local delivery", 7, 16, 43),
("Package is out for delivery to the recipient", 8, 61, 47),
("Package has been successfully delivered to the recipient", 9, 33, 20),
("Package reported lost during transit", 10, 21, 21),
("Package order has been created and is awaiting processing", 1, 74, 37),
("Package has been accepted at the origin facility", 2, 65, 74),
("Package was rejected due to incomplete documentation", 3, 44, 57),
("Package loaded into shipping container at port", 4, 57, 56),
("Package is currently in transit to the destination", 5, 72, 7),
("Package is undergoing customs inspection", 6, 67, 80),
("Package handed over to trucking company for local delivery", 7, 62, 53),
("Package is out for delivery to the recipient", 8, 51, 34),
("Package has been successfully delivered to the recipient", 9, 69, 10),
("Package reported lost during transit", 10, 76, 69);