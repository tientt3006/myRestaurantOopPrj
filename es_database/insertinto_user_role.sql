-- Thêm tài khoản mẫu
INSERT INTO users (firstName, lastName, password, email, phone, roleId) VALUES 
('admin', 'mod', SHA2('123456', 256), 'admin.doe@gmail.com', '0234567890', 2),
('Khanh', 'Nguyen', SHA2('123456', 256), 'khanh@gmail.com', '1234567890', 1),
('Hieu', 'Nguyen', SHA2('123456', 256), 'hieu.doe@gmail.com', '2234567890', 1),
('Huong', 'Nguyen', SHA2('123456', 256), 'huong.doe@gmail.com', '3234567890', 1),
('Son', 'Nguyen', SHA2('123456', 256), 'son.doe@gmail.com', '4234567890', 1),
('Tien', 'Nguyen', SHA2('123456', 256), 'tien.doe@gmail.com', '5234567890', 1);