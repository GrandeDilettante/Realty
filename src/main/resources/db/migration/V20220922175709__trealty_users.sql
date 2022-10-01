CREATE TABLE catalogs.trealty_users
(
    id         bigint NOT NULL DEFAULT nextval('catalogs.mseq'::regclass),
    realty_id bigint NOT NULL,
    user_id   bigint NOT NULL
);

ALTER TABLE ONLY catalogs.trealty_users
    ADD CONSTRAINT trealty_users_pkey PRIMARY KEY (realty_id, user_id);

ALTER TABLE ONLY catalogs.trealty_users
    ADD CONSTRAINT trealty_users_users_fk FOREIGN KEY (user_id) REFERENCES catalogs.tusers (id) ON
        UPDATE CASCADE
        ON
            DELETE CASCADE;

ALTER TABLE ONLY catalogs.trealty_users
    ADD CONSTRAINT trealty_users_realty_fk FOREIGN KEY (realty_id) REFERENCES catalogs.trealty (id) ON
        UPDATE CASCADE
        ON
            DELETE CASCADE;