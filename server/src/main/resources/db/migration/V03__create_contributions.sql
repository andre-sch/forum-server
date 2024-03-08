create table contributions (
  id varchar(255) primary key,
  author_id varchar(255),
  content text,
  created_at int not null,
  last_update int not null,
  foreign key (author_id) references users (id) on delete set null
);
