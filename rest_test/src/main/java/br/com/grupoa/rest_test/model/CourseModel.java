package br.com.grupoa.rest_test.model;

public class CourseModel {

	private String externalId;
	private String dataSourceId;
	private String courseId;
	private String name;
	private String description;
	private boolean allowGuests;
	private boolean readOnly;
	private String termId;
	private String availability;

	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getDataSourceId() {
		return dataSourceId;
	}
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAllowGuests() {
		return allowGuests;
	}
	public void setAllowGuests(boolean allowGuests) {
		this.allowGuests = allowGuests;
	}
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allowGuests ? 1231 : 1237);
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((dataSourceId == null) ? 0 : dataSourceId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (readOnly ? 1231 : 1237);
		result = prime * result + ((termId == null) ? 0 : termId.hashCode());
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
		CourseModel other = (CourseModel) obj;
		if (allowGuests != other.allowGuests)
			return false;
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
		if (dataSourceId == null) {
			if (other.dataSourceId != null)
				return false;
		} else if (!dataSourceId.equals(other.dataSourceId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (readOnly != other.readOnly)
			return false;
		if (termId == null) {
			if (other.termId != null)
				return false;
		} else if (!termId.equals(other.termId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CourseModel [externalId=" + externalId + ", dataSourceId=" + dataSourceId + ", courseId=" + courseId
				+ ", name=" + name + ", description=" + description + ", allowGuests=" + allowGuests + ", readOnly="
				+ readOnly + ", termId=" + termId + ", availability=" + availability + "]";
	}
}
