/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the rae_has_trimestre table.
 */
public class RaeHasTrimestrePk implements Serializable
{
	protected String raeCodigo;

	protected String competenciaCodigo;

	protected String programaCodigoVersion;

	protected String idTrimestre;

	protected String jornada;

	/** 
	 * Sets the value of raeCodigo
	 */
	public void setRaeCodigo(String raeCodigo)
	{
		this.raeCodigo = raeCodigo;
	}

	/** 
	 * Gets the value of raeCodigo
	 */
	public String getRaeCodigo()
	{
		return raeCodigo;
	}

	/** 
	 * Sets the value of competenciaCodigo
	 */
	public void setCompetenciaCodigo(String competenciaCodigo)
	{
		this.competenciaCodigo = competenciaCodigo;
	}

	/** 
	 * Gets the value of competenciaCodigo
	 */
	public String getCompetenciaCodigo()
	{
		return competenciaCodigo;
	}

	/** 
	 * Sets the value of programaCodigoVersion
	 */
	public void setProgramaCodigoVersion(String programaCodigoVersion)
	{
		this.programaCodigoVersion = programaCodigoVersion;
	}

	/** 
	 * Gets the value of programaCodigoVersion
	 */
	public String getProgramaCodigoVersion()
	{
		return programaCodigoVersion;
	}

	/** 
	 * Sets the value of idTrimestre
	 */
	public void setIdTrimestre(String idTrimestre)
	{
		this.idTrimestre = idTrimestre;
	}

	/** 
	 * Gets the value of idTrimestre
	 */
	public String getIdTrimestre()
	{
		return idTrimestre;
	}

	/** 
	 * Sets the value of jornada
	 */
	public void setJornada(String jornada)
	{
		this.jornada = jornada;
	}

	/** 
	 * Gets the value of jornada
	 */
	public String getJornada()
	{
		return jornada;
	}

	/**
	 * Method 'RaeHasTrimestrePk'
	 * 
	 */
	public RaeHasTrimestrePk()
	{
	}

	/**
	 * Method 'RaeHasTrimestrePk'
	 * 
	 * @param raeCodigo
	 * @param competenciaCodigo
	 * @param programaCodigoVersion
	 * @param idTrimestre
	 * @param jornada
	 */
	public RaeHasTrimestrePk(final String raeCodigo, final String competenciaCodigo, final String programaCodigoVersion, final String idTrimestre, final String jornada)
	{
		this.raeCodigo = raeCodigo;
		this.competenciaCodigo = competenciaCodigo;
		this.programaCodigoVersion = programaCodigoVersion;
		this.idTrimestre = idTrimestre;
		this.jornada = jornada;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof RaeHasTrimestrePk)) {
			return false;
		}
		
		final RaeHasTrimestrePk _cast = (RaeHasTrimestrePk) _other;
		if (raeCodigo == null ? _cast.raeCodigo != raeCodigo : !raeCodigo.equals( _cast.raeCodigo )) {
			return false;
		}
		
		if (competenciaCodigo == null ? _cast.competenciaCodigo != competenciaCodigo : !competenciaCodigo.equals( _cast.competenciaCodigo )) {
			return false;
		}
		
		if (programaCodigoVersion == null ? _cast.programaCodigoVersion != programaCodigoVersion : !programaCodigoVersion.equals( _cast.programaCodigoVersion )) {
			return false;
		}
		
		if (idTrimestre == null ? _cast.idTrimestre != idTrimestre : !idTrimestre.equals( _cast.idTrimestre )) {
			return false;
		}
		
		if (jornada == null ? _cast.jornada != jornada : !jornada.equals( _cast.jornada )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (raeCodigo != null) {
			_hashCode = 29 * _hashCode + raeCodigo.hashCode();
		}
		
		if (competenciaCodigo != null) {
			_hashCode = 29 * _hashCode + competenciaCodigo.hashCode();
		}
		
		if (programaCodigoVersion != null) {
			_hashCode = 29 * _hashCode + programaCodigoVersion.hashCode();
		}
		
		if (idTrimestre != null) {
			_hashCode = 29 * _hashCode + idTrimestre.hashCode();
		}
		
		if (jornada != null) {
			_hashCode = 29 * _hashCode + jornada.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.model.dao.dto.RaeHasTrimestrePk: " );
		ret.append( "raeCodigo=" + raeCodigo );
		ret.append( ", competenciaCodigo=" + competenciaCodigo );
		ret.append( ", programaCodigoVersion=" + programaCodigoVersion );
		ret.append( ", idTrimestre=" + idTrimestre );
		ret.append( ", jornada=" + jornada );
		return ret.toString();
	}

}
