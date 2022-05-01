package fr.natsystem.tp.rest.converter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerializer  extends StdSerializer<LocalDate> {
	   private static final long serialVersionUID = -4633764907382246039L;
	    public LocalDateSerializer() {
	        super(LocalDate.class);
	    }
	    
	    @Override
	    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
	            throws IOException {
	        jsonGenerator.writeString(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	    }

}

