package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistance.Contract;
import com.nttdata.hibernate.persistance.Customer;

/**
 * Segundo - Taller - Hibernate
 * 
 * Servicio Customer
 * 
 * @author santiagomr
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(Customer updateCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(Customer deleteCustomer);

	

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */

	public List<Customer> searchAll();

	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public Customer searchById(Long customerID);
	
	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(Contract newContract);

	/**
	 * Actualiza un Contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(Contract updateContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deleteContract
	 */
	public void deleteContract(Contract deleteContract);

	/**
	 * Obtiene un contrato a través de su ID
	 * 
	 * @param contractId
	 */
	public List<Customer> searchByNameAndContractId(String name,Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAllContract();

	List<Customer> searchByNameAndLastNames(String customerName, String customerLastName, String customerSecondLastName);

}
