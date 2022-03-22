package org.testunited.examples.learnright.course;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Course {

	@Id
	private int id;

	public Course(int id, int bookTitleId, String name, Date startDate, Date endDate, CourseStatus status) {
		super();
		this.id = id;
		this.bookTitleId = bookTitleId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Course() {
		super();
	}

	public Course(int id) {
		super();
		this.id = id;
	}

	private int bookTitleId;

	private String name;
	private Date startDate;
	private Date endDate;
	private CourseStatus status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookTitleId() {
		return this.bookTitleId;
	}

	public void setBookTitleId(int bookTitleId) {
		this.bookTitleId = bookTitleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CourseStatus getStatus() {
		return status;
	}

	public void setStatus(CourseStatus status) {
		this.status = status;
	}

	public enum CourseStatus {
		Provisioned, ReadyForEnrolment, EnrolmentFrozen, Archived
	}
}
