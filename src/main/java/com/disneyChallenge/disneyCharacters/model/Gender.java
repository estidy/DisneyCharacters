package com.disneyChallenge.disneyCharacters.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="gender")
public class Gender implements Serializable {

	private static final long serialVersionUID = -4539917301411474294L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_gender;
	@NotEmpty
	@Column(length = 100)
	private String name;
	@Lob
	private String image;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_gender")
	private Set<Movie_Serie> movies_series = new HashSet<>();
	
	
	public void addMovie_serie(Movie_Serie m_s) {
		movies_series.add(m_s);
	}
}

