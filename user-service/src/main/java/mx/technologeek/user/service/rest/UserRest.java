/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.user.service.business.UserSearchService;
import mx.technologeek.user.service.exception.ServiceExecutionException;

/**
 * Servicio REST para la busqueda de usuarios.
 * 
 * @author rsalas - Technologeek Soft
 */
@RestController
public class UserRest {

    /** the user search service. */
    @Autowired
    private UserSearchService userSearchService;

    /**
     * Obtiene al usuario por su email.
     * 
     * @param email Email del usuario.
     * @return Usuario encontrado
     * @throws ServiceExecutionException Error en el servicio.
     */
    @GetMapping("{email}")
    public UserDTO findByEmail(@PathVariable("email") final String email)
            throws ServiceExecutionException {
        return userSearchService.findByEmail(email);
    }

}
