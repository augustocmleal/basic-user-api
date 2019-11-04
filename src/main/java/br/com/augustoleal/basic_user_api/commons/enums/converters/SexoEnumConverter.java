package br.com.augustoleal.basic_user_api.commons.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.augustoleal.basic_user_api.commons.enums.SexoEnum;

@Converter(autoApply = true)
public class SexoEnumConverter implements AttributeConverter<SexoEnum, String> {

    @Override
    public String convertToDatabaseColumn(SexoEnum value) {
	return value.getCode();
    }

    @Override
    public SexoEnum convertToEntityAttribute(String value) {
	return SexoEnum.valueOfCode(value);
    }

}
