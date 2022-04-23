package iths.webservice.consumer;

import iths.webservice.convert.Converter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    public static void main(String[] args) {

    }
}
