 CREATE TABLE FCSMOKE_LABOURCHARGE(JOB_ID NUMBER(3) REFERENCES MAINTENANCE_MASTER(JOB_ID),
                                    TASK_ID NUMBER(3),
                            NOW VARCHAR2(100),
                            OTHER_WORK VARCHAR2(100),
                            AMOUNT NUMBER(10,2))
/
