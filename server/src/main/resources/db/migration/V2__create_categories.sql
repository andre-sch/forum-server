create table categories (
  name varchar(255) primary key,
  description varchar(255) not null,
  color char(6) not null,
  created_at int not null
);
