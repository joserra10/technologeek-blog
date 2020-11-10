/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.client.BlogDataClient;
import mx.technologeek.blog.service.exception.BlogUpdateBadRequestException;
import mx.technologeek.blog.service.exception.BlogUpdateInternalError;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Implementaci&oacute;n de la interfaz {@link BlogUpdateService}.
 * <p>
 * Servicio para la actualizaci&oacute;n de un BLOG.
 * 
 * @author rsalas
 */
@Service
public class BlogUpdateServiceImpl implements BlogUpdateService {

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BlogUpdateServiceImpl.class);

    /** the blog data client. */
    @Autowired
    private BlogDataClient blogDataClient;

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.business.BlogUpdateService#update(mx.
     * technologeek.blog.data.dto.BlogDTO, java.lang.Long).
     */
    @Override
    public BlogDTO update(final BlogDTO blog, final Long userId)
            throws ServiceExecutionException {
        try {
            if (blog.getId() == null) {
                LOGGER.error(
                        "No se encontro el ID del BLOG, por tal razon no se puede actualizar");
                throw new BlogUpdateBadRequestException(
                        "La informacion del BLOG es incompleta.");
            }
            return blogDataClient.update(userId, blog);
        } catch (Exception e) {
            LOGGER.error("Se genero un error en la actualizacion del blog", e);
            throw new BlogUpdateInternalError("No se logro actualizar el blog",
                    e);
        }
    }

}
