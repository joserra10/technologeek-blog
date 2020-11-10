/**
 * 
 */
package mx.technologeek.blog.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mx.technologeek.blog.data.dto.BlogDTO;

/**
 * Feign client to consumes blogs from a REST service.
 * 
 * @author rsalas
 */
@FeignClient(name = "blog-data-access")
public interface BlogDataClient {

	/**
	 * Obtiene el listado de blogs a partir de una busqueda por titulo.
	 * 
	 * @param title Titulo de la entrada.
	 * @return Listado de blogs.
	 */
	@GetMapping("/blog/findAllByTitle/{title}")
	List<BlogDTO> findByLikeTitle(@PathVariable("title") String title);

	/**
	 * Obtiene el blog que esta relacionado al titulo.
	 * 
	 * @param title Titulo.
	 * @return Blog.
	 */
	@GetMapping("/blog/findByTitle/{title}")
	BlogDTO findByTitle(@PathVariable("title") String title);

	/**
	 * Obtiene el listado de los blogs existentes.
	 * 
	 * @return BLOGS.
	 */
	@GetMapping("/blog/findAll")
	List<BlogDTO> findAll();

	/**
	 * Crea una nueava entrada.
	 * 
	 * @param blog Blog.
	 */
	@PostMapping("/blog/{userId}")
	BlogDTO create(@PathVariable("userId") Long userId, @RequestBody BlogDTO blog);

	/**
	 * Actualiza una entrada.
	 * 
	 * @param blog Blog.
	 */
	@PutMapping("/blog/{userId}")
	BlogDTO update(@PathVariable("userId") Long usserId, @RequestBody BlogDTO blog);

}
