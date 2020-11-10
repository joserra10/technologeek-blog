/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.client.BlogDataClient;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Unit tests from the class {@link BlogCreateServiceImpl}.
 * 
 * @author rsalas - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogCreateServiceImpl.class)
public class BlogCreateServiceImplTest {

    /** the blog data client. */
    @MockBean
    private BlogDataClient client;

    /** the service. */
    @Autowired
    private BlogCreateService service;

    /**
     * Unit test to create a new blog.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    public void test() throws ServiceExecutionException {
        Mockito.doReturn(new BlogDTO()).when(client).create(Mockito.anyLong(),
                Mockito.any());
        final BlogDTO result = service.create(new BlogDTO(), 1L);
        Assert.assertNotNull(result);
    }

}
