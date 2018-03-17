package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String description;

	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	public Collection<Review> getReviews() {
		return reviews;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Tag(String description) {
		this.description = description;
	}

	@SuppressWarnings("unused")
	private Tag() {

	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Tag) obj).id;
	}
}
