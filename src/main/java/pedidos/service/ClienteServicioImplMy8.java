package pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Cliente;
import pedidos.repository.ClienteRepositorio;

@Service
public class ClienteServicioImplMy8 implements ClienteServicio{
	
	@Autowired
	ClienteRepositorio clienteRepositorio;
	
	@Override
	public Cliente encontrarPorIdConDevolucion(int idCliente) {
		return clienteRepositorio.findById(idCliente).orElse(null);
	}
	
}
