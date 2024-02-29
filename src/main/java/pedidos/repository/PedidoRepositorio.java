package pedidos.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pedidos.modelo.entities.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

	/*@Query("select p from pedido where p.cliente.idCliente = ?1")
	public List<Pedido> encontrarPorIdPedido(int idComercial);*/
	
	@Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial = ?1")
	public List<Pedido> encontrarPorIdComercialConDevolucion(int idComercial);
	
}
