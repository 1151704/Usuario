/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author OMAR MONTES
 */
public class UsuarioModel extends AbstractTableModel {

    protected List<UsuarioDTO> usuarios;

    private final String[] columnNames = {"Nombre", "Documento", "Fecha nacimiento", "Fecha creación", "Fecha actualización"};
    private final Class[] columnClasses = {String.class, String.class, String.class, String.class, String.class};

    public UsuarioModel(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UsuarioDTO usuario = this.usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getNombre();
            case 1:
                return usuario.getDocumento();
            case 2:
                return usuario.getFechaNacimiento();
            case 3:
                return usuario.getFechaCreacion();
            case 4:
                return usuario.getFechaActualizacion();
        }
        return ("");

    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
