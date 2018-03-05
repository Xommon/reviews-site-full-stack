package org.wecancodeit.reviewssitefullstack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ReviewTest {
	Review review = new Review("Title", new Category("Category"), "Content", "Image URL");

	@Test
	public void shouldGetCategory() {
		Category check = review.getCategory();
		assertEquals(new Category("Category"), check);
	}

	@Test
	public void shouldGetId() {
		Long check = review.getId();
		assertNotNull(check);
	}

	@Test
	public void shouldGetTitle() {
		String check = review.getTitle();
		assertEquals("Title",check);
	}
	
	@Test
	public void shouldGetContent() {
		String check = review.getContent();
		assertEquals("Content",check);
	}
}
