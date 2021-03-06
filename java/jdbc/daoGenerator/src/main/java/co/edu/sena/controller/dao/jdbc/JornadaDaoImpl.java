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

public class JornadaDaoImpl extends AbstractDAO implements JornadaDao
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
	protected final String SQL_SELECT = "SELECT nombre, estado, descripcion FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( nombre, estado, descripcion ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET nombre = ?, estado = ?, descripcion = ? WHERE nombre = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE nombre = ?";

	/** 
	 * Index of column nombre
	 */
	protected static final int COLUMN_NOMBRE = 1;

	/** 
	 * Index of column estado
	 */
	protected static final int COLUMN_ESTADO = 2;

	/** 
	 * Index of column descripcion
	 */
	protected static final int COLUMN_DESCRIPCION = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column nombre
	 */
	protected static final int PK_COLUMN_NOMBRE = 1;

	/** 
	 * Inserts a new row in the jornada table.
	 */
	public JornadaPk insert(Jornada dto) throws JornadaDaoException
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
			stmt.setString( index++, dto.getNombre() );
			stmt.setShort( index++, dto.getEstado() );
			stmt.setString( index++, dto.getDescripcion() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new JornadaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the jornada table.
	 */
	public void update(JornadaPk pk, Jornada dto) throws JornadaDaoException
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
			stmt.setString( index++, dto.getNombre() );
			stmt.setShort( index++, dto.getEstado() );
			stmt.setString( index++, dto.getDescripcion() );
			stmt.setString( 4, pk.getNombre() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new JornadaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the jornada table.
	 */
	public void delete(JornadaPk pk) throws JornadaDaoException
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
			stmt.setString( 1, pk.getNombre() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new JornadaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the jornada table that matches the specified primary-key value.
	 */
	public Jornada findByPrimaryKey(JornadaPk pk) throws JornadaDaoException
	{
		return findByPrimaryKey( pk.getNombre() );
	}

	/** 
	 * Returns all rows from the jornada table that match the criteria 'nombre = :nombre'.
	 */
	public Jornada findByPrimaryKey(String nombre) throws JornadaDaoException
	{
		Jornada ret[] = findByDynamicSelect( SQL_SELECT + " WHERE nombre = ?", new Object[] { nombre } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the jornada table that match the criteria ''.
	 */
	public Jornada[] findAll() throws JornadaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY nombre", null );
	}

	/** 
	 * Returns all rows from the jornada table that match the criteria 'nombre = :nombre'.
	 */
	public Jornada[] findWhereNombreEquals(String nombre) throws JornadaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE nombre = ? ORDER BY nombre", new Object[] { nombre } );
	}

	/** 
	 * Returns all rows from the jornada table that match the criteria 'estado = :estado'.
	 */
	public Jornada[] findWhereEstadoEquals(short estado) throws JornadaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE estado = ? ORDER BY estado", new Object[] {  new Short(estado) } );
	}

	/** 
	 * Returns all rows from the jornada table that match the criteria 'descripcion = :descripcion'.
	 */
	public Jornada[] findWhereDescripcionEquals(String descripcion) throws JornadaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE descripcion = ? ORDER BY descripcion", new Object[] { descripcion } );
	}

	/**
	 * Method 'JornadaDaoImpl'
	 * 
	 */
	public JornadaDaoImpl()
	{
	}

	/**
	 * Method 'JornadaDaoImpl'
	 * 
	 * @param userConn
	 */
	public JornadaDaoImpl(final Connection userConn)
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
		return "observador_de_proyectos.jornada";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Jornada fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Jornada dto = new Jornada();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Jornada[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Jornada dto = new Jornada();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Jornada ret[] = new Jornada[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Jornada dto, ResultSet rs) throws SQLException
	{
		dto.setNombre( rs.getString( COLUMN_NOMBRE ) );
		dto.setEstado( rs.getShort( COLUMN_ESTADO ) );
		dto.setDescripcion( rs.getString( COLUMN_DESCRIPCION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Jornada dto)
	{
	}

	/** 
	 * Returns all rows from the jornada table that match the specified arbitrary SQL statement
	 */
	public Jornada[] findByDynamicSelect(String sql, Object[] sqlParams) throws JornadaDaoException
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
			throw new JornadaDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the jornada table that match the specified arbitrary SQL statement
	 */
	public Jornada[] findByDynamicWhere(String sql, Object[] sqlParams) throws JornadaDaoException
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
			throw new JornadaDaoException( "Exception: " + _e.getMessage(), _e );
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
