package com.iktpreobuka.project.enums;

public enum OfferType {

	WAIT_FOR_APPROVING("wait"), APPROVED("approved"), DECLINED("declined"), EXPIRED("expired");

	private String type;

	private OfferType(String type) {
		this.type = type;
	}

	public static OfferType fromString(String t) {
		for (OfferType ot : OfferType.values())
			if (ot.type.equalsIgnoreCase(t))
				return ot;

		return null;
	}

}
