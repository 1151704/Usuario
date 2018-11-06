package dao.interfaces;

import java.util.List;

/**
 * Implementación de crud de cualquier entidad de la base de datos<br>
 * Utilizando la Generalizacion
 *
 * @author OMAR MONTES
 * @param <T> DTO (data transfer object)
 */
public interface Crud<T> {

    /**
     * Registrar
     *
     * @param o objeto de transferencia de datos
     * @return Verdadero si registro el objeto y falso en caso contrario
     */
    public boolean create(T o);

    /**
     * Leer un objeto
     *
     * @param key clave de referencia
     * @return objeto de transferencia de datos
     */
    public T read(Object key);

    /**
     * Leer todos los objetos
     *
     * @return listado de objetos de transferencia de datos
     */
    public List<T> readAll();

    /**
     * Actualizar
     *
     * @param o objeto de transferencia de datos
     * @return Verdadero si actualizo el objeto y falso en caso contrario
     */
    public boolean update(T o);

    /**
     * Eliminar
     *
     * @param key clave de referencia
     * @return Verdadero si elimino el objeto y falso en caso contrario
     */
    public boolean delete(Object key);

    /**
     * Autoincrementable
     *
     * @return el indice autoincrementable actual de la entidad
     */
    public int auto_increment();

}
