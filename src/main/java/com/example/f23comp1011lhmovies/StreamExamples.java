package com.example.f23comp1011lhmovies;

import javafx.util.converter.CurrencyStringConverter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is not part of the movie DB, it's just an example to show stream's
 */
public class StreamExamples {
    public static void main(String[] args) {
        ArrayList<Employee> employees = DBUtility.getEmployees();

        //provide a list of employees that work in the HR department
        List<Employee> hrEmployees = employees.stream()
                                    .filter(employee -> employee.getDepartment().equals("HR"))
                                    .collect(Collectors.toList());

        //what is the average salary of someone in Sales?
        OptionalDouble avgSalarySales = employees.stream()
                                    .filter(employee -> employee.getDepartment().equals("Sales"))
                                    .mapToDouble(employee -> employee.getSalary())
                                    .average();

        if (avgSalarySales.isPresent())
        {
            CurrencyStringConverter csc = new CurrencyStringConverter(Locale.CANADA);
            System.out.printf("Average Salary in Sales = %s%n", csc.toString(avgSalarySales.getAsDouble()));
        }
        else
        {
            System.out.println("Average Salary in Sales: N/A");
        }


        //display how many people work in each department?
        // sales - 110
        // HR -34
        //Map data structures combine a key with a value.  For example <String, Integer>
        //a solution without streams
        TreeMap<String, Integer> employeesPerDepartment = new TreeMap<>();
        for (Employee employee : employees)
        {
            //check if the department is already in the map
            if (employeesPerDepartment.keySet().contains(employee.getDepartment()))
            {
                int existingCount = employeesPerDepartment.get(employee.getDepartment());
                employeesPerDepartment.put(employee.getDepartment(), ++existingCount);
            }
            else
                employeesPerDepartment.put(employee.getDepartment(), 1);
        }

        System.out.println(employeesPerDepartment);

        Map<String, Long> employeesPerDeptFromStream = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.counting()));

        System.out.println(employeesPerDeptFromStream);
    }
}
