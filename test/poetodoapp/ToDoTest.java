
package poetodoapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ymist
 */
Task Task1 = new Task("Create Login", "Mike Smith", "5", "To Do");
Task Task2 = new Task("Create add Feature","Edward Harrison","8", "Doing");

@test
public void testDisplayArray()
{
String expectedResults="";

expectedResults += "Task Name:\t" + "Create Login";
expectedResults += "Developer Details" + "Mike Smith";
expectedResults += "Duration" + 5;
expectedResults += "Task Status" + "To Do";

expectedResults += "Task Name:\t" + "Create add Feature";
expectedResults += "Developer Details" + "Edward Harrison";
expectedResults += "Duration" + 8;
expectedResults += "Task Status" + "Doing";

String actualResults= Task1.DisplayArray();
assertEquals(expectedResults.actualResults());
}
@test
public void testSearchArray()
{
boolean actualResults = Task2.SearchArray();
assertTrue(actualResults);


}

    
