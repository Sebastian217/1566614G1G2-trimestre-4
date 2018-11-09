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

public interface RolDao
{
	/** 
	 * Inserts a new row in the rol table.
	 */
	public RolPk insert(Rol dto) throws RolDaoException;

	/** 
	 * Updates a single row in the rol table.
	 */
	public void update(RolPk pk, Rol dto) throws RolDaoException;

	/** 
	 * Deletes a single row in the rol table.
	 */
	public void delete(RolPk pk) throws RolDaoException;

	/** 
	 * Returns the rows from the rol table that matches the specified primary-key value.
	 */
	public Rol findByPrimaryKey(RolPk pk) throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the criteria 'id_rol = :idRol'.
	 */
	public Rol findByPrimaryKey(String idRol) throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the criteria ''.
	 */
	public Rol[] findAll() throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the criteria 'id_rol = :idRol'.
	 */
	public Rol[] findWhereIdRolEquals(String idRol) throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the criteria 'descripcion = :descripcion'.
	 */
	public Rol[] findWhereDescripcionEquals(String descripcion) throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the criteria 'estado = :estado'.
	 */
	public Rol[] findWhereEstadoEquals(short estado) throws RolDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the rol table that match the specified arbitrary SQL statement
	 */
	public Rol[] findByDynamicSelect(String sql, Object[] sqlParams) throws RolDaoException;

	/** 
	 * Returns all rows from the rol table that match the specified arbitrary SQL statement
	 */
	public Rol[] findByDynamicWhere(String sql, Object[] sqlParams) throws RolDaoException;

}
