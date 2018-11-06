/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dto.UsuarioDTO;
import facade.INegocio;
import java.util.Date;
import java.util.List;
import negocio.Negocio;

/**
 *
 * @author OMAR MONTES
 */
public class Servicio {

    private final INegocio negocio;

    public Servicio() {
        this.negocio = new Negocio();
    }

    public List<UsuarioDTO> usuarioListar() {
        return negocio.usuarioListar();
    }

    public UsuarioDTO usuarioInfo(int idUsuario) {
        return negocio.usuarioInfo(idUsuario);
    }

    public boolean usuarioRegistrar(String documento, String nombre, Date fechaNacimiento) {
        return negocio.usuarioRegistrar(documento, nombre, fechaNacimiento);
    }

    public boolean usuarioEditar(int idUsuario, String documento, String nombre, Date fechaNacimiento) {
        return negocio.usuarioEditar(idUsuario, documento, nombre, fechaNacimiento);
    }

    public boolean usuarioEliminar(int idUsuario) {
        return negocio.usuarioEliminar(idUsuario);
    }

}
