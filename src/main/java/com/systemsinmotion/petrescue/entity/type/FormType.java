package com.systemsinmotion.petrescue.entity.type;

public enum FormType {
	CAT_ADOPTION("cat-adoption"), DOG_ADOPTION("dog-adoption"), VOLUNTEER(
			"volunteer-application"), UNKNOWN("Unknown");

	private final String description;

	private FormType(String description) {
		this.description = description;
	}

	public static FormType byDescription(String desc) {
		FormType formType = UNKNOWN;
		for (FormType ft : FormType.values()) {
			if (ft.description.equals(desc)) {
				formType = ft;
				break;
			}
		}
		return formType;
	}
}
