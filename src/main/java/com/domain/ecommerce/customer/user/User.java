package com.domain.ecommerce.customer.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.domain.ecommerce.customer.model.BeanModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BeanModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @Size(max = 100)
	@Column(unique = true)
	private String name;
	
	@NotNull
    @Size(max = 100)
	@JsonIgnore// used to prevent the password field from being serialized into JSON.
	private String password;
	
	@NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String email;
	
	private String fullName;
	
	@Column(name="group_id", columnDefinition="Decimal(10,2) default '1'")
	private int groupId;
	
	private String avatar;

}