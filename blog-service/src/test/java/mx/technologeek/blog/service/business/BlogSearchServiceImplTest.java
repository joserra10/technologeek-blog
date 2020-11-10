/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
import mx.technologeek.blog.service.exception.BlogNoContentException;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Unit tests of the class {@link BlogSearchServiceImpl}.
 * 
 * @author rsalas - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogSearchServiceImpl.class)
public class BlogSearchServiceImplTest {

    /** the client. */
    @MockBean
    private BlogDataClient client;
    /** the service. */
    @Autowired
    private BlogSearchService service;

    /**
     * Execute the implementation that consume a rest method to receive a list
     * of blog entries.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    public void findByLikeTitle() throws ServiceExecutionException {
        Mockito.doReturn(createBlogList()).when(client)
                .findByLikeTitle(Mockito.anyString());
        final List<BlogDTO> result = service.findByLikeTitle("TITLE");
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    /**
     * throw an error when the blog list is null.
     * 
     * @throws ServiceExecutionException Error when the blog list is null.
     */
    @Test(expected = BlogNoContentException.class)
    public void findByLikeTitleNullTest() throws ServiceExecutionException {
        Mockito.doReturn(null).when(client)
                .findByLikeTitle(Mockito.anyString());
        service.findByLikeTitle("TITLE");
    }

    /**
     * Execute a method that find a entry according its title.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    public void findByTitleTest() throws ServiceExecutionException {
        Mockito.doReturn(new BlogDTO()).when(client)
                .findByTitle(Mockito.anyString());
        final BlogDTO result = service.findByTitle("TITLE");
        Assert.assertNotNull(result);
    }

    /**
     * Throw an exception when the blog was not found with the title.
     * 
     * @throws ServiceExecutionException Error when the blog is null.
     */
    @Test(expected = BlogNoContentException.class)
    public void findByTitleNullTest() throws ServiceExecutionException {
        Mockito.doReturn(null).when(client).findByTitle(Mockito.anyString());
        service.findByTitle("TITLE");
    }

    /**
     * Test that find all blogs saved into the data base.
     * 
     * @throws ServiceExecutionException Error into the service.
     */
    @Test
    public void findAllTest() throws ServiceExecutionException {
        Mockito.doReturn(createBlogList()).when(client).findAll();
        Assert.assertNotNull(service.findAll());
    }

    /**
     * Throw an error when does not exist any blog.
     * 
     * @throws ServiceExecutionException Error when the list blog is null.
     */
    @Test(expected = BlogNoContentException.class)
    public void findAllNullTest() throws ServiceExecutionException {
        Mockito.doReturn(null).when(client).findAll();
        service.findAll();
    }

    /**
     * It create a blog list.
     * 
     * @return Blog list.
     */
    private List<BlogDTO> createBlogList() {
        return Arrays.asList(new BlogDTO(1L, "TITLE", "SUMMARY", "CONTENT",
                "BASE64:IMAGE", LocalDateTime.now(), "jofo109@gmail.com",
                "Jose Ramon Salas", LocalDateTime.now(), "jofo109@gmail.com"));
    }

}
