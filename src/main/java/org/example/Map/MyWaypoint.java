package org.example.Map;

import java.awt.Color;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MyWaypoint extends DefaultWaypoint
{
    private final String label;
    private final Color color;

    public MyWaypoint(String label, Color color, GeoPosition coord)
    {
        super(coord);
        this.label = label;
        this.color = color;
    }

    public String getLabel()
    {
        return label;
    }

    public Color getColor()
    {
        return color;
    }

}