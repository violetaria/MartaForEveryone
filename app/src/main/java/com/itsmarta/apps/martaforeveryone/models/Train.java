package com.itsmarta.apps.martaforeveryone.models;

import android.location.Location;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Train {

	private String Destination;
	private String Direction;
	private String EventTime;
	private String Line;
	private String NextArrival;
	private String Station;
	private String TrainId;
	private Integer WaitingSeconds;
    private Location location;

    public String getWaitingTime() {
        return WaitingTime;
    }

    public Location getLocation() {
        Location stationLocation = new Location(Station);
        switch(Station.toLowerCase()){
            case "bankhead station":
                stationLocation.setLatitude(33.772979);
                stationLocation.setLongitude(-84.428537);
                break;
            case "midtown station":
                stationLocation.setLatitude(33.780737);
                stationLocation.setLongitude(-84.386657);
                break;
            case "indian creek station":
                stationLocation.setLatitude(33.769212);
                stationLocation.setLongitude(-84.229255);
                break;
            case "garnett station":
                stationLocation.setLatitude(33.748938);
                stationLocation.setLongitude(-84.395513);
                break;
            case "college park station":
                stationLocation.setLatitude(33.6513813);
                stationLocation.setLongitude(-84.4470162);
                break;
            case "ashby station":
                stationLocation.setLatitude(33.756289);
                stationLocation.setLongitude(-84.41755599999999);
                break;
            case "five points station":
                stationLocation.setLatitude(33.754061);
                stationLocation.setLongitude(-84.391539);
                break;
            case "airport station":
                stationLocation.setLatitude(33.639975);
                stationLocation.setLongitude(-84.44403199999999);
                break;
            case "sandy springs station":
                stationLocation.setLatitude(33.9321044);
                stationLocation.setLongitude(-84.3513524);
                break;
            case "lindbergh station":
                stationLocation.setLatitude(33.823698);
                stationLocation.setLongitude(-84.369248);
                break;
            case "lakewood station":
                stationLocation.setLatitude(33.700649);
                stationLocation.setLongitude(-84.429541);
                break;
            case "chamblee station":
                stationLocation.setLatitude(33.8879695);
                stationLocation.setLongitude(-84.30468049999999);
                break;
            case "king memorial station":
                stationLocation.setLatitude(33.749468);
                stationLocation.setLongitude(-84.37601099999999);
                break;
            case "east lake station":
                stationLocation.setLatitude(33.765062);
                stationLocation.setLongitude(-84.31261099999999);
                break;
            case "vine city station":
                stationLocation.setLatitude(33.756612);
                stationLocation.setLongitude(-84.404348);
                break;
            case "buckhead station":
                stationLocation.setLatitude(33.847874);
                stationLocation.setLongitude(-84.367296);
                break;
            case "lenox station":
                stationLocation.setLatitude(33.845137);
                stationLocation.setLongitude(-84.357854);
                break;
            case "civic center station":
                stationLocation.setLatitude(33.766245);
                stationLocation.setLongitude(-84.38750399999999);
                break;
            case "arts center station":
                stationLocation.setLatitude(33.789283);
                stationLocation.setLongitude(-84.387125);
                break;
            case "west end station":
                stationLocation.setLatitude(33.73584);
                stationLocation.setLongitude(-84.412967);
                break;
            case "dunwoody station":
                stationLocation.setLatitude(33.9486029);
                stationLocation.setLongitude(-84.355848);
                break;
            case "omni dome station":
                stationLocation.setLatitude(33.7489954);
                stationLocation.setLongitude(-84.3879824);
                break;
            case "oakland city station":
                stationLocation.setLatitude(33.71726400000001);
                stationLocation.setLongitude(-84.42527899999999);
                break;
            case "east point station":
                stationLocation.setLatitude(33.676609);
                stationLocation.setLongitude(-84.440595);
                break;
            case "doraville station":
                stationLocation.setLatitude(33.9026881);
                stationLocation.setLongitude(-84.28025099999999);
                break;
            case "brookhaven station":
                stationLocation.setLatitude(33.859928);
                stationLocation.setLongitude(-84.33922);
                break;
            case "decatur station":
                stationLocation.setLatitude(33.774455);
                stationLocation.setLongitude(-84.297131);
                break;
            case "medical center station":
                stationLocation.setLatitude(33.9106263);
                stationLocation.setLongitude(-84.3513751);
                break;
            case "georgia state station":
                stationLocation.setLatitude(33.749732);
                stationLocation.setLongitude(-84.38569700000001);
                break;
            case "avondale station":
                stationLocation.setLatitude(33.77533);
                stationLocation.setLongitude(-84.280715);
                break;
            case "inman park station":
                stationLocation.setLatitude(33.757317);
                stationLocation.setLongitude(-84.35262);
                break;
            case "kensington station":
                stationLocation.setLatitude(33.772093);
                stationLocation.setLongitude(-84.252217);
                break;
            case "edgewood candler park station":
                stationLocation.setLatitude(33.761812);
                stationLocation.setLongitude(-84.340064);
                break;
            case "peachtree center station":
                stationLocation.setLatitude(33.759532);
                stationLocation.setLongitude(-84.387564);
                break;
            case "north ave station":
                stationLocation.setLatitude(33.771696);
                stationLocation.setLongitude(-84.387411);
                break;
            default:
                break;
        }
        return stationLocation;
    }

    public void setWaitingTime(String waitingTime) {
        WaitingTime = waitingTime;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public String getLine() {
        return Line;
    }

    public void setLine(String line) {
        Line = line;
    }

    public String getNextArrival() {
        return NextArrival;
    }

    public void setNextArrival(String nextArrival) {
        NextArrival = nextArrival;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }

    public String getTrainId() {
        return TrainId;
    }

    public void setTrainId(String trainId) {
        TrainId = trainId;
    }

    public Integer getWaitingSeconds() {
        return WaitingSeconds;
    }

    public void setWaitingSeconds(Integer waitingSeconds) {
        WaitingSeconds = waitingSeconds;
    }

    private String WaitingTime;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

//    {
//        "DESTINATION": "Indian Creek",
//            "DIRECTION": "E",
//            "EVENT_TIME": "10/29/2016 8:59:18 AM",
//            "LINE": "BLUE",
//            "NEXT_ARR": "08:59:28 AM",
//            "STATION": "EDGEWOOD CANDLER PARK STATION",
//            "TRAIN_ID": "101026",
//            "WAITING_SECONDS": "-11",
//            "WAITING_TIME": "Boarding"
//    }
    public static Train fromJSONObject(JSONObject jsonObject){
        Train train = new Train();
        try {
            train.Destination = jsonObject.getString("DESTINATION");
            train.Direction = jsonObject.getString("DIRECTION");
            train.EventTime = jsonObject.getString("EVENT_TIME");
            train.Line = jsonObject.getString("LINE");
            train.NextArrival = jsonObject.getString("NEXT_ARR");
            train.Station = jsonObject.getString("STATION");
            train.TrainId = jsonObject.getString("TRAIN_ID");
            train.WaitingSeconds = jsonObject.getInt("WAITING_SECONDS");
            train.WaitingTime = jsonObject.getString("WAITING_TIME");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return train;
    }

    public static ArrayList<Train> fromJSONArray(JSONArray jsonArray){
        ArrayList<Train> trains = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            try {
                trains.add(i,fromJSONObject(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return trains;
    }
}