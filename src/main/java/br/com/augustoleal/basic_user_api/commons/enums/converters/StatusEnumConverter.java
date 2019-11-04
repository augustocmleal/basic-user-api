package br.com.augustoleal.basic_user_api.commons.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.augustoleal.basic_user_api.commons.enums.StatusEnum;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum value) {
	return value.getCode();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String value) {
	return StatusEnum.valueOfCode(value);
    }

}
