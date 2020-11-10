/**
 * 
 */
package mx.technologeek.blog.service.business;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Servicio para la creaci&oacuute;n de un blog.
 * 
 * @author rsalas
 */
public interface BlogCreateService {

	/**
	 * Creaci&oacute;n de una nueva entrada.
	 * 
	 * @param blog   Blog.
	 * @param userId ID del usuario creador.
	 * @return Blog creado.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	BlogDTO create(BlogDTO blog, Long userId) throws ServiceExecutionException;

}
