/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.technologeek.blog.data.access.dao.UserDao;
import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.blog.data.entity.Role;
import mx.technologeek.blog.data.entity.User;

/**
 * Unit Tests from the class {@link UserSearchServiceImpl}.
 * 
 * @author rsalas - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserSearchServiceImpl.class)
public class UserSearchServiceImplTest {

    /** the email test. */
    private static final String EMAIL = "jofo109@test.com";

    /** the user dao. */
    @MockBean
    private UserDao userDao;
    /** the service test class. */
    @Autowired
    private UserSearchService service;

    /**
     * It finds a user according to a user email.
     */
    @Test
    public void findByEmailTest() {
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role("ADMIN", null, null));
        final User user = new User();
        user.setRoles(roles);
        Mockito.doReturn(user).when(userDao).findByEmail(EMAIL);

        final UserDTO result = service.findByEmail(EMAIL);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getListRole());
        Assert.assertFalse(result.getListRole().isEmpty());
    }

    /**
     * Success test.
     * <p>
     * It did not find a user. the user is null.
     */
    @Test
    public void findByEmailNullTest() {
        Mockito.doReturn(null).when(userDao).findByEmail(EMAIL);
        final UserDTO result = service.findByEmail(EMAIL);
        Assert.assertNull(result);
    }

}
