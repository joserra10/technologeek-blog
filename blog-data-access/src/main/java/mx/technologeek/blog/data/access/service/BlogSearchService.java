/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.util.List;

import mx.technologeek.blog.data.dto.BlogDTO;

/**
 * Servicio para las consultas del BLOG.
 * 
 * @author rsalas - Technologeek Soft
 */
public interface BlogSearchService {

    /**
     * Encuentra los blogs con las coincidencias en el titulo.
     * 
     * @param title Titutlo.
     * @return Listado de Blogs encontrados.
     */
    List<BlogDTO> findAllByTitle(String title);

    /**
     * Encuentra un blog por el titutlo exacto.
     * 
     * @param title Titulo.
     * @return Blog encontrado.
     */
    BlogDTO findByTitle(String title);

    /**
     * Encuentra todos los BLOGS.
     * 
     * @return BLOGS.
     */
    List<BlogDTO> findAll();

}
