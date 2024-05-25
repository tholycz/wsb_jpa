insert into address (address_id, address_line1, address_line2, city, postal_code)
            values (1, 'aa', 'bb', 'city1', '62-030'), (2, 'xx', 'yy', 'city2', '62-030'), (3, 'adr', 'adr2', 'city3', '66-030'), (4, 'testowa', '2/3', 'Warszawa', '50-023');

insert into doctor (doctor_id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id)
            values (1, 123, 'maciek.kowalski@test.com', 'Maciek', 'Kowalski', 'SURGEON', '676787878', 1), (2, 456, 'martyna.nowak@test.com', 'Martyna', 'Nowak', 'OCULIST', '23127878', 2);

insert into patient (patient_id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id, age)
            values (1, '1999-02-17', 'tomasz.kosakowski@test.com', 'Tomasz', 'Kosakowski', 564, '893849839', 3, 20), (2, '1998-01-3', 'anna.bosak@test.com', 'Anna', 'Bosak', 989, '787283782', 4, 30);

insert into visit (visit_id, description, time, doctor_id, patient_id)
            values (1, 'wizyta1', '2024-04-08T12:30:00', 1, 1), (2, 'wizyta2', '2024-05-08T13:50:00', 1, 2), (3, 'wizyta3', '2024-02-01T20:30:00', 2, 1), (4, 'wizyta4', '2025-01-01T19:20:11', 2, 2);

insert into medical_treatment (id, description, type, visit_id)
            values (1, 'zapalenie pluc', 'USG', 1), (2, 'bol brzucha', 'EKG', 2), (3, 'bol glowy', 'RTG', 3), (4, 'wypadek sachochodowy', 'RTG', 4), (5, 'wypadek sachochodowy', 'EKG', 4);
