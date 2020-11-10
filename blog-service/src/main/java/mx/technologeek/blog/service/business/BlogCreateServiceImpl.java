/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.client.BlogDataClient;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Implementaci&oacute;n de la interfaz {@link BlogCreateService}.
 * <p>
 * Servicio para la creaci&oacute;n de un Blog.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class BlogCreateServiceImpl implements BlogCreateService {

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BlogCreateServiceImpl.class);

    /** the blog data client. */
    @Autowired
    private BlogDataClient blogDataClient;

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.business.BlogCreateService#create(mx.
     * technologeek.blog.data.dto.BlogDTO, java.lang.Long).
     */
    @Override
    public BlogDTO create(final BlogDTO blog, final Long userId)
            throws ServiceExecutionException {
        LOGGER.info("-> create ({}, {})", blog, userId);
        blog.setCreationDate(LocalDateTime.now());
        final BlogDTO blogCreated = blogDataClient.create(userId, blog);
        return blogCreated;
    }

}
