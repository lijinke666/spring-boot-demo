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
  userId  int         not null,
  constraint FK_636f17dadfea1ffb4a412296a28
  foreign key (userId) references user (id)
);