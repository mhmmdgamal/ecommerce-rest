package com.domain.ecommerce.customer.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Data
//@MappedSuperclass
////to automatically populate the createdAt and updatedAt fields:
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class BeanModel implements Serializable {

//	// Time at which the Note was created.
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "created_at", nullable = false, updatable = false)
//	@CreatedDate
//	private Date createdAt;
//
//	// Time at which the Note was updated.
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "updated_at", nullable = false)
//	@LastModifiedDate
//	private Date updatedAt;
//
//	@Column(name = "activated", columnDefinition = "Decimal(10,2) default '1'")
//	private int activated;
}
