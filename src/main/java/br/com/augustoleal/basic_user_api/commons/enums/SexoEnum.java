package br.com.augustoleal.basic_user_api.commons.enums;

import org.apache.commons.lang.StringUtils;

import lombok.Getter;

public enum SexoEnum {

    MASCULINO("M"), FEMININO("F");

    private @Getter String code;

    private SexoEnum(String code) {
	this.code = code;
    }

    public static SexoEnum valueOfCode(String code) {
	if (StringUtils.isBlank(code))
	    return null;

	for (SexoEnum value : values()) {
	    if (value.code.equals(code))
		return value;
	}
	throw new IllegalArgumentException("Nao localizado enum com label [" + code + "]");
    }

}
