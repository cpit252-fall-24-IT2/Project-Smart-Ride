package org.example;

import java.util.List;

public interface MapService {
    String getCoordinates(String address);
    String getAddress(double latitude, double longitude);
    List<String> findNearbyPlaces(double latitude, double longitude, String placeType);
}