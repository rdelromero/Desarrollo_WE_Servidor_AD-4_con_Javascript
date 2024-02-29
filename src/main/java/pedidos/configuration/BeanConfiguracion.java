package pedidos.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracion {
	
	@Bean
	public ModelMapper modeloMapper() {
		return new ModelMapper();
	}
}