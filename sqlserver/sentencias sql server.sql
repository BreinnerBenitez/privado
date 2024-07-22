use principalprueba;

select * from sys.tables;

exec sp_help Empleados;
alter table Empleados add contratacion date;

select * from Empleados;
insert into Empleados values (2, 'Hugo', 'Benitez', 23, 9998887776, 'Calle 789', '1980-03-16', 2100.00, 'SI','');
update Empleados set sexo='M' where sexo=''; 
truncate table Empleados;

alter table Empleados drop column sexo;

select * from Empleados where edad<30;

exec sp_rename 'Empleados.idempleado', 'id';
update Empleados set activo ='NO' where id in(1,2,3,4,5);
select * from Empleados where edad in(25,2,5,30);

delete from empleados where id in(5,6,7);

create table salario(
id int identity(1,1),
nombre varchar(50),
apellido varchar (50),
salario decimal (10,2),


);

select * from salario;
exec sp_help salario;

insert into salario(nombre ,apellido,salario)
select nombre ,apellido,salario from Empleados
where salario > 2500 ;
-- video 18 
select top 50 percent *  from Empleados;
select top 8 * from Empleados;

create table cliente(
idcliente int identity(1,1),
nombre varchar(50),
apellido varchar (50),
direccion varchar(50),
)


insert into cliente values('Juan','Perez','Calle A, Ciudad');
insert into cliente values( 'Maria', NULL, 'Calle B Ciudad');
insert into cliente values('Carlos','Lopez', NULL);
insert into cliente values( NULL, 'Rodriguez', 'Calle D Ciudad');
insert into cliente values('Pedro', NULL, NULL);
insert into cliente values(NULL ,NULL,  'Calle D Ciudad');
insert into cliente values('Luis','Gonzales', 'Calle G Ciudad');
insert into cliente values( NULL, 'Díaz', NULL);
insert into cliente values('Jorge', NULL,' Calle I Ciudad');
insert into cliente values(NULL, NULL, NULL);
insert into cliente values('Ana', 'Hernandez', 'Calle M Ciudad');
insert into cliente values(NULL, NULL, 'Calle M Ciudad'); 
insert into cliente values(NULL, 'Sanchez', NULL);
insert into cliente values('Sofía', NULL, 'Calle M Ciudad');
insert into cliente values(NULL, NULL,  'Calle P Ciudad');
insert into cliente values('Daniel', 'Garcia', NULL);
insert into cliente values('Martha','Fernandez', NULL);
insert into cliente values(NULL, 'Martinez',  'Calle Q Ciudad');
insert into cliente values('Pablo', NULL, NULL);
insert into cliente values( NULL, 'Lopez', 'Calle S Ciudad');

select * from cliente where nombre  is not  null;

create table clientes2(

idcliente int not null,
nombre varchar(50) not null,
direccion varchar (100) not null,
telefono numeric (10)  null,
email varchar (50)  null,

);

-- los constrain 

create table personas(
idpersona int identity (1,1) not null,
nombre varchar(25) not null,
edad int

);


alter table personas add  constraint PK_enlace_personas primary key (idpersona);

alter table personas drop constraint PK_enlace_personas;

insert into personas values('breinner',25);

drop table personas;

select * from sys.tables;


drop table personas;

--constraint check 

create table personas(
id int not null,
nombre varchar(50),
edad int,
ciudad varchar(30) 

);


alter table personas add constraint DF_ciudad default 'no tiene' for ciudad ;

alter table personas drop constraint DF_ciudad; 
select * from personas; 

insert into personas values(1,'jhon',10,default);

drop table personas;


use principalprueba;

create  table clientes3(
id int,
nombre varchar (20),
apellido varchar(20),
edad int not null


);

alter table clientes3 alter column apellido varchar(20) not null ;
alter table clientes3 alter column id int not null;
alter table clientes3 add   constraint PK_clientes primary key (id);

create table ordenes(
id_orden int not null,
articulo varchar(50) not null,
id_cliente int 
constraint FK_ordenes foreign key references clientes3(id)
);

exec sp_help ordenes;

insert into clientes3 values (1,'breinner','benitez',25);
insert into ordenes values (1,'martillo',1);

select * from clientes3;
select * from ordenes;

drop table clientes3;

--vistas (VIEWS)

use principalprueba;

select * from sys.tables;

--crear la tabla clientes

CREATE TABLE clientes (
    id INT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    direccion VARCHAR(50),
    edad INT,
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);


