/**
 * 
 */
package mx.technologeek.blog.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.technologeek.blog.data.dto.UserDTO;

/**
 * Cliente para obtener los usuarios.
 * 
 * @author rsalas
 */
@FeignClient(name = "user-service")
public interface UserFeignClient {

    /**
     * Obtiene al usuario por el email.
     * 
     * @param email Email del usuario.
     * @return Usuario.
     */
    @GetMapping("{email}")
    UserDTO findByEmail(@PathVariable("email") String email);
}
