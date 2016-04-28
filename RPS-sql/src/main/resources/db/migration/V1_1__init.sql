create table users(
  username varchar(200) not null primary key,
  password varchar(500) not null,
  enabled boolean not null,
  user_type int comment '0普通用户,1企业'
);

create table personal(
  id int primary key auto_increment,
  head_img_url varchar(500),
  real_name varchar(45),
  sex int,
  age int,
  tel_no varchar(11),
  username varchar(200) not null,
  foreign key(username) references users(username)
);

create table enterprise(
  id int primary key auto_increment,
  enterprise_name varchar(100),
  enterprise_address varchar(200),
  enterprise_phone varchar(45),
  enterprise_person varchar(20) comment '企业负责人',
  enterprise_industry varchar(100) comment '公司行业',
  enterprise_scale varchar(20) comment '公司规模',
  enterprise_introduce text comment '公司介绍',
  username varchar(200) not null,
  foreign key(username) references users(username)
);

create table authorities(
  username varchar(200) not null,
  authority varchar(50) not null,
  foreign key(username) references users(username)
);

create table resume(
  id int primary key auto_increment,
  education varchar(45),
  education_situation text comment '教育情况',
  practical_experience text comment '实践经历',
  self_evaluation text comment '自我评价',
  username varchar(200) not null,
  is_show boolean comment '是否展示',
  is_pass int default 1 comment '0未审核,1通过,2未通过',
  foreign key(username) references users(username)
);

create table message(
  id int primary key auto_increment,
  message_title varchar(200),
  message_content varchar(200),
  create_time datetime default current_timestamp,
  username varchar(200),
  foreign key(username) references users(username)
);