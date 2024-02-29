package pedidos.service;
import java.util.List;
import pedidos.modelo.entities.Pedido;

public interface PedidoServicio {
	public abstract List<Pedido> encontrarPorIdComercialConDevolucion(int idComercial);
}
