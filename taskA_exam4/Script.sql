create table route (
	route_id serial primary key,
	route_number int not null unique,
	route_start varchar(100) not null,
	route_end varchar(100) not null
)

create table bus (
	bus_id serial primary key,
	bus_number varchar(100) not null unique,
	route_id int references route(route_id) not null
);


create table driver (
	driver_id serial primary key,
	driver_full_name varchar(100) not null,
	bus_id int references bus(bus_id) not null
);

create table bus_log (
	bus_log_id serial primary key,
	driver_id int references driver(driver_id) not null,
	bus_id int references bus(bus_id) not null,
	time timestamp not null
);

insert into route (route_number, route_start, route_end) 
	values(101, 'Bishkek', 'Astana'),
		  (102, 'Astana', 'Almaty'),
		  (103, 'Tokmok', 'Bishkek'),
		  (104, 'Kant', 'Batken')
		  
insert into bus (bus_number, route_id)
	values('B7777', 1),
		  ('AB8976D', 2),
		  ('C8888A', 3),
		  ('B6666', 4)
		  
insert into driver (driver_full_name, bus_id)
	values('A A', 1),
		  ('B B', 2),
		  ('C C', 3),
		  ('D D', 4)
		  
insert into bus_log	(driver_id, bus_id, time)
	values(1, 1, '2020-06-22 19:10:25'),
	      (2, 2, '2020-07-22 20:20:35'),
	      (3, 3, '2020-08-22 21:30:45'),
	      (4, 4, '2020-09-22 22:40:55')
