/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.technologeek.blog.data.access.dao.BlogDao;
import mx.technologeek.blog.data.access.util.ConvertDatesUtil;
import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.data.entity.Blog;

/**
 * Implementaci&oacute;n de la interfaz {@link BlogSearchService}.
 * <p>
 * Servicio para las busquedas de blogs.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class BlogSearchServiceImpl implements BlogSearchService {

    /** the blog dao. */
    @Autowired
    private BlogDao dao;

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.data.access.service.BlogSearchService#findAllByTitle
     * (java.lang.String).
     */
    @Override
    @Transactional(readOnly = true)
    public List<BlogDTO> findAllByTitle(final String title) {
        final List<Blog> listBlog = dao.findByTitleContaining(title);
        List<BlogDTO> listBlogDTO = null;
        if (listBlog != null && !listBlog.isEmpty()) {
            listBlogDTO = listBlog.stream().map(this::createBlogDTO)
                    .collect(Collectors.toList());
        }
        return listBlogDTO;
    }

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.data.access.service.BlogSearchService#findByTitle(
     * java.lang.String).
     */
    @Override
    @Transactional(readOnly = true)
    public BlogDTO findByTitle(final String title) {
        final Blog blog = dao.findByTitle(title);
        BlogDTO blogDTO = null;
        if (blog != null) {
            blogDTO = new BlogDTO();
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTO.setCreationUserName(blog.getUser().getName() + " "
                    + blog.getUser().getLastname());
        }
        return blogDTO;
    }

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.data.access.service.BlogSearchService#findAll().
     */
    @Override
    @Transactional(readOnly = true)
    public List<BlogDTO> findAll() {
        final Iterable<Blog> iterableBlog = dao.findAll();
        List<BlogDTO> listBlogDTO = null;
        if (iterableBlog.iterator().hasNext()) {
            listBlogDTO = StreamSupport
                    .stream(iterableBlog.spliterator(), false)
                    .map(this::createBlogDTO).collect(Collectors.toList());
        }
        return listBlogDTO;
    }

    /**
     * It generates a DTO about the blog from data base.
     * 
     * @param blog the blog.
     * @return BLOG DTO.
     */
    private BlogDTO createBlogDTO(final Blog blog) {
        return new BlogDTO(blog.getId(), blog.getTitle(), blog.getSummary(),
                blog.getContent(), blog.getImage(),
                ConvertDatesUtil.convert(blog.getCreationDate()),
                blog.getCreationUser(),
                blog.getUser().getName() + " " + blog.getUser().getLastname(),
                ConvertDatesUtil.convert(blog.getModifyDate()),
                blog.getModifyUser());
    }

}
