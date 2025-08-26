
USE online_ordering_system;

CREATE TABLE customer (
    ID bigint auto_increment,
    first_name varchar(20),
    last_name varchar(20),
    EMAIL_ADDRESS VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    address varchar(100) not null,
	PRIMARY KEY (ID)
); 

CREATE TABLE product (
    ID bigint auto_increment,
    prod_name varchar(20) not null,
    prod_type varchar(20) not null,
    price double not null,
    prod_description varchar(255) not null,
    is_discounted boolean not null,
    inventory_quantity int not null,
    seller_id bigint not null,
	PRIMARY KEY (ID),
    foreign key (seller_id) references seller(id)
); 

CREATE TABLE seller (
    ID bigint auto_increment,
    seller_name varchar(50),
    ADDRESS VARCHAR(100),
    PHONE_NO VARCHAR(20),
	EMAIL_ADDRESS VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE orders (
    ID bigint auto_increment,
    customer_id bigint not null,
    product_id bigint not null,
    order_date date not null,
    quantity bigint not null,
    order_status varchar(15) not null,
	PRIMARY KEY (ID),
    Foreign Key (customer_id) references customer(id),
    Foreign Key (product_id) references product(id)
); 

-- seeder
insert into customer (first_name, last_name, EMAIL_ADDRESS, USER_PASSWORD, address)
values ("Juan", "Semana","sample@gmail.com","pass1", "Manila")
, ("Brian","Vil","sample@email1.com", "pass2", "Makati")
, ("Abi", "Gail","sample@gmail.com", "pass2", "Manila")
, ("Philip","Ronin","sample@email3.com", "pass2", "Pasay")
, ("Ryan","James","sample@email4.com", "pass2", "Bulacan")
, ("Vic","Tor","sample@gmail.com", "pass2", "Abra")
, ("gnobgnob","socram","sample@email6.com", "pass2", "Malolos")
, ("leni","robredo","sample@gmail.com", "pass2", "Etivac")
, ("wala","ako maisip","sample@email8.com", "pass2", "Manila")
, ("Jartin","Mames","sample@email9.com", "pass2", "Laguna");

insert into product (prod_name, price, prod_type,  prod_description, is_discounted, inventory_quantity, seller_id)
values ("iphone", 10000, "Electronics","sample desc",true, 100, 1)
, ("huawei",2000, "Electronics","sample desc", false, 100, 1)
, ("cherry mobile",1500 ,"Electronics","sample desc", true,100, 1)
, ("rolex",30000, "Analog","sample desc", true,100, 1)
, ("pheonix one",600000,"Vendor","sample desc", true,100, 1)
, ("jira",4000,"Web App","sample desc", false, 100, 1)
, ("prod1",35000, "Random","sample desc", false, 100, 1)
, ("prod2",3000,"Random","sample desc", false, 100, 1)
, ("prod3",1000,"Random","sample desc", false, 100, 1)
, ("prod4",1000,"Random", "sample desc", false, 100, 1);

insert into seller (seller_name, EMAIL_ADDRESS)
values ("comapny1","sample@email.com")
, ("comapny2","sample@email1.com")
, ("comapny3","sample@email2.com")
, ("comapny4","sample@email3.com")
, ("comapny5","sample@email4.com")
, ("comapny6","sample@email5.com")
, ("comapny7","sample@email6.com")
, ("comapny8","sample@email7.com")
, ("comapny9","sample@email8.com")
, ("comapny0","sample@email9.com")
;


insert into orders (customer_id, product_id, order_date, quantity, order_status)
values (1, 11,"2023-03-11", 100, "Delivered")
, (1,12,"2025-08-08", 100, "Delivered")
, (1, 12,"2023-08-10",100, "Delivered")
, (2,12,"2025-01-11",100, "Delivered")
, (2,13,"2022-02-11",100, "Delivered")
, (2,16,"2011-03-11", 100, "Delivered")
, (4,17,"2025-04-11", 100, "In-transit")
, (5,18,"2021-05-11", 100,"In-transit")
, (7,19,"2024-06-11", 100, "In-transit")
, (9,19,"2023-07-11", 100, "In-transit");


-- reset
truncate table customer;
truncate table seller;
truncate table product;
truncate table orders;

-- hard reset
drop table customer;
drop table product;
drop table orders;
drop table seller;

SELECT * FROM CUSTOMER;
select * from product;
select * from seller;
select * from orders;



alter table customer
-- MODIFY COLUMN FIRST_NAME varchar(20) NOT NULL,
-- MODIFY COLUMN LAST_NAME varchar(20) NOT NULL;
-- ADD column ADDRESS VARCHAR(100),
-- ADD column PHONE_NO VARCHAR(20),
-- ADD column EMAIL_ADDRESS VARCHAR(50) NOT NULL,
-- ADD column USER_PASSWORD VARCHAR(50) NOT NULL,
modify column MoP VARCHAR(20);
;



alter table customer AUTO_INCREMENT=100;
-- MODIFY COLUMN FIRST_NAME varchar(20) NOT NULL,
-- MODIFY COLUMN LAST_NAME varchar(20) NOT NULL;
-- ADD column ADDRESS VARCHAR(100),
-- ADD column PHONE_NO VARCHAR(20),
-- ADD column EMAIL_ADDRESS VARCHAR(50) NOT NULL,
-- ADD column USER_PASSWORD VARCHAR(50) NOT NULL,
-- modify column ID 
-- ;

-- 1
select COUNT(PROD_TYPE) AS PRODUCT_TYPE_TOTAL, PROD_TYPE from PRODUCT GROUP BY PROD_TYPE;

-- 2
SELECT FIRST_NAME, LAST_NAME FROM CUSTOMER WHERE ADDRESS LIKE '%a';

-- 3
SELECT * FROM ORDERS WHERE month(ORDER_DATE) between MONTH('2000/01/01') AND MONTH('2025/08/08');

-- 5
select * from orders as o 
join customer as c 
on c.id = o.customer_id  
where year(o.order_date) = (select year(order_date) from orders order by ORDER_DATE desc LIMIT 1) 
and c.EMAIL_ADDRESS like '%@gmail.com';
