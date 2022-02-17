CREATE TABLE MAINTENANCE_MASTER(INSTITUTION_NAME NUMBER(2),
                           VEHICLE_TYPE NUMBER(2),
                           VEHICLE_NUMBER NUMBER(2),
                           BILL_NUMBER NUMBER(5),
                           REQ_DATE DATE,
                           ISSUE_DATE DATE,
                           DRIVER_NAME NUMBER(3),
                           REQ_DRIVERNAME NUMBER(3),
                           ROUTE_NUMBER NUMBER(3),
                           OTHER_REASON VARCHAR2(100),
                           NEEDED_SPARES VARCHAR2(100),
                           GOODS_TYPE NUMBER(3),
                           PLACE NUMBER(3),
                           SERVICE_STATION NUMBER(3),
                           BILL_PASSED NUMBER(1),
                           JOB_ID NUMBER(3) PRIMARY KEY);

ALTER TABLE MAINTENANCE_MASTER ADD(TOTALAMOUNT NUMBER(20,2));







ALTER TABLE MAINTENANCE_MASTER MODIFY(BILL_PASSED NUMBER(1));




//ALTER TABLE MAINTENANCE_MASTER DROP COLUMN TASK_ID;