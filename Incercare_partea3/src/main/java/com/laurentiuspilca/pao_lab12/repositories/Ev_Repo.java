package com.laurentiuspilca.pao_lab12.repositories;

import com.laurentiuspilca.pao_lab12.model.Eveniment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ev_Repo {
    private String url = "jdbc:mysql://localhost/proiect";
    private String username = "vlad";
    private String password = "isprava99";

    public void adaugaEv(Eveniment p) {
        String sql = "INSERT INTO produse VALUES (?,?,?,?,NULL)";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setInt(0, p.getDuration_h());
            s.setInt(1, p.getDuration_m());
            s.setDouble(2, p.getPrice());
            s.setInt(3, p.getLocuri());
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public List<Eveniment> findEvenimente() {
        List<Eveniment> list = new ArrayList<>();

        String sql = "SELECT * FROM produse";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
                ResultSet rs = s.executeQuery();
        ) {
            while (rs.next()) {
                int duration_h = rs.getInt("duration_h");
                int duration_m = rs.getInt("duration_m");
                double price = rs.getDouble("price");
                int locuri = rs.getInt("locuri");
                int id = rs.getInt("id");

                list.add(new Eveniment(duration_h, duration_m, price, locuri, id));

            }
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }

        return list;
    }

    public void stergeEventiment(Eveniment p) {
        String sql = "DELETE FROM produse WHERE id = ?";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setInt(4, p.getId());
            s.executeUpdate();
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }
}
