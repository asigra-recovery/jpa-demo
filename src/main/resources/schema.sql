CREATE SCHEMA IF NOT EXISTS sc_identity;
SET search_path TO sc_identity;

DROP TABLE IF EXISTS t_backup;
CREATE table if not exists t_backup
(
    id   bigint PRIMARY KEY,
    name varchar unique
)
