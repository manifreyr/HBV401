package is.hi.hbv401g.Bakendi;

import java.sql.*;


public class Database {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Tengjast gagnagrunni
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/maria/IdeaProjects/HBV401/flightBooking.db");

            // Búum til statement object til að framkvæma sql skipanir
            Statement statement = connection.createStatement();

            // Framkvæmum skipun til að sækja allar ssn úr töflunni EMPLOYEE
            ResultSet resultSet = statement.executeQuery("SELECT Ssn, Salary FROM EMPLOYEE");

            // Notum PreparedStatement til að gera sql skipunina fyrir launahækkum
            String updateSalarySQL = "UPDATE EMPLOYEE SET salary = ? WHERE Ssn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSalarySQL);

            // Loop through each employee record to update the salary
            // Förum í gegnum alla starfsmenn til að uppfæra Salary
            while (resultSet.next()) {
                String ssn = resultSet.getString("Ssn");
                int currentSalary = resultSet.getInt("Salary");
                int newSalary = currentSalary + 100;  // Bætum við 100$

                // Setjum parameters og framkvæmum uppfærsluna
                preparedStatement.setInt(1, newSalary);
                preparedStatement.setString(2, ssn);
                preparedStatement.executeUpdate();
            }

            // Lokum öllu
            preparedStatement.close();
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Salaries updated by 100$");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

