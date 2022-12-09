package com.nttdata.hibernate.persistance;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Segundo - Taller - Hiberate
 * 
 * Entidad Tabla NTTDATA_CONTRACT
 * 
 * @author santiagomr
 */
@Entity
@Table(name = "NTTDATA_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador */
	private Long contractID;

	/** Fecha de vigencia */
	private String effectiveDate;

	/** Fecha de caducidad */
	private String expiryDate;

	/** Precio */
	private Double contractPrice;

	/** Relación con cliente */
	private List<Customer> customers;

	/**
	 * 
	 * @return the contractID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractID() {
		return contractID;
	}

	/**
	 * 
	 * @param the contractID to set
	 */
	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}

	/**
	 * 
	 * @return the effectiveDate
	 */
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * 
	 * @param the effectiveDate to set
	 */
	public void setEffectiveDate(String string) {
		this.effectiveDate = string;
	}

	/**
	 * 
	 * @return expiryDate
	 */
	@Column(name = "EXPIRY_DATE", nullable = false)
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 
	 * @param the expiryDate to set
	 */
	public void setExpiryDate(String string) {
		this.expiryDate = string;
	}

	/**
	 * 
	 * @return contractPrice
	 */
	@Column(name = "CONTRACT_PRICE", nullable = false)
	public Double getContractPrice() {
		return contractPrice;
	}

	/**
	 * 
	 * @param the contractPrice to set
	 */
	public void setContractPrice(Double contractPrice) {
		this.contractPrice = contractPrice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
	public List<Customer> getCustomers() {

		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Transient
	@Override
	public Long getId() {
		return this.contractID;
	}

}
