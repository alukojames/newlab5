package Core;

import Data.Coordinates;
import Data.LocationFro;
import Data.LocationTo;
import Data.Route;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.HashSet;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileParser {

    public static HashSet<Route> parse(String InputFileName){
        HashSet<Route> collectionInput= new HashSet<>();
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(InputFileName)){
            Object obj = jsonParser.parse(reader);
            JSONArray routeSet = (JSONArray) obj;
            collectionInput = saveIntoCollection(routeSet);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return collectionInput;
    }

    private static HashSet<Route> saveIntoCollection(JSONArray routeSet) {
        HashSet<Route> HS = new HashSet<>();
        routeSet.forEach(r -> {
            try {
                HS.add(convertJsonObjIntoRoute((JSONObject) r));
            } catch (java.text.ParseException e){
                e.printStackTrace();
            }
        });
        return HS;
    }
    /**
     * This method convert JsonObj to Person
     * @return Product which is converted from JsonObject
     * @throws java.text.ParseException throw if occurs error
     */

    private static Route convertJsonObjIntoRoute(JSONObject jsonObject) throws java.text.ParseException {
        Route r = new Route();

        //set ID (generates new ID)
        Integer newID = (Integer) jsonObject.get("id");
        if(CollectionManager.IDChecker.contains(newID)){
            System.out.println("ID is duplicate, please insert valid input!");
        }
        else{
            CollectionManager.IDChecker.add(newID);
            r.setId(newID);
        }

        //set route name
        r.setName((String) jsonObject.get("name"));


        JSONObject coordinatesObj = (JSONObject) jsonObject.get("coordinates");
        r.setCoordinates(new Coordinates(
                (Integer) coordinatesObj.get("cx"), (long) coordinatesObj.get("cy")
        ));

         /*
           parse String to Date
        */

        //date in String
        String stringDate = (String)jsonObject.get("creationDate");

        //build formatter and set date
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime date = LocalDateTime.parse(stringDate, formatter);
        r.setCreationDate(date);

        //set LocationFrom
        LocationFro from = new LocationFro();
        JSONObject fromObj = (JSONObject)jsonObject.get("LocationFrom");
        from.setX((float) fromObj.get("fromX"));
        from.setY((int) fromObj.get("fromY"));
        from.setZ((int) fromObj.get("fromZ"));

        //set LocationTo
        LocationTo to = new LocationTo();
        JSONObject toObj = (JSONObject)jsonObject.get("LocationTo");
        to.setX((Long) toObj.get("toX"));
        to.setY((long) toObj.get("toY"));
        to.setZ((Float) toObj.get("toZ"));
        to.setName((String) toObj.get("toName"));

        //set distance
        r.setDistance((int) jsonObject.get("distance"));

        return r;
    }


}
