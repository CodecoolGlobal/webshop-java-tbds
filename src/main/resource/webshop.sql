
ALTER TABLE IF EXISTS ONLY public.user DROP CONSTRAINT IF EXISTS pk_user_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.product_category DROP CONSTRAINT IF EXISTS pk_product_category_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.supplier DROP CONSTRAINT IF EXISTS pk_supplier_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.product DROP CONSTRAINT IF EXISTS pk_product_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.product DROP CONSTRAINT IF EXISTS fk_product_category_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.product DROP CONSTRAINT IF EXISTS fk_supplier_id CASCADE;


DROP TABLE IF EXISTS public.user;
CREATE TABLE users(
  id serial NOT NULL,
  user_name text,
  email text,
  billing_address text,
  shipping_address text,
  paypal_user_name text,
  paypal_password text,
  card_number text,
  card_holder text,
  expirity_date text,
  card_code text
);

DROP TABLE IF EXISTS public.product_category;
CREATE TABLE product_category(
    id serial NOT NULL,
    name text,
    department text,
    description text
);

DROP TABLE IF EXISTS public.supplire;
CREATE TABLE supplier(
    id serial NOT NULL,
    name text,
    description text
);

DROP TABLE IF EXISTS public.product;
CREATE TABLE product(
    id serial NOT NULL,
    name text,
    description text,
    product_category_id integer,
    supplier_id integer
);


ALTER TABLE ONLY users
  ADD CONSTRAINT pk_user_id PRIMARY KEY (id);

ALTER TABLE ONLY product_category
  ADD CONSTRAINT pk_product_category_id PRIMARY KEY (id);

ALTER TABLE ONLY supplier
  ADD CONSTRAINT pk_supplier_id PRIMARY KEY (id);

ALTER TABLE ONLY product
  ADD CONSTRAINT pk_product_id PRIMARY KEY (id);

ALTER TABLE ONLY product
  ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category_id) REFERENCES "product_category"(id) on delete cascade ;

ALTER TABLE ONLY product
  ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES "supplier"(id) on delete cascade ;
