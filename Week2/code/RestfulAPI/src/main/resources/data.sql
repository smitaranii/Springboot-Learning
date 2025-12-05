INSERT INTO departments (id, title, is_active, size, budget, allocation, department_type, created_at) VALUES
(1, 'Human Resources', true, 25, 500000, 250000, 'HR', NOW()),
(2, 'Finance Core', true, 40, 750000, 500000, 'FINANCE', NOW()),
(3, 'Sales Team A', true, 30, 300000, 150000, 'SALES', NOW()),
(4, 'IT Support', true, 15, 200000, 120000, 'IT', NOW()),
(5, 'Corporate Finance', true, 35, 900000, 850000, 'FINANCE', NOW()),
(6, 'Digital Sales', true, 50, 800000, 600000, 'SALES', NOW()),
(7, 'Tech Innovation', true, 60, 950000, 700000, 'IT', NOW()),
(8, 'HR Recruitment', true, 20, 250000, 150000, 'HR', NOW()),
(9, 'Payroll Department', true, 18, 400000, 250000, 'FINANCE', NOW()),
(10, 'IT Infrastructure', true, 45, 850000, 500000, 'IT', NOW());
INSERT INTO employees
(id, name, email, age, date_of_joining, next_appraisal_date, is_active, is_inactive, department, profile_url, credit_card_number, negative_bonus, debt, leave_balance, commission, performance_rating, role, salary)
VALUES
(1, 'Amit Shah', 'amit@example.com', 30, '2022-01-10', '2025-12-01', true, false, 'HR',
 'https://example.com/amit', '4111111111111111', -500.00, -200.00, 5.00, 200.50, 8, 'ADMIN', 55000),

(2, 'Neha Singh', 'neha@example.com', 28, '2021-05-15', '2026-01-10', true, false, 'IT',
 'https://example.com/neha', '4222222222222', -300.00, 0.00, 3.50, 150.25, 9, 'USER', 45000),

(3, 'Rahul Verma', 'rahul@example.com', 35, '2020-03-20', '2026-03-01', true, false, 'SALES',
 'https://example.com/rahul', '5555555555554444', -200.00, -100.00, 4.25, 300.75, 7, 'ADMIN', 62000),

(4, 'Priya Nair', 'priya@example.com', 32, '2019-07-12', '2025-11-15', true, false, 'FINANCE',
 'https://example.com/priya', '378282246310005', -150.00, 0.00, 2.00, 220.50, 9, 'USER', 70000),

(5, 'Karan Patel', 'karan@example.com', 26, '2023-04-18', '2025-12-28', true, false, 'IT',
 'https://example.com/karan', '6011111111111117', -450.00, -50.00, 1.00, 180.90, 6, 'USER', 40000),

(6, 'Simran Kaur', 'simran@example.com', 29, '2020-12-01', '2026-04-10', true, false, 'HR',
 'https://example.com/simran', '4111111111111111', -320.00, 0.00, 5.00, 140.65, 9, 'ADMIN', 52000),

(7, 'Mohit Jain', 'mohit@example.com', 34, '2018-02-14', '2026-06-01', true, false, 'SALES',
 'https://example.com/mohit', '4012888888881881', -200.00, -80.00, 0.00, 180.40, 7, 'USER', 48000),

(8, 'Deepika Rao', 'deepika@example.com', 31, '2019-09-22', '2026-02-20', true, false, 'FINANCE',
 'https://example.com/deepika', '5105105105105100', -100.00, 0.00, 6.00, 210.10, 8, 'ADMIN', 68000),

(9, 'Saurav Das', 'saurav@example.com', 27, '2021-11-30', '2026-08-05', true, false, 'IT',
 'https://example.com/saurav', '4111111111111111', -250.00, -120.00, 2.00, 190.55, 6, 'USER', 47000),

(10, 'Tanvi Mehta', 'tanvi@example.com', 33, '2017-06-18', '2026-03-30', true, false, 'HR',
 'https://example.com/tanvi', '4007000000027', -350.00, 0.00, 4.00, 160.75, 9, 'ADMIN', 75000);
