package iths.webservice.provider;

import iths.webservice.convert.Converter;
import iths.webservice.convert.Designation;

public class Kelvin implements Converter {

    @Override
    @Designation("°K")
    public double convert(double celsius) {
        return celsius + 273.15;
    }

    @Override
    public String information() {
        return "Convert celsius to Kelvin";
    }
}
