package org.wecancodeit.reviewssitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String content;
	
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
	
	@SuppressWarnings("unused")
	private Review() {
	}
	
	public Review(String title, Category category, String content) {
		this.title = title;
		this.category = category;
		this.content = content;
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
