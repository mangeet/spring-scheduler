package me.common.bean;

public class SchedulerRequest {

	private final String id;

	private final String name;

	private final String description;

	private final String cronExpression;

	public static class Builder {

		private String id;

		private String name;

		private String description;

		private String cronExpression;

		public Builder id(final String id) {
			this.id = id;
			return this;
		}

		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		public Builder cronExpression(final String cronExpression) {
			this.cronExpression = cronExpression;
			return this;
		}

		public SchedulerRequest build() {
			return new SchedulerRequest(this);
		}
	}

	public SchedulerRequest(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.cronExpression = builder.cronExpression;
		this.description = "";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	@Override
	public String toString() {
		return "SchedulerRequest [id=" + id + ", name=" + name + ", description=" + description + ", cronExpression="
				+ cronExpression + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cronExpression == null) ? 0 : cronExpression.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SchedulerRequest other = (SchedulerRequest) obj;
		if (cronExpression == null) {
			if (other.cronExpression != null)
				return false;
		} else if (!cronExpression.equals(other.cronExpression))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
