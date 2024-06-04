package vn.tinhh.workplan.graphql.scaler;

import com.netflix.graphql.dgs.DgsScalar;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DgsScalar(name = "DateCustom")
public class DateTimeScalar implements Coercing<Date, String> {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
        if (dataFetcherResult instanceof Date) {
            Date cDate = (Date) dataFetcherResult;
            return dateFormat.format(cDate);
        } else {
            throw new CoercingSerializeException("Value is not a valid ISO date time. Time format dd/MM/yyyy");
        }
    }

    @Override
    public Date parseValue(Object input) throws CoercingParseValueException {
        try {
            return dateFormat.parse(input.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Date parseLiteral(Object input) throws CoercingParseLiteralException {
        if (input instanceof StringValue) {
            try {
                StringValue stringValue = (StringValue) input;
                return dateFormat.parse(stringValue.getValue());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        throw new CoercingParseLiteralException("Value is not a valid ISO date time. Time format dd/MM/yyyy");
    }

    


}