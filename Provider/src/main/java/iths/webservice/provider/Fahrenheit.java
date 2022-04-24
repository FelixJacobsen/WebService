package iths.webservice.provider;

import iths.webservice.convert.Converter;

public class Fahrenheit implements Converter {

    @Override
    public double convert(double celsius) {
        return (celsius - 32.0) * 5 / 9;
    }

    @Override
    public String information() {
        return "Convert celsius to fahrenheit";
    }


}
