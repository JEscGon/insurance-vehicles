CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    matricula VARCHAR(255) UNIQUE NOT NULL,
    km BIGINT NOT NULL,
    marca VARCHAR(255) NOT NULL,
    fecha_fabricacion DATE NOT NULL,
    date_of_registration DATE,
    date_of_last_update DATE
);