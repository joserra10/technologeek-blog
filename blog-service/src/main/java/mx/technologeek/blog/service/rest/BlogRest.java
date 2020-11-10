/**
 * 
 */
package mx.technologeek.blog.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.business.BlogCreateService;
import mx.technologeek.blog.service.business.BlogSearchService;
import mx.technologeek.blog.service.business.BlogUpdateService;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Servicio REST de las busquedas del blog.
 * 
 * @author rsalas
 */
@RestController
public class BlogRest {

	/** the search service. */
	@Autowired
	private BlogSearchService searchService;
	/** the update service. */
	@Autowired
	private BlogUpdateService updateService;
	/** the create service. */
	@Autowired
	private BlogCreateService createService;

	/**
	 * Busquedo de blogs por titulo.
	 * 
	 * @param title Titulo.
	 * @return Listado de blogs
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	@GetMapping("findByTitleLike/{title}")
	public List<BlogDTO> findByTitleLike(@PathVariable("title") final String title) throws ServiceExecutionException {
		return searchService.findByLikeTitle(title);
	}

	/**
	 * Busqueda de un blog por titulo.
	 * 
	 * @param title Titulo del blog.
	 * @return Blog
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	@GetMapping("findByTitle/{title}")
	public BlogDTO findByTitle(@PathVariable("title") final String title) throws ServiceExecutionException {
		return searchService.findByTitle(title);
	}

	/**
	 * Obtiene el listado completo de los blogs existentes.
	 * 
	 * @return Listado de los blogs.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	@GetMapping("findAll")
	public List<BlogDTO> findAll() throws ServiceExecutionException {
		return searchService.findAll();
	}

	/**
	 * Actualiza un blog.
	 * 
	 * @param blog  Blog actualizado.
	 * @param id    ID del usuario que actualiza el blog.
	 * @param email Email del usuario que actualiza el blog.
	 * @return Blog actualizado.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	@PutMapping("{userId}")
	public BlogDTO update(@RequestBody final BlogDTO blog, @PathVariable("userId") final Long id)
			throws ServiceExecutionException {
		return updateService.update(blog, id);
	}

	/**
	 * Crea un blog.
	 * 
	 * @param blog   Blog creado.
	 * @param userId ID del usuario
	 * @param email  Correo dle usuario.
	 * @return Blog creado.
	 * @throws ServiceExecutionException Error en el servicio.
	 */
	@PostMapping("{userId}")
	public BlogDTO create(@RequestBody final BlogDTO blog, @PathVariable("userId") final Long userId)
			throws ServiceExecutionException {
		return createService.create(blog, userId);
	}

}
