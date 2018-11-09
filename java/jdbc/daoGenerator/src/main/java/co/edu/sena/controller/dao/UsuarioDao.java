/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao;

import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;

public interface UsuarioDao
{
	/** 
	 * Inserts a new row in the usuario table.
	 */
	public UsuarioPk insert(Usuario dto) throws UsuarioDaoException;

	/** 
	 * Updates a single row in the usuario table.
	 */
	public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException;

	/** 
	 * Deletes a single row in the usuario table.
	 */
	public void delete(UsuarioPk pk) throws UsuarioDaoException;

	/** 
	 * Returns the rows from the usuario table that matches the specified primary-key value.
	 */
	public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento'.
	 */
	public Usuario findByPrimaryKey(String tipoDocumento, String numeroDocumento) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria ''.
	 */
	public Usuario[] findAll() throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento'.
	 */
	public Usuario[] findByCliente(String tipoDocumento, String numeroDocumento) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'tipo_documento = :tipoDocumento'.
	 */
	public Usuario[] findWhereTipoDocumentoEquals(String tipoDocumento) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'numero_documento = :numeroDocumento'.
	 */
	public Usuario[] findWhereNumeroDocumentoEquals(String numeroDocumento) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'correo = :correo'.
	 */
	public Usuario[] findWhereCorreoEquals(String correo) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the criteria 'contrasenia = :contrasenia'.
	 */
	public Usuario[] findWhereContraseniaEquals(String contrasenia) throws UsuarioDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the usuario table that match the specified arbitrary SQL statement
	 */
	public Usuario[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the usuario table that match the specified arbitrary SQL statement
	 */
	public Usuario[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsuarioDaoException;

}
