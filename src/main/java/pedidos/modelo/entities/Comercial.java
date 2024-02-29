package pedidos.modelo.entities;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="comerciales")
@NamedQuery(name="Comercial.findAll", query="SELECT c FROM Comercial c")
public class Comercial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Ponemos @GeneratedValue(strategy=GenerationType.IDENTITY) por ser autoincrementable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comercial")
	private int idComercial;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private double comision;
}
