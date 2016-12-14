-- Table: photos
CREATE TABLE photos (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  path_to_origin_photo VARCHAR(255) NOT NULL,
  path_to_medium_photo VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

