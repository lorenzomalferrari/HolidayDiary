-- TABLE
CREATE TABLE Notes(
	id integer PRIMARY KEY,

	title text not null,
	description text not null,

	creation_data DATA,

	id_user integer not null,
	id_travel integer,
	id_place integer,
	id_picture integer,

	foreign key (id_user) references User (id),
	foreign key (id_travel) references Travel (id),
	foreign key (id_place) references Place (id),
	foreign key (id_picture) references Picture (id)

	
);
CREATE TABLE Pictures (
	id integer PRImary key,

  	title text not null,
  	description text,
 	path text not null,

  	id_user text not null,
	id_travel integer,
	id_place integer,
	id_note integer,

  	foreign key (id_user) references User (id),
	foreign key (id_travel) references Travel (id),
	foreign key (id_place) references Place (id),
	foreign key (id_note) references Note (id)

);
CREATE TABLE Places(
	id integer not null,

	title text,
	description text,
	latitude integer not null,
	longitude integer not null,
	city text,
	country text,

	id_user text not null,
	id_picture integer,
	id_travel integer,
	id_note integer,

	foreign key (id_user) references User (id),
	foreign key (id_picture) references Picture (id),
	foreign key (id_travel) references Travel (id),
	foreign key (id_note) references Note (id)

);
CREATE TABLE Travels(
	id integer PRIMARY KEY,

	title text not null,
	description text not null,
	img_list integer,
	city text,
	country text,
	start_travel Date,
	finish_travel Date,

	registration_date Date,

	id_user integer not null,
	id_note integer,
	id_picture integer,
	id_place integer,

	foreign key (id_user) references User (id),
	foreign key (id_note) references Note (id),
	foreign key (id_picture) references Picture (id),
	foreign key (id_place) references Place (id)
	
);
CREATE TABLE Users(
	id integer PRImary key,


	firstName text,
	lastName text,
	username text,
	email text not null,
	password text not null,
	city text,
	country text,
	gender char,
	birthdate DATE,
	img_account integer,

	registration_date DATE,
	last_access DATE,
  
  	id_picture integer,
	id_travel integer,
	id_note integer,
  	id_place integer,


	foreign key (id_travel) references Travel (id),
	foreign key (id_note) references Note (id),
	foreign key (id_picture) references Picture (id),
	foreign key (id_place) references Place (id)
);