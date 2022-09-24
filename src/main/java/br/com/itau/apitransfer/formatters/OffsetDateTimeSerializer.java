package br.com.itau.apitransfer.formatters;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

    @Override
    public void serialize(OffsetDateTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
        if (arg0 != null) {
            arg1.writeString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(arg0));
        } else {
            arg1.writeNull();
        }
    }
}
