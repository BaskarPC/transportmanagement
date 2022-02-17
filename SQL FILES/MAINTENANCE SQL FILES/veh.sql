 create table vehicle(vehicleid number(4),vehicletype number(4),instname number(4));


 insert into vehicle values(176,7,2);
 insert into vehicle values(14,8,4);
 insert into vehicle values(14,8,2);
 insert into vehicle values(14,8,1);
 insert into vehicle values(14,8,3);
 insert into vehicle values(14,9,3);
 insert into vehicle values(14,9,4);
 insert into vehicle values(14,9,2);
 insert into vehicle values(14,9,1);

insert into vehicle values(14,10,3);
insert into vehicle values(14,10,4);
insert into vehicle values(14,10,2);
insert into vehicle values(14,10,5);
insert into vehicle values(14,10,1);


insert into vehicle values(14,13,3);
insert into vehicle values(14,13,4);
insert into vehicle values(14,13,2);
insert into vehicle values(14,13,5);
insert into vehicle values(14,13,1);

 insert into vehicle values(15,7,4);
 insert into vehicle values(17,7,4);
 insert into vehicle values(18,9,1);
 insert into vehicle values(19,12,1);
 insert into vehicle values(19,13,1);
 insert into vehicle values(20,12,2);
 insert into vehicle values(20,11,4);
 insert into vehicle values(20,11,5);
 insert into vehicle values(20,11,2);
 insert into vehicle values(20,13,5);
 insert into vehicle values(20,13,3);
 insert into vehicle values(20,13,4);
 insert into vehicle values(20,6,5);
 insert into vehicle values(21,6,4);

 insert into vehicle values(22,6,1);
 insert into vehicle values(23,7,1);
 insert into vehicle values(23,7,2);
 insert into vehicle values(23,9,1);
 insert into vehicle values(23,9,3);
 insert into vehicle values(23,9,4);
 insert into vehicle values(23,9,5);
 insert into vehicle values(24,8,2);
insert into vehicle values(24,6,2);
insert into vehicle values(24,7,3);
insert into vehicle values(24,8,3);
insert into vehicle values(24,8,4);
insert into vehicle values(24,8,5);










SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where id=1;
select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (select d
                                                                                                    
ERROR at line 1:
ORA-00907: missing right parenthesis


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where id=1);

VEHICLETYPEID
-------------
VEHICLETYPEDESC
--------------------------------------------------------------------------------
            1
BUS


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where id=3);

VEHICLETYPEID
-------------
VEHICLETYPEDESC
--------------------------------------------------------------------------------
            3
CAR


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where id=5;
select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (select d
                                                                                                    
ERROR at line 1:
ORA-00907: missing right parenthesis


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where id=5);

VEHICLETYPEID
-------------
VEHICLETYPEDESC
--------------------------------------------------------------------------------
            5
MARSHALL JEEP


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where instname=1);

VEHICLETYPEID
-------------
VEHICLETYPEDESC
--------------------------------------------------------------------------------
            2
LORRY

            6
AMBULANCE


SQL> select id as vehicletypeid,codedesc as vehicletypedesc from VEHICLETYPE_LOOKUP where id in (sel
ect distinct(vehicletype) as vehtype from vehicle where instname=3);

VEHICLETYPEID
-------------
VEHICLETYPEDESC
--------------------------------------------------------------------------------
            2
LORRY

            8
TEMPO

            9
OTHERS


SQL> desc VEHICLETYPE_LOOKUP;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER(3)
 CODETYPE                                           VARCHAR2(100)
 CODEDESC                                           VARCHAR2(100)

SQL> insert into number_lookup;
insert into number_lookup
                        *
ERROR at line 1:
ORA-00926: missing VALUES keyword


SQL> create table number_lookup(id number(4),CODETYPE varchar2(100),codedesc varchar2(100));

Table created.

SQL> insert into number_lookup values(&id,'&CODETYPE','&codedesc');
Enter value for id: 1
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN33P3083
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(1,'vehiclenumber','TN33P3083')

1 row created.

SQL> /
Enter value for id: 2
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN34AB3339
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(2,'vehiclenumber','TN34AB3339')

1 row created.

SQL> /
Enter value for id: 3
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN36-1111
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(3,'vehiclenumber','TN36-1111')

1 row created.

SQL> /
Enter value for id: 4
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN34C3355
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(4,'vehiclenumber','TN34C3355')

1 row created.

SQL> /
Enter value for id: 5
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN56 6313
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(5,'vehiclenumber','TN56 6313')

1 row created.

SQL> /
Enter value for id: 6
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN63Y4722
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(6,'vehiclenumber','TN63Y4722')

1 row created.

SQL> /
Enter value for id: 7
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN56 5015
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(7,'vehiclenumber','TN56 5015')

1 row created.

SQL> /
Enter value for id: 8
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN56 6302
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(8,'vehiclenumber','TN56 6302')

1 row created.

SQL> /
Enter value for id: 9
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN60F7245
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(9,'vehiclenumber','TN60F7245')

1 row created.

SQL> /
Enter value for id: 10
Enter value for codetype: vehiclenumber
Enter value for codedesc: TN33AE4762
old   1: insert into number_lookup values(&id,'&CODETYPE','&codedesc')
new   1: insert into number_lookup values(10,'vehiclenumber','TN33AE4762')

1 row created.

SQL> commit;

Commit complete.

SQL> select id as vehiclenumberid,codedesc as vehiclenumberdesc from number_lookup where id in (sele
ct vehicleid as vehid from vehicle where vehicletype=2);

VEHICLENUMBERID
---------------
VEHICLENUMBERDESC
--------------------------------------------------------------------------------
              1
TN33P3083

              6
TN63Y4722