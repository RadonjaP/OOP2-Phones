package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the USER database table.
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.getUserByUsername", query="SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = "User.getLoggedUser", query = "SELECT u FROM User u WHERE u.username =:username AND u.password=:password") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String email;

	@Column(name="LAST_NAME")
	private String lastName;

	private String name;

	private String password;

	@Column(name="PICTURE_ADDRESS")
	private String pictureAddress;

	private String username;
	
	@ManyToMany(mappedBy="bidders", fetch=FetchType.EAGER)
	private List<Auction> bidAuctions;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
	private List<Auction> ownAuctions;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPictureAddress() {
		return this.pictureAddress;
	}

	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public List<Auction> getBidAuctions() {
		return bidAuctions;
	}

	public void setBidAuctions(List<Auction> bidAuctions) {
		this.bidAuctions = bidAuctions;
	}

	public List<Auction> getOwnAuctions() {
		return ownAuctions;
	}

	public void setOwnAuctions(List<Auction> ownAuctions) {
		this.ownAuctions = ownAuctions;
	}

}