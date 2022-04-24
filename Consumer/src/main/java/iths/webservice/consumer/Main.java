package iths.webservice.consumer;

import iths.webservice.convert.Converter;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private void run(){
        List<Converter> converterList = getConverterList();
        int option;
        while(true) {
            double celsius = getCelsius();
            try {
                option = getChoice(converterList);
                if (option == 0)
                    break;
                Converter converter = converterList.get(option - 1);
                printAfterConvert(converter, celsius);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter [1] to convert into fahrenheit or [2] to convert into kelvin");
            }
            System.out.println("Type 0 to exit the program" + "\n" + "or");
        }
    }

    private double getCelsius() {
        System.out.println("Enter temperature in celsius");
        return Double.parseDouble(scanner.nextLine());
    }

    private List<Converter> getConverterList() {
        return serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private int getChoice(List<Converter> converterList) {
        printChoices(converterList);
        return Integer.parseInt(scanner.nextLine());
    }


    private void printChoices(List<Converter> converterList) {
        for (Converter c : converterList)
            System.out.println(c.information());
    }

    private void printAfterConvert(Converter converter, double celsius) {
        System.out.println("Result: " + converter.convert(celsius));
    }

}
