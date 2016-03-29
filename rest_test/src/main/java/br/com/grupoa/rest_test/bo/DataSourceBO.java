package br.com.grupoa.rest_test.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.grupoa.rest_test.dao.DAOFactory;
import br.com.grupoa.rest_test.dao.DataSourceDAO;
import br.com.grupoa.rest_test.model.DataSourceModel;
import br.com.grupoa.rest_test.util.RestConstants;
import br.com.grupoa.rest_test.util.RestHandler;
import br.com.grupoa.rest_test.util.RestRequest;

public class DataSourceBO implements RestHandler {

	@Override
	public String createObject(String accessToken) {

		DataSourceDAO dDAO = DAOFactory.createDataSourceDAO();
		DataSourceModel datasourceData = dDAO.getDataSource();
		RestRequest req = new RestRequest();
		String output = "";
		String body = "";

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode datasource = objMapper.createObjectNode();
		((ObjectNode) datasource).put("externalId", datasourceData.getExternalId());
		((ObjectNode) datasource).put("description", datasourceData.getDescription());

		try {
			body = objMapper.writeValueAsString(datasource);
			output = req.storeObject(RestConstants.DATASOURCE_PATH, accessToken, body);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String readObject(String accessToken) {

		DataSourceDAO dDAO = DAOFactory.createDataSourceDAO();
		DataSourceModel datasourceData = dDAO.getDataSource();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			output = req.readObject(RestConstants.DATASOURCE_PATH + "/externalId:" + datasourceData.getExternalId(), accessToken);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String updateObject(String accessToken) {

		DataSourceDAO dDAO = DAOFactory.createDataSourceDAO();
		DataSourceModel datasourceData = dDAO.getDataSource();
		RestRequest req = new RestRequest();
		String output = "";

		datasourceData.setDescription("Teste de descrição");

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode datasource = objMapper.createObjectNode();
		((ObjectNode) datasource).put("externalId", datasourceData.getExternalId());
		((ObjectNode) datasource).put("description", datasourceData.getDescription());

		String body = "";

		try {
			body = objMapper.writeValueAsString(datasource);
			output = req.update(RestConstants.DATASOURCE_PATH + "/externalId:" + datasourceData.getExternalId(), accessToken, body);

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public String deleteObject(String accessToken) {

		DataSourceDAO dDAO = DAOFactory.createDataSourceDAO();
		DataSourceModel datasourceData = dDAO.getDataSource();
		RestRequest req = new RestRequest();
		String output = "";

		try {
			req.delete(RestConstants.DATASOURCE_PATH + "/externalId:" + datasourceData.getExternalId(), accessToken);
			output = "Data source " + datasourceData.getExternalId() +  "was deleted.";
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}
