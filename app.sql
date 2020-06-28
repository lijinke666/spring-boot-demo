create table user
(
  id       int auto_increment
    primary key,
  username varchar(50)                           not null,
  password varchar(50)                           not null,
  phone    varchar(11)                           not null,
  role     enum ('ADMIN', 'USER') default 'USER' not null
);

create table article
(
  id      int auto_increment
    primary key,
  title   varchar(20) not null,
  content text        not null,
  user_id  int         not null,
);
