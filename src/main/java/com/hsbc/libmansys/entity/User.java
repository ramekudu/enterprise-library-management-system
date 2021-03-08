package com.hsbc.libmansys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(name = "userid", length = 100, nullable = false)
	private String userid;
	@Column(name = "firstName", length = 100, nullable = false)
	private String firstName;
	@Column(name = "lastName", length = 100, nullable = false)
	private String lastName;
	@Column(name = "sex", length = 100, nullable = false)
	private String sex;
	@Column(name = "addressline1", length = 100, nullable = false)
	private String addressline1;
	@Column(name = "addressline2", length = 100, nullable = false)
	private String addressline2;
	@Column(name = "country", length = 100, nullable = false)
	private String country;

}
