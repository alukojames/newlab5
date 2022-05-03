package Core;

import Data.Route;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionManager {
    private HashSet<Route> setRoute = new HashSet<>();
    public static HashSet<Integer> IDChecker = new HashSet<>();
    private final LocalDateTime creationDate = LocalDateTime.now();
    public void readInputFromJSONFile(String InputFileName){
        System.out.println(InputFileName);
        setRoute =  FileParser.parse(InputFileName);
    }

    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }
    public int size(){
        return setRoute.size();
    }
    public void PrintCollection(){
        setRoute.forEach(p ->
                System.out.println(p.toString()));
    }

    public void add(Route R){
        setRoute.add(R);
    }
    public void addIfMax(Route P){
        boolean judge = true;
        for (Route product : setRoute) {
            if (P.compareTo(product) < 0) {
                judge = false;
            }
        }
        if (judge) {
            setRoute.add(P);
        }
    }

    @SuppressWarnings("unchecked")
    public void save(String filename){
        JSONArray RouteSet = new JSONArray();
        for (Route route : setRoute){

            System.out.println(setRoute.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", route.getId());
            jsonObject.put("name", route.getName());

            //write coordinates to file
            JSONObject coordinatesObj = new JSONObject();
            coordinatesObj.put("cx", route.getCoordinates().getX());
            coordinatesObj.put("cy", route.getCoordinates().getY());
            jsonObject.put("coordinates", coordinatesObj);

            //Write time
            LocalDateTime date = route.getCreationDate();
            DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE;
            String stringDate = date.format(dateFormat);
            jsonObject.put("creationDate", stringDate);

            //write location from
            JSONObject fromObj = new JSONObject();
            fromObj.put("fromX", route.getFrom().getX());
            fromObj.put("fromY", route.getFrom().getY());
            fromObj.put("fromZ", route.getFrom().getZ());
            jsonObject.put("LocationFrom", fromObj);

            //write location to
            JSONObject toObj = new JSONObject();
            toObj.put("toX", route.getTo().getX());
            toObj.put("toY", route.getTo().getY());
            toObj.put("toZ", route.getTo().getZ());
            toObj.put("toName", route.getTo().getName());
            jsonObject.put("LocationTo", toObj);

            //set distance
            jsonObject.put("distance", route.getDistance());

            RouteSet.add(jsonObject);


        }
        try{
            FileOutputStream outputStream = new FileOutputStream(filename);
            System.out.println("using file output stream");
            String s = RouteSet.toJSONString();
            byte[] bytesArray = s.getBytes();
            outputStream.write(bytesArray);
            outputStream.flush();
            outputStream.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        setRoute.clear();
    }

    public boolean removeById(int id) {
        boolean flag = false;
        for(Iterator<Route> iterator = setRoute.iterator(); iterator.hasNext();){
            Route route = iterator.next();
            if(route.getId()==id){
                flag = true;
                iterator.remove();
            }
        }
        return !flag;
    }

    public boolean removeGreater(Integer input) {
        setRoute.removeIf(r -> r.compareTo(input) > 0);
        System.out.println("The greater route has been deleted");
        return true;
    }

    public boolean printUniqueDistance() {
        for(Route r: setRoute){
            System.out.println(r.getName() + " " + r.getDistance());
        }
        return true;
    }

    public ArrayList<Integer> printFieldAscendingDistance() {
        ArrayList<Integer> routeSorted = new ArrayList<>();
       setRoute.forEach(route -> routeSorted.add(route.getDistance()));
        System.out.println(routeSorted);
        return routeSorted;
    }

}