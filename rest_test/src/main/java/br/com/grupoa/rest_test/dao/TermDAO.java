package br.com.grupoa.rest_test.dao;

import br.com.grupoa.rest_test.model.TermModel;
import br.com.grupoa.rest_test.util.RestConstants;

public class TermDAO {

	public TermModel getTerm() {

		TermModel term = new TermModel();
		term.setExternalId(RestConstants.TERM_ID);
		term.setDataSourceId(RestConstants.DATASOURCE_ID);
		term.setName(RestConstants.TERM_NAME);
		term.setDescription(RestConstants.TERM_DISPLAY);
		term.setAvailability("Yes");
		term.setDuration("Continuous");

		return term;
	}
}
