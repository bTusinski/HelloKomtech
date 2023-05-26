package com.HelloKomtech;

public interface IEmployeeDao {

    public void CreateEmployee(Employee emp);

    public void UptadeEmployee(int id, String firstName, String lastName, int age, String phoneNumber, String email);

    public void DeleteEmployee(int id);

    public void ShowAllEmployee();

    public void ShowEmployeeById(int id);

    public void ShowEmployeeByEmail(String email);
}
