package br.com.grupoa.rest_test.dao;

import br.com.grupoa.rest_test.model.UserModel;
import br.com.grupoa.rest_test.util.RestConstants;

public class UserDAO {

	public UserModel getUser() {

		UserModel user = new UserModel();
		user.setExternalId(RestConstants.USER_ID);
		user.setDataSourceId(RestConstants.DATASOURCE_ID);
		user.setUserName(RestConstants.USER_NAME);
		user.setPassword(RestConstants.USER_PASS);
		user.setAvailability("Yes");
		user.setFirstName(RestConstants.USER_FIRST);
		user.setLastName(RestConstants.USER_LAST);
		user.setEmail(RestConstants.USER_EMAIL);

		return user;
	}
}
