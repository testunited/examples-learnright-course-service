package org.testunited.examples.learnright.course.test.contract;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import org.testunited.examples.learnright.course.CourseController;
import org.testunited.examples.learnright.course.Course;
import org.testunited.examples.learnright.course.CourseService;
import org.testunited.examples.learnright.course.test.TestDataBuilder;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CourseBase {

	// private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@InjectMocks
	private CourseController courseCont;

	@Mock
	private CourseService courseSvc;

	@BeforeEach
	void setup() {
		// mockMvc = standaloneSetup(proCont).build();
		var testDataBuilder = new TestDataBuilder();
		var allCourses = testDataBuilder.getAllCourses();
		var coursesOfBookTitle1 = testDataBuilder.getCoursesForBookTitle1();

		var course1 = allCourses.get(0);

		when(this.courseSvc.getAll()).thenReturn(allCourses);
		when(this.courseSvc.getByBookTitleId(1)).thenReturn(coursesOfBookTitle1);
		when(this.courseSvc.getByBookTitleId(11)).thenReturn(new ArrayList<Course>());
		when(this.courseSvc.getById(1)).thenReturn(course1);
		when(this.courseSvc.getById(11)).thenReturn(null);

		RestAssuredMockMvc.standaloneSetup(this.courseCont);
	}

}