--insertar estos registros en la tabla clientes
    insert into clientes values(1, 'Juan', 'Perez', 'Calle 123', 25, '555-1234', '2000-01-01');
    insert into clientes values(2, 'Maria', 'Lopez', 'Avenida 456', 30, '555-5678', '1995-05-10');
    insert into clientes values(3, 'Carlos', 'Gomez', 'Carrera 789', 40, '555-9012', '1983-12-15');
    insert into clientes values(4, 'Ana', 'Rodriguez', 'Plaza 789', 32, '555-4321', '1989-08-20');
    insert into clientes values(5, 'Pedro', 'Martinez', 'Avenida 987', 45, '555-6789', '1978-03-05');
    insert into clientes values(6, 'Laura', 'Sanchez', 'Calle 456', 27, '555-0987', '1996-11-12');
    insert into clientes values(7, 'Luis', 'Hernandez', 'Calle 654', 38, '555-3456', '1984-07-25');
    insert into clientes values(8, 'Carolina', 'Torres', 'Avenida 321', 29, '555-8765', '1992-09-03');
    insert into clientes values(9, 'Diego', 'Gonzalez', 'Carrera 246', 42, '555-6543', '1979-06-18');
    insert into clientes values(10, 'Sofia', 'Rojas', 'Plaza 135', 31, '555-2109', '1990-04-14');
    insert into clientes values(11, 'Andres', 'Fernandez', 'Calle 789', 37, '555-1092', '1985-02-28');
    insert into clientes values(12, 'Valentina', 'Morales', 'Calle 246', 26, '555-5432', '1997-10-23');
    insert into clientes values(13, 'Roberto', 'Gutierrez', 'Avenida 753', 43, '555-4321', '1978-12-09');
    insert into clientes values(14, 'Daniela', 'Navarro', 'Plaza 159', 33, '555-6789', '1988-06-14');
    insert into clientes values(15, 'Jorge', 'Paz', 'Carrera 357', 44, '555-0987', '1977-01-30');
    insert into clientes values(16, 'Catalina', 'Silva', 'Calle 852', 28, '555-3456', '1995-11-05');
    insert into clientes values(17, 'Gonzalo', 'Luna', 'Avenida 951', 39, '555-8765', '1982-08-12');
    insert into clientes values(18, 'Camila', 'Vargas', 'Carrera 753', 30, '555-6543', '1993-03-28');
    insert into clientes values(19, 'Felipe', 'Cortes', 'Calle 357', 35, '555-2109', '1986-09-13');
    insert into clientes values(20, 'Marcela', 'Ortega', 'Plaza 852', 37, '555-1092', '1985-02-28');

	select * from clientes;


	create view Clientes_nacionales
	as
	select * from clientes; 
	select * from Clientes_nacionales;

	create view clientes_moyor_30
	as
	select * from clientes where edad>30;

	select * from clientes_moyor_30;

	-- index 

	select * from Empleados;

	create clustered index i_idempleados
	on empleados (id);

	create nonclustered index i_edadempleado
	on empleados(edad);

	exec sp_rename 'Empleados.i_idempleados','I_idempleados','INDEX';

	-- clientes
	select * from clientes;

	select  distinct edad from clientes;

	-- Alias con as y de concatenar 

	--operadores 
	
	select (30-12);
	select (30*12);

	--operadores 

	CREATE TABLE articulos (
  codigo INT IDENTITY,
  nombre VARCHAR(30),
  descripcion VARCHAR(100),
  precio SMALLMONEY,
  cantidad INT DEFAULT 0,
  vendidos INT DEFAULT 0,
  PRIMARY KEY (codigo)
);

  insert into articulos values('Laptop Acer', 'Portátil con procesador i5, 8GB RAM, 256GB SSD', 899.99, 10, 2);
  insert into articulos values('Monitor Samsung', 'Monitor LED de 24 pulgadas con resolución Full HD', 179.99, 20, 5);
  insert into articulos values('Impresora HP', 'Impresora láser multifuncional con conexión Wi-Fi', 249.99, 15, 3);
  insert into articulos values('Teclado Logitech', 'Teclado inalámbrico con retroiluminación y teclas programables', 59.99, 30, 8);
  insert into articulos values('Mouse Microsoft', 'Mouse óptico ergonómico con 6 botones programables', 19.99, 40, 12);
  insert into articulos values('Disco Duro Externo', 'Almacenamiento portátil de 1TB con conexión USB 3.0', 79.99, 25, 6);
  insert into articulos values('Laptop HP', 'Portátil con procesador i7, 16GB RAM, 512GB SSD', 1299.99, 8, 1);
  insert into articulos values('Monitor LG', 'Monitor LED de 27 pulgadas con resolución 4K', 299.99, 12, 3);
  insert into articulos values('Impresora Epson', 'Impresora de inyección de tinta con escáner incorporado', 159.99, 18, 4);
  insert into articulos values('Teclado Razer', 'Teclado mecánico con iluminación personalizable', 99.99, 22, 7);
  insert into articulos values('Mouse Logitech', 'Mouse inalámbrico con sensor de alta precisión', 29.99, 35, 10);
  insert into articulos values('Disco Duro SSD', 'Unidad de estado sólido de 500GB con velocidad de transferencia rápida', 109.99, 30, 9);
  insert into articulos values('Laptop Dell', 'Portátil con procesador i7, 16GB RAM, 1TB HDD', 1199.99, 6, 1);
  insert into articulos values('Monitor BenQ', 'Monitor LED de 32 pulgadas con tecnología HDR', 399.99, 9, 2);
  insert into articulos values('Impresora Canon', 'Impresora láser en color de alta velocidad', 199.99, 14, 4);
  insert into articulos values('Teclado Corsair', 'Teclado mecánico para juegos con retroiluminación RGB', 79.99, 28, 9);
  insert into articulos values('Mouse Gaming', 'Mouse para juegos con botones programables y DPI ajustable', 49.99, 42, 15);
  insert into articulos values('Disco Duro Externo SSD', 'Almacenamiento portátil de 2TB con conexión USB-C', 159.99, 20, 8);
  insert into articulos values('Laptop Lenovo', 'Portátil con procesador Ryzen 7, 12GB RAM, 512GB SSD', 999.99, 10, 2);
  insert into articulos values('Monitor ASUS', 'Monitor LED de 29 pulgadas ultrapanorámico', 249.99, 16, 3);
  insert into articulos values('Impresora Brother', 'Impresora láser monocromática de alta capacidad', 179.99, 20, 6);

  select nombre,descripcion, precio+(precio* 0.1) as "nuevo precio " from articulos;

  select * from articulos;

  select nombre ,descripcion , (precio*cantidad) as dinero from articulos;

  create view  V_artticulos
  as
  select nombre,descripcion , (cantidad-vendidos) as inventarioProducto from articulos;

  select * from V_artticulos;

  --video  31 esquemas 

  create schema ventas;
  create schema cobros;

  create table ventas.clientes(
  idclientes int identity(1,1) not null,
  nombre varchar(50) not null,
  apellido varchar(50) not null
  
  );

  select * from ventas.clientes;

  --video 32 quede 

  use AdventureWorks2022;

  select * from HumanResources.Employee;

  -- video 33 quede

  use principalprueba;

  select top 8 id , nombre, edad  from Empleados order by edad;
  
  select * from empleados order by edad desc;

  select * from Empleados where edad >25 order by edad  asc;

  select * from sys.tables;

  select * from articulos;
  
  select max(precio) as valor_maximo  from articulos ;
  select min(precio) as valor_minimo from articulos;

  -- video 35 funciones de agrupacion

  select * from Empleados;

  select count(salario) as cuenta   from Empleados
  where edad = 30 or edad= 25;

  select sum(salario) as salario from Empleados
  where edad = 25 or edad= 30 ;

  select avg(salario) from empleados
  where edad=25 or edad =30;

  select * from empleados where id between 1 and 7
  or id between 2 and 8 


  select * from empleados where salario 
  between 2500 and 3000;

  select * from clientes where nombre like 'L%';

  --join 


  create schema uniones;

create table clientes(
idcliente int not null primary key,
nombre varchar(20) not null,
apellido varchar(30) not null,
direccion varchar(100) not null,
ciudad varchar(50) not null,
telefono numeric(10) null,
);

create table ordenes(
id_orden int not null primary key,
idcliente int foreign key references clientes(idcliente),
fecha_orden date default getdate(),
id_vendedor int not null
);


INSERT INTO clientes (idcliente, nombre, apellido, direccion, ciudad, telefono)
VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Ciudad A', 1234567890),
(2, 'María', 'González', 'Avenida 456', 'Ciudad B', 2345678901),
(3, 'Pedro', 'López', 'Calle Principal', 'Ciudad C', 3456789012),
(4, 'Laura', 'Martínez', 'Avenida Central', 'Ciudad A', 4567890123),
(5, 'Carlos', 'Hernández', 'Calle 789', 'Ciudad B', 5678901234),
(6, 'Ana', 'Sánchez', 'Avenida Secundaria', 'Ciudad C', 6789012345),
(7, 'Luis', 'Rodríguez', 'Calle 321', 'Ciudad A', 7890123456),
(8, 'Sofía', 'Fernández', 'Avenida 654', 'Ciudad B', 8901234567),
(9, 'Andrés', 'Gómez', 'Calle Secundaria', 'Ciudad C', 9012345678),
(10, 'Marta', 'Torres', 'Avenida Principal', 'Ciudad A', 1234567890),
(11, 'Alejandro', 'Vargas', 'Calle Central', 'Ciudad B', 2345678901),
(12, 'Patricia', 'Ortega', 'Avenida 123', 'Ciudad C', 3456789012),
(13, 'Roberto', 'Jiménez', 'Calle 456', 'Ciudad A', 4567890123),
(14, 'Elena', 'Ruíz', 'Avenida 789', 'Ciudad B', 5678901234),
(15, 'Javier', 'Navarro', 'Calle Secundaria', 'Ciudad C', 6789012345),
(16, 'Carolina', 'Lara', 'Avenida 321', 'Ciudad A', 7890123456),
(17, 'Diego', 'Silva', 'Calle 654', 'Ciudad B', 8901234567),
(18, 'Lucía', 'Romero', 'Avenida Central', 'Ciudad C', 9012345678),
(19, 'Gabriel', 'Flores', 'Calle Principal', 'Ciudad A', 1234567890),
(20, 'Valentina', 'Mendoza', 'Avenida Secundaria', 'Ciudad B', 2345678901),
(21, 'Mario', 'López', 'Calle 789', 'Ciudad A', 3456789012),
(22, 'Camila', 'García', 'Avenida 456', 'Ciudad B', 4567890123),
(23, 'José', 'Hernández', 'Calle Principal', 'Ciudad C', 5678901234),
(24, 'Isabel', 'Rojas', 'Avenida Central', 'Ciudad A', 6789012345),
(25, 'Fernando', 'Gómez', 'Calle 123', 'Ciudad B', 7890123456),
(26, 'Ana', 'Lara', 'Avenida Secundaria', 'Ciudad C', 8901234567),
(27, 'Pedro', 'Fuentes', 'Calle 321', 'Ciudad A', 9012345678),
(28, 'Sara', 'Martínez', 'Avenida 654', 'Ciudad B', 1234567890),
(29, 'Gabriel', 'Sánchez', 'Calle Secundaria', 'Ciudad C', 2345678901),
(30, 'Valeria', 'Ortega', 'Avenida Principal', 'Ciudad A', 3456789012),
(31, 'Luisa', 'Vargas', 'Calle Central', 'Ciudad B', 4567890123),
(32, 'Daniel', 'Silva', 'Avenida 123', 'Ciudad C', 5678901234),
(33, 'Carolina', 'Torres', 'Calle 456', 'Ciudad A', 6789012345),
(34, 'Andrés', 'Guzmán', 'Avenida 789', 'Ciudad B', 7890123456),
(35, 'María', 'Romero', 'Calle Secundaria', 'Ciudad C', 8901234567),
(36, 'Alejandro', 'Mendoza', 'Avenida 321', 'Ciudad A', 9012345678),
(37, 'Valentina', 'Pérez', 'Calle 654', 'Ciudad B', 1234567890),
(38, 'Roberto', 'Fernández', 'Avenida Central', 'Ciudad C', 2345678901),
(39, 'Laura', 'González', 'Calle Principal', 'Ciudad A', 3456789012),
(40, 'Javier', 'Soto', 'Avenida Secundaria', 'Ciudad B', 4567890123);


