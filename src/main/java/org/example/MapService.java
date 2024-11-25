package org.example;

public interface MapService {

    void addMarker(double lat, double lon, String label);

    void zoomIn();

    void zoomOut();

    void centerMap(double lat, double lon);
}