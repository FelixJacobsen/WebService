package iths.webservice.consumer;

import iths.webservice.convert.Converter;
import iths.webservice.convert.Designation;

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
                printDesignation(converter);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter 1 to convert into fahrenheit or 2 to convert into kelvin");

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
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
        printInformation(converterList);
        return Integer.parseInt(scanner.nextLine());
    }


    private void printInformation(List<Converter> converterList) {
        for (Converter c : converterList)
            System.out.println(c.information());
    }

    private void printAfterConvert(Converter converter, double celsius) {
        System.out.print("Result: " + converter.convert(celsius));
    }

    private void printDesignation(Converter converter) throws NoSuchMethodException {
        var annotation = converter.getClass().getMethod("convert", double.class).getAnnotation(Designation.class);
        if (annotation != null)
            System.out.println(annotation.value());
    }
}
