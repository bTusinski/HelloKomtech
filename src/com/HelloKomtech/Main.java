package com.HelloKomtech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int id;


        IEmployeeDao dao = new EmployeeDao();

        System.out.println("Witaj w menadżerze zarządzania pracownikami!");

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1. Dodaj pracownika\n" +
                                "2. Edytuj pracownika\n" +
                                "3. Pokaż wszystkich pracowników\n" +
                                "4. Wyszukaj pracownika za pomocą ID\n" +
                                "5. Wyszukaj pracownika za pomocą E-maila\n" +
                                "6. Usuń pracownika\n" +
                                "7. Wyjście\n");

            System.out.println("Wybierz opcję: ");

            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Imię: ");
                    String firstName = sc.next();
                    System.out.println("Nazwisko: ");
                    String lastName = sc.next();
                    System.out.println("Wiek: ");
                    int age = sc.nextInt();
                    System.out.println("Numer Telefonu: ");
                    String phoneNumber = sc.next();
                    System.out.println("E-mail: ");
                    String email = sc.next();

                    emp.setFirstName(firstName);
                    emp.setLastName(lastName);
                    emp.setAge(age);
                    emp.setPhoneNumber(phoneNumber);
                    emp.setEmail(email);

                    dao.CreateEmployee(emp);


                    break;
                case 2:
                    System.out.println("Wpisz ID pracownika którego chcesz edytować: ");
                    id = sc.nextInt();
                    System.out.println("Imie: ");
                    firstName=sc.next();
                    System.out.println("Nazwisko: ");
                    lastName=sc.next();
                    System.out.println("Wiek: ");
                    age=sc.nextInt();
                    System.out.println("Numer telefonu: ");
                    phoneNumber=sc.next();
                    System.out.println("Email: ");
                    email=sc.next();
                    dao.UptadeEmployee(id, firstName, lastName, age, phoneNumber, email);
                    break;
                case 3:
                    dao.ShowAllEmployee();
                    break;
                case 4:
                    System.out.println("Wpisz ID szukanego pracownika: ");
                    int empid = sc.nextInt();
                    dao.ShowEmployeeById(empid);
                    break;


                case 5:
                    System.out.println("Wpisz E-mail szukanego pracownika: ");
                    email = sc.next();
                    dao.ShowEmployeeByEmail(email);
                    break;
                case 6:
                    System.out.println("Wpisz ID pracownika którego chcesz usunąć: ");
                    id = sc.nextInt();
                    dao.DeleteEmployee(id);
                    break;
                case 7:
                    System.out.println("Do zobaczenia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wprowadź poprawne dane!");
                    break;

            }
        }while(true);

    }
}