create table addresses (
	id INT Primary key AUTO_INCREMENT,
    `name` varchar(50) NOT NULL
);

create table categories (
	id INT Primary key AUTO_INCREMENT,
    `name` varchar(10) NOT NULL
);

create table offices (
	id INT Primary key AUTO_INCREMENT,
    workspace_capacity INT NOT NULL,
    website VARCHAR(50),
    `address_id` INT NOT NULL,
    
    Constraint fk_offices_addresses
    Foreign key(`address_id`) REFERENCES addresses(`id`) 
);

create table employees (
	id INT Primary key AUTO_INCREMENT,
    first_name Varchar(30) NOT NULL,
    last_name Varchar(30) NOT NULL,
    age INT NOT NULL,
    salary Decimal(10,2) NOT NULL,
    job_title Varchar(20) NOT NULL,
    happiness_level Char(1) NOT NULL
);



create table teams (
	id INT Primary key AUTO_INCREMENT,
    `name` varchar(40) NOT NULL,
    `office_id` INT NOT NULL,
    `leader_id` INT UNIQUE NOT NULL,
    
    Constraint fk_teams_offices
    Foreign key(`office_id`) REFERENCES offices(`id`), 
    
    Constraint fk_teams_employees
    Foreign key(`leader_id`) REFERENCES employees(`id`) 
);

create table games (
	id INT Primary key AUTO_INCREMENT,
	`name` varchar(50) NOT NULL UNIQUE,
    `description` Text,
    `rating` FLOAT NOT NULL DEFAULT(5.5),
    `budget` DECIMAL(10,2) NOT NULL,
    `release_date` DATE,
    `team_id` INT NOT NULL,
    
    Constraint fk_games_teams
    Foreign key(`team_id`) REFERENCES teams(`id`)
);


create table games_categories (
	`game_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    
    CONSTRAINT game_category_pk PRIMARY KEY(`game_id`, `category_id`),
    
    CONSTRAINT fk_games_categories_games
    FOREIGN KEY (`game_id`) REFERENCES games(`id`), 
    
	CONSTRAINT fk_games_categories_categories
    FOREIGN KEY (`category_id`) REFERENCES categories(`id`)
)


