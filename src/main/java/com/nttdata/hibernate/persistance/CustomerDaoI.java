package com.nttdata.hibernate.persistance;

import java.util.List;

/**
 * Segundo - Taller - Hibernate
 * 
 * DAO de tabla NTTDATA_CUSTOMER
 * 
 * @author santiagomr
 *
 */

public interface CustomerDaoI extends CommonDaoI<Customer> {

	/**
	 * Búsqueda por nombre y apellidos
	 * 
	 * @param customerName
	 * @param customerLastName
	 * @param customerSecondLastName
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndLastNames(String customerName, String customerLastName,
			String customerSecondLastName);

	/**
	 * Obtiene el nombre y el ID del contrato
	 * 
	 * @param name
	 * @param contractId
	 * @return
	 */
	List<Customer> searchByNameAndContractId(String name, Long contractId);

}
