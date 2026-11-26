CREATE TABLE EventRegistration (
  registration_id INT AUTO_INCREMENT PRIMARY KEY,
  student_name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL,
  event_name VARCHAR(100) NOT NULL,
  UNIQUE KEY unique_student_event (email, event_name)
);
