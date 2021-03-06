package entities;


import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Audited
public class Persona extends Base {

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dni")
	private int dni;
	
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn (name= "fk_domicilio")
	private Domicilio domicilio;
	
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
			name= "persona_libro",
			joinColumns= @JoinColumn (name="persona_id"),
			inverseJoinColumns= @JoinColumn (name="libro_id"))	
	private List<Libro> libros=new ArrayList<Libro>();
	
	
}