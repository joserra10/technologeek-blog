/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.access.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.technologeek.blog.data.access.dao.BlogDao;
import mx.technologeek.blog.data.access.util.ConvertDatesUtil;
import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.data.entity.Blog;
import mx.technologeek.blog.data.entity.User;

/**
 * Implementaci&oacute;n de la interfaz {@link BlogSaveService}.
 * <p>
 * Servicio para el almacenamiento de nuevas entradas al blog.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class BlogSaveServiceImpl implements BlogSaveService {

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BlogSaveServiceImpl.class);

    /** the blog dao. */
    @Autowired
    private BlogDao blogDao;

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.data.access.service.BlogSaveService#saveOrUpdate(mx.
     * technologeek.blog.data.dto.BlogDTO, java.lang.Long).
     */
    @Override
    @Transactional
    public BlogDTO saveOrUpdate(final BlogDTO blog, final Long userId) {
        LOGGER.info("-> save({}, {})", blog, userId);
        final Blog blogCreated = blogDao.save(createEntity(blog, userId));
        LOGGER.info("Blog creado con el ID: {}", blogCreated.getId());
        blog.setId(blogCreated.getId());
        return blog;
    }

    /**
     * Crea el Usuario Entity.
     * 
     * @param blogDTO Blog del request.
     * @param userId ID del usuario.
     * @return Blog.
     */
    private Blog createEntity(final BlogDTO blogDTO, final Long userId) {
        final Blog blogEntity = new Blog();
        BeanUtils.copyProperties(blogDTO, blogEntity);
        LOGGER.info("BeanUtiles copyProperties -> FROM{}, TO{}", blogDTO,
                blogEntity);
        final User user = new User();
        user.setId(userId);
        blogEntity.setUser(user);
        blogEntity.setCreationDate(
                ConvertDatesUtil.convert(blogDTO.getCreationDate()));
        blogEntity.setModifyDate(
                ConvertDatesUtil.convert(blogDTO.getModifyDate()));

        return blogEntity;
    }

}
