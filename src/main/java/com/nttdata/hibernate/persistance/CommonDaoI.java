package com.nttdata.hibernate.persistance;

import java.util.List;

/**
 * Segundo - Taller - Hibernate
 * 
 * Interfaz DAO génerico
 * 
 * @author santiagomr
 *
 */
public interface CommonDaoI<C> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramC
	 */
	public void insert(C paramC);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramC
	 */
	public void update(C paramC);

	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramC
	 */
	public void delete(C paramC);

	/**
	 * Localiza un registro de la tabla contratos por ID en BBDD.
	 * 
	 * @param paramC
	 */
	public C searchById(Long id);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<C>
	 */
	public List<C> searchAll();
}