insert into ordenes values(1, 1, '2020-01-12' ,1);
insert into ordenes values(2, 2, '2021-03-20', 2);
insert into ordenes values(3, 3, '2021-06-10', 3);
insert into ordenes values(4, 4, '2021-09-05', 4);
insert into ordenes values(5, 5, GETDATE(),5);
insert into ordenes values(6, 1, '2022-02-28', 1);
insert into ordenes values(7, 2, '2022-05-14', 2);
insert into ordenes values(8, 3, '2022-07-29', 3);
insert into ordenes values(9, 4, GETDATE(), 4);
insert into ordenes values(10, 5, '2022-12-23', 5);
insert into ordenes values(11, 1, '2023-02-14', 1);
insert into ordenes values(12, 2, '2023-04-30', 2);
insert into ordenes values(13, 3, GETDATE(), 3);
insert into ordenes values(14, 4, '2023-09-28', 4);
insert into ordenes values(15, 5, '2023-11-12', 5);
insert into ordenes values(16, 1, '2023-02-05', 1);
insert into ordenes values(17, 2, '2023-04-12', 2);
insert into ordenes values(18, 3, '2023-07-20', 3);
insert into ordenes values(19, 4, GETDATE(), 4);
insert into ordenes values(20, 5, '2023-12-30', 5);
insert into ordenes values(21, 1, '2021-01-15', 1);
insert into ordenes values(22, 2, '2021-03-20', 2);
insert into ordenes values(23, 3, '2021-06-10', 3);
insert into ordenes values(24, 4, '2021-09-05', 4);
insert into ordenes values(25, 5, GETDATE(), 5);
insert into ordenes values(26, 1, '2022-02-28', 1);
insert into ordenes values(27, 2, '2022-05-14', 2);
insert into ordenes values(28, 3, '2022-07-29', 3);
insert into ordenes values(29, 4, GETDATE(), 4);
insert into ordenes values(30, 5, '2022-12-23', 5);
insert into ordenes values(31, 1, '2023-02-14', 1);
insert into ordenes values(32, 2, '2023-04-30', 2);
insert into ordenes values(33, 3, GETDATE(), 3);
insert into ordenes values(34, 4, '2023-09-28', 4);
insert into ordenes values(35, 5, '2023-11-12', 5);
insert into ordenes values(36, 1, '2023-02-05', 1);
insert into ordenes values(37, 2, '2023-04-12', 2);
insert into ordenes values(38, 3, '2023-07-20', 3);
insert into ordenes values(39, 4, GETDATE(), 4);
insert into ordenes values(40, 5, '2023-12-30', 5);





select * from clientes;

select * from ordenes;

select clientes.idcliente, ordenes.id_orden, clientes.nombre , clientes.apellido, ordenes.fecha_orden
from ordenes
inner join clientes on ordenes.idcliente = clientes.idcliente
 where nombre ='juan' order by  ordenes.fecha_orden asc;


-- left join

select clientes.idcliente, clientes.nombre , clientes.apellido, ordenes.id_orden
from clientes
left join ordenes on clientes.idcliente =ordenes.idcliente
order by id_orden desc ;


-- use right join

select ordenes.id_orden , clientes.nombre, clientes.apellido
from clientes
full join ordenes on ordenes.idcliente = clientes.idcliente
order by ordenes.id_orden;


exec sp_help ordenes;



drop table clientes;
drop table ordenes;

-- 43 quede group by 

select * from clientes;


select count(idcliente) as numerociudad , ciudad 
from clientes
group by ciudad order by numerociudad asc;

select max(idcliente) as numerociudad , ciudad 
from clientes
group by ciudad order by numerociudad asc;

select min(idcliente) as numerociudad , ciudad 
from clientes
group by ciudad order by numerociudad asc;

select avg(idcliente) as numerociudad , ciudad 
from clientes
group by ciudad order by numerociudad asc;

 drop table ordenes;
CREATE TABLE ordenes (
    idorden INT PRIMARY KEY,
    idcliente INT,
    idempleado INT,
    fecha_orden DATE,
    id_vendedor INT
);
	insert into ordenes values(1, 1001, 2001, '2023-06-01', 1);
    insert into ordenes values(2, 1002, 2002, '2023-06-02', 2);
    insert into ordenes values(3, 1003, 2003, '2023-06-03', 3);
    insert into ordenes values(4, 1004, 2004, '2023-06-04', 4);
    insert into ordenes values(5, 1005, 2005, '2023-06-05', 5);
    insert into ordenes values(6, 1006, 2006, '2023-06-06', 6);
    insert into ordenes values(7, 1007, 2007, '2023-06-07', 7);
    insert into ordenes values(8, 1008, 2008, '2023-06-08', 1);
    insert into ordenes values(9, 1009, 2009, '2023-06-09', 2);
    insert into ordenes values(10, 1010, 2010, '2023-06-10', 3);
    insert into ordenes values(11, 1011, 2011, '2023-06-11', 4);
    insert into ordenes values(12, 1012, 2012, '2023-06-12', 5);
    insert into ordenes values(13, 1013, 2013, '2023-06-13', 6);
    insert into ordenes values(14, 1014, 2014, '2023-06-14', 7);
    insert into ordenes values(15, 1015, 2015, '2023-06-15', 1);
    insert into ordenes values(16, 1016, 2016, '2023-06-16', 2);
    insert into ordenes values(17, 1017, 2017, '2023-06-17', 3);
    insert into ordenes values(18, 1018, 2018, '2023-06-18', 4);
    insert into ordenes values(19, 1019, 2019, '2023-06-19', 5);
    insert into ordenes values(20, 1020, 2020, '2023-06-20', 6);
    insert into ordenes values(21, 1021, 2021, '2019-07-15', 1);
    insert into ordenes values(22, 1022, 2022, '2020-02-28', 2);
    insert into ordenes values(23, 1023, 2023, '2020-11-10', 3);
    insert into ordenes values(24, 1024, 2024, '2021-05-07', 4);
    insert into ordenes values(25, 1025, 2025, '2021-12-25', 5);
    insert into ordenes values(26, 1026, 2026, '2022-08-18', 6);
    insert into ordenes values(27, 1027, 2027, '2023-03-01', 7);
    insert into ordenes values(28, 1028, 2028, '2019-10-22', 1);
    insert into ordenes values(29, 1029, 2029, '2020-07-12', 2);
    insert into ordenes values(30, 1030, 2030, '2020-11-30', 3);
    insert into ordenes values(31, 1031, 2031, '2021-08-04', 4);
    insert into ordenes values(32, 1032, 2032, '2022-01-15', 5);
    insert into ordenes values(33, 1033, 2033, '2022-10-05', 6);
    insert into ordenes values(34, 1034, 2034, '2023-05-18', 7);
    insert into ordenes values(35, 1035, 2035, '2019-12-08', 1);
    insert into ordenes values(36, 1036, 2036, '2020-06-25', 2);
    insert into ordenes values(37, 1037, 2037, '2020-09-17', 3);
    insert into ordenes values(38, 1038, 2038, '2021-04-02', 4);
    insert into ordenes values(39, 1039, 2039, '2022-01-05', 5);
    insert into ordenes values(40, 1040, 2040, '2022-09-28', 6);


CREATE TABLE vendedor (
    id_vendedor INT PRIMARY KEY,
    nombre VARCHAR(50),
    telefono VARCHAR(20)
);

    insert into vendedor values(1, 'Juan Pérez', '1234567890');
    insert into vendedor values(2, 'María Gómez', '9876543210');
    insert into vendedor values(3, 'Carlos Rodríguez', '5555555555');
    insert into vendedor values(4, 'Laura López', '9999999999');
    insert into vendedor values(5, 'Pedro Martínez', '1111111111');
    insert into vendedor values(6, 'Ana Sánchez', '2222222222');
    insert into vendedor values(7, 'José Morales', '3333333333');


	select  ve.nombre, count (o.idorden) as "cantidad de ordenes"
	from ordenes o
	left join vendedor ve  on ve.id_vendedor = o.id_vendedor
	group by ve.nombre;



drop table clientes;

