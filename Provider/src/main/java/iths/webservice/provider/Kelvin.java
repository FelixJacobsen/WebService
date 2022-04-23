package iths.webservice.provider;

import iths.webservice.convert.ConvertKelvin;

public class Kelvin implements ConvertKelvin {
    @Override
    public double convertKelvin(double celsius) {
        return celsius + 273.15;
    }
}
