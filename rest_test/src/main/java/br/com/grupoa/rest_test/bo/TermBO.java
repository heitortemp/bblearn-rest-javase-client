package br.com.grupoa.rest_test.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.grupoa.rest_test.dao.DAOFactory;
import br.com.grupoa.rest_test.dao.TermDAO;
import br.com.grupoa.rest_test.model.TermModel;
import br.com.grupoa.rest_test.util.RestConstants;
import br.com.grupoa.rest_test.util.RestHandler;
import br.com.grupoa.rest_test.util.RestRequest;

public class TermBO implements RestHandler {

	@Override
	public String createObject(String accessToken) {

		TermDAO tDAO = DAOFactory.createTermDAO();
		TermModel termData = tDAO.getTerm();
		RestRequest req = new RestRequest();
		String output = "";
		String body = "";

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode term = objMapper.createObjectNode();
		term.put("externalId", termData.getExternalId());
//		term.put("dataSourceId",  termData.getExternalId());
		term.put("name",  termData.getName());
		term.put("description",  termData.getDescription());
		ObjectNode availability = term.putObject("availability");
		availability.put("available",  termData.getAvailability());
		ObjectNode duration = availability.putObject("duration");
		duration.put("type", termData.getDuration());

		try {
			body = objMapper.writeValueAsString(term);
			output = req.storeObject(RestConstants.TERM_PATH, accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String readObject(String accessToken) {

		TermDAO tDAO = DAOFactory.createTermDAO();
		TermModel termData = tDAO.getTerm();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.readObject(RestConstants.TERM_PATH + "/externalId:" + termData.getExternalId(), accessToken);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String updateObject(String accessToken) {

		TermDAO tDAO = DAOFactory.createTermDAO();
		TermModel termData = tDAO.getTerm();
		RestRequest req = new RestRequest();
		String output = "";
		
		termData.setName("Período 1");
		termData.setDescription("Descrição 1");
		termData.setAvailability("No");

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode term = objMapper.createObjectNode();
		term.put("externalId", termData.getExternalId());
//		term.put("dataSourceId", termData.getDataSourceId());
		term.put("name", termData.getName());
		term.put("description", termData.getDescription());
		ObjectNode availability = term.putObject("availability");
		availability.put("available", termData.getAvailability());
		ObjectNode duration = availability.putObject("duration");
		duration.put("type",  termData.getDuration());

		String body = "";

		try {
			body = objMapper.writeValueAsString(term);
			output = req.update(RestConstants.TERM_PATH + "/externalId:" + termData.getExternalId(), accessToken, body);

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String deleteObject(String accessToken) {

		TermDAO tDAO = DAOFactory.createTermDAO();
		TermModel termData = tDAO.getTerm();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			req.delete(RestConstants.TERM_PATH + "/externalId:" + termData.getExternalId(), accessToken);
			output = "Term " + termData.getExternalId() +  "was deleted.";
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}
