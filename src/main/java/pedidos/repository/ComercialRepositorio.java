package pedidos.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pedidos.modelo.entities.Comercial;

@Repository
public interface ComercialRepositorio extends JpaRepository<Comercial, Integer>{

	//En mysql SELECT DISTINCT c.* FROM comerciales c INNER JOIN pedidos p ON c.id_comercial = p.id_comercial;
	@Query("SELECT DISTINCT c FROM Comercial c INNER JOIN Pedido p ON c.idComercial = p.comercial.idComercial")
	public List<Comercial> encontrarPorAlMenosUnPedidoConDevolucion();
	
	//En mysql SELECT DISTINCT c.* FROM comerciales c INNER JOIN pedidos p ON c.id_comercial = p.id_comercial AND p.id_cliente=8;
	@Query("SELECT DISTINCT c FROM Comercial c INNER JOIN Pedido p ON c.idComercial = p.comercial.idComercial AND p.cliente.idCliente=?1")
	public List<Comercial> encontrarPorIdClienteConDevolucion(int idCliente);
}
