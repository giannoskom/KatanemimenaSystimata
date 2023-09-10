CREATE TABLE IF NOT exists users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) not null,
    enabled boolean not null
    );
    
 CREATE TABLE IF NOT EXISTS authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
    unique(username,authority),
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username));


INSERT INTO users (username, password, enabled) VALUES
('user1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
('user2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
('root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
('pr1', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
('pr2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't'),
('admin', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 't');


INSERT INTO authorities(username, authority) VALUES
('root', 'ROLE_ADMIN'),
('admin', 'ROLE_ADMIN'),
('admin', 'ROLE_USER'),
('user1', 'ROLE_USER'),
('user2', 'ROLE_USER'),
('pr1', 'ROLE_PRODUCER'),
('pr2', 'ROLE_PRODUCER');


create table Rent (
       id serial not null,
        backTime date,
        email varchar(255),
        gettingTime date,
        renterLastName varchar(255),
        renterName varchar(255),
        primary key (id)
    )
    
INSERT INTO car(username, authority) VALUES
('toyota', 'yaris', '1999'),
('bmw', '120i', '2007'),
('volvo', 'xc40', '2020');

insert into produce (carmodel, caryear, email, producername, brand) values 
('3008', '2020', 'gkom@gmail.com', 'giannos komninos', 'peugeut'),
('Q5', '2015', 'gfov@gmail.com', 'giannis fovakis', 'audi');

