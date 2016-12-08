package BusinessLogic;

import javafx.scene.layout.VBox;

/**
 * Created by Julius on 08-12-2016.
 */
public interface TimelineInterface {
    VBox getTimeline(String projectName);
    String toString();
}
