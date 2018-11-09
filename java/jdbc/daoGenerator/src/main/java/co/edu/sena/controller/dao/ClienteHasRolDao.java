/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao;

import java.util.Date;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;

public interface ClienteHasRolDao
{
	/** 
	 * Inserts a new row in the cliente_has_rol table.
	 */
	public ClienteHasRolPk insert(ClienteHasRol dto) throws ClienteHasRolDaoException;

	/** 
	 * Updates a single row in the cliente_has_rol table.
	 */
	public void update(ClienteHasRolPk pk, ClienteHasRol dto) throws ClienteHasRolDaoException;

	/** 
	 * Deletes a single row in the cliente_has_rol table.
	 */
	public void delete(ClienteHasRolPk pk) throws ClienteHasRolDaoException;

	/** 
	 * Returns the rows from the cliente_has_rol table that matches the specified primary-key value.
	 */
	public ClienteHasRol findByPrimaryKey(ClienteHasRolPk pk) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento AND rol = :rol'.
	 */
	public ClienteHasRol findByPrimaryKey(String tipoDocumento, String numeroDocumento, String rol) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria ''.
	 */
	public ClienteHasRol[] findAll() throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento'.
	 */
	public ClienteHasRol[] findByCliente(String tipoDocumento, String numeroDocumento) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'rol = :rol'.
	 */
	public ClienteHasRol[] findByRol(String rol) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento'.
	 */
	public ClienteHasRol[] findWhereTipoDocumentoEquals(String tipoDocumento) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'numero_documento = :numeroDocumento'.
	 */
	public ClienteHasRol[] findWhereNumeroDocumentoEquals(String numeroDocumento) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'rol = :rol'.
	 */
	public ClienteHasRol[] findWhereRolEquals(String rol) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'estado = :estado'.
	 */
	public ClienteHasRol[] findWhereEstadoEquals(short estado) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'fecha_terminacion = :fechaTerminacion'.
	 */
	public ClienteHasRol[] findWhereFechaTerminacionEquals(Date fechaTerminacion) throws ClienteHasRolDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the cliente_has_rol table that match the specified arbitrary SQL statement
	 */
	public ClienteHasRol[] findByDynamicSelect(String sql, Object[] sqlParams) throws ClienteHasRolDaoException;

	/** 
	 * Returns all rows from the cliente_has_rol table that match the specified arbitrary SQL statement
	 */
	public ClienteHasRol[] findByDynamicWhere(String sql, Object[] sqlParams) throws ClienteHasRolDaoException;

}
