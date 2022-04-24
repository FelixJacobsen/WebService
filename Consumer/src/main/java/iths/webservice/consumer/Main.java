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
        while(true){
            double celsius = getCelsius();
            int option = getChoice(converterList);
            if(option == 0)
                break;
            Converter converter = converterList.get(option - 1);
            printAfterConvert(converter,celsius);
            System.out.println("Type 0 to exit the program" + "\n" + "or" );
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

    private int getChoice(List<Converter> converters) {
        printChoices(converters);
        return Integer.parseInt(scanner.nextLine());
    }


    private void printChoices(List<Converter> converters) {
       for(Converter c : converters){
           System.out.println(c.information());
       }
    }

    private void printAfterConvert(Converter converter, double celsius){
        System.out.println("Result: " + converter.convert(celsius));
    }

}
