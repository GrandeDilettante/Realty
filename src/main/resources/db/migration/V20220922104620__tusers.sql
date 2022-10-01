CREATE TABLE catalogs.tusers
(
    id       bigint                               NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    name     varchar COLLATE pg_catalog."default" NOT NULL,
    budget   double precision,
    whatsapp varchar COLLATE pg_catalog."default" NOT NULL,
    phone    bigint
);

ALTER TABLE ONLY catalogs.tusers
    ADD CONSTRAINT tusers_pkey PRIMARY KEY (id);