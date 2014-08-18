package com.systemsinmotion.petrescue.entity.type;

public enum SizeType {
	S("Small"), M("Medium"), L("Large"), XL("XLarge");

	public String description;

	private SizeType(String description) {
		this.description = description;
	}

	public static SizeType byDescription(String description) {
		SizeType sizeType = null;
		for (SizeType type : SizeType.values()) {
			if (type.description.equalsIgnoreCase(description)) {
				sizeType = type;
				break;
			}
		}
		return sizeType;
	}
}
