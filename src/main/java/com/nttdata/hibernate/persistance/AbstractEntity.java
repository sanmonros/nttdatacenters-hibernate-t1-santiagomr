package com.nttdata.hibernate.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Segundo Taller - Hibernate
 * 
 * Entidad abstracta
 * 
 * @author santiagomr
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría | Usuario que actualiza */
	private String updatedUser;

	/** Auditoría | Día actualizado */
	private Date updatedDate;

	/**
	 * Obtención primary Key
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return the updatedUser
	 */
	@Column(name = "A_UPDATE_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param the updatedUser to set
	 */

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "A_UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
