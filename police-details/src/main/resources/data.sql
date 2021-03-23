INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Signal Jump','100');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Riding without helmet','200');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Not wearing Mask','300');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Triple Riding','400');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Rash Driving','500');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Wrong side','600');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Wrong Parking','700');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('No Vaid Document','800');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Tint Windows','900');

INSERT INTO violation_details (violation_name, violation_penalty) VALUES ('Drink and Drive','1000');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test1','i20','KA12-MA-1947','10/11/2020',
'100','Pending','Signal Jump');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test1','i20','KA12-MA-1947','10/01/2021',
'1000','Pending','Drink and Drive');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test2','i10','KA05-MA-1857','10/12/2020',
'100','Paid','Signal Jump');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test3','Santro','KA11-MA-1942','10/12/2020',
'100','Pending','Signal Jump');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test4','Ritz','KA04-MA-1757','10/03/2021',
'100','Pending','Signal Jump');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test4','Ritz','KA04-MA-1757','11/03/2021',
'500','Pending','Rash Driving');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test5','Pulsar 150','KA01-MA-1902','10/03/2020',
'200','Pending','Riding without helmet');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test5','Pulsar 150','KA01-MA-1902','11/03/2021',
'200','Pending','Riding without helmet');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test5','Pulsar 150','KA01-MA-1902','12/03/2021',
'200','Pending','Riding without helmet');

INSERT INTO customer_violation_details (customer_name, vehicle_name, vehicle_reg_number, violation_date,
violation_penalty, violation_status, violation_type) values ('Test5','Pulsar 150','KA01-MA-1902','13/03/2021',
'400','Pending','Triple Riding');


