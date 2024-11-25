package org.example;

import java.awt.*;
import java.util.List;

public interface MapService {
    String getCoordinates(String address);
    String getAddress(double latitude, double longitude);
    List<String> findNearbyPlaces(double latitude, double longitude, String placeType);
    Component displayMap(double latitude, double longitude, int zoomLevel);
    Component showCurrentLocation();
}