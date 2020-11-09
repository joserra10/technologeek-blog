/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import mx.technologeek.blog.data.dto.BlogDTO;

/**
 * Servicio para persistir el Blog en base de datos.
 * 
 * @author rsalas - Technologeek Soft
 */
public interface BlogSaveService {

    /**
     * Persiste el blog en base de datos.
     * 
     * @param blog Blog a guardar.
     * @param userId ID del usuario.
     * @return Blog almacenado.
     */
    BlogDTO saveOrUpdate(BlogDTO blog, Long userId);

}
