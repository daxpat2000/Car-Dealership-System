package dealership;
import java.util.ArrayList;

public class Filter{

    public static ArrayList<Car> filterByMake(ArrayList<Car> usedList, String make){
        ArrayList<Car> filtered = new ArrayList<Car>();
        for(int i = 0; i < usedList.size(); i++){
            if(usedList.get(i).getMake().equals(make))
                filtered.add(usedList.get(i));
        }
        return filtered;

    }

    public static ArrayList<Car> filterByPrice(ArrayList<Car> usedList, String minP, String maxP){
        ArrayList<Car> filtered = new ArrayList<Car>();
        for(int i = 0; i < usedList.size(); i++){
        	int currPrice = Integer.parseInt(usedList.get(i).getPrice());
            if(currPrice >= Integer.parseInt(minP) & currPrice <= Integer.parseInt(maxP))
                filtered.add(usedList.get(i));
        }
        return filtered;
    }

    public static ArrayList<Car> filterByYear(ArrayList<Car> usedList, String minYear){
        ArrayList<Car> filtered = new ArrayList<Car>();
        for(int i = 0; i < usedList.size(); i++){
            int year = Integer.parseInt(usedList.get(i).getyear());
            if(year >= Integer.parseInt(minYear))
                filtered.add(usedList.get(i));
        }
        return filtered;
    }

    public static ArrayList<Car> filterByColor(ArrayList<Car> usedList, String choice){
        ArrayList<Car> filtered = new ArrayList<Car>();
        for(int i = 0; i < usedList.size(); i++){
            if(usedList.get(i).getColor().equals(choice))
                filtered.add(usedList.get(i));
        }
        return filtered;
    }

}