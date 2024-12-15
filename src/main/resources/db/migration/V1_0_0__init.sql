-- public.buy_detail_transaction definition

-- Drop table

-- DROP TABLE public.buy_detail_transaction;

CREATE TABLE public.buy_detail_transaction (
	price numeric(38, 2) NULL,
	quantity numeric(38, 2) NULL,
	total numeric(38, 2) NULL,
	buy_detail_transaction_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	buy_transaction_id int8 NULL,
	created_at timestamp(6) NULL,
	product_id int8 NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT buy_detail_transaction_pkey PRIMARY KEY (buy_detail_transaction_id)
);


-- public.buy_transaction definition

-- Drop table

-- DROP TABLE public.buy_transaction;

CREATE TABLE public.buy_transaction (
	book_number int4 NULL,
	book_page int4 NULL,
	is_cancel bool NULL,
	net numeric(38, 2) NULL,
	total numeric(38, 2) NULL,
	vat numeric(38, 2) NULL,
	buy_date timestamp(6) NULL,
	buy_transaction_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	cancel_date timestamp(6) NULL,
	created_at timestamp(6) NULL,
	partner_id int8 NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	image_path varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT buy_transaction_pkey PRIMARY KEY (buy_transaction_id)
);


-- public.partner definition

-- Drop table

-- DROP TABLE public.partner;

CREATE TABLE public.partner (
	is_head_office bool NULL,
	created_at timestamp(6) NULL,
	partner_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	updated_at timestamp(6) NULL,
	address varchar(255) NULL,
	address2 varchar(255) NULL,
	branch_name varchar(255) NULL,
	contact_person varchar(255) NULL,
	created_by varchar(255) NULL,
	description varchar(255) NULL,
	email varchar(255) NULL,
	email2 varchar(255) NULL,
	mobile_no varchar(255) NULL,
	mobile_no2 varchar(255) NULL,
	"name" varchar(255) NULL,
	tax_id varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT partner_pkey PRIMARY KEY (partner_id)
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	created_at timestamp(6) NULL,
	product_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	unit_id int8 NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id)
);


-- public.sell_detail_transaction definition

-- Drop table

-- DROP TABLE public.sell_detail_transaction;

CREATE TABLE public.sell_detail_transaction (
	price numeric(38, 2) NULL,
	quantity numeric(38, 2) NULL,
	total numeric(38, 2) NULL,
	created_at timestamp(6) NULL,
	product_id int8 NULL,
	sell_detail_transaction_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	sell_transaction_id int8 NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT sell_detail_transaction_pkey PRIMARY KEY (sell_detail_transaction_id)
);


-- public.sell_transaction definition

-- Drop table

-- DROP TABLE public.sell_transaction;

CREATE TABLE public.sell_transaction (
	book_number int4 NULL,
	book_page int4 NULL,
	is_cancel bool NULL,
	net numeric(38, 2) NULL,
	total numeric(38, 2) NULL,
	vat numeric(38, 2) NULL,
	cancel_date timestamp(6) NULL,
	created_at timestamp(6) NULL,
	partner_id int8 NULL,
	sell_date timestamp(6) NULL,
	sell_transaction_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	image_path varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT sell_transaction_pkey PRIMARY KEY (sell_transaction_id)
);


-- public.unit definition

-- Drop table

-- DROP TABLE public.unit;

CREATE TABLE public.unit (
	created_at timestamp(6) NULL,
	unit_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	updated_at timestamp(6) NULL,
	created_by varchar(255) NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	updated_by varchar(255) NULL,
	CONSTRAINT unit_pkey PRIMARY KEY (unit_id)
);


-- public.user_profile definition

-- Drop table

-- DROP TABLE public.user_profile;

CREATE TABLE public.user_profile (
	active bool NULL,
	created_at timestamp(6) NULL,
	updated_at timestamp(6) NULL,
	user_id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	address varchar(255) NULL,
	created_by varchar(255) NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	"password" varchar(255) NULL,
	phone varchar(255) NULL,
	"role" varchar(255) NULL,
	updated_by varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT user_profile_pkey PRIMARY KEY (user_id)
);