package fr.natsystem.tp.rest.converter;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
	
    protected LocalDateDeserializer(JavaType valueType) {
		super(valueType);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -7290264815546912415L;
    
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        LocalDate result = null;
        try {
            result = LocalDate.parse(jsonParser.getValueAsString());
        } catch (Exception e) {
            throw new IOException("parsing de LocalDate en String impossible " + e.getMessage());
        }
        return result;
    }

}
