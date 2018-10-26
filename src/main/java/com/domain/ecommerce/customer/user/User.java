package com.domain.ecommerce.customer.user;

import javax.persistence.*;

import java.io.FileInputStream;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String password;
	private String email;
	private String fullName;
//	private int groupId;
	private boolean activated;
	private int regStatus;
	private Date date;
	private FileInputStream avatarInput;
	private FileInputStream avatarOutput;

}