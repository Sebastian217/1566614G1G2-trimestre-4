/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao.jdbc;

import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.factory.*;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class FichaHasListaDaoImpl extends AbstractDAO implements FichaHasListaDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT ficha, lista_chequeo FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ficha, lista_chequeo ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ficha = ?, lista_chequeo = ? WHERE ficha = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ficha = ?";

	/** 
	 * Index of column ficha
	 */
	protected static final int COLUMN_FICHA = 1;

	/** 
	 * Index of column lista_chequeo
	 */
	protected static final int COLUMN_LISTA_CHEQUEO = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column ficha
	 */
	protected static final int PK_COLUMN_FICHA = 1;

	/** 
	 * Inserts a new row in the ficha_has_lista table.
	 */
	public FichaHasListaPk insert(FichaHasLista dto) throws FichaHasListaDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setString( index++, dto.getFicha() );
			stmt.setString( index++, dto.getListaChequeo() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FichaHasListaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the ficha_has_lista table.
	 */
	public void update(FichaHasListaPk pk, FichaHasLista dto) throws FichaHasListaDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getFicha() );
			stmt.setString( index++, dto.getListaChequeo() );
			stmt.setString( 3, pk.getFicha() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FichaHasListaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the ficha_has_lista table.
	 */
	public void delete(FichaHasListaPk pk) throws FichaHasListaDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getFicha() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FichaHasListaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the ficha_has_lista table that matches the specified primary-key value.
	 */
	public FichaHasLista findByPrimaryKey(FichaHasListaPk pk) throws FichaHasListaDaoException
	{
		return findByPrimaryKey( pk.getFicha() );
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria 'ficha = :ficha'.
	 */
	public FichaHasLista findByPrimaryKey(String ficha) throws FichaHasListaDaoException
	{
		FichaHasLista ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ficha = ?", new Object[] { ficha } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria ''.
	 */
	public FichaHasLista[] findAll() throws FichaHasListaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ficha", null );
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria 'ficha = :ficha'.
	 */
	public FichaHasLista[] findByFicha(String ficha) throws FichaHasListaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ficha = ?", new Object[] { ficha } );
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria 'lista_chequeo = :listaChequeo'.
	 */
	public FichaHasLista[] findByListaChequeo(String listaChequeo) throws FichaHasListaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE lista_chequeo = ?", new Object[] { listaChequeo } );
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria 'ficha = :ficha'.
	 */
	public FichaHasLista[] findWhereFichaEquals(String ficha) throws FichaHasListaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ficha = ? ORDER BY ficha", new Object[] { ficha } );
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the criteria 'lista_chequeo = :listaChequeo'.
	 */
	public FichaHasLista[] findWhereListaChequeoEquals(String listaChequeo) throws FichaHasListaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE lista_chequeo = ? ORDER BY lista_chequeo", new Object[] { listaChequeo } );
	}

	/**
	 * Method 'FichaHasListaDaoImpl'
	 * 
	 */
	public FichaHasListaDaoImpl()
	{
	}

	/**
	 * Method 'FichaHasListaDaoImpl'
	 * 
	 * @param userConn
	 */
	public FichaHasListaDaoImpl(final Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "observador_de_proyectos.ficha_has_lista";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected FichaHasLista fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			FichaHasLista dto = new FichaHasLista();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected FichaHasLista[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			FichaHasLista dto = new FichaHasLista();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		FichaHasLista ret[] = new FichaHasLista[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(FichaHasLista dto, ResultSet rs) throws SQLException
	{
		dto.setFicha( rs.getString( COLUMN_FICHA ) );
		dto.setListaChequeo( rs.getString( COLUMN_LISTA_CHEQUEO ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(FichaHasLista dto)
	{
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the specified arbitrary SQL statement
	 */
	public FichaHasLista[] findByDynamicSelect(String sql, Object[] sqlParams) throws FichaHasListaDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FichaHasListaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the ficha_has_lista table that match the specified arbitrary SQL statement
	 */
	public FichaHasLista[] findByDynamicWhere(String sql, Object[] sqlParams) throws FichaHasListaDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FichaHasListaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
