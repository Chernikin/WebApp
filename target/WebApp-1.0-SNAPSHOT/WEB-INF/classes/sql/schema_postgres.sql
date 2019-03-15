create table if not exists Products (
  id serial primary key,
  company_id int not null,
  product_name varchar(255) not null,
  cpu_id int not null,
  gpu_id int not null,
  specification varchar(255) not null,
  price int not null
);

insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (1, 'Notebook 1', 1, 1, 'Specification 1', 1000);
insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (2, 'Notebook 2', 2, 2, 'Specification 2', 2000);
insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (3, 'Notebook 3', 1, 1, 'Specification 3', 3000);
insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (1, 'Notebook 4', 2, 2, 'Specification 4', 4000);
insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (2, 'Notebook 5', 1, 1, 'Specification 5', 5000);
insert into Products (company_id, product_name, cpu_id, gpu_id, specification, price) values (3, 'Notebook 6', 2, 2, 'Specification 6', 6000);

create table if not exists CPU (
  id int primary key not null auto_increment,
  cpu_name varchar(255) not null
);

insert into CPU (cpu_name) values ('Intel');
insert into CPU (cpu_name) values ('Amd');

create table if not exists GPU (
  id serial primary key,
  gpu_name varchar(255) not null
);

insert into GPU (gpu_name) values ('Integrated');
insert into GPU (gpu_name) values ('Discrete');

create table if not exists Companies (
  id serial primary key,
  company_name varchar(255) not null
);

insert into Companies (company_name) values ('Asus');
insert into Companies (company_name) values ('Apple');
insert into Companies (company_name) values ('Dell');