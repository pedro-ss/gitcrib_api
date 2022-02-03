CREATE SCHEMA gitcrib;

CREATE TABLE IF NOT EXISTS contributor (
	"id" serial4 NOT NULL,
	"age" int4 NULL,
	"email" varchar(255) NULL,
	"password" varchar(255) NULL,
	"points" int8 NULL,
	"since" date NULL,
	"user_name" varchar(255) NULL,
	CONSTRAINT contributor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS founder (
	"id" serial4 NOT NULL,
	"email" varchar(255) NULL,
	"password" varchar(255) NULL,
	"points" int8 NULL,
	"since" date NULL,
	"user_name" varchar(255) NULL,
	CONSTRAINT founder_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS project (
	"id" serial4 NOT NULL,
	"description" varchar(255) NULL,
	"project_status" varchar(255) NULL,
	"founder" int4 NULL,
	CONSTRAINT project_pkey PRIMARY KEY (id),
    CONSTRAINT founder_id 
    FOREIGN KEY (founder) REFERENCES founder(id)
);

CREATE TABLE IF NOT EXISTS task (
	"id" serial4 NOT NULL,
	"description" varchar(255) NULL,
	"task_status" varchar(255) NULL,
	"title" varchar(255) NULL,
	"project" int4 NULL,
	"task" int4 NULL,
	CONSTRAINT task_pkey PRIMARY KEY (id),
    CONSTRAINT project_id FOREIGN KEY (project) REFERENCES project(id)
);

create table if not exists ACTIVITY (
	"id" serial4 NOT NULL,
	"contributor_id" int8 NULL,
	"task_id" int8 NULL,
	CONSTRAINT activity_pkey PRIMARY KEY (id),
	CONSTRAINT contributor_id 
    FOREIGN KEY (contributor_id) REFERENCES contributor(id),
    CONSTRAINT task_id 
    FOREIGN KEY (task_id) REFERENCES task(id)
);


INSERT INTO FOUNDER (NAME,PASSWORD,POINTS,SINCE,USER_NAME) VALUES ('Godofredo','0Vu30usQx9QGYrMb8Al19XwHltiCHw',0,'2021-01-01','severino');
INSERT INTO FOUNDER (NAME,PASSWORD,POINTS,SINCE,USER_NAME) VALUES ('Marcos','0Vu30usQx9QGYrMb8Al19XwHltiCHw',0,'2021-02-09','Bill Pullman');

INSERT INTO PROJECT (DESCRIPTION,PROJECT_STATUS,FOUNDER) VALUES ('Projeto em React para faculdade','em andamento',1);
INSERT INTO PROJECT (DESCRIPTION,PROJECT_STATUS,FOUNDER) VALUES ('Projeto em Python para automação','em andamento',2);


INSERT INTO TASK (DESCRIPTION,STATUS,TITLE,PROJECT,TASK) VALUES('implementar função CREATE','em andamento','create func em python', 1,1);
INSERT INTO TASK (DESCRIPTION,STATUS,TITLE,PROJECT,TASK) VALUES('implementar função UPDATE','disponível','create func em python', 1,1);
INSERT INTO TASK (DESCRIPTION,STATUS,TITLE,PROJECT,TASK) VALUES('implementar função DELETE','disponível','create del func em python', 1,1);