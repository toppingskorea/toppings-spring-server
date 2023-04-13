CREATE TABLE t_user (
    user_id bigint(20) NOT NULL AUTO_INCREMENT,
    user_username varchar(100) NOT NULL,
    user_password varchar(255) NOT NULL,
    user_name varchar(50) NOT NULL,
    user_email varchar(100) NOT NULL,
    user_country varchar(50) NOT NULL,
    user_role varchar(20) NOT NULL,
    user_profile_url longtext,
    user_profile_path varchar(200),
    PRIMARY KEY (user_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_user_habit (
    user_habit_id bigint(20) NOT NULL AUTO_INCREMENT,
    user_habit_name varchar(100) NOT NULL,
    PRIMARY KEY (user_habit_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant (
    restaurant_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_image (
    restaurant_image_id bigint(20) NOT NULL AUTO_INCREMENT,
    restaurant_image_url longtext NOT NULL,
    restaurant_image_path longtext NOT NULL,
    PRIMARY KEY (restaurant_image_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_category (
    restaurant_category_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_category_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_comment (
    restaurant_comment_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_comment_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_comment_image (
    restaurant_comment_image_id bigint(20) NOT NULL AUTO_INCREMENT,
    restaurant_comment_image_url longtext NOT NULL,
    restaurant_comment_image_path longtext NOT NULL,
    PRIMARY KEY (restaurant_comment_image_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_saved_restaurant (
    saved_restaurant_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (saved_restaurant_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_notification (
    notification_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (notification_id)
) DEFAULT CHARSET utf8mb4;