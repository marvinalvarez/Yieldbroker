CREATE TABLE YB_ORDER (
ID BIGINT AUTO_INCREMENT NOT NULL, 
CLIENT_ORDER_ID INTEGER NOT NULL, 
PRICE DECIMAL(10,2) NOT NULL, 
RECEIVED_TIME TIMESTAMP, 
SIDE VARCHAR(5) NOT NULL, 
VOLUME INTEGER NOT NULL,
 PRIMARY KEY (ID)
)