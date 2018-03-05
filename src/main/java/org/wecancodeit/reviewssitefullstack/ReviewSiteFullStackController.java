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
	
	@RequestMapping(value = "categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories",categoryRepo.findAll());
		return "categories";
	}
	
	@RequestMapping(value = "category")
	public String getReviewListofCategories(@RequestParam Long id, Model model) {
		model.addAttribute("category",categoryRepo.findOne(id));
		return "category";
	}
	
	@RequestMapping(value = "reviews")
	public String getAllReviews(Model model) {
		model.addAttribute("reviews",reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping(value = "review")
	public String getCategoryListofReviews(@RequestParam Long id, Model model) {
		model.addAttribute("review",reviewRepo.findOne(id));
		return "review";
	}
}
