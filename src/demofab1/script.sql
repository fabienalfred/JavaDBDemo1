--Script de création des tables de la base COMMANDE


-- LANCEMENT DU SCRIPT DE CREATION DE LA BASE COMMANDE-VERSION 2015



--SUPPRESSION DES TABLES

-- SUPPRESSION DES TABLES


drop table representant cascade constraints purge;
drop table client cascade constraints purge;
drop table article cascade constraints purge;
drop table commande cascade constraints purge;
drop table ligne_com cascade constraints purge;



--CREATION DES TABLES


-- CREATION DES TABLES



-- CREATION DE LA TABLE REPRESENTANT

create table representant
( idrep          number(5) constraint pk_idrep primary key,
  prenomrep      varchar(20),
  nomrep         varchar(20),
  adresse        varchar2(20),
  codepostal     number(5),
  ville          varchar (30),
  telephone      varchar(10) );

-- CREATION DE LA TABLE CLIENT

create table client
( idclient       number constraint pk_idcli primary key,
  raisonsociale  varchar(20), 
  Adresse        varchar(60),
  codepostal     number(5),
  Ville          varchar(30),
  Telephone      varchar(20),
  idrep          number constraint fk_idrep references representant(idrep));

-- CREATION DE LA TABLE ARTICLE

create table article
( idarticle      number constraint pk_idart primary key,
  designation    varchar(30), 
  prixunit       number(8,2),
  qtestock       number);

-- CREATION DE LA TABLE COMMANDE
create table commande
( numcom         number constraint pk_num primary key,
  idclient       number constraint fk_idcl references client(idclient),
  datecom        date);


CREATE TABLE ligne_com
( numcom         NUMBER constraint fk_num references commande (numcom),
  idarticle      NUMBER constraint fk_idar references article(idarticle),
  numlig         NUMBER,
  qtecom         NUMBER,
  Constraint pk_ligne_com primary key (numcom,idarticle) );




--INSERTION DES DONNEES

-- INSERTION DES DONNEES



-- INSERTION DANS REPRESENTANT

DELETE FROM REPRESENTANT;
insert into representant values (1,'Paul','Dupond','20 Rue des Jardins',69000,'Lyon','0425124556');
insert into representant values (2,'Jean','Fontaine','10 Place des Armes',75000,'Paris','0125194556');
insert into representant values (3,'Remi','Hoareau','5 Rue des Acacias',13012,'Marseille','0425194576');
insert into representant values (4,'Pierre','Sanchez','Rue des Roses',90145,'Belfort','0325129551');
insert into representant values (5,'Patrick','Garcia','2 bis rue des lilas',33016,'Bordeaux','0515128556');
insert into representant values (6,'Patrick','lebeaux','80 Rue des Amandines',62000,'Lille','0229123554');
insert into representant values (7,'David','Legrand','12 Rue des Muguets',18000,'Bourges','0325134556');


-- INSERTION DANS CLIENT

delete from client;
insert into client values(1,'DARTY','',75005,'paris','0126597820',4);
insert into client values(2,'INFO SYSTEM','15 rue de la boeme',75007,'PARIS','0135678712',4);
insert into client values(3,'CD PRO','1 RUE JEAN MERMOZ',45900,'LA SOURCE','0302345698',5);
insert into client values(4,'Multimedia','13 avenue des Tilleuls',92310,'SEVRES','0134568934',5);
insert into client values(5,'CARREFOUR','',13008,'MARSEILLE','0456788932',7);
insert into client values(6,'THOMSON','',33000,'BORDEAUX','0455237806',null);



-- INSERTION DANS ARTICLE

delete from article;
insert into article values (1,'Moniteur 28"',300,30);
insert into article values (2,'Moniteur 19"',169,20);
insert into article values (3,'Disque dur 5To',240,250);
insert into article values (4,'Disque dur 2To',104,350);
insert into article values (5,'Clavier SF',79,200);
insert into article values (6,'UC HP500-310',514,50);
insert into article values (7,'TV LED-3D',3990,10);


-- INSERTION DANS COMMANDE
delete from commande;

alter session set nls_date_format='dd/mm/yyyy';

insert into commande 
values (1,1,'12/12/'||(to_char(sysdate, 'YYYY')-2));
insert into commande 
values (2,3,'25/12/'||(to_char(sysdate, 'YYYY')-2));
insert into commande 
values (3,5,'12/02/'||(to_char(sysdate, 'YYYY')-1));
insert into commande values (4,1,sysdate);
insert into commande values (5,2,sysdate-4);
insert into commande values (6,4,sysdate+30);


-- INSERTION DANS LIGNE_COM

delete from ligne_com;
insert into ligne_com values(1,2,1,3);
insert into ligne_com values(1,6,2,1);
insert into ligne_com values(2,4,1,10);
insert into ligne_com values(3,1,1,1);
insert into ligne_com values(3,5,2,1);
insert into ligne_com values(3,2,3,15); 
insert into ligne_com values(4,2,1,2);
insert into ligne_com values(4,6,2,3);
insert into ligne_com values(4,1,3,3);
insert into ligne_com values(5,1,1,1);
insert into ligne_com values(6,3,1,3);
insert into ligne_com values(6,4,2,1);
insert into ligne_com values(6,6,3,4);



-- Validation des Donnees


commit;

-- FIN DE CREATION DE LA BASE COMMANDE.



-- *****************************************************BONNE FORMATION*****************                                  
