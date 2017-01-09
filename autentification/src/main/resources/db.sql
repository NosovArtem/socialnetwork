-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  avatar BLOB
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

-- Table: user_informations
CREATE TABLE user_informations (
  user_id         INT NOT NULL PRIMARY KEY,
  first_name      VARCHAR(255),
  last_name       VARCHAR(255),
  city            VARCHAR(255),
  mobile_phone    VARCHAR(255),
  native_language VARCHAR(255),
  religion        VARCHAR(255),
  interests       VARCHAR(255),
  favorite_music  VARCHAR(255),
  favorite_book   VARCHAR(255),
  favorite_film   VARCHAR(255),
  FOREIGN KEY (user_id) REFERENCES users (id)

)
  ENGINE = InnoDB;





-- Insert data
INSERT INTO users VALUES (1, 'admin123', '$2a$11$loKOUD3WxD/GI.vTnh13ieGRb0EnsZpXab6Wg2.nRZGzQaZLzQXPa', 0);
INSERT INTO users VALUES (2, 'artur123', '$2a$11$cSyKt9LA3.XfzxQ0FmzxFuiH.MV5DNafuTzwt1.HVcsC/qo8lmxw6', 0);
INSERT INTO users VALUES (3, 'eugeniy123', '$2a$11$FhJFOYRkRFKjNnJDt7S2/OvmWmNlRP7NQHz9ZkiddbJvs/CS2weD6', 0);



INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);
INSERT INTO user_roles VALUES (1, 1);

INSERT INTO user_friends VALUES (1, 2);
INSERT INTO user_friends VALUES (2, 1);
INSERT INTO user_friends VALUES (2, 3);



INSERT INTO user_informations VALUES (1, 'Denis', 'Sidorov', 'Samara', '322-67-89', 'Russian', 'heathen', 'extreme driving', 'Kooks', 'Thinking in Java', 'Last Samurai' );
INSERT INTO user_informations VALUES (2, 'Artur', 'Savik', 'London', '123-90-10', 'English', 'heathen', 'football', 'GreenDay', 'HaryPotter', 'Imaginarium' );
