package com.disneyChallenge.disneyCharacters.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity(name="user")
public class Usr implements Serializable{
	
	private static final long serialVersionUID = 3313101904237592948L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usr;
	@Column(length = 50)
	@NotEmpty
	private String username;
	@NotEmpty
	@Column(length = 255)
	@Min(6)
	private String password;
	@Column(length = 50, unique = true, nullable = false)
	@NotEmpty
	@Email (message = "El formato de correo electrónico es incorrecto")
	private String email;
	@Pattern(regexp = "[0-9]+")
	private String phone;
	private Boolean active = Boolean.TRUE;
	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profile profile;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date_account;
}