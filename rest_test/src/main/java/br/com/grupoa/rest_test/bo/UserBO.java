package br.com.grupoa.rest_test.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.grupoa.rest_test.dao.DAOFactory;
import br.com.grupoa.rest_test.dao.UserDAO;
import br.com.grupoa.rest_test.model.UserModel;
import br.com.grupoa.rest_test.util.RestConstants;
import br.com.grupoa.rest_test.util.RestHandler;
import br.com.grupoa.rest_test.util.RestRequest;

public class UserBO implements RestHandler {

	@Override
	public String createObject(String accessToken) {

		UserDAO uDAO = DAOFactory.createUserDAO();
		UserModel userData = uDAO.getUser();
		RestRequest req = new RestRequest();
		String output = "";
		String body = "";

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode user = objMapper.createObjectNode();
		user.put("externalId", userData.getExternalId());
//		user.put("dataSourceId", userData.getDataSourceId());
		user.put("userName", userData.getUserName());
		user.put("password", userData.getPassword());
		ObjectNode availability = user.putObject("availability");
		availability.put("available", userData.getAvailability());
		ObjectNode name = user.putObject("name");
		name.put("given", userData.getFirstName());
		name.put("family", userData.getLastName());
		ObjectNode contact = user.putObject("contact");
		contact.put("email", userData.getEmail());

		try {
			body = objMapper.writeValueAsString(user);
			output = req.storeObject(RestConstants.USER_PATH, accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String readObject(String accessToken) {

		UserDAO uDAO = DAOFactory.createUserDAO();
		UserModel userData = uDAO.getUser();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.readObject(RestConstants.USER_PATH + "/externalId:" + userData.getExternalId(), accessToken);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String updateObject(String accessToken) {

		UserDAO uDAO = DAOFactory.createUserDAO();
		UserModel userData = uDAO.getUser();
		RestRequest req = new RestRequest();
		String output = "";
		
		userData.setFirstName("João");
		userData.setLastName("Educação");
		userData.setAvailability("Yes");

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode user = objMapper.createObjectNode();
		user.put("externalId", userData.getExternalId());
//		user.put("dataSourceId", userData.getDataSourceId());
		user.put("userName", userData.getUserName());
		user.put("password", userData.getPassword());
		ObjectNode availability = user.putObject("availability");
		availability.put("available", userData.getAvailability());
		ObjectNode name = user.putObject("name");
		name.put("given", userData.getFirstName());
		name.put("family", userData.getLastName());
		ObjectNode contact = user.putObject("contact");
		contact.put("email", userData.getEmail());

		String body = "";

		try {
			body = objMapper.writeValueAsString(user);
			output = req.update(RestConstants.USER_PATH + "/externalId:" + userData.getExternalId(), accessToken, body);

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String deleteObject(String accessToken) {

		UserDAO uDAO = DAOFactory.createUserDAO();
		UserModel userData = uDAO.getUser();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			req.delete(RestConstants.USER_PATH + "/externalId:" + userData.getExternalId(), accessToken);
			output = "User " + userData.getExternalId() +  "was deleted.";
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}
