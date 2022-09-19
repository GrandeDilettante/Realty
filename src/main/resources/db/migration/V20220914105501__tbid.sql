CREATE TABLE catalogs.tbid
(
    id          bigint NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    date_create timestamp without time zone,
    value       double precision,
    realty_id   bigint
);

ALTER TABLE ONLY catalogs.tbid
    ADD CONSTRAINT tbid_pkey PRIMARY KEY (id);