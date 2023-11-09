package com.example.f23comp1011lhmovies;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This is not part of the movie DB, it's just an example to show stream's
 */

public class DBUtility {

    /**
     * These should reflect whatever the user name / password is for
     * your instance of MySQL Server
     */
    private static String user = "student";
    private static String password = "student";

    /**
     * jdbc:mysql - this piece tells Java which driver to use
     * 127.0.0.1:3306 - this is the IP address and port #
     * F23COMP1011LH - this is your database name
     */
    private static String connectUrl = "jdbc:mysql://127.0.0.1:3306/LHTest1";

    /**
     * This method will return an ArrayList of all valid Employees in the database
     * @return
     */
    public static ArrayList<Employee> getEmployees()
    {
        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            //loop over all the users in the result set and add Person objects to the ArrayList
            while (resultSet.next())
            {
                try{
                    Employee employee = new Employee(resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("department"),
                            resultSet.getString("email"),
                            resultSet.getDate("birthday").toLocalDate(),
                            resultSet.getDouble("salary"));
                    employees.add(employee);
                }catch (IllegalArgumentException e)
                {
                    //log or display broken employee
                    System.out.printf("Employee id: %d had a fault when loading. Fault: %s",
                            resultSet.getInt("id"),e.getMessage());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employees;
    }

    public static XYChart.Series<String,Integer> getEmployeesPerDepartment()
    {

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Employees/Department");

        String sql = "SELECT department, COUNT(email) AS count " +
                "FROM employees " +
                "GROUP BY department;";
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //loop over all the users in the result set and add Person objects to the ArrayList
            while (resultSet.next())
            {
//                createdSeries.getData().add(new XYChart.Data<>("August", 15));
                series.getData().add(new XYChart.Data<>(resultSet.getString("department"),
                                                        resultSet.getInt("count")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return series;
    }





}
