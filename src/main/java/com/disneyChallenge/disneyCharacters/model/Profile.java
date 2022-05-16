package com.disneyChallenge.disneyCharacters.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "profile")
public class Profile implements Serializable{
	private static final long serialVersionUID = 5029783019606927428L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_profile;
	@Column(length = 50)
	@NotEmpty
	private String name;
	private String description;
}
