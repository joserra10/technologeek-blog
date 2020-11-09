/**
 * Technologeek Soft 9 nov 2020
 */
package mx.technologeek.blog.data.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO con la informaci&oacute;n del USUARIO.
 * 
 * @author LENOVO - Technologeek Soft
 */
public class UserDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1865376430096472199L;

    /** the id. */
    private Long id;
    /** the creation date. */
    private LocalDateTime creationDate;
    /** the email. */
    private String email;
    /** the last name. */
    private String lastname;
    /** the name. */
    private String name;
    /** the password. */
    private String password;
    /** the list role. */
    private List<String> listRole;
    /** the enabled value. */
    private boolean enabled;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the listRole
     */
    public List<String> getListRole() {
        return listRole;
    }

    /**
     * @param listRole the listRole to set
     */
    public void setListRole(final List<String> listRole) {
        this.listRole = listRole;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getClass().getName());
        builder.append("[id=");
        builder.append(id);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", email=");
        builder.append(email);
        builder.append(", lastname=");
        builder.append(lastname);
        builder.append(", name=");
        builder.append(name);
        builder.append(", password=");
        builder.append(password);
        builder.append(", listRole=");
        builder.append(listRole);
        builder.append(", enabled=");
        builder.append(enabled);
        builder.append("]");
        return builder.toString();
    }

}
