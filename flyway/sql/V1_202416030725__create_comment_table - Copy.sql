CREATE TABLE `anonbook`.`comments` (
  `id` INT NOT NULL,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `post_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
