package org.example;

import java.sql.*;

public class Employeeimplement  extends Parent implements EmployeeInterface{

Connection con;
    @Override
    public void createEmployee(Employee employee) {
        con = Dbconnection.createDbconnection();
        String query = "insert into employee values(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,employee.getId());
            ps.setString(2, employee.getName());
            ps.setDouble(3,employee.getSalary());
            ps.setInt(4,employee.getAge());
         int count = ps.executeUpdate();

         if (count > 0){
             System.out.println("Employee created successfully");
        }
        else {
             System.out.println("Employee not created");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void add(int a) {
        super.add(a);
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public void showAllEmployees() {
con = Dbconnection.createDbconnection();
String query = "select * from employee";
        System.out.format("%s\t%s\t%s\t       %s\n","Id","Name","Salary","Age");

try {
    Statement statement = con.createStatement();
   ResultSet resultSet = statement.executeQuery(query);
   while (resultSet.next()){
       System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1),
               resultSet.getString(2),
               resultSet.getDouble(3),
               resultSet.getInt(4));
       System.out.println("----------------------------------------------------");
   }

} catch (SQLException ex) {
    throw new RuntimeException(ex);
}

catch (Exception e) {
    e.printStackTrace();
}

    }

    @Override
    public void showEmployeeById(int id) {
        con = Dbconnection.createDbconnection(); //create connection
        String query = "select * from employee where id =" + id;
        try {
            Statement statement = con.createStatement();
           ResultSet  resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
                System.out.format("%d\t%s\t%f\t%d\n", resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4));
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
  con = Dbconnection.createDbconnection();
  String query = "update employee set name = ? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,id);
            int count = ps.executeUpdate();
            if (count > 0){
                System.out.println("Employee updated successfully");
            }
            else {
                System.out.println("Employee not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id ) {
        con = Dbconnection.createDbconnection();
        String query = "delete from employee where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
