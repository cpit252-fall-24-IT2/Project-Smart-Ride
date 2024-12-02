package org.example.Map;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;

public class SelectionAdapter extends MouseAdapter {
    private boolean dragging;
    private JXMapViewer viewer;
    private Point2D startPos = new Point2D.Double();
    private Point2D endPos = new Point2D.Double();
    private MyWaypoint waypoint = null;

    public SelectionAdapter(JXMapViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON3) // Check if the right mouse button is pressed
            return;

        startPos.setLocation(e.getX(), e.getY());
        endPos.setLocation(e.getX(), e.getY());

        dragging = true;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!dragging)
            return;

        endPos.setLocation(e.getX(), e.getY());

        viewer.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!dragging)
            return;

        if (e.getButton() != MouseEvent.BUTTON3) // Right mouse button must be released
            return;

        // Convert the pixel coordinates to GeoPosition for the WayPoint
        GeoPosition geoPos = viewer.convertPointToGeoPosition(e.getPoint());
        waypoint = new MyWaypoint("Waypoint", Color.RED, geoPos);

        dragging = false;

        // Repaint after finishing the dragging
        viewer.repaint();
    }

    // Get the waypoint created by the user on mouse release
    public MyWaypoint getWaypoint() {
        MyWaypoint tempWaypoint = waypoint;
        waypoint = null; // Reset the waypoint after returning it
        return tempWaypoint;
    }

    public void paint(Graphics g) {
        if (dragging) {

            g.setColor(Color.RED);
            int x = (int) Math.min(startPos.getX(), endPos.getX());
            int y = (int) Math.min(startPos.getY(), endPos.getY());
            int width = (int) Math.abs(startPos.getX() - endPos.getX());
            int height = (int) Math.abs(startPos.getY() - endPos.getY());

            g.drawRect(x, y, width, height);  // Example of a rectangle for visual feedback
        }
    }
}