/**
 * Technologeek Soft 7 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.time.LocalDateTime;

import org.junit.Before;
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

/**
 * Prueba unitaria de la clase {@link BlogSaveService}.
 * 
 * @author LENOVO - Technologeek Soft
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BlogSaveServiceImpl.class)
public class BlogSaveServiceImplTest {

    /** the blog dao. */
    @MockBean
    private BlogDao blogDao;
    /** the service test class. */
    @Autowired
    private BlogSaveService service;

    /**
     * Configuraci&oacute;n de la clase unitaria.
     */
    @Before
    public void setUp() {
        Mockito.doReturn(createMockBlog()).when(blogDao).save(Mockito.any());
    }

    /**
     * Crea el Entity del BLOG.
     * 
     * @return Entity.
     */
    private Blog createMockBlog() {
        final Blog blog = new Blog();
        blog.setId(1L);
        return blog;
    }

    /**
     * Crea un DTO del blog.
     * 
     * @return DTO.
     */
    private BlogDTO createBlogDTO() {
        final BlogDTO blog = new BlogDTO();
        blog.setCreationDate(LocalDateTime.now());
        blog.setModifyDate(LocalDateTime.now());

        return blog;
    }

    /**
     * Purbea untiaria del guardado de un BLOG.
     */
    @Test
    public void test() {
        service.saveOrUpdate(createBlogDTO(), 1L);
    }

}
