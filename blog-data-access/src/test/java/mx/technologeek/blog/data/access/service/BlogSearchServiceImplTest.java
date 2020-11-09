/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.technologeek.blog.data.access.dao.BlogDao;
import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.data.entity.Blog;
import mx.technologeek.blog.data.entity.User;

/**
 * United tests of class {@link BlogSearchServiceImpl}.
 * 
 * @author LENOVO - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogSearchServiceImpl.class)
public class BlogSearchServiceImplTest {

    /** the dao. */
    @MockBean
    private BlogDao dao;

    /** the service test class. */
    @Autowired
    private BlogSearchService service;

    /**
     * Success test.
     * <p>
     * The result is a list that contains one element from the data base.
     */
    @Test
    public void fdinAllByTitleTest() {
        Mockito.doReturn(getListBlogForTest()).when(dao)
                .findByTitleContaining(Mockito.anyString());
        final List<BlogDTO> result = service.findAllByTitle("TEST");
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    /**
     * Success test.
     * <p>
     * The result is a null list from the data base.
     */
    @Test
    public void findAllByTitleNullTest() {
        Mockito.doReturn(null).when(dao)
                .findByTitleContaining(Mockito.anyString());
        final List<BlogDTO> result = service.findAllByTitle("TEST");
        Assert.assertNull(result);
    }

    /**
     * Success test.
     * <p>
     * The result is a empty list from the data base.
     */
    @Test
    public void findAllByTitleEmptyTest() {
        Mockito.doReturn(new ArrayList<>()).when(dao)
                .findByTitleContaining(Mockito.anyString());
        final List<BlogDTO> result = service.findAllByTitle("TEST");
        Assert.assertNull(result);
    }

    /**
     * Success test.
     * <p>
     * It finds a blog title into the database and gets a row.
     */
    @Test
    public void findByTitleTest() {
        final User user = new User();
        user.setName("Ramon");
        user.setLastname("Salas");
        final Blog blog = new Blog();
        blog.setUser(user);

        Mockito.doReturn(blog).when(dao).findByTitle(Mockito.anyString());

        final BlogDTO result = service.findByTitle("TEST");
        Assert.assertNotNull(result);
    }

    /**
     * Success test.
     * <p>
     * The result a null value from the data base.
     */
    @Test
    public void findByTitleNullTest() {
        Mockito.doReturn(null).when(dao).findByTitle(Mockito.anyString());

        final BlogDTO result = service.findByTitle("TEST");
        Assert.assertNull(result);
    }

    /**
     * Success test.
     * <p>
     * It returns a blog list.
     */
    @Test
    public void findAllTest() {
        Mockito.doReturn(getListBlogForTest()).when(dao).findAll();
        final List<BlogDTO> result = service.findAll();
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    /**
     * Success test.
     * <p>
     * It returns a empty list.
     */
    @Test
    public void findAllEmptyTesT() {
        Mockito.doReturn(new ArrayList<>()).when(dao).findAll();
        final List<BlogDTO> result = service.findAll();
        Assert.assertNull(result);
    }

    /**
     * Get the blog list for tests.
     * 
     * @return Blog list.
     */
    private List<Blog> getListBlogForTest() {
        return Arrays.asList(new Blog(
                new User(null, null, "Salas", "Ramon", null, false), "TEST",
                Calendar.getInstance().getTime(), "jofo109@gmail.com",
                "TEST IMAGE", null, null, "TEST", "TEST"));
    }

}
