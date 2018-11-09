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

public interface ObservacionGeneralDao
{
	/** 
	 * Inserts a new row in the observacion_general table.
	 */
	public ObservacionGeneralPk insert(ObservacionGeneral dto) throws ObservacionGeneralDaoException;

	/** 
	 * Updates a single row in the observacion_general table.
	 */
	public void update(ObservacionGeneralPk pk, ObservacionGeneral dto) throws ObservacionGeneralDaoException;

	/** 
	 * Deletes a single row in the observacion_general table.
	 */
	public void delete(ObservacionGeneralPk pk) throws ObservacionGeneralDaoException;

	/** 
	 * Returns the rows from the observacion_general table that matches the specified primary-key value.
	 */
	public ObservacionGeneral findByPrimaryKey(ObservacionGeneralPk pk) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'grupo_numero_ficha = :grupoNumeroFicha AND grupo_codigo = :grupoCodigo AND id_observacion = :idObservacion'.
	 */
	public ObservacionGeneral findByPrimaryKey(String grupoNumeroFicha, int grupoCodigo, int idObservacion) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria ''.
	 */
	public ObservacionGeneral[] findAll() throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'grupo_numero_ficha = :grupoNumeroFicha AND grupo_codigo = :grupoCodigo'.
	 */
	public ObservacionGeneral[] findByGrupoProyecto(String grupoNumeroFicha, int grupoCodigo) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'grupo_numero_ficha = :grupoNumeroFicha'.
	 */
	public ObservacionGeneral[] findWhereGrupoNumeroFichaEquals(String grupoNumeroFicha) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'grupo_codigo = :grupoCodigo'.
	 */
	public ObservacionGeneral[] findWhereGrupoCodigoEquals(int grupoCodigo) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'id_observacion = :idObservacion'.
	 */
	public ObservacionGeneral[] findWhereIdObservacionEquals(int idObservacion) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'observacion = :observacion'.
	 */
	public ObservacionGeneral[] findWhereObservacionEquals(String observacion) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'jurado = :jurado'.
	 */
	public ObservacionGeneral[] findWhereJuradoEquals(String jurado) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'fecha = :fecha'.
	 */
	public ObservacionGeneral[] findWhereFechaEquals(Date fecha) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the criteria 'usuario = :usuario'.
	 */
	public ObservacionGeneral[] findWhereUsuarioEquals(String usuario) throws ObservacionGeneralDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the observacion_general table that match the specified arbitrary SQL statement
	 */
	public ObservacionGeneral[] findByDynamicSelect(String sql, Object[] sqlParams) throws ObservacionGeneralDaoException;

	/** 
	 * Returns all rows from the observacion_general table that match the specified arbitrary SQL statement
	 */
	public ObservacionGeneral[] findByDynamicWhere(String sql, Object[] sqlParams) throws ObservacionGeneralDaoException;

}
