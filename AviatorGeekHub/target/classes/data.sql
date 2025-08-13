-- Seed Users with BCrypt encrypted passwords (password: password)
INSERT INTO users (id, username, password, name, email, role, enabled) VALUES
(1, 'admin', '$2a$10$hHohsb7b2cwe26fgMmJcTukBALJ684TUoHwmH5Av1yuwrMByOGN1C', 'Admin User', 'admin@aviation.com', 'ADMIN', true),
(2, 'pilot1', '$2a$10$hHohsb7b2cwe26fgMmJcTukBALJ684TUoHwmH5Av1yuwrMByOGN1C', 'Captain Smith', 'pilot@aviation.com', 'PILOT', true),
(3, 'spotter1', '$2a$10$hHohsb7b2cwe26fgMmJcTukBALJ684TUoHwmH5Av1yuwrMByOGN1C', 'John Spotter', 'spotter@aviation.com', 'SPOTTER', true),
(4, 'student1', '$2a$10$hHohsb7b2cwe26fgMmJcTukBALJ684TUoHwmH5Av1yuwrMByOGN1C', 'Ava Student', 'student@aviation.com', 'STUDENT', true),
(5, 'fan1', '$2a$10$hHohsb7b2cwe26fgMmJcTukBALJ684TUoHwmH5Av1yuwrMByOGN1C', 'Liam Fan', 'fan@aviation.com', 'FAN', true);

-- Seed Flights
INSERT INTO flights (id, flight_number, origin, destination, status, aircraft) VALUES
(1, 'AI101', 'Delhi', 'New York', 'On Time', 'Boeing 777'),
(2, 'EK215', 'Dubai', 'Los Angeles', 'Delayed', 'Airbus A380'),
(3, 'SQ318', 'Singapore', 'London', 'On Time', 'Boeing 787'),
(4, 'BA001', 'London', 'New York', 'On Time', 'Boeing 747'),
(5, 'LH401', 'Frankfurt', 'Tokyo', 'Delayed', 'Airbus A350');

-- Seed Logbook Entries
INSERT INTO logbook_entries (id, pilot_id, flight_date, aircraft, duration_hours, flight_number, origin, destination, remarks) VALUES
(1, 2, '2024-01-15', 'Boeing 737', 5.2, 'AI101', 'Delhi', 'New York', 'Smooth flight, good weather'),
(2, 2, '2024-01-10', 'Airbus A320', 3.8, 'EK215', 'Dubai', 'Los Angeles', 'Strong headwinds'),
(3, 2, '2024-01-05', 'Boeing 777', 7.1, 'SQ318', 'Singapore', 'London', 'Excellent conditions');

-- Seed Spotter Submissions
INSERT INTO spotter_submissions (id, spotter_id, aircraft, location, description, approved, submission_date) VALUES
(1, 3, 'Airbus A380', 'Mumbai Airport', 'Spotted Emirates A380 during takeoff', true, '2024-01-15 10:30:00'),
(2, 3, 'Boeing 747', 'Delhi Airport', 'British Airways 747 on final approach', false, '2024-01-14 15:45:00'),
(3, 3, 'Airbus A350', 'Bangalore Airport', 'Lufthansa A350 at gate', true, '2024-01-13 09:20:00');

-- Seed Resources
INSERT INTO resources (id, title, url, description, resource_type, category, created_date, updated_date) VALUES
(1, 'Introduction to Aerodynamics', 'https://example.com/aerodynamics', 'Basic principles of flight aerodynamics', 'ARTICLE', 'AERODYNAMICS', '2024-01-01 00:00:00', '2024-01-01 00:00:00'),
(2, 'Air Traffic Control Basics', 'https://example.com/atc', 'Learn about ATC procedures and communications', 'VIDEO', 'NAVIGATION', '2024-01-01 00:00:00', '2024-01-01 00:00:00'),
(3, 'Aviation Regulations', 'https://example.com/regulations', 'Understanding aviation laws and regulations', 'BOOK', 'REGULATIONS', '2024-01-01 00:00:00', '2024-01-01 00:00:00'),
(4, 'Weather and Flying', 'https://example.com/weather', 'How weather affects aviation operations', 'ARTICLE', 'METEOROLOGY', '2024-01-01 00:00:00', '2024-01-01 00:00:00');

-- Seed Quizzes
INSERT INTO quizzes (id, question, option_a, option_b, option_c, correct_answer, category, difficulty) VALUES
(1, 'What does ATC stand for?', 'Air Traffic Control', 'Air Transport Commission', 'Aircraft Technical Checklist', 'A', 'GENERAL', 'EASY'),
(2, 'Which aircraft manufacturer produces the 737?', 'Airbus', 'Boeing', 'Embraer', 'B', 'AIRCRAFT', 'EASY'),
(3, 'What is the primary function of flaps?', 'Increase speed', 'Increase lift at low speeds', 'Reduce fuel consumption', 'B', 'AERODYNAMICS', 'MEDIUM'),
(4, 'What does IFR stand for?', 'Instrument Flight Rules', 'International Flight Regulations', 'In-Flight Requirements', 'A', 'NAVIGATION', 'MEDIUM'),
(5, 'Which color indicates a runway edge light?', 'White', 'Blue', 'Green', 'A', 'NAVIGATION', 'EASY');

-- Seed Favourites
INSERT INTO favourites (id, fan_id, flight_id, added_date) VALUES
(1, 5, 1, '2024-01-15 12:00:00'),
(2, 5, 3, '2024-01-14 16:30:00');
