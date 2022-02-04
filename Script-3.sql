CREATE TABLE ers_reimbursement (

	reimbursement_id serial PRIMARY KEY,
	reimbursement_ammount int,
	reimbursement_submitted TIMESTAMP,
	reimbursement_author_fk int REFERENCES ers_user (user_id ),
	reimbursement_status_fk int REFERENCES ers_reimbursement_status (status_id),
	reimbursement_type_fk int REFERENCES reimbursement_type(type_id )


);

SELECT * FROM ers_reimbursement;

CREATE TABLE ers_user (
	user_id serial PRIMARY KEY,
	ers_username VARCHAR (50) UNIQUE,
	ers_password VARCHAR (50),
	user_f_name TEXT,    --first name
	user_l_name TEXT, --last name 
	user_email VARCHAR (50),
	user_role_id_fk int REFERENCES ers_user_roles(ers_user_roleid)

);

SELECT *FROM ers_user; 
SELECT * FROM ers_user_roles; 



CREATE TABLE reimbursement_type (

type_id serial PRIMARY KEY,
type_name varchar (10)

);
	
CREATE TABLE ers_user_roles (
ers_user_roleid serial PRIMARY KEY,
user_role varchar (10)
	
);

CREATE TABLE ers_reimbursement_status (
status_id serial PRIMARY KEY , 
reimbursement_status VARCHAR (10)
);

SELECT * FROM ers_reimbursement_status;
INSERT INTO ers_reimbursement_status(status_id, reimbursement_status )VALUES (1, 'PENDING'), (2,'APPROVED '), (3,'DENIED');

INSERT INTO reimbursement_type (type_name)
VALUES ('LODGING'), ('TRAVEL'), ('FOOD'), ('OTHER');


ALTER TABLE ers_user ADD email VARCHAR(255) UNIQUE;

ALTER TABLE ers_reimbursement ALTER COLUMN  reimbursement_submitted SET DEFAULT now();

SELECT * FROM reimbursement_type; 

-- REFERENCE
--SELECT * FROM roles;  
--INSERT INTO employees (f_name, l_name, role_id)
--VALUES ('Eugene', 'Krabs', 1),
	--   ('Spongebob', 'Squarepants', 2),
	--   ('Squidward', 'Tentacles', 3),
	--   ('Pearl', 'Krabs', 5);

--SELECT * FROM employees;
