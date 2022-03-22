package org.testunited.examples.learnright.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	public List<Course> findByBookTitleId(int bookTitleId);
}
