

CREATE TABLE managers (  

 id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,  

 login VARCHAR(10) UNIQUE NOT NULL,
 
 password VARCHAR(20) NOT NULL

); 


CREATE TABLE masters (  

 id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,  

 login VARCHAR(10) UNIQUE NOT NULL,
 
 password VARCHAR(20) NOT NULL,

 rating INT

); 


CREATE TABLE Customers
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    
    bill INT,
    
    login VARCHAR(20) NOT NULL UNIQUE,
    
    password VARCHAR(20) NOT NULL
    
);
 
CREATE TABLE Orders
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    
    CustomerLogin VARCHAR(20),
    
    masterLogin VARCHAR(10),
    
    CreatedAt Date,
    
    is_in_development bool,
 
    is_done bool,
 
    is_waiting_for_payment bool,
 
    is_paid bool,
 
    is_canceled bool,

    ordersPrice INT,
    
    is_CheckEngine bool,
    
    is_CheckElectricity bool,
    
    is_CheckWheels bool,
    
    car_type VARCHAR(20),

    master_reference TEXT,
    
    FOREIGN KEY (CustomerLogin)  REFERENCES Customers (login)

    ON UPDATE CASCADE

    ON DELETE CASCADE,

    FOREIGN KEY (masterLogin)  REFERENCES masters (login)

    ON UPDATE CASCADE

    ON DELETE CASCADE
);