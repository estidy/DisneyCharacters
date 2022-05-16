package com.disneyChallenge.disneyCharacters.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="characters")
public class Character implements Serializable {

	private static final long serialVersionUID = -2887453247465768640L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_character;
	@Lob
	private String image;
	@NotEmpty
	private String name;
	@NotNull
	private Integer age;
	@NotNull
	private Double weight;
	@Lob
	private String history;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "character_movie_serie", joinColumns = { @JoinColumn(name = "character_id") }, inverseJoinColumns = {
			@JoinColumn(name = "movie_serie_id") })
	private Set<Movie_Serie> movies_series = new HashSet<>();
	
	
	public void addMovie_Serie(Movie_Serie m_s) {
		movies_series.add(m_s);
	}

}
