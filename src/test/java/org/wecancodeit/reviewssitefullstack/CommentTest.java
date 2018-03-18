package org.wecancodeit.reviewssitefullstack;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CommentTest {
	Category testCategory = new Category("");
	Tag testTag = new Tag("");
	Review testReview = new Review("", testCategory, "", "", testTag);
	Comment testComment = new Comment("1", testReview);
	Comment testComment2 = new Comment("2", testReview);

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CommentRepository commentRepo;

	@Test
	public void shouldAddTwoCommentsToReview() {
		testCategory = categoryRepo.save(testCategory);
		testReview = reviewRepo.save(testReview);
		testTag = tagRepo.save(testTag);
		testComment = commentRepo.save(testComment);
		testComment2 = commentRepo.save(testComment2);

		entityManager.flush();
		entityManager.clear();

		Collection<Review> testReviews = reviewRepo.findAllByComments(testComment);
		Collection<Review> testReviews2 = reviewRepo.findAllByComments(testComment2);

		assertThat(testReviews, contains(testReview));
		assertThat(testReviews2, contains(testReview));
	}
}
