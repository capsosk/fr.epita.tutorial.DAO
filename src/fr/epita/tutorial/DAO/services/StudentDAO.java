package fr.epita.tutorial.DAO.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.epita.tutorial.DAO.dataModel.Student;
import fr.epita.tutorial.DAO.services.Configurator;
public class StudentDAO {
	//
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		final String connectionString = Configurator.getInstance().getProperty("db.host");
		final String userName = Configurator.getInstance().getProperty("db.userName");
		final String password = Configurator.getInstance().getProperty("db.password");

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(connectionString, userName, password);
		return connection;
	}
	
	public void create(Student student) {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENTS(NAME, STUDENT_ID) values (?,?) ");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getSID());
			preparedStatement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception thrown while creating new Student! : " + e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void update(Student old, Student updated) {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENTS SET NAME = ?,  STUDENT_ID = ? WHERE NAME = ? AND STUDENT_ID = ? ");
			preparedStatement.setString(3, old.getName());
			preparedStatement.setString(4, old.getSID());
			preparedStatement.setString(1, updated.getName());
			preparedStatement.setString(2, updated.getSID());
			preparedStatement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception thrown while updating new Student! : " + e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	
	
}
