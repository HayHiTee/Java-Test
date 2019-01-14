/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Hayhitee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final String OPERATION_FIND_CITY = "CITY";
    private static final String OPERATION_FIND_ID = "ID";

    public static final char FIRST_FORMAT = '1';
    public static final char SECOND_FORMAT = '2';

    public static final String FIRST_FORMAT_SPLIT_STRING = ",";
    public static final String SECOND_FORMAT_SPLIT_STRING = " ; ";

    private static final HashMap<String, ArrayList<String>> cities = new HashMap<String, ArrayList<String>>();

    private static final HashMap<String, ArrayList<String>> person_ids = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {
        String filename = args[0];
        String operationType = args[1];
        if (operationType.equals(OPERATION_FIND_CITY)) {
            String cityName = args[2];
            readInput(filename, operationType);
            printPeopleFromCity(cityName);

        } else if (operationType.equals(OPERATION_FIND_ID)) {
            String id = args[2];
            readInput(filename, operationType);
            printCityFromPerson(id);

        } else {
            System.out.println(operationType);
            System.out.println(args);
            System.out.println("Invalid command");
        }
    }

    public static void readInput(String filename, String query_type) {
        // TODO code application logic here

        BufferedReader br = null;
        FileReader fr = null;
        String[] userData = new String[5];
        char currentFormat = FIRST_FORMAT;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                if (currentLine.charAt(0) == 'F') {
                    currentFormat = currentLine.charAt(1);

                } else {
                    userData = formatInput(currentFormat, currentLine);
                    if (query_type.equals("CITY")) {
                        addToCity(userData);
                    } else {
                        addToPerson(userData);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String[] formatInput(char format, String line) {
        line = line.substring(2);
        String splitString;
        if (format == FIRST_FORMAT) {
            splitString = FIRST_FORMAT_SPLIT_STRING;
        } else {
            splitString = SECOND_FORMAT_SPLIT_STRING;
        }
        String[] userData = line.split(splitString);
        userData[2] = userData[2].replace("-", "");
        return userData;

    }

    public static void printPeopleFromCity(String city_name) {
        if (cities.containsKey(city_name)) {
//            ArrayList<String> results = cities.get(city_id);
            for (String city : cities.get(city_name)) {
                System.out.println(city);
            }
//            System.out.println(results);
        } else {
            System.out.println(city_name);
        }
    }

    public static void addToCity(String[] userData) {
        ArrayList<String> persons = new ArrayList<String>();
        String city_name = userData[1];
        String person = userData[0] + "," + userData[2];

        if (cities.containsKey(city_name) && !cities.get(city_name).contains(person)) {
            cities.get(city_name).add(person);
        } else {
            persons.add(person);
            cities.put(city_name, persons);
        }


    }

    public static void printCityFromPerson(String person_id) {
        if (person_ids.containsKey(person_id)) {
//            System.out.println(person_ids.get(person_id));
            for (String person : person_ids.get(person_id)) {
                System.out.println(person);
            }
        }

    }

    public static void addToPerson(String[] userData) {
        ArrayList<String> cities = new ArrayList<String>();
        String person_id = userData[2];
        String city_name = userData[1];

        if (person_ids.containsKey(person_id) && !person_ids.get(person_id).contains(city_name)) {
            person_ids.get(person_id).add(city_name);
        } else {
            cities.add(city_name);
            person_ids.put(person_id, cities);
        }
    }





}