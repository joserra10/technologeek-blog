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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad de Base de datos ROLE que contiene el nombe de los roles del usuario.
 * 
 * @author rsalas.
 */
@Entity
@Table(name = "role", catalog = "db_technologeek_blog")
public class Role {

	private Integer id;
	private String name;
	private Date creationDate;
	private String creationUser;
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(String name, Date creationDate, String creationUser) {
		this.name = name;
		this.creationDate = creationDate;
		this.creationUser = creationUser;
	}

	public Role(String name, Date creationDate, String creationUser, Set<User> users) {
		this.name = name;
		this.creationDate = creationDate;
		this.creationUser = creationUser;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, length = 26)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "creation_user", nullable = false, length = 50)
	public String getCreationUser() {
		return this.creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "db_technologeek_blog", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getName());
		builder.append("[id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", creationUser=");
		builder.append(creationUser);
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();
	}

}
