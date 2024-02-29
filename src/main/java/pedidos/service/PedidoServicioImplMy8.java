package pedidos.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Comercial;
import pedidos.modelo.entities.Pedido;
import pedidos.repository.PedidoRepositorio;

@Service
public class PedidoServicioImplMy8 implements PedidoServicio{

	@Autowired
	PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	PedidoRepositorio comercialRepositorio;
	
	@Override
	public List<Pedido> encontrarPorIdComercialConDevolucion(int idComercial) {
		if (comercialRepositorio.findById(idComercial) != null) {
			return pedidoRepositorio.encontrarPorIdComercialConDevolucion(idComercial);
		}
		else
			return null;
	}
}
