//import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainTest {
    private static final Main main = new Main();
    public static final String FIRST_FORMAT_SPLIT_STRING = ",";
    public static final String SECOND_FORMAT_SPLIT_STRING = " ; ";
    private static final HashMap<String, ArrayList<String>> cities = new HashMap();

    private static final HashMap<String, ArrayList<String>> person_ids = new HashMap();


    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void Testmain() throws ArrayIndexOutOfBoundsException{
        String [] args = new String[0];
        String filename = args[0];
        String operationType = args[1];
        String id = args[2];
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void TestreadInput() throws IOException {
        String filename =  "";
        BufferedReader br = null;
        FileReader fr = null;
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
    }

    @Test(expectedExceptions = StringIndexOutOfBoundsException.class)
    public void TestformatInput() throws StringIndexOutOfBoundsException{
        String line = "";
        line = line.substring(2);

        String line_final_one = "D Russell Pope ; CARTAGENA ; 69429384-C";
        String line_final_two = "D Marta Mendez,LAS VEGAS,17200667W ";
        String[] userData_one = line_final_one.split(FIRST_FORMAT_SPLIT_STRING);
        String[] userData_two = line_final_two.split(SECOND_FORMAT_SPLIT_STRING);


        assertArrayEquals(userData_one, main.formatInput('1',line_final_one));

        assertArrayEquals(userData_two, main.formatInput('2',line_final_two));




    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void TestaddToPerson() throws ArrayIndexOutOfBoundsException{
        String [] userData = new String[0];
        String person_id = userData[2];
        String city_name = userData[1];

    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void TestaddToCity() throws ArrayIndexOutOfBoundsException{
        String [] userData = new String[0];
        String person_id = userData[0];
        String city_name = userData[1];

    }

    @Test
    public void TestprintPeopleFromCity() {
        cities.get("");
    }

    @Test
    public void TestprintCityFromPerson() {
        person_ids.get("");
    }


}