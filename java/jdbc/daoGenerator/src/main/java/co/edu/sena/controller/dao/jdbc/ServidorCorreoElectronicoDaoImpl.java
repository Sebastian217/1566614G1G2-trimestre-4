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

public class ServidorCorreoElectronicoDaoImpl extends AbstractDAO implements ServidorCorreoElectronicoDao
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
	protected final String SQL_SELECT = "SELECT correo, contrasenia, smtp_host, smtp_port, smtp_start_tls_enable, smtp_auth, asunto_recuperacion, mensage_recuperacion FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( correo, contrasenia, smtp_host, smtp_port, smtp_start_tls_enable, smtp_auth, asunto_recuperacion, mensage_recuperacion ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET correo = ?, contrasenia = ?, smtp_host = ?, smtp_port = ?, smtp_start_tls_enable = ?, smtp_auth = ?, asunto_recuperacion = ?, mensage_recuperacion = ? WHERE correo = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE correo = ?";

	/** 
	 * Index of column correo
	 */
	protected static final int COLUMN_CORREO = 1;

	/** 
	 * Index of column contrasenia
	 */
	protected static final int COLUMN_CONTRASENIA = 2;

	/** 
	 * Index of column smtp_host
	 */
	protected static final int COLUMN_SMTP_HOST = 3;

	/** 
	 * Index of column smtp_port
	 */
	protected static final int COLUMN_SMTP_PORT = 4;

	/** 
	 * Index of column smtp_start_tls_enable
	 */
	protected static final int COLUMN_SMTP_START_TLS_ENABLE = 5;

	/** 
	 * Index of column smtp_auth
	 */
	protected static final int COLUMN_SMTP_AUTH = 6;

	/** 
	 * Index of column asunto_recuperacion
	 */
	protected static final int COLUMN_ASUNTO_RECUPERACION = 7;

	/** 
	 * Index of column mensage_recuperacion
	 */
	protected static final int COLUMN_MENSAGE_RECUPERACION = 8;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 8;

	/** 
	 * Index of primary-key column correo
	 */
	protected static final int PK_COLUMN_CORREO = 1;

	/** 
	 * Inserts a new row in the servidor_correo_electronico table.
	 */
	public ServidorCorreoElectronicoPk insert(ServidorCorreoElectronico dto) throws ServidorCorreoElectronicoDaoException
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
			stmt.setString( index++, dto.getCorreo() );
			stmt.setString( index++, dto.getContrasenia() );
			stmt.setString( index++, dto.getSmtpHost() );
			stmt.setInt( index++, dto.getSmtpPort() );
			stmt.setShort( index++, dto.getSmtpStartTlsEnable() );
			stmt.setShort( index++, dto.getSmtpAuth() );
			stmt.setString( index++, dto.getAsuntoRecuperacion() );
			stmt.setString( index++, dto.getMensageRecuperacion() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ServidorCorreoElectronicoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the servidor_correo_electronico table.
	 */
	public void update(ServidorCorreoElectronicoPk pk, ServidorCorreoElectronico dto) throws ServidorCorreoElectronicoDaoException
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
			stmt.setString( index++, dto.getCorreo() );
			stmt.setString( index++, dto.getContrasenia() );
			stmt.setString( index++, dto.getSmtpHost() );
			stmt.setInt( index++, dto.getSmtpPort() );
			stmt.setShort( index++, dto.getSmtpStartTlsEnable() );
			stmt.setShort( index++, dto.getSmtpAuth() );
			stmt.setString( index++, dto.getAsuntoRecuperacion() );
			stmt.setString( index++, dto.getMensageRecuperacion() );
			stmt.setString( 9, pk.getCorreo() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ServidorCorreoElectronicoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the servidor_correo_electronico table.
	 */
	public void delete(ServidorCorreoElectronicoPk pk) throws ServidorCorreoElectronicoDaoException
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
			stmt.setString( 1, pk.getCorreo() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ServidorCorreoElectronicoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the servidor_correo_electronico table that matches the specified primary-key value.
	 */
	public ServidorCorreoElectronico findByPrimaryKey(ServidorCorreoElectronicoPk pk) throws ServidorCorreoElectronicoDaoException
	{
		return findByPrimaryKey( pk.getCorreo() );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'correo = :correo'.
	 */
	public ServidorCorreoElectronico findByPrimaryKey(String correo) throws ServidorCorreoElectronicoDaoException
	{
		ServidorCorreoElectronico ret[] = findByDynamicSelect( SQL_SELECT + " WHERE correo = ?", new Object[] { correo } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria ''.
	 */
	public ServidorCorreoElectronico[] findAll() throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY correo", null );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'correo = :correo'.
	 */
	public ServidorCorreoElectronico[] findWhereCorreoEquals(String correo) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE correo = ? ORDER BY correo", new Object[] { correo } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'contrasenia = :contrasenia'.
	 */
	public ServidorCorreoElectronico[] findWhereContraseniaEquals(String contrasenia) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE contrasenia = ? ORDER BY contrasenia", new Object[] { contrasenia } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'smtp_host = :smtpHost'.
	 */
	public ServidorCorreoElectronico[] findWhereSmtpHostEquals(String smtpHost) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE smtp_host = ? ORDER BY smtp_host", new Object[] { smtpHost } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'smtp_port = :smtpPort'.
	 */
	public ServidorCorreoElectronico[] findWhereSmtpPortEquals(int smtpPort) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE smtp_port = ? ORDER BY smtp_port", new Object[] {  new Integer(smtpPort) } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'smtp_start_tls_enable = :smtpStartTlsEnable'.
	 */
	public ServidorCorreoElectronico[] findWhereSmtpStartTlsEnableEquals(short smtpStartTlsEnable) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE smtp_start_tls_enable = ? ORDER BY smtp_start_tls_enable", new Object[] {  new Short(smtpStartTlsEnable) } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'smtp_auth = :smtpAuth'.
	 */
	public ServidorCorreoElectronico[] findWhereSmtpAuthEquals(short smtpAuth) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE smtp_auth = ? ORDER BY smtp_auth", new Object[] {  new Short(smtpAuth) } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'asunto_recuperacion = :asuntoRecuperacion'.
	 */
	public ServidorCorreoElectronico[] findWhereAsuntoRecuperacionEquals(String asuntoRecuperacion) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE asunto_recuperacion = ? ORDER BY asunto_recuperacion", new Object[] { asuntoRecuperacion } );
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the criteria 'mensage_recuperacion = :mensageRecuperacion'.
	 */
	public ServidorCorreoElectronico[] findWhereMensageRecuperacionEquals(String mensageRecuperacion) throws ServidorCorreoElectronicoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mensage_recuperacion = ? ORDER BY mensage_recuperacion", new Object[] { mensageRecuperacion } );
	}

	/**
	 * Method 'ServidorCorreoElectronicoDaoImpl'
	 * 
	 */
	public ServidorCorreoElectronicoDaoImpl()
	{
	}

	/**
	 * Method 'ServidorCorreoElectronicoDaoImpl'
	 * 
	 * @param userConn
	 */
	public ServidorCorreoElectronicoDaoImpl(final Connection userConn)
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
		return "observador_de_proyectos.servidor_correo_electronico";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ServidorCorreoElectronico fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ServidorCorreoElectronico dto = new ServidorCorreoElectronico();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ServidorCorreoElectronico[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ServidorCorreoElectronico dto = new ServidorCorreoElectronico();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ServidorCorreoElectronico ret[] = new ServidorCorreoElectronico[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ServidorCorreoElectronico dto, ResultSet rs) throws SQLException
	{
		dto.setCorreo( rs.getString( COLUMN_CORREO ) );
		dto.setContrasenia( rs.getString( COLUMN_CONTRASENIA ) );
		dto.setSmtpHost( rs.getString( COLUMN_SMTP_HOST ) );
		dto.setSmtpPort( rs.getInt( COLUMN_SMTP_PORT ) );
		dto.setSmtpStartTlsEnable( rs.getShort( COLUMN_SMTP_START_TLS_ENABLE ) );
		dto.setSmtpAuth( rs.getShort( COLUMN_SMTP_AUTH ) );
		dto.setAsuntoRecuperacion( rs.getString( COLUMN_ASUNTO_RECUPERACION ) );
		dto.setMensageRecuperacion( rs.getString( COLUMN_MENSAGE_RECUPERACION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ServidorCorreoElectronico dto)
	{
	}

	/** 
	 * Returns all rows from the servidor_correo_electronico table that match the specified arbitrary SQL statement
	 */
	public ServidorCorreoElectronico[] findByDynamicSelect(String sql, Object[] sqlParams) throws ServidorCorreoElectronicoDaoException
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
			throw new ServidorCorreoElectronicoDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the servidor_correo_electronico table that match the specified arbitrary SQL statement
	 */
	public ServidorCorreoElectronico[] findByDynamicWhere(String sql, Object[] sqlParams) throws ServidorCorreoElectronicoDaoException
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
			throw new ServidorCorreoElectronicoDaoException( "Exception: " + _e.getMessage(), _e );
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
