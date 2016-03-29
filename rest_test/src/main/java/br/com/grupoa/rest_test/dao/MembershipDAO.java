package br.com.grupoa.rest_test.dao;

import br.com.grupoa.rest_test.model.MembershipModel;
import br.com.grupoa.rest_test.util.RestConstants;

public class MembershipDAO {

	public MembershipModel getMembership() {

		MembershipModel membership = new MembershipModel();
		membership.setDataSourceId(RestConstants.DATASOURCE_ID);
		membership.setAvailability("No");
		membership.setCourseRoleId("S");
		membership.setCourseId(RestConstants.COURSE_ID);
		membership.setUserId(RestConstants.USER_ID);

		return membership;
	}
}