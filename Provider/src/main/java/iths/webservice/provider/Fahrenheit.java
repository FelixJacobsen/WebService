package iths.webservice.provider;

import iths.webservice.convert.Converter;
import iths.webservice.convert.Designation;

public class Fahrenheit implements Converter {

    @Override
    @Designation("°F")
    public double convert(double celsius) {
        return (9.0 / 5.0) * celsius + 32;
    }

    @Override
    public String information() {
        return "Convert celsius to fahrenheit";
    }

}
