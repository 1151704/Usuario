/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.UsuarioDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author OMAR MONTES
 */
public interface INegocio {

    public List<UsuarioDTO> usuarioListar();

    public UsuarioDTO usuarioInfo(int idUsuario);

    public boolean usuarioRegistrar(String documento, String nombre, Date fechaNacimiento);

    public boolean usuarioEditar(int idUsuario, String documento, String nombre, Date fechaNacimiento);

    public boolean usuarioEliminar(int idUsuario);

}