CREATE TABLE clientes (
  idcliente INT,
  nombre VARCHAR(50),
  direccion VARCHAR(100),
  ciudad VARCHAR(50),
  codigo_postal VARCHAR(10),
  pais VARCHAR(50)
);
INSERT INTO clientes (idcliente, nombre, direccion, ciudad, codigo_postal, pais)
VALUES
  (1, 'Juan Pérez', 'Calle 123', 'Ciudad de México', '12345', 'México'),
  (2, 'María García', 'Avenida Principal 456', 'Monterrey', '67890', 'México'),
  (3, 'Carlos López', 'Calle Principal 789', 'Guadalajara', '54321', 'México'),
  (4, 'Ana Rodríguez', 'Carrera 10', 'Bogotá', '11111', 'Colombia'),
  (5, 'Luisa Martínez', 'Calle 20', 'Medellín', '22222', 'Colombia'),
  (6, 'Pedro Gómez', 'Avenida Central', 'Cali', '33333', 'Colombia'),
  (7, 'Pablo Fernández', 'Calle Principal 1', 'Madrid', '28001', 'España'),
  (8, 'Sofía Torres', 'Avenida Gran Vía', 'Barcelona', '08001', 'España'),
  (9, 'Javier Ramírez', 'Calle Diagonal', 'Valencia', '46001', 'España'),
  (10, 'Fernanda Silva', 'Avenida 9 de Julio', 'Buenos Aires', '1000', 'Argentina'),
  (11, 'Diego López', 'Calle Florida', 'Córdoba', '2000', 'Argentina'),
  (12, 'Gabriela González', 'Avenida Libertador', 'Rosario', '3000', 'Argentina'),
  (13, 'Mario Huamán', 'Jirón de la Unión', 'Lima', '01', 'Perú'),
  (14, 'Rosa Cruz', 'Avenida Arequipa', 'Arequipa', '02', 'Perú'),
  (15, 'Andrés Torres', 'Calle Las Nazarenas', 'Cusco', '03', 'Perú'),
  (16, 'Camila Soto', 'Avenida Providencia', 'Santiago', '8320000', 'Chile'),
  (17, 'Lucas Morales', 'Calle Alonso de Córdova', 'Viña del Mar', '8320000', 'Chile'),
  (18, 'Valentina Castro', 'Avenida Apoquindo', 'Valparaíso', '8320000', 'Chile'),
  (19, 'Mariano Mendoza', 'Calle Tacna', 'Arica', '1000000', 'Chile'),
  (20, 'Laura Torres', 'Avenida Pedro Montt', 'Antofagasta', '1000000', 'Chile'),
  (21, 'Isabella Morales', 'Calle Principal 2', 'Ciudad de México', '54321', 'México'),
  (22, 'Emilio Vargas', 'Avenida Reforma', 'Ciudad de México', '12345', 'México'),
  (23, 'Valeria González', 'Calle Morelos', 'Monterrey', '67890', 'México'),
  (24, 'Daniel Silva', 'Avenida Juárez', 'Monterrey', '54321', 'México'),
  (25, 'Sara Ramírez', 'Calle Independencia', 'Guadalajara', '11111', 'México'),
  (26, 'Javier García', 'Avenida Hidalgo', 'Guadalajara', '22222', 'México'),
  (27, 'Camila Torres', 'Calle 20 de Noviembre', 'Bogotá', '33333', 'Colombia'),
  (28, 'Diego Castro', 'Avenida de los Andes', 'Bogotá', '67890', 'Colombia'),
  (29, 'Valentina Vargas', 'Calle Santander', 'Medellín', '11111', 'Colombia'),
  (30, 'Andrés Pérez', 'Avenida Oriental', 'Medellín', '54321', 'Colombia'),
  (31, 'Luciana López', 'Calle Mayor', 'Cali', '22222', 'Colombia'),
  (32, 'Sebastián Ramírez', 'Avenida 9 de Octubre', 'Cali', '33333', 'Colombia'),
  (33, 'Paula Fernández', 'Calle Gran Vía', 'Madrid', '11111', 'España'),
  (34, 'Joaquín Torres', 'Avenida Paseo del Prado', 'Madrid', '22222', 'España'),
  (35, 'Lucía Herrera', 'Calle Serrano', 'Barcelona', '33333', 'España'),
  (36, 'Tomás Martínez', 'Avenida Diagonal', 'Barcelona', '67890', 'España'),
  (37, 'Catalina Castro', 'Calle San Martín', 'Valencia', '54321', 'España'),
  (38, 'Mateo Morales', 'Avenida Blasco Ibáñez', 'Valencia', '11111', 'España'),
  (39, 'Isidora Ramírez', 'Calle Florida', 'Buenos Aires', '22222', 'Argentina'),
  (40, 'Benjamín Silva', 'Avenida Corrientes', 'Buenos Aires', '33333', 'Argentina'),
  (41, 'Valentín Gómez', 'Calle Hidalgo', 'Córdoba', '67890', 'Argentina'),
  (42, 'Renata Torres', 'Avenida Libertador', 'Córdoba', '54321', 'Argentina'),
  (43, 'Emilio Soto', 'Calle Santa Fe', 'Rosario', '11111', 'Argentina'),
  (44, 'Martina Morales', 'Avenida 27 de Abril', 'Rosario', '22222', 'Argentina'),
  (45, 'Felipe González', 'Calle Huallaga', 'Lima', '33333', 'Perú'),
  (46, 'Renata Castro', 'Avenida Abancay', 'Lima', '67890', 'Perú'),
  (47, 'Sebastián Herrera', 'Calle Mariscal Miller', 'Arequipa', '54321', 'Perú'),
  (48, 'Antonella Ramírez', 'Avenida Dolores', 'Arequipa', '11111', 'Perú'),
  (49, 'Maximiliano Silva', 'Calle Merced', 'Cusco', '22222', 'Perú'),
  (50, 'Valentina Torres', 'Avenida El Sol', 'Cusco', '33333', 'Perú'),
  (51, 'Agustín Morales', 'Calle Merced', 'Santiago', '67890', 'Chile'),
  (52, 'Renata Castro', 'Avenida Providencia', 'Santiago', '54321', 'Chile'),
  (53, 'Matías Herrera', 'Calle Alonso de Córdova', 'Viña del Mar', '11111', 'Chile'),
  (54, 'Emilia Ramírez', 'Avenida San Martín', 'Viña del Mar', '22222', 'Chile'),
  (55, 'Luciano González', 'Calle San Martín', 'Valparaíso', '33333', 'Chile'),
  (56, 'Delfina Silva', 'Avenida Errázuriz', 'Valparaíso', '67890', 'Chile'),
  (57, 'Máximo López', 'Calle 21 de Mayo', 'Arica', '54321', 'Chile'),
  (58, 'Isidora Morales', 'Avenida Pedro Montt', 'Arica', '11111', 'Chile'),
  (59, 'Felipe Castro', 'Calle Rancagua', 'Antofagasta', '22222', 'Chile'),
  (60, 'Constanza Torres', 'Avenida Balmaceda', 'Antofagasta', '33333', 'Chile');

select count(idcliente) as numerodepersonas, pais
from clientes
group by pais
having   count (idcliente) >5 
order by numerodepersonas desc;

--45 

create table facturas(
  numero int not null,
  fecha datetime,
  cliente varchar(30),
  primary key(numero)
);

create table detalles(
  numerofactura int not null,
  numeroitem int not null, 
  articulo varchar(30),
  precio decimal(5,2),
  cantidad int,
  primary key(numerofactura,numeroitem),
   constraint FK_detalles_numerofactura
   foreign key (numerofactura)
   references facturas(numero)
   on update cascade
   on delete cascade
);

go

set dateformat ymd;

INSERT INTO facturas (numero, fecha, cliente) VALUES
  (1, '2023-06-28', 'Juan Pérez'),
  (2, '2023-06-28', 'María González'),
  (3, '2023-06-28', 'Carlos López'),
  (4, '2023-06-28', 'Ana Rodríguez'),
  (5, '2023-06-28', 'Luisa Martínez'),
  (6, '2023-06-28', 'Pedro Hernández'),
  (7, '2023-06-28', 'Laura Gómez'),
  (8, '2023-06-28', 'Diego Torres'),
  (9, '2023-06-28', 'Valentina Ramírez'),
  (10, '2023-06-28', 'Andrés Silva'),
  (11, '2023-06-28', 'Camila Vargas'),
  (12, '2023-06-28', 'Mateo Castro'),
  (13, '2023-06-28', 'Isabella Rios'),
  (14, '2023-06-28', 'Santiago Morales'),
  (15, '2023-06-28', 'Valeria Rojas'),
  (16, '2023-06-28', 'Daniel Acosta'),
  (17, '2023-06-28', 'Mariana Duarte'),
  (18, '2023-06-28', 'Alejandro Cardona'),
  (19, '2023-06-28', 'Fernanda Mendoza'),
  (20, '2023-06-28', 'Gabriel Medina');

