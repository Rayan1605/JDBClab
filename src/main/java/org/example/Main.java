package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employeeimplement emp = new Employeeimplement();

        emp.add(2);
        emp.print();


        System.out.println("Welcome to Employee Management application!");
        Scanner myinput = new Scanner(System.in);

        do {
            try {
                long secondsToSleep = 2;
                Thread.sleep(secondsToSleep * 500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println();
            System.out.println("1. Create Employee\n");
            System.out.println("2. Show All Employees\n");
            System.out.println( "3. Show Employee by Id\n");
            System.out.println("4. Update Employee\n");
            System.out.println("5. Delete Employee\n");
            System.out.println();
            System.out.println(" Please enter your choice\n");
            int ch = myinput.nextInt();
            switch (ch){
                case 1:
                    Employee employee = new Employee();
                    Employee employee1 = new Employee(45,"sara", 5000, 23);
                    System.out.println("Enter the id of the employee\n");
                    int id = myinput.nextInt();
                    employee.setId(id);
                    System.out.println("Enter the name of the employee\n");
                    String name = myinput.next();
                    employee.setName(name);
                    System.out.println("Enter the salary of the employee\n");
                    double salary = myinput.nextDouble();
                    employee.setSalary(salary);
                    System.out.println("Enter the age of the employee\n");
                    int age = myinput.nextInt();
                    employee.setAge(age);
                    emp.createEmployee(employee);
                    break;
                case 2:
                    emp.showAllEmployees();
                    break;
                    case 3:
                        System.out.println("Enter the id of the employee you want to show");
                         id = myinput.nextInt();
                        emp.showEmployeeById(id);
                        break;
                        case 4:
                            System.out.println("Enter the id of the employee you want to update");
                            int id1 = myinput.nextInt();
                            System.out.println("Enter the name of the employee you want to change4");
                             name = myinput.next();
                            emp.updateEmployee(id1, name);
                            break;
                            case 5:
                                System.out.println("Enter the id of the employee you want to delete");
                                int id2 = myinput.nextInt();
                                emp.deleteEmployee(id2);
                                break;
                case 6:
               System.out.println("Thank you for using Employee Management application!");
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid choice");
                    break;

            }

        }while (true);

    }
}