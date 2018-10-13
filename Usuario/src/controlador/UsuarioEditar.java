/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.UsuarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.UsuarioFormularioEditar;

/**
 *
 * @author OMAR MONTES
 */
public class UsuarioEditar implements ActionListener {

    private UsuarioFormularioEditar vista;
    private UsuarioControl control;
    private UsuarioDTO usuario;

    public UsuarioEditar(UsuarioControl control, UsuarioDTO usuario) {
        this.control = control;
        this.vista = new UsuarioFormularioEditar();
        this.usuario = usuario;
        init();
    }

    private void init() {

        vista.setVisible(true);
        resetearFormulario();
        vista.btnEditar.addActionListener(this);

    }

    private void resetearFormulario() {

        vista.txtDoc.setText(usuario.getDocumento());
        vista.txtNombre.setText(usuario.getNombre());
        vista.dateNac.setDate(usuario.getFechaNacimiento());
    }

    public UsuarioFormularioEditar getVista() {
        return vista;
    }

    private void usuario_editar() {

        try {

            UsuarioDTO usuario_nuevo = new UsuarioDTO(usuario.getId(),
                    usuario.getDocumento(),
                    vista.txtNombre.getText(),
                    vista.dateNac.getDate());

            if (!control.usuario_editar(usuario_nuevo)) {
                resetearFormulario();
            }

        } catch (Exception e) {
            control.mostrarMensaje(control.getVista(), "Formulario incorrecto");
        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {

            if (event.getActionCommand().contentEquals("action-usuario_editar")) {
                usuario_editar();
            }

        } catch (Exception e) {
        }

    }

}
