package org.testunited.examples.learnright.course.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.util.GregorianCalendar;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.testunited.examples.learnright.course.Course;
import org.testunited.examples.learnright.course.Course.CourseStatus;
import org.testunited.examples.learnright.course.CourseRepository;

@Service
public class TestDataBuilder {

	@Autowired
	CourseRepository courseRepo;

	Date startDate = new GregorianCalendar(2019,5,2).getTime();
	Date endDate = new GregorianCalendar(2020,5,2).getTime();

	Course course1 = new Course(1, 1, "Sams Teach Yourself Java in 21 Days - June 2019 Intake", startDate,
			endDate, CourseStatus.ReadyForEnrolment);
	Course course2 = new Course(2, 1, "Sams Teach Yourself Java in 21 Days - July 2019 Intake", startDate,
	endDate, CourseStatus.Provisioned);
	Course course3 = new Course(3, 2, "Spring in Action, Fifth Edition - Summer Camp 2019", startDate,
	endDate, CourseStatus.ReadyForEnrolment);
	Course course4 = new Course(4, 2, "Spring in Action, Fifth Edition - Fall 2019 Full Course", startDate,
			endDate, CourseStatus.Provisioned);

	public void createCourses() {
		var courses = getAllCourses();
		courseRepo.saveAll(courses);
	}

	public List<Course> getAllCourses() {
		var courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);

		return courses;
	}

	public List<Course> getCoursesForBookTitle1() {
		var courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		return courses;
	}

}
