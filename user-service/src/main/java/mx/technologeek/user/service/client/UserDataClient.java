/**
 * 
 */
package mx.technologeek.user.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.technologeek.blog.data.dto.UserDTO;

/**
 * Cliente del servicio de Usuario.
 * 
 * @author rsalas
 */
@FeignClient(name = "blog-data-access")
public interface UserDataClient {

	/**
	 * Obtiene el usuario con su email.
	 * 
	 * @param email Email del usuario a buscar.
	 * @return Usuario encontrado.
	 */
	@GetMapping("user/{email}")
	UserDTO findByEmail(@PathVariable("email") String email);

}
