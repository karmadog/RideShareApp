package kapaunmtcarmel.rides;

import android.net.Uri;

/**
 * Created by karma on 2/25/2018.
 */

public class RideRequest {
    String riderName;
    int day;
    int month;
    String destinationAddress;
    String photoUrl;

    RideRequest(String userName, int requestDay, int requestMonth, String address, String photo){
        riderName = userName;
        day = requestDay;
        month = requestMonth;
        destinationAddress = address;
        photoUrl = photo;
    }

    public void setRiderName(String userName){
        riderName = userName;
    }

    public void setDay(int requestDay){
        day = requestDay;
    }

    public void setMonth(int requestMonth){
        month = requestMonth;
    }

    public void setDestinationAddress(String address){
        destinationAddress = address;
    }

    public void setPhotoUrl(String photo){ photoUrl = photo; }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public String getDestinationAddress(){
        return destinationAddress;
    }

    public String getPhotoUrl(){ return photoUrl; }
}
