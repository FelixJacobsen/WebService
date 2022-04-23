package iths.webservice.provider;

import iths.webservice.convert.Converter;

public class Kelvin implements Converter {

    @Override
    public double convert(double celsius) {
        return celsius - 273.15;
    }
}
