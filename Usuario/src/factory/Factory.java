/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author OMAR MONTES
 */
public class Factory {

    public UsuarioDAO getUsuario() throws SQLException {
        return new UsuarioDAO();
    }

}
