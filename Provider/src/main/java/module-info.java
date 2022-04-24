import iths.webservice.convert.Converter;
import iths.webservice.provider.Fahrenheit;
import iths.webservice.provider.Kelvin;

module Provider {
    requires iths.webservice.converter;
    provides Converter with Fahrenheit, Kelvin;
}
