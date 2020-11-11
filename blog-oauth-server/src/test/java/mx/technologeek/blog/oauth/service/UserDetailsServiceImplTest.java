/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.blog.oauth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.blog.oauth.client.UserFeignClient;

/**
 * Unit tests of the class {@link UserDetailsServiceImpl}.
 * 
 * @author rsalas - Technologeek Soft
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { UserDetailsServiceImpl.class })
class UserDetailsServiceImplTest {

    /** the client. */
    @MockBean
    private UserFeignClient client;

    /** the service. */
    @Autowired
    private UserDetailsService service;

    /**
     * Load the user by the email.
     * 
     * @throws UsernameNotFoundException Error into the service.
     */
    @Test
    void loadUserByUsernameTest() throws UsernameNotFoundException {
        Mockito.doReturn(createUser()).when(client)
                .findByEmail(Mockito.anyString());
        final UserDetails user = service
                .loadUserByUsername("jofo109@gmail.com");
        Assertions.assertAll(() -> assertNotNull(user),
                () -> assertEquals("jofo109@gmail.com", user.getUsername()),
                () -> assertEquals("PASSWORD", user.getPassword()));
    }

    /**
     * throws an exception cause the feign client is null.
     * 
     * @throws UsernameNotFoundException Error into the service.
     */
    @Test
    void loadUserByUsernameErrorTest() throws UsernameNotFoundException {
        Mockito.doThrow(new NullPointerException()).when(client)
                .findByEmail(Mockito.anyString());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername("jofo109@gmail.com");
        });
    }

    /**
     * Generates a user to the unit tests.
     * 
     * @return User.
     */
    private UserDTO createUser() {
        final List<String> listRole = Arrays.asList("ADMIN");
        final UserDTO user = new UserDTO();
        user.setEmail("jofo109@gmail.com");
        user.setPassword("PASSWORD");
        user.setEnabled(Boolean.TRUE);
        user.setListRole(listRole);

        return user;
    }

}
