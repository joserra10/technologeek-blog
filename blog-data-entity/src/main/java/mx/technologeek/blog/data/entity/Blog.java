/**
 * 
 */
package mx.technologeek.blog.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Data base entity to obtain the information about blog entries.
 * 
 * @author rsalas
 */
@Entity
@Table(name = "blog", catalog = "db_technologeek_blog",
        uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Blog {

    private Long id;
    private User user;
    private String content;
    private Date creationDate;
    private String creationUser;
    private String image;
    private Date modifyDate;
    private String modifyUser;
    private String summary;
    private String title;

    public Blog() {
    }

    public Blog(User user, String content, Date creationDate,
            String creationUser, String image, String summary, String title) {
        this.user = user;
        this.content = content;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.image = image;
        this.summary = summary;
        this.title = title;
    }

    public Blog(User user, String content, Date creationDate,
            String creationUser, String image, Date modifyDate,
            String modifyUser, String summary, String title) {
        this.user = user;
        this.content = content;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.image = image;
        this.modifyDate = modifyDate;
        this.modifyUser = modifyUser;
        this.summary = summary;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "content", nullable = false, length = 16777215)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, length = 26)
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "creation_user", nullable = false)
    public String getCreationUser() {
        return this.creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    @Column(name = "image", nullable = false, length = 16777215)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date", length = 26)
    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(name = "modify_user")
    public String getModifyUser() {
        return this.modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Column(name = "summary", nullable = false, length = 100)
    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "title", unique = true, nullable = false, length = 50)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getClass().getName());
        builder.append("[id=");
        builder.append(id);
        builder.append(", user=");
        builder.append(user);
        builder.append(", content=");
        builder.append(content);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", creationUser=");
        builder.append(creationUser);
        builder.append(", image=");
        builder.append(image);
        builder.append(", modifyDate=");
        builder.append(modifyDate);
        builder.append(", modifyUser=");
        builder.append(modifyUser);
        builder.append(", summary=");
        builder.append(summary);
        builder.append(", title=");
        builder.append(title);
        builder.append("]");
        return builder.toString();
    }

}
