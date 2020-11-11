/**
 * 
 */
package mx.technologeek.user.service.business;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.user.service.exception.ServiceExecutionException;

/**
 * Servicio para generar consultas para obtener a usuario.
 * 
 * @author rsalas
 */
public interface UserSearchService {

	/**
	 * Encuentra a un usuario de acuerdo a su email.
	 * 
	 * @param email Email del usuario.
	 * @return Usuario.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	UserDTO findByEmail(String email) throws ServiceExecutionException;

}
