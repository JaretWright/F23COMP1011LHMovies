package com.example.f23comp1011lhmovies;

import javafx.util.converter.CurrencyStringConverter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * This is not part of the movie DB, it's just an example to show stream's
 */

public class Employee {
    private int id;
    private String firstName, lastName, department, email;
    private LocalDate birthday;
    private double salary;

    public Employee(int id, String firstName, String lastName, String department, String email, LocalDate birthday, double salary) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
        setEmail(email);
        setBirthday(birthday);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id>0)
            this.id = id;
        else
            throw new IllegalArgumentException("id must be greater than 0");
    }

    public String getFirstName() {
        return firstName;
    }

    /** "    "
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (firstName.length()>1)
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("first name must be more than 1 character");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }



    public void setDepartment(String department) {
        List<String> departments = Arrays.asList("Sales","Marketing", "Finance", "HR", "IT","Research");
        if (departments.contains(department))
            this.department = department;
        else
            throw new IllegalArgumentException(department + " was not a valid department, must be one of "+departments);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();

        if (email.length()>=5 && email.contains("@") && email.contains("."))
            this.email = email;
        else
            throw new IllegalArgumentException("email must be 5 or more characters, have a @ and a .");
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("birthday cannot be in the future");
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName()
    {
        return firstName + " " + lastName;
    }

    public String getFormattedSalary()
    {
        CurrencyStringConverter csc = new CurrencyStringConverter(Locale.CANADA);
        return csc.toString(salary);
    }

    public boolean contains(String searchTerm)
    {
        return getName().contains(searchTerm) ||
                Integer.toString(id).contains(searchTerm) ||
                department.contains(searchTerm) ||
                email.contains(searchTerm);
    }
}
