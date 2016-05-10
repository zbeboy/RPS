create table users(
  username varchar(200) not null primary key,
  password varchar(500) not null,
  enabled boolean not null,
  is_active boolean comment '是否已激活',
  active_key varchar(45) comment '激活key' ,
  reset_key varchar(45) comment '重置key',
  user_type varchar(45) comment '普通用户,企业'
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
  real_name varchar(100),
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
  title varchar(45),
  education varchar(45) comment '学历',
  real_name varchar(45),
  sex int,
  age int,
  tel_no varchar(11),
  education_situation text comment '教育情况',
  practical_experience text comment '实践经历',
  self_evaluation text comment '自我评价',
  username varchar(200) not null,
  is_show boolean comment '是否展示',
  is_pass int default 0 comment '0未审核,1通过,2未通过',
  resume_img varchar(500) comment '简历封面',
  job_interview varchar(500) comment '面试职位',
  create_time date,
  foreign key(username) references users(username)
);

create table message(
  id int primary key auto_increment,
  message_title varchar(200),
  message_content varchar(200),
  create_time date,
  username varchar(200),
  accept_user varchar(200),
  is_see boolean,
  foreign key(username) references users(username),
  foreign key(accept_user) references users(username)
);

insert into users(username, password, enabled, user_type,is_active) values('10000@rps.com','e10adc3949ba59abbe56e057f20f883e',true,'1',true);
insert into authorities(username, authority) values('10000@rps.com','ROLE_ADMIN');
insert into personal(id,head_img_url,real_name,sex,age,tel_no,username) values(1,'','z','1','18','13987614709','10000@rps.com');