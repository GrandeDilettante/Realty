ALTER TABLE ONLY catalogs.tbid
    ADD CONSTRAINT tbid_realty_fk FOREIGN KEY (realty_id) REFERENCES catalogs.trealty (id) ON
        UPDATE CASCADE ON DELETE CASCADE;