import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private ConsultasDeAPI consultasDeAPI;
    private Scanner scanner;
    private Gson gson;
    private Map<String, String> currencies;

    public Menu() {
        this.consultasDeAPI = new ConsultasDeAPI();
        this.scanner = new Scanner(System.in);
        this.gson = new GsonBuilder().setPrettyPrinting().create(); // Configurar Gson con pretty printing
        this.currencies = new HashMap<>();
        initializeCurrencies();
    }

    private void initializeCurrencies() {
        currencies.put("AED", "UAE Dirham");
        currencies.put("AFN", "Afghan Afghani");
        currencies.put("ALL", "Albanian Lek");
        currencies.put("AMD", "Armenian Dram");
        currencies.put("ANG", "Netherlands Antillian Guilder");
        currencies.put("AOA", "Angolan Kwanza");
        currencies.put("ARS", "Argentine Peso");
        currencies.put("AUD", "Australian Dollar");
        currencies.put("AWG", "Aruban Florin");
        currencies.put("AZN", "Azerbaijani Manat");
        currencies.put("BAM", "Bosnia and Herzegovina Mark");
        currencies.put("BBD", "Barbados Dollar");
        currencies.put("BDT", "Bangladeshi Taka");
        currencies.put("BGN", "Bulgarian Lev");
        currencies.put("BHD", "Bahraini Dinar");
        currencies.put("BIF", "Burundian Franc");
        currencies.put("BMD", "Bermudian Dollar");
        currencies.put("BND", "Brunei Dollar");
        currencies.put("BOB", "Bolivian Boliviano");
        currencies.put("BRL", "Brazilian Real");
        currencies.put("BSD", "Bahamian Dollar");
        currencies.put("BTN", "Bhutanese Ngultrum");
        currencies.put("BWP", "Botswana Pula");
        currencies.put("BYN", "Belarusian Ruble");
        currencies.put("BZD", "Belize Dollar");
        currencies.put("CAD", "Canadian Dollar");
        currencies.put("CDF", "Congolese Franc");
        currencies.put("CHF", "Swiss Franc");
        currencies.put("CLP", "Chilean Peso");
        currencies.put("CNY", "Chinese Renminbi");
        currencies.put("COP", "Colombian Peso");
        currencies.put("CRC", "Costa Rican Colon");
        currencies.put("CUP", "Cuban Peso");
        currencies.put("CVE", "Cape Verdean Escudo");
        currencies.put("CZK", "Czech Koruna");
        currencies.put("DJF", "Djiboutian Franc");
        currencies.put("DKK", "Danish Krone");
        currencies.put("DOP", "Dominican Peso");
        currencies.put("DZD", "Algerian Dinar");
        currencies.put("EGP", "Egyptian Pound");
        currencies.put("ERN", "Eritrean Nakfa");
        currencies.put("ETB", "Ethiopian Birr");
        currencies.put("EUR", "Euro");
        currencies.put("FJD", "Fiji Dollar");
        currencies.put("FKP", "Falkland Islands Pound");
        currencies.put("FOK", "Faroese Króna");
        currencies.put("GBP", "Pound Sterling");
        currencies.put("GEL", "Georgian Lari");
        currencies.put("GGP", "Guernsey Pound");
        currencies.put("GHS", "Ghanaian Cedi");
        currencies.put("GIP", "Gibraltar Pound");
        currencies.put("GMD", "Gambian Dalasi");
        currencies.put("GNF", "Guinean Franc");
        currencies.put("GTQ", "Guatemalan Quetzal");
        currencies.put("GYD", "Guyanese Dollar");
        currencies.put("HKD", "Hong Kong Dollar");
        currencies.put("HNL", "Honduran Lempira");
        currencies.put("HRK", "Croatian Kuna");
        currencies.put("HTG", "Haitian Gourde");
        currencies.put("HUF", "Hungarian Forint");
        currencies.put("IDR", "Indonesian Rupiah");
        currencies.put("ILS", "Israeli New Shekel");
        currencies.put("IMP", "Manx Pound");
        currencies.put("INR", "Indian Rupee");
        currencies.put("IQD", "Iraqi Dinar");
        currencies.put("IRR", "Iranian Rial");
        currencies.put("ISK", "Icelandic Króna");
        currencies.put("JEP", "Jersey Pound");
        currencies.put("JMD", "Jamaican Dollar");
        currencies.put("JOD", "Jordanian Dinar");
        currencies.put("JPY", "Japanese Yen");
        currencies.put("KES", "Kenyan Shilling");
        currencies.put("KGS", "Kyrgyzstani Som");
        currencies.put("KHR", "Cambodian Riel");
        currencies.put("KID", "Kiribati Dollar");
        currencies.put("KMF", "Comorian Franc");
        currencies.put("KRW", "South Korean Won");
        currencies.put("KWD", "Kuwaiti Dinar");
        currencies.put("KYD", "Cayman Islands Dollar");
        currencies.put("KZT", "Kazakhstani Tenge");
        currencies.put("LAK", "Lao Kip");
        currencies.put("LBP", "Lebanese Pound");
        currencies.put("LKR", "Sri Lanka Rupee");
        currencies.put("LRD", "Liberian Dollar");
        currencies.put("LSL", "Lesotho Loti");
        currencies.put("LYD", "Libyan Dinar");
        currencies.put("MAD", "Moroccan Dirham");
        currencies.put("MDL", "Moldovan Leu");
        currencies.put("MGA", "Malagasy Ariary");
        currencies.put("MKD", "Macedonian Denar");
        currencies.put("MMK", "Burmese Kyat");
        currencies.put("MNT", "Mongolian Tögrög");
        currencies.put("MOP", "Macanese Pataca");
        currencies.put("MRU", "Mauritanian Ouguiya");
        currencies.put("MUR", "Mauritian Rupee");
        currencies.put("MVR", "Maldivian Rufiyaa");
        currencies.put("MWK", "Malawian Kwacha");
        currencies.put("MXN", "Mexican Peso");
        currencies.put("MYR", "Malaysian Ringgit");
        currencies.put("MZN", "Mozambican Metical");
        currencies.put("NAD", "Namibian Dollar");
        currencies.put("NGN", "Nigerian Naira");
        currencies.put("NIO", "Nicaraguan Córdoba");
        currencies.put("NOK", "Norwegian Krone");
        currencies.put("NPR", "Nepalese Rupee");
        currencies.put("NZD", "New Zealand Dollar");
        currencies.put("OMR", "Omani Rial");
        currencies.put("PAB", "Panamanian Balboa");
        currencies.put("PEN", "Peruvian Sol");
        currencies.put("PGK", "Papua New Guinean Kina");
        currencies.put("PHP", "Philippine Peso");
        currencies.put("PKR", "Pakistani Rupee");
        currencies.put("PLN", "Polish Złoty");
        currencies.put("PYG", "Paraguayan Guaraní");
        currencies.put("QAR", "Qatari Riyal");
        currencies.put("RON", "Romanian Leu");
        currencies.put("RSD", "Serbian Dinar");
        currencies.put("RUB", "Russian Ruble");
        currencies.put("RWF", "Rwandan Franc");
        currencies.put("SAR", "Saudi Riyal");
        currencies.put("SBD", "Solomon Islands Dollar");
        currencies.put("SCR", "Seychellois Rupee");
        currencies.put("SDG", "Sudanese Pound");
        currencies.put("SEK", "Swedish Krona");
        currencies.put("SGD", "Singapore Dollar");
        currencies.put("SHP", "Saint Helena Pound");
        currencies.put("SLE", "Sierra Leonean Leone");
        currencies.put("SOS", "Somali Shilling");
        currencies.put("SRD", "Surinamese Dollar");
        currencies.put("SSP", "South Sudanese Pound");
        currencies.put("STN", "São Tomé and Príncipe Dobra");
        currencies.put("SYP", "Syrian Pound");
        currencies.put("SZL", "Eswatini Lilangeni");
        currencies.put("THB", "Thai Baht");
        currencies.put("TJS", "Tajikistani Somoni");
        currencies.put("TMT", "Turkmenistan Manat");
        currencies.put("TND", "Tunisian Dinar");
        currencies.put("TOP", "Tongan Paʻanga");
        currencies.put("TRY", "Turkish Lira");
        currencies.put("TTD", "Trinidad and Tobago Dollar");
        currencies.put("TVD", "Tuvaluan Dollar");
        currencies.put("TWD", "New Taiwan Dollar");
        currencies.put("TZS", "Tanzanian Shilling");
        currencies.put("UAH", "Ukrainian Hryvnia");
        currencies.put("UGX", "Ugandan Shilling");
        currencies.put("USD", "United States Dollar");
        currencies.put("UYU", "Uruguayan Peso");
        currencies.put("UZS", "Uzbekistani Som");
        currencies.put("VES", "Venezuelan Bolívar Soberano");
        currencies.put("VND", "Vietnamese Đồng");
        currencies.put("VUV", "Vanuatu Vatu");
        currencies.put("WST", "Samoan Tālā");
        currencies.put("XAF", "Central African CFA Franc");
        currencies.put("XCD", "East Caribbean Dollar");
        currencies.put("XDR", "Special Drawing Rights");
        currencies.put("XOF", "West African CFA Franc");
        currencies.put("XPF", "CFP Franc");
        currencies.put("YER", "Yemeni Rial");
        currencies.put("ZAR", "South African Rand");
        currencies.put("ZMW", "Zambian Kwacha");
        currencies.put("ZWL", "Zimbabwean Dollar");
    }

    public void mostrarMenu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    convertirMoneda();
                    break;
                case 2:
                    consultarMonedasDisponibles();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }

    private void mostrarOpciones() {
        System.out.println("\n==== Menú ====");
        System.out.println("1. Convertir moneda");
        System.out.println("2. Consultar lista de monedas disponibles");
        System.out.println("9. Salir");
        System.out.println("Ingrese su opción:");
    }

    private void convertirMoneda() {
        System.out.println("Ingrese la moneda de origen (por ejemplo, AUD):");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la moneda de destino (por ejemplo, USD):");
        String monedaDestino = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese el valor a convertir:");
        double valorAConvertir = scanner.nextDouble();

        double valorConvertido = 0.0;

        if (monedaOrigen.equals(monedaDestino)) {
            System.out.println("Las monedas de origen y destino son las mismas. No se requiere conversión.");
            valorConvertido = valorAConvertir;
            guardarConversion(monedaOrigen, monedaDestino, valorAConvertir, valorConvertido);
        } else {
            double tasaDeCambio = consultasDeAPI.obtenerTasaDeCambio(monedaOrigen, monedaDestino);
            if (tasaDeCambio != 0.0) {
                valorConvertido = valorAConvertir * tasaDeCambio;
                System.out.printf("%.2f %s equivale a %.2f %s%n", valorAConvertir, monedaOrigen, valorConvertido, monedaDestino);
                guardarConversion(monedaOrigen, monedaDestino, valorAConvertir, valorConvertido);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio para " + monedaOrigen + " a " + monedaDestino);
                guardarError("Error al obtener la tasa de cambio para " + monedaOrigen + " a " + monedaDestino);
            }
        }
    }

    private void consultarMonedasDisponibles() {
        System.out.println("Lista de monedas disponibles:");
        currencies.forEach((key, value) -> {
            System.out.printf("%s: %s%n", key, value);
        });
    }

    private void guardarConversion(String monedaOrigen, String monedaDestino, double valorAConvertir, double valorConvertido) {
        Map<String, Object> conversion = new HashMap<>();
        conversion.put("monedaOrigen", monedaOrigen);
        conversion.put("monedaDestino", monedaDestino);
        conversion.put("valorAConvertir", valorAConvertir);
        conversion.put("valorConvertido", valorConvertido);

        String json = gson.toJson(conversion); // Usar el Gson configurado con pretty printing

        try (FileWriter file = new FileWriter("conversiones.json", true)) {
            file.write(json + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la conversión: " + e.getMessage());
        }
    }

    private void guardarError(String mensaje) {
        try (FileWriter file = new FileWriter("errores.txt", true)) {
            file.write(mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el mensaje de error: " + e.getMessage());
        }
    }
}