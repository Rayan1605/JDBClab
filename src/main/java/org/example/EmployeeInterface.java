package org.example;

public interface EmployeeInterface {

    //create employee
    public void createEmployee(Employee employee);
    //show all employees
    public void showAllEmployees();
    //show employee by id
    public void showEmployeeById(int id);
    //update employee
    public void updateEmployee(int id, String name );

    //delete employee
   public void deleteEmployee(int id );
}
