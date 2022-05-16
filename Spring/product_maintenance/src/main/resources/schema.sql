create table if not exists product (
    id varchar(45) not null,
    description varchar(100) not null,
    price float not null,
    PRIMARY KEY (id)
);