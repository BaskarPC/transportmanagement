 CREATE TABLE SCRAP_ISSUE(JOB_ID NUMBER(3) REFERENCES MAINTENANCE_MASTER(JOB_ID),
                                    TASK_ID NUMBER(3),
			    PART_NUMBER NUMBER(3),
			    COMPANY NUMBER(3),
			    CATEGORY NUMBER(4),
			    QTY_SOLD NUMBER(3))
/
