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
    PRIMARY KEY (user_habit_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant (
    restaurant_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_attach (
    restaurant_attach_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_attach_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_star (
    restaurant_star_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_star_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_restaurant_category (
    restaurant_category_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (restaurant_category_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_review (
    review_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (review_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_review_attach (
    review_attach_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (review_attach_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_scrap (
    scrap_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (scrap_id)
) DEFAULT CHARSET utf8mb4;

CREATE TABLE t_notification (
    notification_id bigint(20) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (notification_id)
) DEFAULT CHARSET utf8mb4;