INSERT INTO detalles (numerofactura, numeroitem, articulo, precio, cantidad) VALUES
  (1, 1, 'Lápiz', 1.99, 5),
  (1, 2, 'Cuaderno', 3.99, 3),
  (1, 3, 'Bolígrafo', 0.99, 10),
  (2, 1, 'Goma de borrar', 0.5, 8),
  (2, 2, 'Marcadores', 2.49, 4),
  (2, 3, 'Pegamento', 1.99, 2),
  (3, 1, 'Regla', 1.25, 5),
  (3, 2, 'Tijeras', 2.99, 2),
  (3, 3, 'Notas adhesivas', 0.75, 6),
  (4, 1, 'Lápices de colores', 4.99, 1),
  (4, 2, 'Borrador', 0.99, 3),
  (4, 3, 'Cinta adhesiva', 1.49, 2),
  (5, 1, 'Resaltador', 1.75, 4),
  (5, 2, 'Papel de carta', 2.99, 2),
  (5, 3, 'Clips', 0.25, 10),
  (6, 1, 'Corrector líquido', 1.99, 3),
  (6, 2, 'Carpeta', 2.49, 2),
  (6, 3, 'Sacapuntas', 0.99, 5),
  (7, 1, 'Calculadora', 9.99, 1),
  (7, 2, 'Agenda', 4.99, 1),
  (8, 1, 'Lápiz', 1.99, 5),
  (8, 2, 'Cuaderno', 3.99, 3),
  (8, 3, 'Bolígrafo', 0.99, 10),
  (9, 1, 'Goma de borrar', 0.5, 8),
  (9, 2, 'Marcadores', 2.49, 4),
  (9, 3, 'Pegamento', 1.99, 2),
  (10, 1, 'Regla', 1.25, 5),
  (10, 2, 'Tijeras', 2.99, 2),
  (10, 3, 'Notas adhesivas', 0.75, 6),
  (11, 1, 'Lápices de colores', 4.99, 1),
  (11, 2, 'Borrador', 0.99, 3),
  (11, 3, 'Cinta adhesiva', 1.49, 2),
  (12, 1, 'Resaltador', 1.75, 4),
  (12, 2, 'Papel de carta', 2.99, 2),
  (12, 3, 'Clips', 0.25, 10),
  (13, 1, 'Corrector líquido', 1.99, 3),
  (13, 2, 'Carpeta', 2.49, 2),
  (13, 3, 'Sacapuntas', 0.99, 5),
  (14, 1, 'Calculadora', 9.99, 1),
  (14, 2, 'Agenda', 4.99, 1),
  (15, 1, 'Lápiz', 1.99, 5),
  (15, 2, 'Cuaderno', 3.99, 3),
  (15, 3, 'Bolígrafo', 0.99, 10),
  (16, 1, 'Goma de borrar', 0.5, 8),
  (16, 2, 'Marcadores', 2.49, 4),
  (16, 3, 'Pegamento', 1.99, 2),
  (17, 1, 'Regla', 1.25, 5),
  (17, 2, 'Tijeras', 2.99, 2),
  (17, 3, 'Notas adhesivas', 0.75, 6),
  (18, 1, 'Lápices de colores', 4.99, 1),
  (18, 2, 'Borrador', 0.99, 3),
  (18, 3, 'Cinta adhesiva', 1.49, 2),
  (19, 1, 'Resaltador', 1.75, 4),
  (19, 2, 'Papel de carta', 2.99, 2),
  (19, 3, 'Clips', 0.25, 10),
  (20, 1, 'Corrector líquido', 1.99, 3),
  (20, 2, 'Carpeta', 2.49, 2),
  (20, 3, 'Sacapuntas', 0.99, 5),
  (1, 4, 'Calculadora', 9.99, 1),
  (1, 5, 'Agenda', 4.99, 1);

  select * from Empleados;
select id ,nombre ,apellido ,salario from empleados 
where salario >=
(select avg(salario) from empleados)


select nombre, apellido  from Empleados
where id =
(select id from Empleados where edad=25)


use principalprueba;
select * from facturas;

select * from detalles; 

-- cuales clientes han comprado lapices

-- video 47 

select * from sys.tables;


create TABLE productos (
  idproducto INT,
  nombre VARCHAR(100),
  precio_unidad NUMERIC(6,2),
  existencia INT,
  vendidos INT
);
INSERT INTO productos (idproducto, nombre, precio_unidad, existencia, vendidos)
VALUES
  (1, 'Martillo', 12.50, 100, 50),
  (2, 'Destornillador', 6.75, 80, NULL),
  (3, 'Taladro', 75.00, 25, 10),
  (4, 'Sierra eléctrica', 120.25, 15, NULL),
  (5, 'Cinta métrica', 5.20, 200, 100),
  (6, 'Llave inglesa', 9.80, 50, NULL),
  (7, 'Pala', 15.00, 40, 20),
  (8, 'Clavos', 1.50, 500, NULL),
  (9, 'Tornillos', 2.00, 300, 150),
  (10, 'Alicate', 7.25, 70, NULL),
  (11, 'Escalera', 40.00, 10, 5),
  (12, 'Cincel', 4.30, 40, NULL),
  (13, 'Cepillo', 8.15, 30, 15),
  (14, 'Nivel', 10.50, 25, NULL),
  (15, 'Brocha', 3.75, 120, 60),
  (16, 'Talocha', 6.00, 80, NULL),
  (17, 'Llave ajustable', 11.20, 45, 25),
  (18, 'Mazo', 9.90, 20, NULL),
  (19, 'Formón', 5.80, 35, 15),
  (20, 'Serrucho', 8.50, 60, NULL),
  (21, 'Taladro inalámbrico', 95.00, 20, 15),
  (22, 'Llave de tubo', 13.50, 30, 20),
  (23, 'Pintura blanca', 18.75, 50, NULL),
  (24, 'Cepillo metálico', 6.25, 40, 30),
  (25, 'Escuadra', 2.80, 100, 50),
  (26, 'Broca para concreto', 4.50, 75, 40),
  (27, 'Gafas de seguridad', 8.90, 60, 45),
  (28, 'Cinta adhesiva', 1.25, 200, NULL),
  (29, 'Nivel láser', 45.50, 10, 5),
  (30, 'Sierra de mano', 7.80, 50, 35),
  (31, 'Alicates de corte', 9.25, 30, 20),
  (32, 'Tornillos de acero', 2.50, 500, NULL),
  (33, 'Destornillador de precisión', 5.50, 40, 30),
  (34, 'Martillo de goma', 10.75, 25, 20),
  (35, 'Llave hexagonal', 6.60, 50, NULL),
  (36, 'Pala plegable', 14.00, 15, 10),
  (37, 'Escobilla de alambre', 3.25, 80, 60),
  (38, 'Clavos galvanizados', 2.75, 1000, NULL),
  (39, 'Cincel de punta', 7.40, 35, 25),
  (40, 'Cúter', 2.15, 90, NULL);


  select *  from productos;

  select nombre, precio_unidad, isnull(vendidos,0) as vendidos
  from productos


  select * from articulos;

  update clientes set ciudad =null
  where idcliente in(1,3,9,10,13,11,14,20,23,34,38,40,46)
  --1. ver artiuclos de mi inventario con existencia normal
  --2. ver articulos que necesitan ser pedidos
  --3. ver articulos menos vendidos 

  select nombre,cantidad,
  case 
	 when cantidad >30 then 'articulo con sobre-existencia'
	 when cantidad <10 then 'se debe ralizar pedido '
	 else 'existencia normal'
	 end as inventario
  from articulos;

  select nombre,ciudad, pais
  from clientes
  order by 
  (case 
   when ciudad is null then pais
   else ciudad
   end);
   --49  funciones matematicas

   select pi() as pi;
   
   --funcion de redondeo de cifras

   select ceiling (123.45) as redondeo;

   -- funcion para eliminar decimales
  
  select floor(123.45);
  -- funcion de redondeo con cifra de aproximacion

  select round(123.588,2);

  --potencia
  select power(4,3);

  -- rand  numero randon

  select rand()* (101-1);

  -- raiz cudrada 

  select sqrt(81) as raiz

  -- video 50 quede  funciones string 

  use principalprueba;
  
  
  -- funcion char(binario)
  select nombre + char(65) as nombres from empleados;

  --funcion concat, para unir valores separados por comas 
  select concat(' hola ',' a ','todos');
 --contar caracteres 

   select len('hola a todos') as temario

