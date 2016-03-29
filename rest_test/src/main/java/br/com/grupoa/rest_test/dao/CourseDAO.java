package br.com.grupoa.rest_test.dao;

import br.com.grupoa.rest_test.model.CourseModel;
import br.com.grupoa.rest_test.util.RestConstants;

public class CourseDAO {

	public CourseModel getCourse() {

		CourseModel course = new CourseModel();

		course.setExternalId(RestConstants.COURSE_ID);
		course.setDataSourceId(RestConstants.DATASOURCE_ID);
		course.setCourseId(RestConstants.COURSE_ID);
		course.setName(RestConstants.COURSE_NAME);
		course.setDescription(RestConstants.COURSE_DESCRIPTION);
		course.setAllowGuests(true);
		course.setReadOnly(false);
		course.setTermId(RestConstants.TERM_ID);
		course.setAvailability("continuous");

		return course;
	}

}
