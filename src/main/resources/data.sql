INSERT INTO app_user (name, email, password) VALUES
('Shubham Rathore', 'shubham@test.com', 'shubham@123'),
('Anjali Singh', 'anjali.singh@test.com', 'anjali@123'),
('Rahul Sharma', 'rahul.sharma@test.com', 'rahul@123'),
('Sneha Verma', 'sneha.verma@test.com', 'sneha@123'),
('Vikram Joshi', 'vikram.joshi@test.com', 'vikram@123'),
('Priya Mehta', 'priya.mehta@test.com', 'priya@123'),
('Amit Tiwari', 'amit.tiwari@test.com', 'amit@123'),
('Neha Gupta', 'neha.gupta@test.com', 'neha@123'),
('Rohan Patel', 'rohan.patel@test.com', 'rohan@123'),
('Kavita Kapoor', 'kavita.kapoor@test.com', 'kavita@123');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'DRIVER'),
(2, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(5, 'DRIVER'),
(6, 'RIDER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER');

INSERT INTO rider (id, user_id, rating) VALUES
(1,1,4.9);

INSERT INTO driver (id, user_id, rating, available, current_location) VALUES
(2, 2, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),
(3, 3, 4.5, true, ST_GeomFromText('POINT(72.8777 19.0760)', 4326)),
(4, 4, 4.8, false, ST_GeomFromText('POINT(88.3639 22.5726)', 4326)),
(5, 5, 4.6, true, ST_GeomFromText('POINT(80.2707 13.0827)', 4326)),
(6, 6, 4.9, true, ST_GeomFromText('POINT(77.5946 12.9716)', 4326)),
(7, 7, 4.4, false, ST_GeomFromText('POINT(75.8577 22.7196)', 4326)),
(8, 8, 4.7, true, ST_GeomFromText('POINT(73.8567 18.5204)', 4326)),
(9, 9, 4.6, true, ST_GeomFromText('POINT(76.6413 12.2958)', 4326)),
(10, 10, 4.5, false, ST_GeomFromText('POINT(78.4867 17.3850)', 4326));