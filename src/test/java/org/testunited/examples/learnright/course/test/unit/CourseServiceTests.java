package org.testunited.examples.learnright.course.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.testunited.examples.learnright.course.CourseRepository;
import org.testunited.examples.learnright.course.Course;
import org.testunited.examples.learnright.course.CourseService;

import org.junit.jupiter.api.*;

@SpringBootTest
public class CourseServiceTests {

	@InjectMocks
	private CourseService service;

	@Mock
	private CourseRepository reposirotyMock;

	@Test
	public void testGetAll() {
		ArrayList<Course> mockedResult = new ArrayList<Course>();
		mockedResult.add(new Course(1));
		mockedResult.add(new Course(2));

		when(reposirotyMock.findAll()).thenReturn(mockedResult);

		assertEquals(2, service.getAll().size());
	}

	@Test
	public void testGetById() {
		Course bookTitle = new Course(1, 1, "Unit Testing in 21 Days", new Date(), new Date(),
				Course.CourseStatus.Provisioned);

		when(reposirotyMock.findById(1)).thenReturn(Optional.ofNullable(bookTitle));

		assertEquals("Unit Testing in 21 Days", service.getById(1).getName());
	}

	@Test
	public void testSave() {
		Course bookTitle = new Course(1);
		this.service.Save(bookTitle);
	}
}
