package weatherstats;

/**
 *
 * @author t.j.butler2
 */
public class WeatherStats 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        WeatherStatsList myList = new WeatherStatsList();
        
        myList.addFront(new WeatherInfo(10, 20, 30));
        myList.addFront(new WeatherInfo(48, 26, 18));
        myList.addFront(new WeatherInfo(32, 24, 23));
        
        WeatherInfo temp;
        
        temp = myList.GetWeatherinfo(0);
        System.out.println(temp);
        temp = myList.GetWeatherinfo(2);
        System.out.println(temp);
        temp = myList.GetWeatherinfo(1);
        System.out.println(temp);
    }
    
}
