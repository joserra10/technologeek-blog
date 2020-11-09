/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.technologeek.blog.data.access.service.UserSearchService;
import mx.technologeek.blog.data.dto.UserDTO;

/**
 * Servicio REST del objeto USUARIO.
 * 
 * @author rsalas - Technologeek Soft
 */
@RestController
@RequestMapping("/user")
public class UserRest {

    /** the user search service. */
    @Autowired
    private UserSearchService userSearchService;

    /**
     * Obtien al usuario que coincida con email.
     * 
     * @param email Correo electronico.
     * @return Usuario.
     */
    @GetMapping("{email}")
    public UserDTO findByEmail(@PathVariable("email") final String email) {
        return userSearchService.findByEmail(email);
    }

}
