/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import mx.technologeek.blog.data.dto.UserDTO;

/**
 * Servicio de recuperaci&oacute;n del usuario.
 * 
 * @author rsalas - Technologeek Soft
 */
public interface UserSearchService {

    /**
     * Busca al usuario por el email.
     * 
     * @param email Email.
     * @return Usuario.
     */
    UserDTO findByEmail(String email);

}
