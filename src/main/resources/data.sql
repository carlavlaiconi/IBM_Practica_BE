CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     databaseVersion LONG,
                                     createDate TIMESTAMP,
                                     updateDate TIMESTAMP,
                                     name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL
    );
INSERT INTO users (name, email, role) VALUES ('John Doe', 'john.doe@example.com', 'leader');
INSERT INTO users (name, email, role) VALUES ('Jane Smith', 'jane.smith@example.com', 'mentor');

CREATE TABLE IF NOT EXISTS team (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    databaseVersion LONG,
                                    createDate TIMESTAMP,
                                    updateDate TIMESTAMP,
                                    name VARCHAR(50) NOT NULL
    );
INSERT INTO team (name) VALUES ('Team A');
INSERT INTO team (name) VALUES ('Team B');

CREATE TABLE IF NOT EXISTS activity (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        databaseVersion LONG,
                                        createDate TIMESTAMP,
                                        updateDate TIMESTAMP,
                                        name VARCHAR(50) NOT NULL
    );
INSERT INTO activity (name) VALUES ('Activity 1');
INSERT INTO activity (name) VALUES ('Activity 2');

CREATE TABLE IF NOT EXISTS session (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       databaseVersion LONG,
                                       createDate TIMESTAMP,
                                       updateDate TIMESTAMP,
                                       date VARCHAR(50) NOT NULL,
    activity_id INT
    );
INSERT INTO session (date, activity_id) VALUES ('2023-07-18', 1);

CREATE TABLE IF NOT EXISTS attendance (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          databaseVersion LONG,
                                          createDate TIMESTAMP,
                                          updateDate TIMESTAMP,
                                          student_id INT,
                                          session_id INT,
                                          present BOOLEAN NOT NULL
);
INSERT INTO attendance (student_id, session_id, present) VALUES (2, 1, true);
INSERT INTO attendance (student_id, session_id, present) VALUES (1, 1, false);

CREATE TABLE IF NOT EXISTS grade (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     database_version LONG,
                                     create_date TIMESTAMP,
                                     update_date TIMESTAMP,
                                     student_id INT,
                                     session_id INT,
                                     grade INT NOT NULL,
                                     comment VARCHAR(500),
    mentor_id INT
    );
INSERT INTO grade (student_id, session_id, grade, comment, mentor_id) VALUES (1, 1, 90, 'Good work!', 1);
INSERT INTO grade (student_id, session_id, grade, mentor_id) VALUES (2, 1, 85, 1);