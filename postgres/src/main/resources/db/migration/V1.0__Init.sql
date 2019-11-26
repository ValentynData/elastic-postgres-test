CREATE EXTENSION if not exists postgis;


CREATE TABLE IF NOT EXISTS full_geopoint(

id VARCHAR(256) PRIMARY KEY,

--   location GEOMETRY,
location GEOGRAPHY(Point),
country VARCHAR(256),

city VARCHAR(256),

street VARCHAR(256)

);

-- CREATE INDEX if not exists location  ON full_geopoint USING GIST (location);

