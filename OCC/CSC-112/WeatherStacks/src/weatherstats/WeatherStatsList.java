package weatherstats;

import linkedlistsadt.LinkedListsADT;
import linkedlistsadt.Node;

/**
 *
 * @author t.j.butler2
 */
public class WeatherStatsList extends LinkedListsADT<WeatherInfo>
{
    public WeatherInfo GetWeatherinfo(int item)
    {
        WeatherInfo temp = null;
        
        if(item <= size && item >= 0)
        {
            Node<WeatherInfo> current = front;

            for (int count = 0; count < item; count++) 
            {
                current = current.getNext();
            }
            
            temp = current.getValue();
        }
        
        return temp;
    }
}
