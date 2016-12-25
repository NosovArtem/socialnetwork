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


