package com.disneyChallenge.disneyCharacters.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity (name="movie_serie")
public class Movie_Serie implements Serializable {

	private static final long serialVersionUID = 2973620462083950105L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_move_serie;
	@Lob
	private String image;
	@NotEmpty
	@Column(length = 255)
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate creation_date;
	@Range (min =1, max =5, message ="El elemento anotado debe estar en el rango apropiado")
	private Integer Score;
	@ManyToMany(mappedBy="movies_series", cascade = CascadeType.PERSIST)
	private Set<Character> characters = new HashSet<>();
	
	
	public void addCharacter(Character c) {
		characters.add(c);
	}

}