-- funcion  para pasar a mayusculas

 select upper('hola a todos')

 -- funcion lower para pasar a minusculas 

 select lower('SISAS HOMBRE')

 -- ltrim quita espacios en blancos

select  ltrim('    hola a todos       ')

 -- rtrim quita espacios en blancos

 select  rtrim('                  hola a todos       ')

  --trim quita los espacios de todo el campo

select   trim(' espacios   ')

-- replace remplaza las letras

select replace ('el cocobonbo','o','a' )

-- traladar caracteres


select translate ('abcdef','abce','0000')

-- replicate para replicar

select replicate(' hola',10);

-- al revez
select REVERSE(123456) as alreves;

select REVERSE('breinner') as alreves;

-- video 51  quede

-- me trae la fehca
select getdate() as fecha;

-- me agrega un dia a la fecha

select dateadd(day,1,getdate());

--me agrega meses 

select dateadd(month,1,getdate());


-- se agrega años
select dateadd(year,1,getdate());

--se agrega horas

select dateadd(hour,1,getdate());

--agregar minutos

select dateadd(minute,1,getdate());

-- video 51 
use principalprueba; 

drop table detalles;

truncate table facturas;

INSERT INTO facturas (numero, fecha, cliente)
VALUES
  (1, '2018-01-01', 'Juan Pérez'),
  (2, '2018-01-15', 'María González'),
  (3, '2018-01-22', 'Pedro Rodríguez'),
  (4, '2018-02-10', 'Ana López'),
  (5, '2018-02-05', 'Luisa Martínez'),
  (6, '2018-03-12', 'Carlos Sánchez'),
  (7, '2018-04-20', 'Laura Torres'),
  (8, '2018-05-18', 'Javier Herrera'),
  (9, '2018-06-27', 'Sofía Ramírez'),
  (10, '2018-10-14', 'Diego Castro'),
  (11, '2019-01-03', 'Valeria Gómez'),
  (12, '2019-02-25', 'Andrés Cruz'),
  (13, '2019-03-17', 'Gabriela Vargas'),
  (14, '2019-04-08', 'Miguel Flores'),
  (15, '2019-05-19', 'Fernanda Mendoza'),
  (16, '2019-06-27', 'Roberto Ríos'),
  (17, '2019-07-14', 'Paulina Acosta'),
  (18, '2019-08-29', 'Emilio Castro'),
  (19, '2019-09-11', 'Carolina Mejía'),
  (20, '2019-10-05', 'Jorge Mora'),
  (21, '2021-01-01', 'Juan Pérez'),
  (22, '2021-02-15', 'María González'),
  (23, '2021-03-22', 'Pedro Rodríguez'),
  (24, '2021-04-10', 'Ana López'),
  (25, '2021-05-05', 'Luisa Martínez'),
  (26, '2021-06-12', 'Carlos Sánchez'),
  (27, '2021-07-20', 'Laura Torres'),
  (28, '2021-08-18', 'Javier Herrera'),
  (29, '2021-09-27', 'Sofía Ramírez'),
  (30, '2021-10-14', 'Diego Castro'),
  (31, '2019-01-03', 'Valeria Gómez'),
  (32, '2020-02-25', 'Andrés Cruz'),
  (33, '2020-03-17', 'Gabriela Vargas'),
  (34, '2020-04-08', 'Miguel Flores'),
  (35, '2020-05-19', 'Fernanda Mendoza'),
  (36, '2020-06-27', 'Roberto Ríos'),
  (37, '2020-07-14', 'Paulina Acosta'),
  (38, '2020-08-29', 'Emilio Castro'),
  (39, '2020-09-11', 'Carolina Mejía'),
  (40, '2020-10-05', 'Jorge Mora');

  select * from facturas
  where fecha between '2018-01-01'
  and dateadd(year,3,'2018-01-01')

  select datename(month, getdate())as mes;

  -- se establecio el idioma a español

  set language spanish; 


  select datename(month,getdate()) as mes;
  select datepart(month,getdate()) as mesnumero;

  select datename(day,getdate()) as Dia;

  select cliente, fecha , datename(month, fecha) as mes
  from facturas 
  where datename(month,fecha)= datename(month, getdate());

 -- trae caracteres de la parte izquierda
 select  left(cliente,3) from facturas;



 -- trae caracteres de la parte derecha
select right (cliente,3) as caracteres_nombres from facturas 
 order by caracteres_nombres asc;

 
 
 -- stuff remplazo donde empieza  y donde termina 

select stuff('hola a todos',1,6,'amigos') as rempplazo;



-- video 53  TRANSACT SQL 

-- BULK INSERT DATOS EXTERIORES

create table autos(
marca varchar (50),
modelo varchar(50),
tipo varchar(25),
color varchar (20)
)

bulk insert 
autos -- tabla destino
from 'C:\Users\Breinner\Downloads\TABLA_AUTOS.txt'
with (firstrow=2)

select *  from autos;


--video 54 quede 

select * from sys.tables;

CREATE TABLE ventas (
    idvendedor INT,
    ciudad VARCHAR(50),
    pais VARCHAR(50),
    cuota_ventas MONEY,
    comision MONEY,
    ven_ult_anio MONEY,
    fecha DATE
);

INSERT INTO ventas (idvendedor, ciudad, pais, cuota_ventas, comision, ven_ult_anio, fecha)
VALUES
    (1, 'Buenos Aires', 'Argentina', 2500.00, 150.00, 785432, '2019-05-10'),
    (2, 'Rosario', 'Argentina', 3800.00, 230.00, 623591, '2020-07-22'),
    (3, 'Córdoba', 'Argentina', 4200.00, 250.00, 752164, '2021-09-14'),
    (4, 'Mendoza', 'Argentina', 3100.00, 190.00, 926532, '2022-12-01'),
    (5, 'Mar del Plata', 'Argentina', 2700.00, 160.00, 531246, '2023-03-29'),
    (6, 'Sao Paulo', 'Brasil', 2900.00, 180.00, 654821, '2018-11-05'),
    (7, 'Río de Janeiro', 'Brasil', 4100.00, 240.00, 719638, '2019-10-18'),
    (8, 'Belo Horizonte', 'Brasil', 3600.00, 210.00, 897421, '2020-08-27'),
    (9, 'Salvador', 'Brasil', 3800.00, 220.00, 613579, '2021-06-02'),
    (10, 'Fortaleza', 'Brasil', 3200.00, 190.00, 735214, '2022-04-14'),
    (11, 'Ciudad de México', 'México', 2700.00, 160.00, 926485, '2019-01-07'),
    (12, 'Guadalajara', 'México', 3500.00, 210.00, 598723, '2020-02-21'),
    (13, 'Monterrey', 'México', 3900.00, 230.00, 813579, '2021-03-17'),
    (14, 'Puebla', 'México', 3200.00, 190.00, 754921, '2022-06-10'),
    (15, 'Tijuana', 'México', 2900.00, 170.00, 629348, '2023-09-03'),
    (16, 'Lima', 'Perú', 2800.00, 160.00, 832457, '2018-12-15'),
    (17, 'Arequipa', 'Perú', 3300.00, 200.00, 746921, '2019-11-27'),
    (18, 'Trujillo', 'Perú', 3600.00, 210.00, 925317, '2020-10-09'),
    (19, 'Chiclayo', 'Perú', 3100.00, 180.00, 618493, '2021-08-22'),
    (20, 'Cusco', 'Perú', 3000.00, 170.00, 743215, '2022-07-05'),
    (21, 'Rosario', 'Argentina', 2900.00, 180.00, 675821, '2019-08-05'),
    (22, 'Córdoba', 'Argentina', 3100.00, 190.00, 743216, '2020-09-18'),
    (23, 'Mendoza', 'Argentina', 2500.00, 150.00, 562714, '2021-11-02'),
    (24, 'Mar del Plata', 'Argentina', 2700.00, 160.00, 891457, '2022-12-30'),
    (25, 'Sao Paulo', 'Brasil', 3800.00, 220.00, 725913, '2018-10-10'),
    (26, 'Río de Janeiro', 'Brasil', 3600.00, 210.00, 914573, '2019-12-22'),
    (27, 'Belo Horizonte', 'Brasil', 3200.00, 190.00, 671942, '2020-08-05'),
    (28, 'Salvador', 'Brasil', 3100.00, 180.00, 859613, '2021-05-19'),
    (29, 'Fortaleza', 'Brasil', 2800.00, 170.00, 612374, '2022-03-03'),
    (30, 'Ciudad de México', 'México', 3900.00, 230.00, 759281, '2019-04-15'),
    (31, 'Guadalajara', 'México', 3700.00, 220.00, 923671, '2020-06-29'),
    (32, 'Monterrey', 'México', 3300.00, 200.00, 674192, '2021-08-13'),
    (33, 'Puebla', 'México', 3000.00, 180.00, 842519, '2022-11-01'),
    (34, 'Tijuana', 'México', 2600.00, 160.00, 536192, '2023-02-25'),
    (35, 'Lima', 'Perú', 3100.00, 190.00, 753219, '2019-01-12'),
    (36, 'Arequipa', 'Perú', 3300.00, 200.00, 924617, '2020-02-24'),
    (37, 'Trujillo', 'Perú', 3400.00, 200.00, 691534, '2021-04-08'),
    (38, 'Chiclayo', 'Perú', 2900.00, 170.00, 813597, '2022-06-22'),
    (39, 'Cusco', 'Perú', 2700.00, 160.00, 576921, '2023-08-06'),
    (40, 'Santiago', 'Chile', 3200.00, 190.00, 748315, '2018-09-20');

	select * from ventas;

	select * from (
	     select row_number() over (order by a.ven_ult_anio desc) as contador ,
	     a.idvendedor, a.ven_ult_anio from ventas a
	    )as a where a.contador=1;

