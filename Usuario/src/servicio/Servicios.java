/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author OMAR MONTES
 */
public class Servicios {

    private static Servicios servicios;
    private Servicio servicio;

    private Servicios() {
        servicio = new Servicio();
    }

    public static Servicios getServicios() {
        if (servicios == null) {
            servicios = new Servicios();
        }
        return servicios;
    }

    public Servicio getServicio() {

        return servicio;

    }

}
