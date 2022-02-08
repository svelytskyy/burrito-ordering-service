drop table if exists public.orders;
drop table if exists public.flyway_history_table;
CREATE TABLE public.orders (
id UUID NOT NULL,
order_s TEXT,
created_on TIMESTAMP,
CONSTRAINT id_pk PRIMARY KEY (id)
);
insert into public.orders values(111111,null, null);
commit;