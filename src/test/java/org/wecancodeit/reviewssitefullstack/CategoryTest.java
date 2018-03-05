package org.wecancodeit.reviewssitefullstack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CategoryTest {
	Category category = new Category("Name");
	
	@Test
	public void shouldGetId() {
		Long check = category.getId();
		assertNotNull(check);
	}
	
	@Test
	public void shouldGetName() {
		String check = category.getName();
		assertEquals("Name", check);
	}
	
}
