/**
 * 
 */
package mx.technologeek.blog.service.business;

import java.util.List;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Servicio para la obtenci&oacute;n de BLOGS.
 * 
 * @author rsalas
 */
public interface BlogSearchService {

	/**
	 * Obtiene el listado de blogs que coincidan con un titulo.
	 * 
	 * @param title Titulo.
	 * @return Listado de blogs.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	List<BlogDTO> findByLikeTitle(String title) throws ServiceExecutionException;

	/**
	 * Obtiene el blog que coincida con el titulo.
	 * 
	 * @param title Titulo.
	 * @return Blog.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	BlogDTO findByTitle(String title) throws ServiceExecutionException;

	/**
	 * Obtiene el listado de los blogs existentes.
	 * 
	 * @return Listado de blogs.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	List<BlogDTO> findAll() throws ServiceExecutionException;

}
