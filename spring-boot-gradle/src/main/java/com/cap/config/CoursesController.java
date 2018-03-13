package com.cap.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cap.bean.Courses;
import com.cap.repositories.BaseRepository;

@RestController
public class CoursesController {

	@Inject
	private BaseRepository baseRepository;

	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("cources");
	}

	@GetMapping(value = { "/courses" })
	public List<Courses> courses(/* @PathVariable(value = "id") Long id */) {
		final ArrayList<Courses> courses = new ArrayList<Courses>();
		courses.add(new Courses("1", "Big Data", "Big Data Analytics Session",
				"1 week"));
		courses.add(new Courses("2", "Data Scientist",
				"Data Scientist & Big Data Analytics Session", "2 week"));
		courses.add(new Courses("3", "Java J2ee Fullstack",
				"Java J2ee Full Stack Brushup Session", "2 days"));
		return courses;
	}

	@DeleteMapping(value = { "/courses" }, produces = { "application/json" }, consumes = { "application/json" })
	public String deleteCourses(
			@NotNull(message = "courses cann't be null") @RequestBody List<Courses> bean) {
		return "Deleted Successfully";
	}

	BaseRepository getBaseRepository() {
		return baseRepository;
	}

	void setBaseRepository(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

}
