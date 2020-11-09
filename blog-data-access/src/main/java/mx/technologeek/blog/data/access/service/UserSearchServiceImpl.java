/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.access.dao.UserDao;
import mx.technologeek.blog.data.access.util.ConvertDatesUtil;
import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.blog.data.entity.User;

/**
 * Implementaci&oacute;n de la interfaz {@link UserSearchService}.
 * <p>
 * Servicio para la busqueda del usuario.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class UserSearchServiceImpl implements UserSearchService {

    /** the user dao. */
    @Autowired
    private UserDao dao;

    /*
     * 
     */
    @Override
    public UserDTO findByEmail(final String email) {
        final User user = dao.findByEmail(email);
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTO.setCreationDate(
                    ConvertDatesUtil.convert(user.getCreationDate()));
            userDTO.setListRole(user.getRoles().stream()
                    .map(role -> role.getName()).collect(Collectors.toList()));
        }
        return userDTO;
    }

}
