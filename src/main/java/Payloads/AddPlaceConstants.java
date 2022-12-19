package Payloads;

public class AddPlaceConstants {

    private static String addPlacePayload ="{\n" +
            "  \"location\": {\n" +
            "    \"lat\": -38.383494,\n" +
            "    \"lng\": 33.427362\n" +
            "  },\n" +
            "  \"accuracy\": 50,\n" +
            "  \"name\": \"Test house\",\n" +
            "  \"phone_number\": \"(+92) 304 444 0481\",\n" +
            "  \"address\": \"181, layout, cohen 09\",\n" +
            "  \"types\": [\n" +
            "    \"shoe park\",\n" +
            "    \"shop\"\n" +
            "  ],\n" +
            "  \"website\": \"http://google.com\",\n" +
            "  \"language\": \"French-IN\"\n" +
            "}\n";


    private static String coursePayload ="{\n" +
            "\n" +
            "\"dashboard\": {\n" +
            "\n" +
            "\"purchaseAmount\": 910,\n" +
            "\n" +
            "\"website\": \"rahulshettyacademy.com\"\n" +
            "\n" +
            "},\n" +
            "\n" +
            "\"courses\": [\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Selenium Python\",\n" +
            "\n" +
            "\"price\": 50,\n" +
            "\n" +
            "\"copies\": 6\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Cypress\",\n" +
            "\n" +
            "\"price\": 40,\n" +
            "\n" +
            "\"copies\": 4\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"RPA\",\n" +
            "\n" +
            "\"price\": 45,\n" +
            "\n" +
            "\"copies\": 10\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]\n" +
            "\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "1. Print No of courses returned by API\n" +
            "\n" +
            "2.Print Purchase Amount\n" +
            "\n" +
            "3. Print Title of the first course\n" +
            "\n" +
            "4. Print All course titles and their respective Prices\n" +
            "\n" +
            "5. Print no of copies sold by RPA Course\n" +
            "\n" +
            "6. Verify if Sum of all Course prices matches with Purchase Amount\n" +
            "\n";


    public static String getAddPlacePayload(){
        return addPlacePayload;
    }

    public static String getUpdatePlacePayload(String placeId){
        return "{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\"80 winter walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }


    public static String getCoursePayload(){
        return coursePayload;
    }
}
