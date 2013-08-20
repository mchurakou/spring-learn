DROP TABLE IF EXISTS TELEPHON;
DROP TABLE IF EXISTS HOBBY;
DROP TABLE IF EXISTS CONTACT;
DROP TABLE IF EXISTS CONTACT_HOBBY_DETAIL;

CREATE TABLE HOBBY (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(20) NOT NULL,
	VERSION INT NOT NULL DEFAULT 0,
	UNIQUE UQ_HOBBY_NAME (NAME),
	PRIMARY KEY (ID)
);

CREATE TABLE CONTACT (
	ID INT NOT NULL AUTO_INCREMENT,
	FIRST_NAME VARCHAR(20) NOT NULL,
	LAST_NAME VARCHAR(20) NOT NULL,
	BIRTH_DATE DATE,
	VERSION INT NOT NULL DEFAULT 0,
	UNIQUE UQ_CONTACT_FIRST_LAST (FIRST_NAME, LAST_NAME),
	PRIMARY KEY (ID)
);

CREATE TABLE TELEPHON(
    ID INT NOT NULL AUTO_INCREMENT,
	CONTACT_ID INT NOT NULL,
	TEL_TYPE VARCHAR(20) NOT NULL,
    TEL_NUMBER VARCHAR(20) NOT NULL,
	VERSION INT NOT NULL DEFAULT 0,
    UNIQUE UQ_TELEPHON_CONTACT_ID_TEL_TYPE (CONTACT_ID, TEL_TYPE),
	PRIMARY KEY (ID),
	CONSTRAINT FK_TELEPHON_CONTACT FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID)
);

CREATE TABLE CONTACT_HOBBY (
	ID INT NOT NULL AUTO_INCREMENT,
    CONTACT_ID INT NOT NULL,
	HOBBY_ID INT NOT NULL,
	UNIQUE UQ_CONTACT_HOBBY (CONTACT_ID, HOBBY_ID),
	VERSION INT NOT NULL DEFAULT 0,
    CONSTRAINT FK_CONTACT_HOBBY_CONTACT FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID) ON DELETE CASCADE,
	CONSTRAINT FK_CONTACT_HOBBY_HOBYY FOREIGN KEY (HOBBY_ID) REFERENCES HOBBY (ID) ON DELETE CASCADE,
	PRIMARY KEY (ID)
);












