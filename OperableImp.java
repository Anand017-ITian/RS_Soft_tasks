package com.acc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.JDBCconnection.util.DBConnection;
import com.acc.model.Doctor;

public class OperableImp implements Operable {

    
    @Override
    public List<Doctor> findAll() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Doctor> docs = new ArrayList<>();

        try {
            con = DBConnection.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM doctor");

            while (rs.next()) {
                docs.add(new Doctor(
                        rs.getInt("id"),
                        rs.getInt("exp"),
                        rs.getString("specialist"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getLong("contact"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getInt("fees"),
                        rs.getString("available")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return docs;
    }

    
    @Override
    public List<Doctor> findAll(String specialist) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Doctor> docs = new ArrayList<>();

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM doctor WHERE specialist=?");
            pstmt.setString(1, specialist);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                docs.add(new Doctor(
                        rs.getInt("id"),
                        rs.getInt("exp"),
                        rs.getString("specialist"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getLong("contact"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getInt("fees"),
                        rs.getString("available")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return docs;
    }

 
    @Override
    public Doctor find(int id) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Doctor doc = null;

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM doctor WHERE id=?");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                doc = new Doctor(
                        rs.getInt("id"),
                        rs.getInt("exp"),
                        rs.getString("specialist"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getLong("contact"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getInt("fees"),
                        rs.getString("available"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

   
    @Override
    public void add(Doctor doc) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(
                    "INSERT INTO doctor VALUES (?,?,?,?,?,?,?,?,?,?)");

            pstmt.setInt(1, doc.getId());
            pstmt.setInt(2, doc.getExp());
            pstmt.setString(3, doc.getSpecialist());
            pstmt.setString(4, doc.getFname());
            pstmt.setString(5, doc.getLname());
            pstmt.setLong(6, doc.getContact());
            pstmt.setString(7, doc.getAddress());
            pstmt.setString(8, doc.getGender());
            pstmt.setInt(9, doc.getFees());
            pstmt.setString(10, doc.getAvailable());

            pstmt.executeUpdate();
            System.out.println("Doctor Added Successfully!!!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   
    @Override
    public void delete(int id) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM doctor WHERE id=?");
            pstmt.setInt(1, id);

            int count = pstmt.executeUpdate();
            if (count > 0)
                System.out.println("Doctor Deleted Successfully!!!");
            else
                throw new DoctorNotFound("Doctor Not Found"); //remain to add throw

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DoctorNotFound e) {
			
			e.printStackTrace();
		} finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void update(int id) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnection.getDBConnection();
            Scanner sc =new Scanner(System.in);
            UpdateableImp op = new UpdateableImp();
            
            System.out.println("----- UPDATE DOCTOR DETAILS -----");
            System.out.println("1. Update Experience");
            System.out.println("2. Update Specialist");
            System.out.println("3. Update First Name");
            System.out.println("4. Update Last Name");
            System.out.println("5. Update Contact");
            System.out.println("6. Update Address");
            System.out.println("7. Update Gender");
            System.out.println("8. Update Fees");
            System.out.println("9. Update Availability");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {

            case 1:
                System.out.print("Enter New Experience: ");
                int exp = sc.nextInt();
                op.updateExp(exp, id);
                break;

            case 2:
                System.out.print("Enter New Specialist: ");
                String specialist = sc.next();
                op.updateSpecialist(specialist, id);
                break;

            case 3:
                System.out.print("Enter New First Name: ");
                String fname = sc.next();
                op.updateFname(fname, id);
                break;

            case 4:
                System.out.print("Enter New Last Name: ");
                String lname = sc.next();
                op.updateLname(lname, id);
                break;

            case 5:
                System.out.print("Enter New Contact: ");
                long contact = sc.nextLong();
                op.updateContact(contact, id);
                break;

            case 6:
                System.out.print("Enter New Address: ");
                String address = sc.next();
                op.updateAddress(address, id);
                break;

            case 7:
                System.out.print("Enter New Gender: ");
                String gender = sc.next();
                op.updateGender(gender, id);
                break;

            case 8:
                System.out.print("Enter New Fees: ");
                int fees = sc.nextInt();
                op.updateFees(fees, id);
                break;

            case 9:
                System.out.print("Enter Availability (Yes/No): ");
                String available = sc.next();
                op.updateAvailable(available, id);
                break;

            default:
                throw new UpdateOption("Invalid Update Option!");//  added throw
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UpdateOption e) {
			e.printStackTrace();
		} finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