-- video 55 quede 

-- declare
	--variables
	
--begin 
	--codigo principal
	   --if-else
	  --return
	  --while
	  --case
	  --continue

		--control de eventaulidades 

		--continue
		--break
--end 


if exists (select * from articulos where cantidad=0)
(select nombre, precio ,cantidad
from articulos where cantidad=0)
else
 select 'No hay articulos en 0'

-- video 57

declare
  @id_valor int,
  @nombre varchar  (30),
  @telefono numeric(10),
  @fecha_nac date,
  @activo bit; -- esto es para boleanos

begin 
     set @id_valor = 50;
	 
	 set @nombre='sql server'
	 set @telefono=12345678;
	 set @fecha_nac='1999-03-25'
	set @activo='true'

	 select @nombre as nombre, @telefono as telefono, @fecha_nac as fecha
	 , @activo as booleano

end; 

select * from articulos;


declare 
@valorminimi numeric (10);

begin
 select  @valorminimi = min(precio) from articulos;
 select *  from articulos where precio = @valorminimi ;

end

select * from articulos
where precio=
(select min(precio) from articulos);


declare

  @tabla1 table (
  
  id int,
  nombre varchar (20),
  telefono numeric (10));

  begin

  select * from @tabla1;

  end;


--59 procedimientos almacenados

create procedure pro_existencia
as
select * from articulos
where cantidad <=20;

exec pro_existencia;

create procedure pro_Actulizainventario
as
begin

	if exists(select * from articulos where cantidad=0)
		update articulos set cantidad =10
		where cantidad =0
	else 
	select 'no existe';
end;


exec pro_Actulizainventario;

select * from empleados;

create procedure  p_bonificacion
as
begin

  if exists(select edad from empleados where edad>25)
		
	begin 
		update empleados set salario=salario*0.20	
	   print'se ha aplicado la bonificacion'
	end
  else
	begin 
	print 'no hay empleados mayores de 25'
	end
end;

exec p_bonificacion;
-- video 60 actualizar un procedimiento actualizado
alter procedure  p_bonificacion
as
begin

  if exists(select edad from empleados where edad>20)
		
	begin 
		update empleados set bonificacion=salario*0.20	
	   print'se ha aplicado la bonificacion'
	end
  else
	begin 
	print 'no hay empleados mayores de 20'
	end
end;

exec p_bonificacion;

alter table empleados add  bonificacion int;
select * from empleados;


-- video 61   parametros

create or alter procedure p_busca_emple
  @nombre varchar (30)='juan'
as
select * from empleados where nombre=@nombre;

exec p_busca_emple;


create or alter procedure p_busca_emple_2
@nombre varchar(30)='juan',
@sueldo int=20.00,
@hijos int=25

as
select * from empleados where
nombre =@nombre and salario= @sueldo
and edad=@hijos;

exec p_busca_emple_2

--video 62 con parametros de salida

create or alter procedure p_promedio
	@valor1 numeric (6,2),
	@valor2 numeric (6,2),
	@resultado numeric (6,2) output

as

select @resultado =(@valor1+@valor2)/2;


declare 
 @promedio numeric(6,2)

 exec p_promedio 4271.12,4175.89,
 @promedio output
 select @promedio as promedrio;
 


 create or alter procedure p_emppe_sal_promedio
-- with encryption 
 @edad numeric(30)='%',
 @suma numeric(6,2)output,
 @promedio numeric(6,2)output

 as 
 
begin
	
	select * from empleados where edad like @edad
	select @suma =sum(salario) from empleados where edad like @edad;
	select @promedio = avg(salario) from empleados where edad like @edad;
end

declare 

@sumatoria numeric (6,2),@prom numeric(6,2)

exec  p_emppe_sal_promedio 30 , @sumatoria output, @prom output
select @sumatoria as total , @prom as promedio;




 select * from Empleados order by salario asc;

 -- video 63 encriptacion de objetos
 -- with encryption 



 exec sp_helptext  p_emppe_sal_promedio;

 --video 64 tablas temporables

 create table #usuarios(
 nombre varchar (10),
 clave varchar (10),
 primary key (nombre)
 );
 -- video 65 qude

 create or alter function f_suma
 (@valor1 int , @valor2 int)
 returns int
 as 

 begin
	 declare 
	@resultado int
	set @resultado = @valor1 + @valor2
	return @resultado
end;

select dbo.f_suma(1,2);

select datename(MONTH, fecha) as mes from facturas ;

create or alter function f_meses
(@fecha date)
returns varchar (15)
as
begin 
	declare
	@nombre varchar(15)
	set @nombre=
	case datename(month,@fecha)
	when 'January' then 'enero'
	when 'February' then 'Febrero'
	when 'March' then 'Marzo'
	when 'April' then 'Abril'
	when 'May' then 'Mayo'
	when 'June' then 'Junio'
	when 'July' then 'Julio'
	when 'August' then 'Agosto'
	when 'September' then 'Septembre'
	when 'October' then 'Octubre'
	when 'November' then 'Noviembre'
	when 'Dicember' then 'Diciembre'

	end --case
 return @nombre
end;

select cliente,
dbo.f_meses(fecha) as 'mes de ingreso'
from facturas;

exec sp_helptext f_meses;

select * from facturas;

 set language spanish;

 -- video 66 quede 


 drop table libros 
