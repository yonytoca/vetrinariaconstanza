/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.veterinaria.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cfg.uapa.java.veterinaria.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
public class ServicioPais {
       private static final ServicioPais INSTANCIA = new ServicioPais();

    private ServicioPais() {
    }

    public static ServicioPais getInstancia() {
        return INSTANCIA;
    }


    public List<Pais> getListadoPais(){

       List<Pais> Listapais = new ArrayList<>();

        try (PreparedStatement stmt = Coneccion.getInstancia().getConeccion().prepareStatement("select * from pais")) {
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Pais pais = new Pais();                    
                    pais.setId(rs.getInt(1));
                    pais.setDescripcion(rs.getString(2));
                    Listapais.add(pais);
                 }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, ex);          
        }

        return Listapais;
    }



    public Pais getPaisPorId(int id) {

        String sql = "select * from pais where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pais pais = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();
            pais = new Pais();
            pais.setId(rs.getInt("id"));           
            pais.setDescripcion(rs.getString("descripcion"));
        } catch (SQLException e) {
            Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return pais;
    }
}

