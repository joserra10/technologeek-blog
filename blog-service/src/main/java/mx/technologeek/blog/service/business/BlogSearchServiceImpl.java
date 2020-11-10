/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.technologeek.blog.data.dto.BlogDTO;
import mx.technologeek.blog.service.client.BlogDataClient;
import mx.technologeek.blog.service.exception.BlogNoContentException;
import mx.technologeek.blog.service.exception.ServiceExecutionException;

/**
 * Clase que implementa el servicio {@link BlogSearchService}.
 * 
 * @author rsalas - Technologeek Soft
 */
@Service
public class BlogSearchServiceImpl implements BlogSearchService {

    /** the blog data client. */
    @Autowired
    private BlogDataClient blogDataClient;

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.service.business.BlogSearchService#findByLikeTitle(
     * java.lang.String).
     */
    @Override
    public List<BlogDTO> findByLikeTitle(final String title)
            throws ServiceExecutionException {
        return validateData(blogDataClient.findByLikeTitle(title),
                "No se encontro informacion con el titulo " + title);
    }

    /*
     * (non-Javadoc)
     * @see
     * mx.technologeek.blog.service.business.BlogSearchService#findByTitle(java.
     * lang.String).
     */
    @Override
    public BlogDTO findByTitle(final String title)
            throws ServiceExecutionException {
        return validateData(blogDataClient.findByTitle(title),
                "No existe el blog con el titulo " + title);
    }

    /*
     * (non-Javadoc)
     * @see mx.technologeek.blog.service.business.BlogSearchService#findAll().
     */
    @Override
    public List<BlogDTO> findAll() throws ServiceExecutionException {
        return validateData(blogDataClient.findAll(),
                "No existe ningun blog aun");
    }

    /**
     * Method that validates the data received by the rest consume.
     * 
     * @param <E> Data type to validate.
     * @param data Data
     * @param errorMessage Message error throws when the data is null.
     * @return Data validated
     * @throws ServiceExecutionException Error when the data is null.
     */
    private <E> E validateData(final E data, final String errorMessage)
            throws ServiceExecutionException {
        if (data == null) {
            throw new BlogNoContentException(errorMessage);
        }

        return data;
    }

}
