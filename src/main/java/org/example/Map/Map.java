package org.example.Map;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

public class Map {

    private JXMapViewer mapViewer;
    private SelectionAdapter selectionAdapter;

    // Initializes the map viewer
    public void createMapViewer() {
        mapViewer = new JXMapViewer();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);
        tileFactory.setThreadPoolSize(8);  // Use 8 threads to load tiles
    }

    // Configures the map viewer
    public void configureMapViewer() {
        mapViewer.setZoom(7);  // Set zoom level
        mapViewer.setAddressLocation(new GeoPosition(21.5, 39.2));  // Set focus to  Jeddah
    }

    // Adds mouse and key listeners to the map
    public void addInteractions() {
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Add selection listener
        selectionAdapter = new SelectionAdapter(mapViewer);
        mapViewer.addMouseListener(selectionAdapter);
        mapViewer.addMouseMotionListener(selectionAdapter);
    }

    // Creates the JFrame window and adds the map viewer
    public JFrame setupWindow(String FrameTitle) {
        JFrame frame = new JFrame(FrameTitle);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    // Catches the waypoint
    public MyWaypoint runWaypointCatcher() {
        while (true) {
            MyWaypoint waypoint = selectionAdapter.getWaypoint();
            if (waypoint != null) {
                System.out.println(waypoint);
                return waypoint;
            }
        }
    }
}

