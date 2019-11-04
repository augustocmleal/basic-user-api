package br.com.augustoleal.basic_user_api.commons.enums;

import org.apache.commons.lang.StringUtils;

import lombok.Getter;

public enum StatusEnum {

    ATIVO("A"), INATIVO("I");

    private @Getter String code;

    private StatusEnum(String code) {
	this.code = code;
    }

    public static StatusEnum valueOfCode(String code) {
	if (StringUtils.isBlank(code))
	    return null;

	for (StatusEnum value : values()) {
	    if (value.code.equals(code))
		return value;
	}
	throw new IllegalArgumentException("Nao localizado enum com label [" + code + "]");
    }

}
