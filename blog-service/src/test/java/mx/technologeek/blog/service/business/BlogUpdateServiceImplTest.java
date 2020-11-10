/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.client.BlogDataClient;
import mx.technologeek.blog.service.exception.BlogUpdateInternalError;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Unit tests of the {@link BlogUpdateServiceImpl}.
 * 
 * @author rsalas - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogUpdateServiceImpl.class)
public class BlogUpdateServiceImplTest {

    /** the client. */
    @MockBean
    private BlogDataClient client;

    /** the service. */
    @Autowired
    private BlogUpdateService service;

    /**
     * Test that update a blog.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    public void updateTest() throws ServiceExecutionException {
        Mockito.doReturn(new BlogDTO()).when(client).update(Mockito.anyLong(),
                Mockito.any());
        assertNotNull(service.update(new BlogDTO(1L, "TITLE", "SUMMARY",
                "CONTENT", "IMAGE", LocalDateTime.now(), "jofo109@gmail.com",
                "Ramon Salas", LocalDateTime.now(), "jofo109@gmail."), 1L));
    }

    /**
     * Error in the Blog ID.
     * 
     * @throws ServiceExecutionException Error when the blog id is null.
     */
    @Test(expected = BlogUpdateInternalError.class)
    public void updateIdNullTest() throws ServiceExecutionException {
        service.update(new BlogDTO(), 1L);
    }

}
