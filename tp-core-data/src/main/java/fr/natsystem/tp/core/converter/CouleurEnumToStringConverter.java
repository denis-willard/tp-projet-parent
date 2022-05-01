package fr.natsystem.tp.core.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import fr.natsystem.tp.core.utilities.CouleurEnum;

@Converter
public class CouleurEnumToStringConverter implements AttributeConverter<CouleurEnum, String> {

	
    @Override
    public String convertToDatabaseColumn(CouleurEnum value) {
        if (value == null)
            return null;

        return value.toString();
    }

    @Override
    public CouleurEnum convertToEntityAttribute(String value) {
        if (StringUtils.isBlank(value))
            return null;

        return CouleurEnum.getEnum(value);
    }


}
