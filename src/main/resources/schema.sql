
create table if not exists skill(
    id  serial primary key,
    name varchar(255),
    logo text,
    rating decimal(10, 2),
    created_at timestamp default now(),
    updated_at timestamp default now()
);