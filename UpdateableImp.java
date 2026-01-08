package com.acc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.JDBCconnection.util.DBConnection;

public class UpdateableImp implements Updateable {

    @Override
    public void updateExp(int exp, int id) {
        executeUpdate("UPDATE doctor SET exp=? WHERE id=?", exp, id);
    }

    @Override
    public void updateSpecialist(String specialist, int id) {
        executeUpdate("UPDATE doctor SET specialist=? WHERE id=?", specialist, id);
    }

    @Override
    public void updateFname(String fname, int id) {
        executeUpdate("UPDATE doctor SET fname=? WHERE id=?", fname, id);
    }

    @Override
    public void updateLname(String lname, int id) {
        executeUpdate("UPDATE doctor SET lname=? WHERE id=?", lname, id);
    }

    @Override
    public void updateContact(long contact, int id) {
        executeUpdate("UPDATE doctor SET contact=? WHERE id=?", contact, id);
    }

    @Override
    public void updateAddress(String address, int id) {
        executeUpdate("UPDATE doctor SET address=? WHERE id=?", address, id);
    }

    @Override
    public void updateGender(String gender, int id) {
        executeUpdate("UPDATE doctor SET gender=? WHERE id=?", gender, id);
    }

    @Override
    public void updateFees(int fees, int id) {
        executeUpdate("UPDATE doctor SET fees=? WHERE id=?", fees, id);
    }

    @Override
    public void updateAvailable(String available, int id) {
        executeUpdate("UPDATE doctor SET available=? WHERE id=?", available, id);
    }

    
    public void executeUpdate(String sql, Object value, int id) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, value);
            pstmt.setInt(2, id);

            int count = pstmt.executeUpdate();
            if (count > 0)
                System.out.println("Doctor Updated Successfully!");
            else
                throw new DoctorNotFound("Doctor Not Found!");// added throw exception

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
}
