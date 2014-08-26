package com.systemsinmotion.petrescue.entity.type;

public enum ApiType {
	PF("PetFinder"), UNKNOWN("Unknown");

	private String description;

	private ApiType(String description) {
		this.description = description;
	}

	public static ApiType byDescription(String description) {
		ApiType apiType = UNKNOWN;
		for (ApiType type : ApiType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				apiType = type;
				break;
			}
		}
		return apiType;
	}

}
