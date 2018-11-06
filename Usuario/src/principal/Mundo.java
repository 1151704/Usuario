/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.UsuarioControl;
import servicio.Servicio;
import servicio.Servicios;

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

        Servicio servicios = Servicios.getServicios().getServicio();

        UsuarioControl control = new UsuarioControl(servicios);

    }
}
