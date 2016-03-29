package br.com.grupoa.rest_test.dao;

public class DAOFactory {

	public static CourseDAO createCourseDAO() {

		CourseDAO cDAO = new CourseDAO();

		return cDAO;

	}
	public static DataSourceDAO createDataSourceDAO() {

		DataSourceDAO dDAO = new DataSourceDAO();

		return dDAO;

	}
	public static MembershipDAO createMembershipDAO() {

		MembershipDAO mDAO = new MembershipDAO();

		return mDAO;

	}
	public static TermDAO createTermDAO() {

		TermDAO tDAO = new TermDAO();

		return tDAO;

	}
	public static UserDAO createUserDAO() {

		UserDAO uDAO = new UserDAO();

		return uDAO;

	}
}
