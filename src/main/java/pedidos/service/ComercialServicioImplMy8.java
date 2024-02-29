package pedidos.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedidos.modelo.entities.Comercial;
import pedidos.repository.ComercialRepositorio;

@Service
public class ComercialServicioImplMy8 implements ComercialServicio{

	@Autowired
	ComercialRepositorio comercialRepositorio;
	
	@Autowired
	ComercialRepositorio clienteRepositorio;
	
	@Override
	public List<Comercial> encontrarTodosConDevolucion() {
		return comercialRepositorio.findAll();
	}

	@Override
	public Comercial encontrarPorIdConDevolucion(int idComercial) {
		return comercialRepositorio.findById(idComercial).orElse(null);
	}

	@Override
	public Comercial crearEInsertarComercialConDevolucion(Comercial comercial) {
		return comercialRepositorio.save(comercial);
	}

	@Override
	public Comercial actualizarComercialConDevolucion(Comercial comercial) {
		try {
			return comercialRepositorio.save(comercial);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int borrarPorId(int idComercial) {
		try {
			if (encontrarPorIdConDevolucion(idComercial) != null) {
			    comercialRepositorio.deleteById(idComercial);
			    return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Comercial> encontrarPorAlMenosUnPedidoConDevolucion() {
		return comercialRepositorio.encontrarPorAlMenosUnPedidoConDevolucion();
	}

	@Override
	public List<Comercial> encontrarPorIdClienteConDevolucion(int idCliente) {
		if (clienteRepositorio.encontrarPorIdClienteConDevolucion(idCliente) != null) {
		    return comercialRepositorio.encontrarPorIdClienteConDevolucion(idCliente);
		} else {
			return null;
		}
	}
}
