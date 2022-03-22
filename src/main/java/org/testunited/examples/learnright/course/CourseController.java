package org.testunited.examples.learnright.course;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public List<Course> getAll() {
		return this.courseService.getAll();
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getById(@PathVariable int id) {
		Course course = this.courseService.getById(id);

		if (course == null)
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PostMapping("/courses")
	@ResponseStatus(HttpStatus.CREATED)
	public Course add(@Valid @RequestBody Course course) {
		this.courseService.Save(course);
		return course;
	}

	@GetMapping("/booktitles/{bookTitleId}/courses")
	public List<Course> getByBookTitleId(@PathVariable int bookTitleId) {
		var course = this.courseService.getByBookTitleId(bookTitleId);
		return course;
	}
}