CREATE TABLE libros (
    codigo INT IDENTITY(1,1) PRIMARY KEY,
    titulo NVARCHAR(100) NOT NULL,
    autor NVARCHAR(100) NOT NULL,
    editorial NVARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

INSERT INTO libros (titulo, autor, editorial, precio) VALUES
('1984', 'George Orwell', 'Debolsillo', 15.00),
('Cien años de soledad', 'Gabriel García Márquez', 'Editorial Sudamericana', 25.99),
('El principito', 'Antoine de Saint-Exupéry', 'Salvat', 10.50),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Salamandra', 19.95),
('Matar un ruiseñor', 'Harper Lee', 'Vintage Books', 12.75),
('El gran Gatsby', 'F. Scott Fitzgerald', 'Scribner', 18.00),
('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Editorial Planeta', 22.50),
('Orgullo y prejuicio', 'Jane Austen', 'Penguin Classics', 14.99),
('Crimen y castigo', 'Fiodor Dostoievski', 'Alianza Editorial', 16.95),
('Los juegos del hambre', 'Suzanne Collins', 'RBA Molino', 17.25),
('La sombra del viento', 'Carlos Ruiz Zafón', 'Planeta', 21.00),
('El código Da Vinci', 'Dan Brown', 'Umbriel Editores', 23.95),
('To Kill a Mockingbird', 'Harper Lee', 'Harper Perennial Modern Classics', 13.50),
('The Lord of the Rings', 'J.R.R. Tolkien', 'Mariner Books', 30.00),
('Pride and Prejudice', 'Jane Austen', 'Vintage Classics', 12.99),
('The Catcher in the Rye', 'J.D. Salinger', 'Back Bay Books', 16.50),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 18.00),
('The Hunger Games', 'Suzanne Collins', 'Scholastic Press', 14.95),
('The Alchemist', 'Paulo Coelho', 'HarperOne', 13.25),
('Brave New World', 'Aldous Huxley', 'Harper Perennial Modern Classics', 11.99),
('La Catedral del Mar', 'Ildefonso Falcones', 'Grijalbo', 16.99),
('La Sombra de la Serpiente', 'Rick Riordan', 'Montena', 22.50),
('El Hobbit', 'J.R.R. Tolkien', 'Minotauro', 18.95),
('El amor en los tiempos del cólera', 'Gabriel García Márquez', 'Diana', 19.75),
('Cazadores de sombras: Ciudad de hueso', 'Cassandra Clare', 'Destino', 14.50),
('Drácula', 'Bram Stoker', 'Anaya', 15.99),
('It', 'Stephen King', 'Debolsillo', 27.25),
('Los pilares de la Tierra', 'Ken Follett', 'Follett', 20.00),
('El nombre del viento', 'Patrick Rothfuss', 'Plaza & Janés', 23.95),
('Cien años de soledad', 'Gabriel García Márquez', 'Círculo de Lectores', 21.99),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Wordsworth Classics', 10.99),
('1984', 'George Orwell', 'Secker & Warburg', 14.75),
('The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', 16.50),
('The Lord of the Rings', 'J.R.R. Tolkien', 'Houghton Mifflin Harcourt', 28.00),
('The Hunger Games', 'Suzanne Collins', 'Scholastic Corporation', 14.95),
('Harry Potter and the Sorcerers Stone', 'J.K. Rowling', 'Arthur A. Levine Books', 19.99),
('Matar a un ruisenior', 'Harper Lee', 'Harper Lee', 12.50),
('Pride and Prejudice', 'Jane Austen', 'Penguin Books', 11.99),
('The Alchemist', 'Paulo Coelho', 'HarperOne', 14.25),
('Brave New World', 'Aldous Huxley', 'Harper Brothers', 10.99);

select * from libros;

create or alter function f_autor
(@autor varchar(30))
returns table

as
return (select * from libros 
	where autor like @autor+'%');

select * from f_autor('b');

select * from libros  where autor='harper lee';

-- video 67 triggers

create table prueba(
id int null,
nombre varchar(10),
fecha date,
cantidad numeric(3,2)

);

create table control(
usuario varchar(30),
fecha date,
accion varchar(50)
);

create or alter trigger t_inserta
on prueba
after insert
as
 begin
 declare  @usuario varchar (30);
 set @usuario=suser_name()
 insert into control values(@usuario,getdate(),'insert');
 
 end;

 insert into prueba values(1,'jose',getdate(),1.20 );

 --68 video

 create table control_emple(
 usuario varchar(30),
fecha date,
hora varchar(50),
accion varchar(50)
 );

 create or alter trigger tri_control_emple
 on empleados
 for insert, update, delete
 as
  declare
   @hora varchar(20)=right (getdate(),8);
  if exists(select 0 from inserted)
   begin 
   if exists(select 0 from deleted)
	   begin 
		insert into control_emple values
		(suser_name(),getdate(),@hora,'Actualizo en la tabla empleados');
		end
		  else
		  begin
		     insert into control_emple values
			 (suser_name(),getdate(),@hora,'inserto en la tabla empleados');
		     end
	end
  else
    begin 
		insert into control_emple values
		(suser_name(),getdate(),@hora,'borro en la tabla empleados');
	end;

	insert into empleados values (25,'manuel','gonazales',25,31140869,'direccion 3030','1999-03-25',600.00,'no',42);
	update empleados set salario=2000 where id=25;
	delete  from empleados  where id=25;
	set language spanish
	select * from control_emple;

	exec sp_help empleados;

	-- 69 instead of

	truncate table control_emple;
	
	exec sp_rename 'control_emple','control_productos';

	create or alter trigger tr_blockinsert_productos
	on productos
	instead of insert

	as 
	 begin 
	  insert into control_productos values(suser_name(),getdate(),RIGHT(getdate(),8),'intento un insert');
	  print 'NO ES POSIBLE INSERTAR DATOS EN ESA TABLA';
 
  end 

  insert into productos values(42,'soldador electrico',80.40,4,0);

	
	select * from productos;
	select * from control_emple;
	select * from control_productos;

	--video  70 enable disables

	alter table productos disable trigger
	tr_blockinsert_productos;
	--71 quede Raise Error

	create or alter trigger tr_borra_empleados
	on empleados for delete

	as
	 if (select count(*) from deleted)>2
	  begin  
	   raiserror ('no se puede elimar mas de dos empleados',16,1);
	   rollback transaction -- esto borra la sentencia de borrar
	   end;

	   select * from empleados;
	 delete from dbo.Empleados where  id in (2,3,4);

	 select  * from sys.tables;
	 exec sp_helptext tri_control_emple;

	 --video 72 bulk insert
if(select name from tempdb.sys.tables) like '%#basepedidos'
drop table #basepedidos

create table #basepedidos(
CodigoPedido varchar(100) not null,
DocumentoCliente varchar(100) not null,
codigoCiudad int null,
Codigoproducto varchar(100) null,
CantidadProducto int,
FechaPedido date,
HoraPedido time
);


bulk insert #basepedidos
from 'C:\Users\Breinner\Documents\bulkinsert\basepedidos.txt'
with (firstrow=2)

select * from #basepedidos;

--73 video variables de sistemas

print 'version' + @@version; --devuelve la version del sql server

print 'lenguage' +@@language;--devuelve idioma del sql server

print 'servidor' + @@servername; --devulve el nombre del servidor nombreequipo

print 'conexiones' +str( @@connections);-- devuelve numero de conexiones de usuario

print 'conexiones maximas' + str(@@max_connections); -- conexiones maximas

print 'tiempo del servidor' + str(@@cpu_busy);-- tiempo del servidor en segundos

print 'tiempo del servidor desconectado' + str(@@idle);-- tiempo del servidor en segundos

print 'transaciones activas' + str(@@trancount); --devuelve el numero de transacciones en mi base 

print 'ultimas filas' + str(@@rowcount);-- filas afectadas ultima consulta

print 'Error ultima operacion' + str(@@error);-- error de ultima operacion

print 'ultimo identity' + str(@@identity); -- devulve utimo numero indetificador 

print 'bloque en milesegundos' + str(@@lock_timeout); --devuelve  tiempo  de bloqueo de session

--video 74 quede curso loop-bucles

declare 
 @conteo int=0;

 while @conteo<=10
 begin
  print convert(varchar,@conteo);
  set @conteo+=1;

  end;

  -- video 78
 
  select * from productos;

  create or alter procedure pr_descuento
  as
  declare  @id int
  select @id=min(idproducto) from productos

  while @id>0
   begin 
   update productos set  precio_unidad =precio_unidad*0.9
   where idproducto =@id and vendidos is null

   select @id =min(idproducto) from productos
   where idproducto >@id and vendidos is null

end;

exec pr_descuento;

--video 79 cursores

select * from productos;

declare 
 @descripcion numeric(6,2);
 declare
 prod_info cursor  for
 select precio_unidad from productos
 open prod_info
 fetch next from prod_info into @descripcion
  while @@fetch_status=0
   begin 
  print @descripcion
  fetch next from pro_info into @descripcion
  end
  close pro_info
  deallocate prod_info

  -- video 82 usuarios de la base de datos

  select * from sys.schemas;
  create schema prubea2;

  -- video 84 quede  jobs en sql server automizador de tareas 
  select * from control;

  grant insert on dbo.control to usuariogenerico;

  select * from control;

  -- 85   backup base de datos

  backup database prueba2
  to disk ='D:\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\Backup\prueba2.bak';


