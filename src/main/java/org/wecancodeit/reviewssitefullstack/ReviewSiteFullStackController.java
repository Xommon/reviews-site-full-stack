package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteFullStackController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	CommentRepository commentRepo;

	@RequestMapping(value = "/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping(value = "/category")
	public String getReviewListofCategories(@RequestParam Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category";
	}

	@RequestMapping(value = "/reviews")
	public String getAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping(value = "/review")
	public String getCategoryListofReviews(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("tagModel", tagRepo.findAllByReviews(reviewRepo.findOne(id)));
		return "review";
	}

	@RequestMapping(value = "/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "tagsView";
	}

	@RequestMapping(value = "/add-tag")
	public String addATag(String stringId, String description) {
		Long id = Long.parseLong(stringId);
		Review review = reviewRepo.findOne(id);
		Tag tag = new Tag(description, review);
		tag = tagRepo.save(tag);
		return "redirect:/review?id=";

	}

	@RequestMapping(value = "/add-comment")
	public String addAComment(String stringId, String content) {
		Long id = Long.parseLong(stringId);
		Review review = reviewRepo.findOne(id);
		Comment comment = new Comment(content, review);
		comment = commentRepo.save(comment);
		return "redirect:/category?id=" + stringId;
	}
}
