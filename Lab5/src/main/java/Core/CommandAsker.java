package Core;

import Data.Coordinates;
import Data.LocationFro;
import Data.LocationTo;
import Data.Route;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class CommandAsker {
    private final InputChecker inputChecker;

    public CommandAsker(InputChecker inputChecker) {
        this.inputChecker = inputChecker;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public Route createRoute(){
        Route newRoute = new Route();
        System.out.println("Creating a new route!!!");

        newRoute.setId(idAsker());
        newRoute.setName(nameAsker());
        newRoute.setCreationDate(creationDateAsker());
        newRoute.setCoordinates(coordinatesAsker());
        newRoute.setFrom(locationFromAsker());
        newRoute.setTo(locationToAsker());
        return newRoute;

    }

    private LocationTo locationToAsker() {
        System.out.println("Put in the location details");

        LocationTo to = new LocationTo();

        to.setX(toXAsker());
        to.setY(toYAsker());
        to.setZ(toZAsker());
        to.setName(toNameAsker());
        return to;
    }

    public Long toXAsker(){
        System.out.println("Insert x: ");
        long toX;
        toX = longAsker(Long.MIN_VALUE, Long.MAX_VALUE);
        return toX;
    }

    public  long toYAsker(){
        System.out.println("Insert y: ");
        long toY;
        toY = longAsker(Long.MIN_VALUE, Long.MAX_VALUE);
        return toY;
    }

    public Float toZAsker(){
        System.out.println("Insert z: ");
        float toZ;
        toZ = floatAsker(Float.MIN_VALUE, Float.MAX_VALUE);
        return toZ;
    }

    public String toNameAsker(){
        System.out.println("Insert destination: ");
        String str = scanner.nextLine();
        if(str.length() >573){
            System.out.println("No such place exists");
            return toNameAsker();
        }
        return  str;
    }

    private LocationFro locationFromAsker() {
        System.out.println("Put in the location details");

        LocationFro from = new LocationFro();

        from.setX(fromXAsker());
        from.setY(fromYAsker());
        from.setZ(fromZAsker());

        return from;
    }

    public float fromXAsker(){
        System.out.println("Insert x: ");
        float fromX;
        fromX = floatAsker(Float.MIN_VALUE, Float.MAX_VALUE);
        return fromX;
    }

    public  int fromYAsker(){
        System.out.println("Insert y: ");
        int fromY;
        fromY = intAsker(Integer.MIN_VALUE, Integer.MAX_VALUE);
        return fromY;
    }

    public int fromZAsker(){
        System.out.println("Insert z: ");
        int fromZ;
        fromZ = intAsker(Integer.MIN_VALUE, Integer.MAX_VALUE);
        return fromZ;
    }

    public float floatAsker(float min, float max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one float number: ");
            }
            else{
                float x;
                try {
                    x = Float.parseFloat(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an double number");
                }
            }
        }
    }

    public int intAsker(int min, int max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one int number: ");
            }
            else{
                int x;
                try {
                    x = Integer.parseInt(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an integer number");
                }
            }
        }
    }
    public long longAsker(long min, long max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one long number: ");
            }
            else{
                long x;
                try {
                    x = Integer.parseInt(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an long number");
                }
            }
        }
    }




    public int idAsker(){
        int newID = new Random().nextInt();
        if(CollectionManager.IDChecker.contains(newID) || newID <=0) {
            System.out.println("invalid id");
            return idAsker();
        }
        else {
            CollectionManager.IDChecker.add(newID);
            System.out.println("ID = " +newID + "has been generated");
            return newID;
        }
    }

    public String nameAsker(){
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }
    public LocalDateTime creationDateAsker(){
        System.out.println("Creation date is automatically generated");
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        return date;
    }

    public Coordinates coordinatesAsker(){
        System.out.println("Insert Coordinates: ");
        while(true){
            System.out.println("Insert the x and y respectively");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 2){
                System.out.println("please insert numbers (x and y respectively)");
            }
            else{
                if(!inputChecker.integerValidChecker(inputNumber[0],  Integer.MIN_VALUE, 537)) continue;
                if(!inputChecker.longValidCheck(inputNumber[1], Long.MIN_VALUE, (long) 858)) continue;
                Integer x = Integer.parseInt(inputNumber[0]);
                Long y = Long.parseLong(inputNumber[1]);
                return new Coordinates(x, y);
            }
        }
    }




}
