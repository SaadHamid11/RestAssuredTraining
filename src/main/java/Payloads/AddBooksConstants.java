package Payloads;

public class AddBooksConstants {

    public static String getAddBookPayload(String bookName, String isbnCode, int aisle, String author){
        String payload = "{\n" +
                "\n" +
                "\"name\":\""+bookName+"\",\n" +
                "\"isbn\":\""+isbnCode+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+author+"\"\n" +
                "}\n";

        return payload;
    }
}
