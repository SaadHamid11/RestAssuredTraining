package Basics;

import Payloads.AddPlaceConstants;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonReadDemo {


    @Test
    public void JsonReadTest(){
        JsonPath js = new JsonPath(AddPlaceConstants.getCoursePayload());

        int courseCount = js.getInt("courses.size()");
        System.out.println("Total number of Courses: "+courseCount);

        System.out.println("Purchase amount: "+js.getInt("dashboard.purchaseAmount"));

        System.out.println("First course title: "+js.getString("courses[0].title"));

        //Printing all courses titles available in json along with respective prices

        for(int i = 0 ; i < courseCount ; i++){
            System.out.println("Course name: "+js.get("courses["+i+"].title")+ " - Course Price: "+js.getInt("courses["+i+"].price"));

        }


        //Print number of copies sold by RPA course
        for(int i=0 ; i < courseCount; i++){
            if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")){
                System.out.println("Total copies sold of RPA course: "+js.getInt("courses["+i+"].copies"));
                break;
            }
        }

        //Verify if Sum of all Course prices matches with Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");

        int sumOfCoursePrice = 0;

        for(int i = 0 ; i < courseCount ; i++){
            int copies = js.getInt("courses["+i+"].copies");
            int price = js.getInt("courses["+i+"].price");
            sumOfCoursePrice += (copies * price);
        }
        System.out.println("Total sum of all courses: "+sumOfCoursePrice);
        Assert.assertEquals(purchaseAmount, sumOfCoursePrice);
    }

}
