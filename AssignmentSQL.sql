use fun;

create table customers (
	customer_id int,
    first_name varchar(50),
    last_name varchar(50),
    email_address varchar(200),
    phone_number varchar(20),
    address varchar(100)
);

create table accounts (
	account_number int,
    account_type varchar(30),
    account_balance float
);
create table transactions (
	account_number int,
    description varchar(100),
    DateandTime date,
    transaction_type varchar(20),
    transaction_amount float
);
select * from accounts;

select account_balance from accounts where account_number = 1001;
select * from customers;

select * from transactions where account_number = 1001 and DateandTime between '2023-12-16' and '2023-12-16';



