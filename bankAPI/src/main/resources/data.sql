DROP TABLE IF EXISTS currency;
CREATE TABLE currency (
   	code VARCHAR(10) PRIMARY KEY NOT NULL,
	chinese VARCHAR(50) NOT NULL
);


INSERT INTO currency (code, chinese) VALUES ('USD', '美元');
INSERT INTO currency (code, chinese) VALUES ('GBP', '英鎊');
INSERT INTO currency (code, chinese) VALUES ('EUR', '歐元');