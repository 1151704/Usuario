/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dto.UsuarioDTO;
import facade.INegocio;
import factory.Factory;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author OMAR MONTES
 */
public class Negocio implements INegocio {

    private final Factory factory;

    public Negocio() {
        this.factory = new Factory();
    }

    @Override
    public List<UsuarioDTO> usuarioListar() {
        try {
            return factory.getUsuario().readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UsuarioDTO usuarioInfo(int idUsuario) {
        try {
            return factory.getUsuario().read(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean usuarioRegistrar(String documento, String nombre, Date fechaNacimiento) {
        try {
            return factory.getUsuario().create(new UsuarioDTO(documento, nombre, fechaNacimiento));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean usuarioEditar(int idUsuario, String documento, String nombre, Date fechaNacimiento) {
        try {
            return factory.getUsuario().update(new UsuarioDTO(idUsuario, documento, nombre, fechaNacimiento));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean usuarioEliminar(int idUsuario) {
        try {
            return factory.getUsuario().delete(idUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
