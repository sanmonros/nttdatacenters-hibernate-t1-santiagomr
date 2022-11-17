package com.nttdata.hibernate.persistance;

import java.util.List;

/**
 * Primer Taller - Hibernate
 * 
 * DAO de tabla NTTDATA_CUSTOMER
 * 
 * @author santiagomr
 *
 */

public interface CustomerDaoI<C> {

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
	 * Localiza un registro por ID en BBDD.
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

	/**
	 * Búsqueda por nombre y apellidos
	 * 
	 * @param customerName
	 * @param customerLastName
	 * @param customerSecondLastName
	 * @return
	 */
	public List<Customer> searchByNameAndLastNames(String customerName, String customerLastName,
			String customerSecondLastName);
}
