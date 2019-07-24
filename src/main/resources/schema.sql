CREATE TABLE role (
  role_id int(11) NOT NULL auto_increment,
  role varchar(255) default NULL,
  PRIMARY KEY  (role_id)
);

CREATE TABLE user (
  id int(11) NOT NULL auto_increment,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  active int(11) default NULL,
  PRIMARY KEY  (id)
);

CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY  (user_id,role_id),
  CONSTRAINT user_userrole FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT role_userrole FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE  persistent_logins (
  username varchar(64) NOT NULL,
  series varchar(64) NOT NULL,
  token varchar(64) NOT NULL,
  last_used timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (series)
);

INSERT INTO `role` VALUES (1,'ADMIN');