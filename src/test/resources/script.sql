create table rezerwamiesieczna(
	rok int, 
	miesiac int,
	numerSzkody varchar(255),
	typRezerwy varchar(255),
	rodzajRezerwy varchar(255),
	stanSzkody varchar(255),
	wartosc decmial(19, 2)
)

create table rezerwamiesiecznanaryzyku(
	id int,
	rezerwamiesieczna_rok int, 
	rezerwamiesieczna_miesiac int,
	rezerwamiesieczna_numerSzkody varchar(255),
	rezerwamiesieczna_typRezerwy varchar(255),
	nazwaRyzyka varchar(255),
	rodzajRezerwy varchar(255),
	wartosc decimal(19, 2)
)