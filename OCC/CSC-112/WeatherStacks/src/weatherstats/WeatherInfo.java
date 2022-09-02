package weatherstats;

/**
 *
 * @author t.j.butler2
 */
public class WeatherInfo 
{
    private double rain;
    private double sun;
    private double snow;

    public WeatherInfo(double rain, double sun, double snow) 
    {
        this.rain = rain;
        this.sun = sun;
        this.snow = snow;
    }
    
    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public double getSun() {
        return sun;
    }

    public void setSun(double sun) {
        this.sun = sun;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" + "rain: " + rain + ", sun: " + sun + ", snow: " + snow + '}';
    }
    
    
}
