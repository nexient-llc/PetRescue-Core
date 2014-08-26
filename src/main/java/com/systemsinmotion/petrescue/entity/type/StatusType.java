package com.systemsinmotion.petrescue.entity.type;

public enum StatusType {
	A("adoptable"), H("hold"), P("pending"), X("adopted");

	public static StatusType byDescription(String description) {
		StatusType statusType = null;
		for (StatusType type : StatusType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				statusType = type;
				break;
			}
		}
		return statusType;
	}

	public String description;

	private StatusType(String description) {
		this.description = description;
	}
}
