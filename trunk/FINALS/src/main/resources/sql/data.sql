-- HOBBY TABLE
INSERT INTO HOBBY (NAME) 
VALUES ('Swimming');

INSERT INTO HOBBY (NAME) 
VALUES ('Jogging');

INSERT INTO HOBBY (NAME) 
VALUES ('Programming');

INSERT INTO HOBBY (NAME) 
VALUES ('Movies');

INSERT INTO HOBBY (NAME) 
VALUES ('Reading');

-- ROLES TABLE
INSERT INTO ROLES (NAME) 
VALUES ('ROLE_USER');

-- USERS TABLE
INSERT INTO USERS (LOGIN, PASSWORD) 
VALUES ('user', 'user');

INSERT INTO ROLES_USERS (ROLE_ID, USER_ID) 
VALUES (1, 1);


INSERT INTO USERS (LOGIN, PASSWORD) 
VALUES ('user1', 'user1');

INSERT INTO ROLES_USERS (ROLE_ID, USER_ID) 
VALUES (1, 2);


