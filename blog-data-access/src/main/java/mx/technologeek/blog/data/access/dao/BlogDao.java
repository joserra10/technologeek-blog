/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.technologeek.blog.data.entity.Blog;

/**
 * DAO de la entidad {@link Blog}.
 * 
 * @author rsalas - Technologeek Soft
 */
public interface BlogDao extends PagingAndSortingRepository<Blog, Long> {

    /**
     * Se encarga de buscar las entradas con las coincidencias en el titulo.
     * 
     * @param title Tiulo a buscar.
     * @return listado de entradas en el blog.
     */
    List<Blog> findByTitleContaining(String title);

    /**
     * Busca un blog por su titulo.
     * 
     * @param title Titulo del blog.
     * @return Blog.
     */
    Blog findByTitle(String title);

}
