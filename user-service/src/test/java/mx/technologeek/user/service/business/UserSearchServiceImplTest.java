/**
 * Technologeek Soft 10 nov 2020
 */
package mx.technologeek.user.service.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.technologeek.blog.data.dto.UserDTO;
import mx.technologeek.user.service.client.UserDataClient;
import mx.technologeek.user.service.exception.ServiceExecutionException;
import mx.technologeek.user.service.exception.UserNotFoundException;

/**
 * Unit tests of the class {@link UserSearchServiceImpl.
 * 
 * @author rsalas - Technologeek Soft
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { UserSearchServiceImpl.class })
class UserSearchServiceImplTest {

    /** the client. */
    @MockBean
    private UserDataClient client;
    /** the service. */
    @Autowired
    private UserSearchService service;

    /**
     * Test that find a user from his password.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    void findByEmailTest() throws ServiceExecutionException {
        Mockito.doReturn(new UserDTO()).when(client)
                .findByEmail(Mockito.anyString());
        Assertions.assertNotNull(service.findByEmail("jofo109@gmail.com"));
    }

    /**
     * Throw an exception beacause the use email was not found.
     * 
     * @throws ServiceExecutionException Error.
     */
    @Test
    void findByEmailNullTest() throws ServiceExecutionException {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            Mockito.doReturn(null).when(client)
                    .findByEmail(Mockito.anyString());
            service.findByEmail("jofo109@gmail.com");
        });

    }

}
