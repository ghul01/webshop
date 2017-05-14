CREATE TABLE VAROS 
(
  V_NEV VARCHAR2(50 BYTE) NOT NULL
, IRSZ VARCHAR2(4 BYTE) NOT NULL 
, CONSTRAINT VAROS_PK PRIMARY KEY (V_NEV)
)

CREATE TABLE KATEGORIA
(
  KAT_NEV VARCHAR2(50) NOT NULL
, CONSTRAINT KATEGORIA_PK PRIMARY KEY (KAT_NEV)
)

CREATE TABLE KEDVEZMENY
(
  LOWER_LIMIT INT NOT NULL
, RATE NUMBER NOT NULL
, CONSTRAINT KEDVEZMENY_PK PRIMARY KEY (LOWER_LIMIT)
)