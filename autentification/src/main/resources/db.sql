-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;


-- Table user_friends
CREATE TABLE user_friends (
  user_id INT NOT NULL,
  user_friend_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (user_friend_id) REFERENCES users (id),

  UNIQUE (user_id, user_friend_id)
)
  ENGINE = InnoDB;

-- Table: comments
CREATE TABLE comments (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  producer_comment_id INT NOT NULL,
  message VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table user_comments
CREATE TABLE user_comments (
  user_id INT NOT NULL,
  comment_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (comment_id) REFERENCES comments (id),

  UNIQUE (user_id, comment_id)
)
  ENGINE = InnoDB;



-- Insert data

INSERT INTO users VALUES (1, 'admin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');
INSERT INTO users VALUES (2, 'guest', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);

INSERT INTO user_friends VALUES (1, 2);
INSERT INTO user_friends VALUES (2, 1);


INSERT INTO comments VALUES (1, 1, "Hello everyone I'm back");
INSERT INTO user_comments VALUES (1, 1);