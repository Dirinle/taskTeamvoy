package teamvoy.com.mytask.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import teamvoy.com.mytask.modelGoogle.MessageGoogle;
import teamvoy.com.mytask.modelSunriseSunset.AcceptedMessage;
import teamvoy.com.mytask.modelSunriseSunset.Results;

import java.io.IOException;

public class GooglePlaceProcessor {
    public Results getSunriseSunsetFromPlace(String place){
        RestTemplate restTemplate= new RestTemplate();
        String googleAPIkey="AIzaSyDrHL9rqX1C7q5C58PfbefMuR9sGEkO4Q4";
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                place +
                "&key="+googleAPIkey;
        String resultString =restTemplate.getForObject(url, String.class);
        MessageGoogle result=null;
        try {
            result = new ObjectMapper().readValue(resultString, MessageGoogle.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result==null)
            return null;
        if (result.getStatus().equals("ZERO_RESULTS"))
            return null;
        Double lat= Double.parseDouble(result.getResults().get(0).getGeometry().getLocation().getLat());
        Double lng= Double.parseDouble(result.getResults().get(0).getGeometry().getLocation().getLng());
        return new SunriseSunsetProcessor().getSunriseSunsetFromCoordinates(lat, lng);
    }
}
