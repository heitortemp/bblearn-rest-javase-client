package br.com.grupoa.rest_test.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.grupoa.rest_test.dao.CourseDAO;
import br.com.grupoa.rest_test.dao.DAOFactory;
import br.com.grupoa.rest_test.model.CourseModel;
import br.com.grupoa.rest_test.util.RestConstants;
import br.com.grupoa.rest_test.util.RestHandler;
import br.com.grupoa.rest_test.util.RestRequest;

public class CourseBO implements RestHandler {

	@Override
	public String createObject(String accessToken) {

		CourseDAO cDAO = DAOFactory.createCourseDAO();
		CourseModel courseData = cDAO.getCourse();
		RestRequest req = new RestRequest();
		String output = "";
		String body = "";

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode course = objMapper.createObjectNode();
		course.put("externalId", courseData.getExternalId());
		//		course.put("dataSourceId", courseData.getDataSourceId());
		course.put("courseId", courseData.getExternalId());
		course.put("name", courseData.getName());
		course.put("description", courseData.getDescription());
		course.put("allowGuests", String.valueOf(courseData.isAllowGuests()));
		course.put("readOnly", String.valueOf(courseData.isReadOnly()));
		course.put("termId", courseData.getTermId());
		ObjectNode availability = course.putObject("availability");
		availability.put("duration", courseData.getAvailability());

		try {
			body = objMapper.writeValueAsString(course);
			output = req.storeObject(RestConstants.COURSE_PATH, accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String readObject(String accessToken) {

		CourseDAO cDAO = DAOFactory.createCourseDAO();
		CourseModel courseData = cDAO.getCourse();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.readObject(RestConstants.COURSE_PATH + "/externalId:" + courseData.getExternalId(), accessToken);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String updateObject(String accessToken) {

		CourseDAO cDAO = DAOFactory.createCourseDAO();
		CourseModel courseData = cDAO.getCourse();
		RestRequest req = new RestRequest();
		String output = "";

		courseData.setCourseId("prototipação_mecatrônica");
		courseData.setName("Prototipação mecatrônica");
		courseData.setAllowGuests(false);

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode course = objMapper.createObjectNode();
		course.put("externalId", courseData.getExternalId());
		//		course.put("dataSourceId", courseData.getDataSourceId());
		course.put("courseId", courseData.getExternalId());
		course.put("name", courseData.getName());
		course.put("description", courseData.getDescription());
		course.put("allowGuests", String.valueOf(courseData.isAllowGuests()));
		course.put("readOnly", String.valueOf(courseData.isReadOnly()));
		course.put("termId", courseData.getTermId());
		ObjectNode availability = course.putObject("availability");
		availability.put("duration", courseData.getAvailability());

		String body = "";

		try {
			body = objMapper.writeValueAsString(course);
			output = req.update(RestConstants.COURSE_PATH + "/externalId:" + courseData.getExternalId(), accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String deleteObject(String accessToken) {

		CourseDAO cDAO = DAOFactory.createCourseDAO();
		CourseModel courseData = cDAO.getCourse();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			req.delete(RestConstants.COURSE_PATH + "/externalId:" + courseData.getExternalId(), accessToken);
			output = "Course " + courseData.getExternalId() +  "was deleted.";
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}