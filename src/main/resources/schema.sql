
-- 1 profile
create table if not exists profile(
    id serial primary key,
    username varchar(255),
    full_name varchar(255),
    date_of_birth date,
    email varchar(250) unique,
    phone_number varchar(255),
    address varchar(255),
    about_me text,
    profile varchar(500),
    created_at timestamp default now(),
    updated_at timestamp default now()
);
-- 2 skill
create table if not exists skill(
    id  serial primary key,
    name varchar(255),
    logo text,
    rating decimal(10, 2),
    created_at timestamp default now(),
    updated_at timestamp default now()
);
-- 3 image_skill
create table if not exists image_skill(
    id bigserial primary key,
    by_skill bigint not null,
    image_url varchar(500) not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    constraint fk_skill
        foreign key (by_skill)
        references skill(id)
        on delete cascade
);
-- 4 education
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