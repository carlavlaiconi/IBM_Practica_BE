package com.example.ibmbe;

import java.sql.*;

public class H2DatabaseConnection {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");

            // Connect to the in-memory H2 database
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a database operation (create a table)
            String createTableQuery = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), leader BOOLEAN, mentor BOOLEAN, teamId INTEGER)";
            statement.execute(createTableQuery);

            String insertUserQuery = "INSERT INTO users (id, name, email, leader, mentor, teamId) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement userStatement = connection.prepareStatement(insertUserQuery)) {
                userStatement.setInt(1, 1);
                userStatement.setString(2, "John Doe");
                userStatement.setString(3, "john.doe@example.com");
                userStatement.setBoolean(4, true); // leader = true
                userStatement.setBoolean(5, false); // mentor = false
                userStatement.setInt(6, 101); // teamId = 101
                userStatement.executeUpdate();

                userStatement.setInt(1, 2);
                userStatement.setString(2, "Jane Smith");
                userStatement.setString(3, "jane.smith@example.com");
                userStatement.setBoolean(4, false); // leader = false
                userStatement.setBoolean(5, true); // mentor = true
                userStatement.setInt(6, 102); // teamId = 102
                userStatement.executeUpdate();
            }

            // Create the "team" table and populate it
            createTableQuery = "CREATE TABLE team (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.execute(createTableQuery);

            String insertTeamQuery = "INSERT INTO team (id, name) VALUES (?, ?)";
            try (PreparedStatement teamStatement = connection.prepareStatement(insertTeamQuery)) {
                teamStatement.setInt(1, 101);
                teamStatement.setString(2, "Team A");
                teamStatement.executeUpdate();

                teamStatement.setInt(1, 102);
                teamStatement.setString(2, "Team B");
                teamStatement.executeUpdate();
            }

            // Create the "activity" table and populate it
            createTableQuery = "CREATE TABLE activity (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.execute(createTableQuery);

            String insertActivityQuery = "INSERT INTO activity (id, name) VALUES (?, ?)";
            try (PreparedStatement activityStatement = connection.prepareStatement(insertActivityQuery)) {
                activityStatement.setInt(1, 1);
                activityStatement.setString(2, "Activity 1");
                activityStatement.executeUpdate();

                activityStatement.setInt(1, 2);
                activityStatement.setString(2, "Activity 2");
                activityStatement.executeUpdate();
            }

            // Create the "session" table and populate it
            createTableQuery = "CREATE TABLE session (id INT PRIMARY KEY, date VARCHAR(255), activityId INT)";
            statement.execute(createTableQuery);

            String insertSessionQuery = "INSERT INTO session (id, date, activityId) VALUES (?, ?, ?)";
            try (PreparedStatement sessionStatement = connection.prepareStatement(insertSessionQuery)) {
                sessionStatement.setInt(1, 1);
                sessionStatement.setString(2, "2023-07-17");
                sessionStatement.setInt(3, 1);
                sessionStatement.executeUpdate();

                sessionStatement.setInt(1, 2);
                sessionStatement.setString(2, "2023-07-18");
                sessionStatement.setInt(3, 2);
                sessionStatement.executeUpdate();
            }

            // Create the "attendance" table and populate it
            createTableQuery = "CREATE TABLE attendance (id INT PRIMARY KEY, studentId INT, sessionId INT, present BOOLEAN)";
            statement.execute(createTableQuery);

            String insertAttendanceQuery = "INSERT INTO attendance (id, studentId, sessionId, present) VALUES (?, ?, ?, ?)";
            try (PreparedStatement attendanceStatement = connection.prepareStatement(insertAttendanceQuery)) {
                attendanceStatement.setInt(1, 1);
                attendanceStatement.setInt(2, 1);
                attendanceStatement.setInt(3, 1);
                attendanceStatement.setBoolean(4, true); // student 1 is present in session 1
                attendanceStatement.executeUpdate();

                attendanceStatement.setInt(1, 2);
                attendanceStatement.setInt(2, 1);
                attendanceStatement.setInt(3, 2);
                attendanceStatement.setBoolean(4, false); // student 1 is absent in session 2
                attendanceStatement.executeUpdate();
            }

            // Create the "grade" table and populate it
            createTableQuery = "CREATE TABLE grade (id INT PRIMARY KEY, studentId INT, sessionId INT, grade INT, comment VARCHAR(255))";
            statement.execute(createTableQuery);

            String insertGradeQuery = "INSERT INTO grade (id, studentId, sessionId, grade, comment) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement gradeStatement = connection.prepareStatement(insertGradeQuery)) {
                gradeStatement.setInt(1, 1);
                gradeStatement.setInt(2, 1);
                gradeStatement.setInt(3, 1);
                gradeStatement.setInt(4, 90);
                gradeStatement.setString(5, "Good work!");
                gradeStatement.executeUpdate();

                gradeStatement.setInt(1, 2);
                gradeStatement.setInt(2, 1);
                gradeStatement.setInt(3, 2);
                gradeStatement.setInt(4, 85);
                gradeStatement.setString(5, "Needs improvement.");
                gradeStatement.executeUpdate();
            }

            // Create the "teamActivity" table
            createTableQuery = "CREATE TABLE teamActivity (id INT, teamId INT, activityId INT)";
            statement.execute(createTableQuery);

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
