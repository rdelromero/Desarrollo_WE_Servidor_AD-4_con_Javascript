package pedidos.modelo.DTO;
import java.util.Date;
import jakarta.persistence.Entity;
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
public class PedidoDTO {
	private int idPedido;
	private double total;
	private Date fecha;
	private int idCliente;
	private int idComercial;
}
