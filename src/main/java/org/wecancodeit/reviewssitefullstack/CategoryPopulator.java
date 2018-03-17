package org.wecancodeit.reviewssitefullstack;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryPopulator implements CommandLineRunner {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {

		Tag tagEast = tagRepo.save(new Tag("East"));
		Tag tagWest = tagRepo.save(new Tag("West"));

		Category transit = new Category("Transit");
		transit = categoryRepo.save(transit);
		reviewRepo.save(new Review("Toronto", transit,
				"The subways in Toronto are very roomy and pretty far reaching. The streetcars can get you anywhere you want with ease, that is if you live only in Old Toronto.",
				"https://www.ttc.ca/Spadina/images/about%20the%20project/SubwayFutureMap_sm.jpg", tagEast));
		reviewRepo.save(new Review("Montréal", transit,
				"The  Métro de Montréal is generally regarded as one of the best metro systems in all of Canada. The Métro has access to most of the major parts of the city. Interlocking subway lines allow for ease of transfer. The subways even go to neighbouring suburbs.",
				"http://www.stm.info/sites/all/modules/features/stm_metro/theme/images/map-interactive.gif", tagEast));
		reviewRepo.save(new Review("Vancouver", transit,
				"Vancouver has decent coverage with their sky trains. They're not the most useful when it comes to inter-city travel, but there is train access to the airport and some suburbs. SkyTrain also boasts the, by far, the best views of any Canadian transit.",
				"http://www.orangesmile.com/common/img_metro_maps/vancouver-map-metro-1.png", tagWest));
		reviewRepo.save(new Review("Calgary", transit,
				"The CTrain provides good coverage to the city of Calgary, in all directions. The most unique aspect of the CTrain is that it provides riders with nine free stops in the downtown Calgary area.",
				"https://pbs.twimg.com/media/CoSw9kSWEAALxvT.jpg", tagWest, tagEast));
		Category culture = new Category("Culture");
		culture = categoryRepo.save(culture);
		reviewRepo.save(new Review("Toronto", culture,
				"With only 39% of the population identifying as white, Toronto is known universally as the most diverse city on the planet. Out-of-towners may view Torontonians as overworked businessmen, but the plethora shows and festivals often distract from this.",
				"https://cdn.narcity.com/uploads/228294_e63fcd5d73d5814291f7538180b83cfdde474d6e.jpg_facebook.jpg",
				tagEast));
		reviewRepo.save(new Review("Montréal", culture,
				"Montreal is a French Mecca, and buildings are often built in a very classic French style. All Canadians know that Montreal is the place to go to have fun -- with their many museums and La Ronde theme park. Montreal also has many winter festivals.",
				"https://cdn.mtlblog.com/uploads/203009_a09a5ae85533c18157485ce6505afa4cd4de0a10.jpg_facebook.jpg",
				tagEast));
		reviewRepo.save(new Review("Vancouver", culture,
				"Vancouver holds the highest percentage of Asian-identifying peoples: almost 40%. Chinese culture has a huge impact on Vancouver life and is also commonly the star of many of its festivals.",
				"http://images.dailyhive.com/20170926115631/vancouver-chinese-lantern-festival-6.jpg", tagWest));
		reviewRepo.save(new Review("Calgary", culture,
				"Arguably the Texas of Canada, Calgary generally has a population of more rural-minded people. Calgary is also home to the largest rodeo in the entire world, called the Calgary Stampede.",
				"http://www.snaffletravel.com.au/wp-content/uploads/2016/05/hr-canada.jpg", tagWest));
		Category weather = new Category("Weather");
		weather = categoryRepo.save(weather);
		reviewRepo.save(new Review("Toronto", weather,
				"Toronto has hot, humid summers and cold, snowy winters. Summers are often in the 30°C area and winters average out at -6°C.",
				"https://s3.amazonaws.com/btoimage/prism-thumbnails/articles/2017118-winter-weather-toronto.jpg-resize_then_crop-_frame_bg_color_FFF-h_1365-gravity_center-q_70-preserve_ratio_true-w_2048_.jpg",
				tagEast));
		reviewRepo.save(new Review("Montréal", weather,
				"Montreal (and Quebec in general), are known for being the coldest major city areas in Canada, with winters getting down to -14°C. Summers, at around 26°C, are generally mild but humid.",
				"https://fthmb.tqn.com/h97i9lfJsjmKRmSv_0yAhNnvOoE=/960x0/filters:no_upscale()/montreal-february-weather-yves-marcoux-getty-56a63f5c3df78cf7728c15ed.jpg",
				tagEast));
		reviewRepo.save(new Review("Vancouver", weather,
				"Vancouver has a mild climate all around, for Canada. Winter temperatures rarely go below 0°C, and summers usually hit around 23°C.",
				"http://www.cbc.ca/vancouverweather/mt/beach.jpg", tagWest));
		reviewRepo.save(new Review("Calgary", weather,
				"Calgary has pretty rough winters and decent summers. Although -13°C is average for Calgarian winters, -30°C is not uncommon. Summers average out to 24°C.",
				"https://www.lifeincalgary.ca/sites/default/files/bucket/CalgaryFacts_Weather_0.jpg", tagWest));
	}
}