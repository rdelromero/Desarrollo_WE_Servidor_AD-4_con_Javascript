package pedidos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pedidos.modelo.entities.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
