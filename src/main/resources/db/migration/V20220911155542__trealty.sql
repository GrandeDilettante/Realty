CREATE TABLE catalogs.trealty
(
    id bigint NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    name varchar COLLATE pg_catalog."default" NOT NULL,
    price integer
);

ALTER TABLE ONLY catalogs.trealty
    ADD CONSTRAINT trealty_pkey PRIMARY KEY (id);