/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.factory;

import java.sql.Connection;
import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.dao.jdbc.*;

public class ObservacionItemDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ObservacionItemDao
	 */
	public static ObservacionItemDao create()
	{
		return new ObservacionItemDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ObservacionItemDao
	 */
	public static ObservacionItemDao create(Connection conn)
	{
		return new ObservacionItemDaoImpl( conn );
	}

}
