/**
 * 
 */
package mx.technologeek.blog.service.business;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Se encarga de actualizar un blog.
 * 
 * @author rsalas
 */
public interface BlogUpdateService {

	/**
	 * Actualizaci&oacute;n de un blog.
	 * 
	 * @param blog   Blog a actualizar.
	 * @param userId ID del usuario.
	 * @return Blog actualizado.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	BlogDTO update(BlogDTO blog, Long userId) throws ServiceExecutionException;

}
