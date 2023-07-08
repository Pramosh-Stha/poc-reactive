create table if not exists "users"
(
    id serial constraint id primary key,
    created_by  varchar(100),
    created_on  timestamp,
    is_deleted  boolean default false not null,
    modified_by varchar(100),
    modified_on timestamp,
    name        varchar(100)          not null
        constraint tb_user_uk_name
            unique,
    city        varchar(100),
    age         integer,
    salary      real
);

alter table "users"
    owner to ycore;