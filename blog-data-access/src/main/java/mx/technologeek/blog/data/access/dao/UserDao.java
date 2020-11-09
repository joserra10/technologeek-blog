/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.technologeek.blog.data.entity.User;

/**
 * DAO del usuario.
 * 
 * @author rsalas - Technologeek Soft
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    /**
     * Recupera al usuario de base de datos de acuerdo al email.
     * 
     * @param email Email del usuario.
     * @return Usuario.
     */
    User findByEmail(String email);

}
