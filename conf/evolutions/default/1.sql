# --- !Ups
create table posts (
    id int auto_increment primary key,
    createdAt DATE not null,
    title varchar(255) not null,
    body varchar(255) not null
);

insert into posts values (default, '2019-06-30', 'test title', 'this is test body. posted 6月30日になってるかな');
insert into posts values (default, CURRENT_TIMESTAMP(), 'test title2', 'this is test body2 posted TODAY?');
insert into posts values (default, CURRENT_TIMESTAMP(), 'test title3', 'this is test body3. 今日の日付になってるかな？');
insert into posts values (default, CURRENT_TIMESTAMP(), 'test title3', 'this is test body3. 今日の日付になってるかな？2');

# --- !Downs
drop table posts