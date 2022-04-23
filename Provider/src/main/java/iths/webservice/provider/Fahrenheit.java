package iths.webservice.provider;

import iths.webservice.convert.ConvertFahrenheit;

public class Fahrenheit implements ConvertFahrenheit {
    @Override
    public double convertFahrenheit(double celsius) {
        return celsius - 32.0 * 5 / 9;
    }
}
