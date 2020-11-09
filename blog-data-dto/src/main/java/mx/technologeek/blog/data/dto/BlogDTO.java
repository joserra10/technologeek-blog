/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO con la informaci&oacute;n de los BLOGS.
 * 
 * @author LENOVO - Technologeek Soft
 */
public class BlogDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 9079181411783022898L;

    /** Default constructor. */
    public BlogDTO() {
    }

    /**
     * @param id ID de la entrada.
     * @param title Titulo.
     * @param summary Resumen.
     * @param content Contenido.
     * @param image Imagen en BASE64.
     * @param creationDate Fecha de creaci&oacute;n de la entrada.
     * @param creationUser Usuario de creaci&oacute;n.
     * @param modifyDate Fecha de modificaci&oacute;n.
     * @param modifyUser Usuario de modificaci&oacute;n.
     */
    public BlogDTO(final Long id, final String title, final String summary,
            final String content, final String image,
            final LocalDateTime creationDate, final String creationUser,
            final String creationUserName, final LocalDateTime modifyDate,
            final String modifyUser) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.image = image;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.creationUserName = creationUserName;
        this.modifyDate = modifyDate;
        this.modifyUser = modifyUser;
    }

    /** ID del blog. */
    private Long id;
    /** Titulo. */
    private String title;
    /** Resumen. */
    private String summary;
    /** Contenido. */
    private String content;
    /** Imagen en BASE64. */
    private String image;
    /** Fecha de creaci&oacute;n. */
    private LocalDateTime creationDate;
    /** Usuario que creo la entrada. */
    private String creationUser;
    /** Nombre del usuario creador. */
    private String creationUserName;
    /** fecha de modificaci&oacute;n. */
    private LocalDateTime modifyDate;
    /** Usuario que modifico la entrada. */
    private String modifyUser;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(final String summary) {
        this.summary = summary;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(final String image) {
        this.image = image;
    }

    /**
     * @return the creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the creationUser
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * @param creationUser the creationUser to set
     */
    public void setCreationUser(final String creationUser) {
        this.creationUser = creationUser;
    }

    /**
     * @return the creationUserName
     */
    public String getCreationUserName() {
        return creationUserName;
    }

    /**
     * @param creationUserName the creationUserName to set
     */
    public void setCreationUserName(final String creationUserName) {
        this.creationUserName = creationUserName;
    }

    /**
     * @return the modifyDate
     */
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate the modifyDate to set
     */
    public void setModifyDate(final LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return the modifyUser
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * @param modifyUser the modifyUser to set
     */
    public void setModifyUser(final String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getClass().getName());
        builder.append("[id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", summary=");
        builder.append(summary);
        builder.append(", content=");
        builder.append(content);
        builder.append(", image=");
        builder.append(image);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", creationUser=");
        builder.append(creationUser);
        builder.append(", creationUserName=");
        builder.append(creationUserName);
        builder.append(", modifyDate=");
        builder.append(modifyDate);
        builder.append(", modifyUser=");
        builder.append(modifyUser);
        builder.append("]");
        return builder.toString();
    }

}
