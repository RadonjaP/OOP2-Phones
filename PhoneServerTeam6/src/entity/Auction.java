package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;
import entity.User;


/**
 * The persistent class for the AUCTION database table.
 * 
 */
@Entity
@NamedQuery(name="Auction.findAll", query="SELECT a FROM Auction a")
public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean active;

	@Column(name="OFFERED_PRICE")
	private int offeredPrice;

	//bi-directional many-to-one association to Phone
	@ManyToOne
	@JoinColumn(name="ID_PHONE")
	private Phone phone;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ID_OWNER")
	private User owner;

    @ManyToMany
    @JoinTable(name="USER_AUCTION",
        joinColumns=
            @JoinColumn(name="AUCTION_ID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="USER_ID", referencedColumnName="ID")
        )
	private List<User> bidders;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="auction")
	private List<Comment> comments;

	public Auction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getOfferedPrice() {
		return this.offeredPrice;
	}

	public void setOfferedPrice(int offeredPrice) {
		this.offeredPrice = offeredPrice;
	}

	public Phone getPhone() {
		return this.phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}


	public List<User> getBidders() {
		return bidders;
	}

	public void setBidders(List<User> bidders) {
		this.bidders = bidders;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAuction(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAuction(null);

		return comment;
	}
	
	public void printBidders() {
		System.out.println("Bidders auction:                          xxxx");
		for (User u : bidders) {
			System.out.println(u.getName());
		}
	}

}