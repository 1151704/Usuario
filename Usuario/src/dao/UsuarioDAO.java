/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import dto.UsuarioDTO;
import interfaces.Crud;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OMAR MONTES
 */
public class UsuarioDAO implements Crud<UsuarioDTO> {
    
    private static final String SQL_TABLE = "usuario",
            SQL_INSERT = "INSERT INTO " + SQL_TABLE + " (documento, nombre, fecha_nacimiento) VALUES (?,?,?)",
            SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET documento=?, nombre=?, fecha_nacimiento=? WHERE id = ?",
            SQL_DELETE = "DELETE FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT = "SELECT * FROM " + SQL_TABLE + " WHERE id = ?",
            SQL_SELECT_ALL = "SELECT * FROM " + SQL_TABLE,
            SQL_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = '" + SQL_TABLE + "'";
    
    private static final Conexion CON = Conexion.getInstance();
    
    @Override
    public boolean create(UsuarioDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_INSERT);
            
            ps.setString(1, o.getDocumento());
            ps.setString(2, o.getNombre());
            if (o.getFechaNacimiento() != null) {
                ps.setDate(3, new java.sql.Date(o.getFechaNacimiento().getTime()));
            } else {
                ps.setString(4, null);
            }
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }
    
    @Override
    public UsuarioDTO read(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        UsuarioDTO item = null;
        
        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT);
            
            ps.setInt(1, (Integer) key);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                item = new UsuarioDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getTimestamp(5),
                        rs.getTimestamp(6)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (item);
    }
    
    @Override
    public List<UsuarioDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<UsuarioDTO> listado = new ArrayList();
        
        try {
            ps = CON.getCnn().prepareStatement(SQL_SELECT_ALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                listado.add(new UsuarioDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getTimestamp(5),
                        rs.getTimestamp(6)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (listado);
    }
    
    @Override
    public boolean update(UsuarioDTO o) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, o.getDocumento());
            ps.setString(2, o.getNombre());
            if (o.getFechaNacimiento() != null) {
                ps.setDate(3, new java.sql.Date(o.getFechaNacimiento().getTime()));
            } else {
                ps.setString(3, null);
            }
            ps.setInt(4, o.getId());
            
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }
    
    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_DELETE);
            
            ps.setInt(1, (Integer) key);
            
            if (ps.executeUpdate() > 0) {
                return (true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (false);
    }
    
    @Override
    public int auto_increment() {
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AUTO_INCREMENT);
            
            ps.setString(1, Conexion.getDb());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.close();
        }
        return (id);
    }
    
}
