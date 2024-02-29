package pedidos.restcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedidos.modelo.entities.Comercial;
import pedidos.service.ClienteServicio;
import pedidos.service.ComercialServicio;
import pedidos.service.PedidoServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comercial")
public class ComercialRestController {
	
	@Autowired
	private ComercialServicio comercialServicio;
	
	@Autowired
	private ClienteServicio clienteServicio;
	
	@Autowired
	private PedidoServicio pedidoServicio;
	
	@GetMapping("")
	public List<Comercial> todos() {
		return comercialServicio.encontrarTodosConDevolucion();
	}
	
	//Con ResponseEntity<?> permitimos la devolucion de objetos de diferentes tipos, en este caso o Comercial o String.
	@GetMapping("/uno/{idComercial}")
    public ResponseEntity<?> uno(@PathVariable int idComercial) {
        Comercial comercial = comercialServicio.encontrarPorIdConDevolucion(idComercial);
        if (comercial == null) {
            String mensaje = "No existe un comercial con id " + idComercial+".";
            //Error 404 y devuelvo un mensaje
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);	
        } else  {
            return ResponseEntity.ok(comercial);
        }
    }
	
	//Ojo es RequestBody no RequestParameter
	@PostMapping("/alta")
	public Comercial alta(@RequestBody Comercial comercial){
		return comercialServicio.crearEInsertarComercialConDevolucion(comercial);
	}
	
	//Recibiremos familia con código y todo
	@PutMapping("/actualizar")
	public Comercial actualizacion(@RequestBody Comercial comercial) {
		return comercialServicio.actualizarComercialConDevolucion(comercial);
	}
	
	@DeleteMapping("/eliminar/{idComercial}")
	public String borrar(@PathVariable int idComercial) {
		if (comercialServicio.borrarPorId(idComercial)==1)
			return "Comercial borrado correctamente";
		else if (comercialServicio.borrarPorId(idComercial)==-1)
		    return "No se ha podido borrar. No existe comercial con ese id.";
		else
			return "No se ha podido borrar. El comercial tiene pedidos gestionados a su nombre.";
	}
	
	@GetMapping("/pedidos/{idComercial}")
    public ResponseEntity<?> pedidosporcomercial (@PathVariable int idComercial) {
        if (comercialServicio.encontrarPorIdConDevolucion(idComercial) == null) {
            String mensaje = "No existe el comercial con id "+idComercial+".";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        } else if (pedidoServicio.encontrarPorIdComercialConDevolucion(idComercial).isEmpty()) {
            String mensaje = "El comercial de id "+idComercial+" existe pero no tiene ningún pedido gestionado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        } else {
            return ResponseEntity.ok(pedidoServicio.encontrarPorIdComercialConDevolucion(idComercial));
        }
    }
	
	@GetMapping("/conpedidos")
    public List<Comercial> comercialesconpedidos() {
		return comercialServicio.encontrarPorAlMenosUnPedidoConDevolucion();
    }
	
	@GetMapping("/bycliente/{idCliente}")
    public ResponseEntity<?> comercialesquehantrabajadoconundeterminadocliente(@PathVariable int idCliente) {
		System.out.println(clienteServicio.encontrarPorIdConDevolucion(idCliente));
		if (clienteServicio.encontrarPorIdConDevolucion(idCliente) == null) {
            String mensaje = "No existe un cliente con id "+idCliente+".";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
		} else if (comercialServicio.encontrarPorIdClienteConDevolucion(idCliente).isEmpty()) {
            String mensaje = "El cliente de id "+idCliente+" existe pero no tiene ningún pedido gestionado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
		} else {
		    return ResponseEntity.ok(comercialServicio.encontrarPorIdClienteConDevolucion(idCliente));
        }
	}
}


