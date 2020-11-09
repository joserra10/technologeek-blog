/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.technologeek.blog.data.access.service.BlogSaveService;
import mx.technologeek.blog.data.access.service.BlogSearchService;
import mx.technologeek.blog.data.dto.BlogDTO;

/**
 * REST del objeto BLOG.
 * 
 * @author rsalas - Technologeek Soft
 */
@RestController
@RequestMapping("/blog")
public class BlogRest {

    /** the blog save service. */
    @Autowired
    private BlogSaveService blogSaveService;
    /** the blog search service. */
    @Autowired
    private BlogSearchService blogSearchService;

    /**
     * Servicio REST para guardar una nueva entrada en el blog.
     * 
     * @param userId ID del usuario.
     * @param blog BLOG.
     * @return BLOG creado.
     */
    @PostMapping("{userId}")
    public BlogDTO save(@PathVariable("userId") final Long userId,
            @RequestBody final BlogDTO blog) {
        return blogSaveService.saveOrUpdate(blog, userId);
    }

    /**
     * Servicio REST para actualizar una nueva entrada en el blog.
     * 
     * @param userId ID del usuario.
     * @param blog Blog a actualizar.
     * @return Blog.
     */
    @PutMapping("{userId}")
    public BlogDTO update(@PathVariable("userId") final Long userId,
            @RequestBody final BlogDTO blog) {
        return blogSaveService.saveOrUpdate(blog, userId);
    }

    /**
     * Servicio REST para obtener un blog que coincida con el titulo.
     * 
     * @param title Titulo.
     * @return Blog.
     */
    @GetMapping("findByTitle/{title}")
    public BlogDTO findByTitle(@PathVariable("title") final String title) {
        return blogSearchService.findByTitle(title);
    }

    /**
     * Servicio REST para obtener un listado de BLOGS que coincidan con el
     * titulo.
     * 
     * @param title Titulo.
     * @return Listado de blogs.
     */
    @GetMapping("findAllByTitle/{title}")
    public List<BlogDTO> findAllByTitle(
            @PathVariable("title") final String title) {
        return blogSearchService.findAllByTitle(title);
    }

    /**
     * Servicio REST para obtener todo el listado de blogs existentes.
     * 
     * @return Listado de blogs.
     */
    @GetMapping("findAll")
    public List<BlogDTO> findAll() {
        return blogSearchService.findAll();
    }

}
