package br.com.grupoa.rest_test.model;

public class MembershipModel {

	private String dataSourceId;
	private String availability;
	private String courseRoleId;
	private String courseId;
	private String userId;

	public String getDataSourceId() {
		return dataSourceId;
	}
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getCourseRoleId() {
		return courseRoleId;
	}
	public void setCourseRoleId(String courseRoleId) {
		this.courseRoleId = courseRoleId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseRoleId == null) ? 0 : courseRoleId.hashCode());
		result = prime * result + ((dataSourceId == null) ? 0 : dataSourceId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembershipModel other = (MembershipModel) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseRoleId == null) {
			if (other.courseRoleId != null)
				return false;
		} else if (!courseRoleId.equals(other.courseRoleId))
			return false;
		if (dataSourceId == null) {
			if (other.dataSourceId != null)
				return false;
		} else if (!dataSourceId.equals(other.dataSourceId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MembershipModel [dataSourceId=" + dataSourceId + ", availability=" + availability + ", courseRoleId="
				+ courseRoleId + ", courseId=" + courseId + ", userId=" + userId + "]";
	}
}