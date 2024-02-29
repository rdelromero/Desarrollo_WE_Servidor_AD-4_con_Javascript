package pedidos.service;
import java.util.List;
import pedidos.modelo.entities.Comercial;

public interface ComercialServicio {
	public abstract List<Comercial> encontrarTodosConDevolucion();
	public abstract Comercial encontrarPorIdConDevolucion(int idComercial);
	public abstract Comercial crearEInsertarComercialConDevolucion(Comercial comercial);
	public abstract Comercial actualizarComercialConDevolucion(Comercial comercial);
	public abstract int borrarPorId(int idComercial);
	public abstract List<Comercial> encontrarPorAlMenosUnPedidoConDevolucion();
	public abstract List<Comercial> encontrarPorIdClienteConDevolucion(int idCliente);
}
