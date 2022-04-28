package fr.natsystem.tp.core.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import fr.natsystem.tp.core.utilities.ConstantesOuiNon;

@Converter
public class BooleanToStringOuiNonConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return BooleanUtils.toString(value, ConstantesOuiNon.OUI, ConstantesOuiNon.NON, null);
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (StringUtils.isBlank(value)) return null;
        return ConstantesOuiNon.OUI.equals(value);
    }

}
