 CREATE TABLE GENERAL_WASTECLOTH(JOB_ID NUMBER(3) REFERENCES MAINTENANCE_MASTER(JOB_ID),
                                    TASK_ID NUMBER(3),
                            PART_NUMBER NUMBER(4),
			    ITEM_DESC NUMBER(4),
                            AVAILABLE_QTY NUMBER(4),
                            QTY_WANTED NUMBER(4),
                            REASON_REQ VARCHAR2(100),
                            URATE NUMBER(3),
                            AMOUNT NUMBER(10,2))
/
