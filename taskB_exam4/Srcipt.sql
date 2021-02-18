create table news (
	news_id serial primary key,
	news_header varchar(100) not null,
	news_text varchar(255) not null,
	news_date timestamp not null
);
