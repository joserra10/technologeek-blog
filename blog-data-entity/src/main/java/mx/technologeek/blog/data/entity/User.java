/**
 * 
 */
package mx.technologeek.blog.data.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Entidad de base de datos USER.
 * 
 * @author rsalas
 */
@Entity
@Table(name = "user", catalog = "db_technologeek_blog", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	private Long id;
	private Date creationDate;
	private String email;
	private String lastname;
	private String name;
	private String password;
	private Set<Blog> blogs = new HashSet<Blog>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	private boolean enabled;

	public User() {
	}

	public User(Date creationDate, String email, String lastname, String name, String password, boolean enabled) {
		this.creationDate = creationDate;
		this.email = email;
		this.lastname = lastname;
		this.name = name;
		this.password = password;
		this.password = password;
	}

	public User(Date creationDate, String email, String lastname, String name, String password, Set<Blog> blogs,
			Set<Role> roles, boolean enabled) {
		this.creationDate = creationDate;
		this.email = email;
		this.lastname = lastname;
		this.name = name;
		this.password = password;
		this.blogs = blogs;
		this.roles = roles;
		this.enabled = enabled;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 26)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "email", unique = true, nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "lastname", nullable = false, length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "db_technologeek_blog", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the enabled
	 */
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
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
		builder.append(", blogs=");
		builder.append(blogs);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}

}
