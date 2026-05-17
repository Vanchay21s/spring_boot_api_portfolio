
-- 1 profile
-- 2 skill
create table if not exists skill(
    id  serial primary key,
    name varchar(255),
    logo text,
    rating decimal(10, 2),
    created_at timestamp default now(),
    updated_at timestamp default now()
);
-- 3 education
create table if not exists education(
    id serial primary key,
    name varchar(255),
    logo text,
    major varchar(255),
    gpa varchar(255),
    year varchar(255),
    created_at timestamp default now(),
    updated_at timestamp default now()
)