create database if not exists minio default charset utf8 collate utf8_unicode_ci;

/* 管理员角色 */
create table role
(
  id          int primary key auto_increment,
  name        varchar(16), /* 角色名称 */
  permissions varchar(1024) /* 角色权限 */
);

insert into role(name, permissions)
values ('超级管理员', '["ROLE_EDIT", "ADMIN_LIST", "ADMIN_EDIT"]');

/* 管理员信息表 */
create table admin
(
  id        int primary key auto_increment, /* 主键 */
  username  varchar(16) not null, /* username */
  name      varchar(16), /* 用户名称/备注 */
  password  varchar(32) not null, /* 密码 */
  role_id   int, /* 角色 */
  status    tinyint(4), /* 1.正常 2.停用 */
  signin_at bigint /* 最后登录时间 */
);
/* password A111111+salt */
insert into admin(username, name, password, role_id, status, signin_at)
values ('admin', '超级管理员', 'c4723c465300cf66978f39ccf83f0adc', 1, 1, null);

/* 管理员登录日志 & token 持久化 */
create table admin_session
(
  id        int primary key auto_increment, /* 主键 */
  admin_id  int, /* 关联admin */
  role      varchar(128), /* 管理组名称 */
  name      varchar(128), /* 管理员名称 */
  token     varchar(64), /* token */
  signin_at bigint, /* 登录时间 */
  expire_at bigint, /* 过期时间 */
  ip        varchar(32), /* 登录ip */
  location  varchar(128), /* 登录地址 */
  UNIQUE KEY `token` (`token`)
);
