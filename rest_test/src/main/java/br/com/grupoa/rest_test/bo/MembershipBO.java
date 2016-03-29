package br.com.grupoa.rest_test.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.grupoa.rest_test.dao.DAOFactory;
import br.com.grupoa.rest_test.dao.MembershipDAO;
import br.com.grupoa.rest_test.model.MembershipModel;
import br.com.grupoa.rest_test.util.RestConstants;
import br.com.grupoa.rest_test.util.RestHandler;
import br.com.grupoa.rest_test.util.RestRequest;

public class MembershipBO implements RestHandler {

	@Override
	public String createObject(String accessToken) {

		MembershipDAO mDAO = DAOFactory.createMembershipDAO();
		MembershipModel membershipData  = mDAO.getMembership();
		RestRequest req = new RestRequest();
		String output = "";
		String body = "";

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode membership = objMapper.createObjectNode();
//		membership.put("dataSourceId", membershipData.getDataSourceId());
		ObjectNode availability = membership.putObject("availability");
		availability.put("available", membershipData.getAvailability());
		membership.put("courseRoleId", membershipData.getCourseRoleId());

		try {
			body = objMapper.writeValueAsString(membership);
			output = req.putObject(RestConstants.COURSE_PATH + "/externalId:" + membershipData.getCourseId() + "/users/externalId:" + membershipData.getUserId(), accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String readObject(String accessToken) {

		MembershipDAO mDAO = DAOFactory.createMembershipDAO();
		MembershipModel membershipData  = mDAO.getMembership();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.readObject(RestConstants.COURSE_PATH + "/externalId:" + membershipData.getCourseId() + "/users/externalId:"+ membershipData.getUserId(), accessToken);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String updateObject(String accessToken) {

		MembershipDAO mDAO = DAOFactory.createMembershipDAO();
		MembershipModel membershipData  = mDAO.getMembership();
		RestRequest req = new RestRequest();
		String output = "";

		membershipData.setAvailability("Yes");
		membershipData.setCourseRoleId("G");

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode membership = objMapper.createObjectNode();
		//membership.put("dataSourceId", RestConstants.DATASOURCE_ID);
		ObjectNode availability = membership.putObject("availability");
		availability.put("available", membershipData.getAvailability());
		membership.put("courseRoleId", membershipData.getCourseRoleId());

		String body = "";

		try {
			body = objMapper.writeValueAsString(membership);
			output = req.update(RestConstants.COURSE_PATH + "/externalId:" + membershipData.getCourseId() + "/users/externalId:" + membershipData.getUserId(), accessToken, body);

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String deleteObject(String accessToken) {

		MembershipDAO mDAO = DAOFactory.createMembershipDAO();
		MembershipModel membershipData  = mDAO.getMembership();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.delete(RestConstants.COURSE_PATH + "/externalId:" + membershipData.getCourseId() + "/users/externalId:" + membershipData.getUserId(), accessToken);
			output = "Member " + membershipData.getUserId() +  "was deleted from the course " + membershipData.getCourseId();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}
