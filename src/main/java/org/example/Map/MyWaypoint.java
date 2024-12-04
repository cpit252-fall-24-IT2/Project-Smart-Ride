package org.example.Map;

import java.awt.Color;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MyWaypoint extends DefaultWaypoint {
    private String label;
    private Color color;

    public MyWaypoint(String label, Color color, GeoPosition coord) {
        super(coord);
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "MyWaypoint{" + "label='" + label + '\'' +
                ", color=" + color + "Position"+ super.getPosition()+ '}';
    }
}