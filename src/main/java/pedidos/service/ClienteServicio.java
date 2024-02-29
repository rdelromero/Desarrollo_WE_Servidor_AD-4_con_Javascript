package pedidos.service;
import pedidos.modelo.entities.Cliente;

public interface ClienteServicio {
	public abstract Cliente encontrarPorIdConDevolucion(int idCliente);
}
