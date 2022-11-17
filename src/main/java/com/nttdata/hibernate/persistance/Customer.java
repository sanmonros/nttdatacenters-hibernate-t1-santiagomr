package com.nttdata.hibernate.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Primer Taller - Hibernate
 * 
 * Entidad de la tabla NTTDATA_CUSTOMER
 * 
 * @author santiagomr
 *
 */
@Entity
@Table(name = "NTTDATA_CUSTOMER")
public class Customer implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador */
	private Long customerID;

	/** Nombre */
	private String customerName;

	/** Primer apellido */
	private String customerLastName;

	/** Segundo apellido */
	private String customerSecondLastName;

	/** Documento de identidad */
	private String customerDni;

	/**
	 * 
	 * @return the customerID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")

	public Long getCustomerID() {
		return customerID;
	}

	/**
	 * 
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	/**
	 * 
	 * @return the customerName
	 */
	@Column(name = "CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 
	 * @return the customerLastName
	 */
	@Column(name = "CUSTOMER_LASTNAME")
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * 
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * 
	 * @return the customerSecondLastName
	 */
	@Column(name = "CUSTOMER_SECOND_LAST_NAME")
	public String getCustomerSecondLastName() {
		return customerSecondLastName;
	}

	/**
	 * 
	 * @param customerSecondLastName the customerSecondLastName to set
	 */
	public void setCustomerSecondLastName(String customerSecondLastName) {
		this.customerSecondLastName = customerSecondLastName;
	}

	/**
	 * 
	 * @return customerDni
	 */
	@Column(name = "CUSTOMER_DNI", nullable = false)
	@Digits(integer = 9, fraction = 0)
	@Min(value = 000000001)
	@Max(value = 999999999)

	/**
	 * 
	 * @return the customerDni
	 */
	public String getCustomerDni() {
		return customerDni;
	}

	/**
	 * 
	 * @param customerDni the customerDni to set
	 */
	public void setCustomerDni(String customerDni) {
		this.customerDni = customerDni;
	}

	/**
	 * Método toString()
	 */
	@Override
	public String toString() {
		return "[customerID = " + customerID + ", customerName = " + customerName + ", customerLastName = "
				+ customerLastName + ", customerSecondLastName = " + customerSecondLastName + ", customerDni = "
				+ customerDni + "]";
	}

}
