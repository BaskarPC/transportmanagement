 CREATE TABLE SERVICE_DETAILS(JOB_ID NUMBER(3) REFERENCES MAINTENANCE_MASTER(JOB_ID),
                                    TASK_ID NUMBER(3),
			    PLACE NUMBER(4),
			    SERVICE_STATION NUMBER(3),
			    SERVICE_NAME NUMBER(3),
			    PRESENT_KM NUMBER(3),
			    AMOUNT NUMBER(3),
			    WARRANTY VARCHAR2(40))
/
