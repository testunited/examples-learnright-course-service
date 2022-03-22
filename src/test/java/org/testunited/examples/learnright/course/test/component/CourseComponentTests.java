package org.testunited.examples.learnright.course.test.component;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Date;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import org.testunited.examples.learnright.course.Course;
import org.testunited.examples.learnright.course.Course.CourseStatus;
import org.testunited.examples.learnright.course.CourseController;
import org.testunited.examples.learnright.course.CourseRepository;
import org.testunited.examples.learnright.course.CourseService;
import org.testunited.examples.learnright.course.test.TestDataBuilder;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@Tag("microservice:booktitle")
//@ActiveProfiles({"dev","ci"})
public class CourseComponentTests {

	private MockMvc mockMvc;
	@Autowired
	private CourseController controller;
//
//	private final String jsonSingleBookTitleGood = "{\n" + "    \"id\": 1,\n" + "    \"name\": \"my new book title\",\n"
//			+ "    \"author\": \"who else, its me\"\n" + "}";
//
//	private final String jsonSingleBookTitleBad = "{\n" + "    \"bookTitleId\": 1,\n"
//			+ "    \"bookTitleName\": \"my new book title\",\n" + "    \"bookTitleAuthor\": \"who else, its me\"\n"
//			+ "}";
//

	private final Course course1 = new Course(1, 1, "who else, its me", new Date(), new Date(),
			CourseStatus.Provisioned);
//	private final Course singleBookTitleResponse2 = new Course(2, "my new book title 2", "who else, its me");
//
//	private final ArrayList<Course> bookTitleList = new ArrayList<Course>();
//

	// @InjectMocks
	// private CourseService service;

	// @Mock
	// private CourseRepository repoMock;

	@Autowired
	private TestDataBuilder testDataBuilder;

	@BeforeAll
	public void setUp() throws Exception {
		mockMvc = standaloneSetup(controller).build();
		testDataBuilder.createCourses();

	}

	@Test
	@Tag("method:GET")
	@Tag("route:/courses/{id}")
	@Tag("group:statuscode")
	@Tag("expected:contentmatch")
	public void testGetById() throws Exception {
		// when(this.repoMock.findById(1)).thenReturn(Optional.ofNullable(this.course1));

		var course1 = this.testDataBuilder.getAllCourses().get(1);
		var result = this.mockMvc.perform(get("/courses/" + course1.getId()));
		result.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is(course1.getId())))
				.andExpect(jsonPath("$.name", Matchers.is(course1.getName())));
	}
//
//	@Test
//	@Tag("method:GET")
//	@Tag("route:/booktitles")
//	@Tag("group:statuscode")
//	@Tag("expected:contentmatch")
//	@DisplayName("Get All BookTitles")
//	public void testGetAll() throws Exception {
//
//		this.bookTitleList.add(this.singleBookTitleResponse1);
//		this.bookTitleList.add(this.singleBookTitleResponse2);
//
//		when(serviceMock.getAll()).thenReturn(this.bookTitleList);
//
//		this.mockMvc.perform(get("/booktitles").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("$.*", Matchers.hasSize(2)));
//
//	}
//
//	@Test
//	public void testAdd() throws Exception {
//		this.mockMvc
//				.perform(post("/booktitles").content(jsonSingleBookTitleGood).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated());
//	}
//
//	@Test
//	@Tag("method:GET")
//	@Tag("route:/booktitles")
//	@Tag(TestTags.GROUP_REQUEST_VALIDATION)
//	@Tag("case:bad_json")
//	@DisplayName("Validate status code when bad JSON is sent")
//	public void testAddBadRequestBadJson() throws Exception {
//		this.mockMvc
//				.perform(post("/booktitles").content(jsonSingleBookTitleBad).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isBadRequest());
//	}
//
//	@Test
//	public void testAddBadRequestNotJson() throws Exception {
//		this.mockMvc.perform(post("/booktitles").content("NotJason").contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isBadRequest());
//	}

}
