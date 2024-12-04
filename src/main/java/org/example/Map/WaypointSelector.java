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

public class WaypointSelector {
    MyWaypoint waypoint;

    public WaypointSelector(String title) {
       createMapViewer(title);
    }

    // Initializes the map viewer
    private void createMapViewer(String title) {
        JXMapViewer mapViewer = new JXMapViewer();

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        // Use 8 threads in parallel to load the tiles
        tileFactory.setThreadPoolSize(8);

        // Set the focus
        mapViewer.setZoom(7);
        mapViewer.setAddressLocation(new GeoPosition(21.5, 39.2));

        // Add interactions
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Add a selection
        SelectionAdapter selectionAdapter = new SelectionAdapter(mapViewer);
        mapViewer.addMouseListener(selectionAdapter);
        mapViewer.addMouseMotionListener(selectionAdapter);

        // Display the viewer in a JFrame
        JFrame frame = new JFrame(title);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //Waypoint Catcher
        while (true){
            waypoint=selectionAdapter.getWaypoint();
            if (waypoint!=null){
                selectionAdapter.WaypointCler();
                break;
            }
        }
        frame.dispose();
    }

    public MyWaypoint getWaypoint(String Label) {
        waypoint.setLabel(Label);
        return waypoint;
    }

}

