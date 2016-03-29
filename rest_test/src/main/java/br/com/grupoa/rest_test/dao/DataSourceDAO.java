package br.com.grupoa.rest_test.dao;

import br.com.grupoa.rest_test.model.DataSourceModel;
import br.com.grupoa.rest_test.util.RestConstants;

public class DataSourceDAO {

	public DataSourceModel getDataSource() {

		DataSourceModel datasource = new DataSourceModel();
		datasource.setExternalId(RestConstants.DATASOURCE_ID);
		datasource.setDescription(RestConstants.DATASOURCE_DESCRIPTION);

		return datasource;
	}
}
