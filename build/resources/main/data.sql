CREATE TABLE `groups` (
	`id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`type_id`	tinyint	NOT NULL,
	`name`	varchar(20)	NOT NULL,
	`introduction`	varchar(200)	NOT NULL,
	`max_user`	smallint	NOT NULL	DEFAULT 10,
	`is_done`	boolean	NOT NULL	DEFAULT 0,
	`deadline_date`	timestamp	NULL	DEFAULT null,
	`created_at`	timestamp	NOT NULL,
	`deleted_at`	timestamp	NULL	DEFAULT null
);

CREATE TABLE `users` (
	`id`	int	NOT NULL,
	`level_id`	tinyint	NOT NULL,
	`auth_type`	tinyint	NOT NULL,
	`email`	varchar(30)	NOT NULL,
	`nickname`	varchar(15)	NOT NULL,
	`image`	varchar(150)	NULL	DEFAULT default.jpg,
	`link`	varchar(300)	NULL,
	`created_at`	timestamp	NOT NULL	DEFAULT 현재시간,
	`deleted_at`	timestamp	NULL	DEFAULT null
);

CREATE TABLE `levels` (
	`id`	tinyint	NOT NULL,
	`name`	varchar(10)	NOT NULL
);

CREATE TABLE `group_types` (
	`id`	tinyint	NOT NULL,
	`name`	varchar(10)	NOT NULL
);

CREATE TABLE `group_members` (
	`id`	int	NOT NULL	COMMENT 'auto_increament',
	`group_id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`created_at`	timestamp	NOT NULL,
	`deleted_at`	timestamp	NULL	DEFAULT null
);

CREATE TABLE `group_join_history` (
	`id`	int	NOT NULL	COMMENT 'auto_increament',
	`group_id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`meesage`	varchar(100)	NOT NULL,
	`status`	tinyint	NOT NULL	COMMENT '1: 가입, 2: 거절, 3:대기',
	`created_at`	timestamp	NOT NULL,
	`updated_at`	timestamp	NULL	DEFAULT null	COMMENT '신청 상태 반영일'
);

CREATE TABLE `group_inquiry_history` (
	`id`	int	NOT NULL	COMMENT 'auto_increament',
	`group_id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`contents`	varchar(300)	NOT NULL,
	`is_checked`	boolean	NOT NULL	DEFAULT 0,
	`created_at`	timestamp	NOT NULL,
	`checked_at`	timestamp	NULL	DEFAULT null
);

CREATE TABLE `group_reply_history` (
	`id`	int	NOT NULL	COMMENT 'auto_increament',
	`group_id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`contents`	varchar(300)	NOT NULL,
	`is_checked`	boolean	NOT NULL	DEFAULT 0,
	`created_at`	timestamp	NOT NULL,
	`checked_at`	timestamp	NULL	DEFAULT null
);

CREATE TABLE `group_hit_history` (
	`id`	int	NOT NULL	COMMENT 'auto_increament',
	`group_id`	int	NOT NULL,
	`user_id`	int	NOT NULL,
	`created_at`	timestamp	NOT NULL
);

CREATE TABLE `auth_types` (
	`id`	tinyint	NOT NULL,
	`name`	varchar(10)	NOT NULL
);

ALTER TABLE `groups` ADD CONSTRAINT `PK_GROUPS` PRIMARY KEY (
	`id`
);

ALTER TABLE `users` ADD CONSTRAINT `PK_USERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `levels` ADD CONSTRAINT `PK_LEVELS` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_types` ADD CONSTRAINT `PK_GROUP_TYPES` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_members` ADD CONSTRAINT `PK_GROUP_MEMBERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_join_history` ADD CONSTRAINT `PK_GROUP_JOIN_HISTORY` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_inquiry_history` ADD CONSTRAINT `PK_GROUP_INQUIRY_HISTORY` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_reply_history` ADD CONSTRAINT `PK_GROUP_REPLY_HISTORY` PRIMARY KEY (
	`id`
);

ALTER TABLE `group_hit_history` ADD CONSTRAINT `PK_GROUP_HIT_HISTORY` PRIMARY KEY (
	`id`
);

ALTER TABLE `auth_types` ADD CONSTRAINT `PK_AUTH_TYPES` PRIMARY KEY (
	`id`
);

