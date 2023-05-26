package com.HelloKomtech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao implements IEmployeeDao {

    Connection con;
    @Override
    public void CreateEmployee(Employee emp) {
        con = DbConnection.CreateDbConnection();
        String query = "insert into Pracownicy values(?,?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            //pstm.setInt(1,emp.getId());
            pstm.setString(1,emp.getFirstName());
            pstm.setString(2, emp.getLastName());
            pstm.setInt(3,emp.getAge());
            pstm.setString(4,emp.getPhoneNumber());
            pstm.setString(5,emp.getEmail());
            int cnt = pstm.executeUpdate();
            if (cnt!=0)
                System.out.println("Pomyślnie dodano pracownika!\n");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void UptadeEmployee(int id, String firstName, String lastName, int age, String phoneNumber, String email) {
        con = DbConnection.CreateDbConnection();
        String query = "update Pracownicy set prac_imie = ?, prac_nazwisko = ?, prac_wiek = ?, prac_nr_telefonu = ?, prac_email = ?  where prac_id = " + id ;

        try{
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, firstName);
            pstm.setString(2, lastName);
            pstm.setInt(3, age);
            pstm.setString(4, phoneNumber);
            pstm.setString(5, email);
            int cnt = pstm.executeUpdate();
            if (cnt!=0)
                System.out.println("Pomyślnie zaktualizowano pracownika!\n");
            else
                System.out.println("Pracowninik o podanym ID nie istnieje\n");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void DeleteEmployee(int id) {
        con = DbConnection.CreateDbConnection();
        String query = "delete from Pracownicy where prac_id = ?";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);

            int cnt = pstm.executeUpdate();
            if (cnt!=0)
                System.out.println("Pomyślnie usunięto pracownika!\n");
            else
                System.out.println("Pracowninik o podanym ID nie istnieje\n");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void ShowAllEmployee() {
        con = DbConnection.CreateDbConnection();
        String query = "select * from Pracownicy";
        System.out.println("Szczegóły pracowników:");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "Imie", "Nazwisko", "Wiek", "Numer telefonu", "E-mail");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%d\t%s\t%s\n",
                                    result.getInt(1),
                                    result.getString(2),
                                    result.getString(3),
                                    result.getInt(4),
                                    result.getString(5),
                                    result.getString(6));

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void ShowEmployeeById(int id) {
        con = DbConnection.CreateDbConnection();
        String query = "select * from Pracownicy where prac_id = " + id;
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "Imie", "Nazwisko", "Wiek", "Numer telefonu", "E-mail");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            if (result.next() == false)
                System.out.println("Pracowninik o podanym ID nie istnieje\n");

            while (result.next()){

                System.out.format("%d\t%s\t%s\t%d\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void ShowEmployeeByEmail(String email) {
        con = DbConnection.CreateDbConnection();
        String query = "select * from Pracownicy where prac_email = " + "'" + email + "'";

        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "Imie", "Nazwisko", "Wiek", "Numer telefonu", "E-mail");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            if (result.next() == false)
                System.out.println("Pracowninik o podanym E-mailu nie istnieje\n");

            while (result.next()){
                System.out.format("%d\t%s\t%s\t%d\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getString(6));
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
