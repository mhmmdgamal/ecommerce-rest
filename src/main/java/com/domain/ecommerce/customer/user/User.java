package com.domain.ecommerce.customer.user;

import javax.persistence.*;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String password;
	private String email;
	private String fullName;
	private int groupId;
//	private int regStatus;
	private int activated;
	private Date date;
	private String avatar;
	
}