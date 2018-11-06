/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.UsuarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.UsuarioFormularioRegistrar;

/**
 *
 * @author OMAR MONTES
 */
public class UsuarioRegistrar implements ActionListener {

    private UsuarioFormularioRegistrar vista;
    private UsuarioControl control;

    public UsuarioRegistrar(UsuarioControl control) {
        this.control = control;
        this.vista = new UsuarioFormularioRegistrar();
        init();
    }

    private void init() {

        vista.setVisible(true);
        vista.btnRegistrar.addActionListener(this);

    }

    private void limpiarFormulario() {
        vista.txtDoc.setText(null);
        vista.txtNombre.setText(null);
        vista.dateNac.setDate(null);
    }

    public UsuarioFormularioRegistrar getVista() {
        return vista;
    }

    private void usuario_registrar() {
        try {

            if (!control.usuario_registrar(vista.txtDoc.getText(), vista.txtNombre.getText(), vista.dateNac.getDate())) {
                limpiarFormulario();
            }
            
        } catch (Exception e) {
            control.mostrarMensaje(control.getVista(), "Datos incorrectos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {

            if (event.getActionCommand().contentEquals("action-usuario_registrar")) {
                usuario_registrar();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
