package controlador;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import vista.UsuarioModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import servicio.Servicio;
import vista.Usuarios;

/**
 *
 * @author OMAR MONTES
 */
public class UsuarioControl implements ActionListener {

    /**
     * Ventana
     *
     * @param vista JFrame usuario
     */
    private Usuarios vista;

    private final Servicio servicios;

    /**
     * Lista
     *
     * @param usuarios listado de usuarios
     */
    private List<UsuarioDTO> usuarios;

    /**
     * Usuario seleccionado
     *
     * @param usuario DATA TRANSFER OBJECT
     */
    private UsuarioDTO usuario;

    /**
     * Popup tabla
     *
     * @param tablePopup
     */
    private TablePopup tablePopup;

    public UsuarioControl(Servicio servicios) {
        this.servicios = servicios;
        this.vista = new Usuarios();
        init();
    }

    /**
     * Inicializa el controlador de usuarios
     */
    private void init() {

        vista.setVisible(true);

        tablePopup = new TablePopup(vista.tabla, this);

        this.vista.btnActualizar.addActionListener(this);

        actualizar();

    }

    /**
     * Importar formulario de edición del usuario seleccionado
     */
    protected void mostrarFormularioEditar() {
        if (usuario != null) {
            UsuarioEditar controlEditar = new UsuarioEditar(this, usuario);
            vista.contenedorForm.setViewportView(controlEditar.getVista());
        } else {
            mostrarMensaje(vista, "No existe un usuario seleccionado");
        }
    }

    /**
     * Importar formulario de registro de un usuario
     */
    private void mostrarFormularioRegistrar() {

        UsuarioRegistrar controlRegistrar = new UsuarioRegistrar(this);
        vista.contenedorForm.setViewportView(controlRegistrar.getVista());

    }

    /**
     * Servlet para actualizar datos de un usuario
     *     
     * @param idUsuario
     * @param documento
     * @param nombre
     * @param fechaNacimiento
     * @return true si el usuario se actualizo con exito, false en caso
     * contrario
     */
    protected boolean usuario_editar(int idUsuario, String documento, String nombre, Date fechaNacimiento) {

        if (servicios.usuarioEditar(idUsuario, documento, nombre, fechaNacimiento)) {
            actualizar();
            return true;
        } else {
            mostrarMensaje(vista, "No se actualizo el usuario");
        }
        return false;

    }

    /**
     * Servlet para registrar un nuevo usuario
     *
     * @param documento
     * @param nombre
     * @param fechaNacimiento
     * @return true si el registro se realizo con exito, false en caso contrario
     */
    protected boolean usuario_registrar(String documento, String nombre, Date fechaNacimiento) {
        if (servicios.usuarioRegistrar(documento, nombre, fechaNacimiento)) {
            actualizar();
            return true;
        } else {
            mostrarMensaje(vista, "No se registro el usuario");
        }
        return false;
    }

    /**
     * Servlet para eliminar el usuario seleccionado
     *
     * @return true si se elimino con exito, false en caso contrario
     */
    protected boolean usuario_eliminar() {

        if (usuario != null) {
            switch (confirmar(vista, "Seguro desea eliminar el usuario \"" + usuario.getNombre() + "\"")) {

                case 0:
                    if (servicios.usuarioEliminar(usuario.getId())) {
                        actualizar();
                        return true;
                    }
                    break;

                default:
                    break;

            }
        } else {
            mostrarMensaje(vista, "No existe un usuario seleccionado");
        }
        return (false);
    }

    /**
     * Actualizar información de la tabla
     */
    private void actualizar() {

        usuarios = servicios.usuarioListar();
        usuario = null;
        mostrarFormularioRegistrar();

        vista.tabla.setModel(new UsuarioModel(usuarios));

        vista.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                int row = vista.tabla.rowAtPoint(me.getPoint());

                usuario = usuarios.get(row);

                if (me.isPopupTrigger()) {
                    tablePopup.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getActionCommand().contentEquals("action-usuario_registrar")) {
                mostrarFormularioRegistrar();
            }
            if (event.getActionCommand().contentEquals("action-tabla_actualizar")) {
                actualizar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void mostrarMensaje(Component contenedor, String mensaje) {
        JOptionPane.showMessageDialog(contenedor, mensaje);
    }

    private int confirmar(Component contenedor, String mensaje) {
        return JOptionPane.showConfirmDialog(contenedor, mensaje);
    }

    public Usuarios getVista() {
        return vista;
    }

}

class TablePopup extends JPopupMenu {

    public TablePopup(JTable tree, UsuarioControl controlador) {
        JMenuItem itemEdit = new JMenuItem("Editar");
        JMenuItem itemDelete = new JMenuItem("Eliminar");
        itemEdit.addActionListener((ActionEvent ae) -> {
            controlador.mostrarFormularioEditar();
        });
        itemDelete.addActionListener((ActionEvent ae) -> {
            controlador.usuario_eliminar();
        });

        super.add(itemEdit);
        super.add(new JSeparator());
        super.add(itemDelete);
    }
}
