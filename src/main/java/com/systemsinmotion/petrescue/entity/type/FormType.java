package com.systemsinmotion.petrescue.entity.type;

public enum FormType {
	CAT_ADOPTION("cat-adoption"), DOG_ADOPTION("dog-adoption"), VOLUNTEER("volunteer-application");

	private final String description;

	private FormType(String description) {
		this.description = description;
	}

	public static FormType byDescription(String desc) {
		FormType formType = null;
		for (FormType ft : FormType.values()) {
			if (ft.description.equals(desc)) {
				formType = ft;
				break;
			}
		}
		return formType;
	}
}
