package com.company;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Baza {

    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/korisnici";
    private static String username = "root";
    private static String password = "";

    public static void addUser(User user) {
        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement st = con.prepareStatement("INSERT INTO users (ime,prezime,adresa,telefon,godina) " + "VALUES (?,?,?,?,?)");
            st.setString(1, user.getIme());
            st.setString(2, user.getPrezime());
            st.setString(3, user.getAdresa());
            st.setString(4, user.getTelefon());
            st.setInt(5, user.getGodina());
            st.execute();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}