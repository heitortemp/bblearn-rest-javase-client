package br.com.grupoa.rest_test.util;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.grupoa.rest_test.bo.CourseBO;
import br.com.grupoa.rest_test.bo.DataSourceBO;
import br.com.grupoa.rest_test.bo.MembershipBO;
import br.com.grupoa.rest_test.bo.TermBO;
import br.com.grupoa.rest_test.bo.UserBO;
import br.com.grupoa.rest_test.model.Token;

public class App 
{
	public static void main( String[] args ) {

		Authorizer auth = new Authorizer();
		Token token = new Token();
		
		try {
			token = auth.authorize();
			CourseBO cBO = new CourseBO();
			DataSourceBO dBO = new DataSourceBO();
			MembershipBO mBO = new MembershipBO();
			TermBO tBO = new TermBO();
			UserBO uBO = new UserBO();
			
			String outputCreateCourse = cBO.createObject(token.getToken());
			System.out.println("Output: " + outputCreateCourse);
//			String outputGetCourse = cBO.readObject(token.getToken());
//			System.out.println("Output: " + outputGetCourse);
//			String outputUpdateCourse = cBO.updateObject(token.getToken());
//			System.out.println("Output: " + outputUpdateCourse);
//			String outputDeleteCourse = cBO.deleteObject(token.getToken());
//			System.out.println("Output: " + outputDeleteCourse);
			
			String outputCreateDataSource = dBO.createObject(token.getToken());
			System.out.println("Output: " + outputCreateDataSource);
//			String outputGetDataSource = dBO.readObject(token.getToken());
//			System.out.println("Output: " + outputGetDataSource);
//			String outputUpdateDataSource = dBO.updateObject(token.getToken());
//			System.out.println("Output: " + outputUpdateDataSource);
//			String outputDeleteDataSource = dBO.deleteObject(token.getToken());
//			System.out.println("Output: " + outputDeleteDataSource);
			
			String outputCreateTerm = tBO.createObject(token.getToken());
			System.out.println("Output: " + outputCreateTerm);
//			String outputGetTerm = tBO.readObject(token.getToken());
//			System.out.println("Output: " + outputGetTerm);
//			String outputUpdateTerm = tBO.updateObject(token.getToken());
//			System.out.println("Output: " + outputUpdateTerm);
//			String outputDeleteTerm = tBO.deleteObject(token.getToken());
//			System.out.println("Output: " + outputDeleteTerm);
			
			String outputCreateUser = uBO.createObject(token.getToken());
			System.out.println("Output: " + outputCreateUser);
//			String outputGetUser = uBO.readObject(token.getToken());
//			System.out.println("Output: " + outputGetUser);
//			String outputUpdateUser = uBO.updateObject(token.getToken());
//			System.out.println("Output: " + outputUpdateUser);
//			String outputDeleteUser = uBO.deleteObject(token.getToken());
//			System.out.println("Output: " + outputDeleteUser);
			
			String outputCreateMembership = mBO.createObject(token.getToken());
			System.out.println("Output: " + outputCreateMembership);
//			String outputGetMembership = mBO.readObject(token.getToken());
//			System.out.println("Output: " + outputGetMembership);
//			String outputUpdateMembership = mBO.updateObject(token.getToken());
//			System.out.println("Output: " + outputUpdateMembership);
//			String outputDeleteMembership = mBO.deleteObject(token.getToken());
//			System.out.println("Output: " + outputDeleteMembership);		

		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
