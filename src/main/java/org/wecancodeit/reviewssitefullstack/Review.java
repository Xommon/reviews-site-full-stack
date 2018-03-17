package org.wecancodeit.reviewssitefullstack;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import static java.util.Arrays.asList;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String content;
	private String imageUrl;

	@ManyToMany
	Collection<Tag> tags;

	@ManyToOne
	private Category category;

	public Category getCategory() {
		return category;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String title, Category category, String content, String imageUrl, Tag... tags) {
		this.title = title;
		this.category = category;
		this.content = content;
		this.imageUrl = imageUrl;
		this.tags = new HashSet<>(asList(tags));
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
		return id == ((Review) obj).id;
	}
}
