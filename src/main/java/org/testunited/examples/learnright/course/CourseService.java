package org.testunited.examples.learnright.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository bookTitleRepository;

	public void Save(Course bookTitle) {
		this.bookTitleRepository.save(bookTitle);
	}

	public List<Course> getAll() {
		return (List<Course>) bookTitleRepository.findAll();
	}

	public Course getById(int id) {
		return this.bookTitleRepository.findById(id).orElse(null);
	}

	public List<Course> getByBookTitleId(int bookTitleId) {
		return this.bookTitleRepository.findByBookTitleId(bookTitleId);
	}

}
