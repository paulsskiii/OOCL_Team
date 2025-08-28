INSERT INTO `user_credentials` (`username`, `password`, `is_active`) VALUES
("test", "test_password", TRUE),
("test2", "test2_password", TRUE)
;

INSERT INTO `user_information` (`email`, `contact_number`, `user_credentials_id`) VALUES
("testuser@gmail.com", "+639236439243", 1),
("testuser2@gmail.com", "+639174439315", 2)
;

INSERT INTO `ports` (`id`, `name`) VALUES
("PHAEL", "Alabel"),
("PHAGO", "Agoncillo"),
("PHAGL", "Angeles"),
("PHAGT", "Angat"),
("PHEUQ", "Antique Evelio Javier Apt"),
("PHARA", "Aras Asan/Bislig")
;

INSERT INTO `status` (`id`, `name`) VALUES
("PD", "Pending"),
("AR", "Arrived"),
("TR", "In Transit"),
("ED", "Expectd to Depart"),
("EA", "Expected to Arrive"),
("CA", "Cancelled")
;

INSERT INTO `containers` (`name`, `origin`, `destination`, `status`, `weight`, `departure_date`, `arrival_date`, `booked_by`) VALUES
("OOLU164854", "PHAEL", "PHAGO", "ED", 2353.54, "2025-08-28 13:43:00", NULL, 1),
("TEMU465185", "PHARA", "PHAEL", "EA", 2353.54, "2025-08-25 11:42:05", "2025-08-30 16:30:00", 1),
("TLLU637854", "PHEUQ", "PHAGT", "PD", 2353.54, NULL, NULL, 2)
;


-- Verify added data
SELECT * FROM containers;
SELECT * FROM status;
SELECT * FROM user_credentials;
SELECT * FROM user_information;
SELECT * FROM ports;