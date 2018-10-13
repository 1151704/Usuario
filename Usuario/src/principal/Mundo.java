/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.UsuarioControl;
import dao.UsuarioDAO;

/**
 *
 * @author OMAR MONTES
 */
public class Mundo {

    /**
     * Iniciar app
     *
     * @param args
     */
    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioControl control = new UsuarioControl(usuarioDAO);

    }
}
