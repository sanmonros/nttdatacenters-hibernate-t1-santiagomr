package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistance.Contract;
import com.nttdata.hibernate.persistance.ContractDaoI;
import com.nttdata.hibernate.persistance.ContractDaoImpl;
import com.nttdata.hibernate.persistance.Customer;
import com.nttdata.hibernate.persistance.CustomerDaoI;
import com.nttdata.hibernate.persistance.CustomerDaoImpl;

/**
 * Segundo - Taller - Hibernate
 * 
 * Servicio Customer implementación
 * 
 * @author santiagomr
 */
public class ManagementServiceImpl implements ManagementServiceI {

	/** DAO: NTTDATA_CUSTOMER */

	private CustomerDaoI customerDao;

	private ContractDaoI contractDao;

	/**
	 * Método Constructor
	 * 
	 * @param customerDao
	 */
	public ManagementServiceImpl(Session session) {
		this.customerDao = new CustomerDaoImpl(session);
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(Customer newCustomer) {
		// Comprobar nulidad e inexistencia
		if (newCustomer != null && newCustomer.getCustomerID() == null) {

			// Insertar un nuevo cliente
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(Customer updateCustomer) {
		// Comprobar nulidad e inexistencia
		if (updateCustomer != null && updateCustomer.getCustomerID() == null) {
			// Actualizar cliente
			customerDao.update(updateCustomer);
		}
	}

	@Override
	public void deleteCustomer(Customer deleteCustomer) {

		if (deleteCustomer != null && deleteCustomer.getCustomerID() == null) {
			// Borrar cliente
			customerDao.delete(deleteCustomer);
		}

	}

	@Override
	public List<Customer> searchByNameAndLastNames(String customerName, String customerLastName,
			String customerSecondLastName) {
		// Lista resultado
		List<Customer> customerList = new ArrayList<>();

		// Comprobación nulidad
		if (StringUtils.isNotBlank(customerName)) {
			customerList = customerDao.searchByNameAndLastNames(customerName, customerLastName, customerSecondLastName);
		}

		return customerList;
	}

	@Override
	public List<Customer> searchAll() {

		List<Customer> customerList;

		customerList = customerDao.searchAll();

		return customerList;
	}

	/**
	 * Obtención del id de cliente
	 */
	public Customer searchById(Long customerID) {

		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (customerID != null) {

			// Obtención del jugador por ID.
			customer = customerDao.searchById(customerID);
		}

		return customer;
	}

	@Override
	public void insertNewContract(Contract newContract) {
		// Verificacion de nulidad.
		if (newContract != null && newContract.getContractID() == null) {
			// Insercion del nuevo contrato.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(Contract updateContract) {
		// Verificacion de nulidad.
		if (updateContract != null && updateContract.getContractID() != null) {
			// Actualizacion del contrato.
			contractDao.update(updateContract);
		}

	}

	@Override
	public void deleteContract(Contract deleteContract) {

		// Verificacion de nulidad.
		if (deleteContract != null && deleteContract.getContractID() != null) {

			// Eliminacion del contrato.
			contractDao.delete(deleteContract);
		}

	}

	@Override
	public List<Customer> searchByNameAndContractId(String name, Long contractId) {
		List<Customer> clientList;

		// Obtención de clientes.
		clientList = customerDao.searchByNameAndContractId(name, contractId);
		return clientList;
	}

	@Override
	public List<Contract> searchAllContract() {
		// Resultado.
		List<Contract> contractList;

		// Obtencion de contratos.
		contractList = contractDao.searchAll();

		return contractList;
	}

}
