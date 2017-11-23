package teamvoy.com.mytask.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import teamvoy.com.mytask.modelSunriseSunset.AcceptedMessage;
import teamvoy.com.mytask.modelSunriseSunset.Results;

import java.io.IOException;

public class SunriseSunsetProcessor {

    public Results getSunriseSunsetFromCoordinates(Double lat, Double lng){
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.sunrise-sunset.org/json?lat="+
                    lat.toString()+
                    "&lng="+
                    lng.toString();
            String resultString =restTemplate.getForObject(url, String.class);
            AcceptedMessage result=null;
            try {
                result = new ObjectMapper().readValue(resultString, AcceptedMessage.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (result==null)
                return null;
            else if (!result.getStatus().equals("OK"))
                return null;
            else{
                return result.getResults();
            }
    }
}
