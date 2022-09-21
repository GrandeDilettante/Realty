CREATE TABLE catalogs.users
(
    id    bigint  NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    name  varchar NOT NULL
);

ALTER TABLE ONLY catalogs.users
    ADD CONSTRAINT tusers_pkey PRIMARY KEY (id);

CREATE TABLE catalogs.trealty_users
(
    id bigint NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    realty_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_trealty_users PRIMARY KEY (id),
    FOREIGN KEY (realty_id) REFERENCES catalogs.trealty,
    FOREIGN KEY (user_id) REFERENCES catalogs.users
);