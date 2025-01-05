import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficSimulator extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Pane pane;

    private Thread northThread, southThread, eastThread, westThread;
    private Lock lock;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.pane = new Pane();
        Scene scene = new Scene(this.pane, WIDTH, HEIGHT);

        // Initialize the lock for thread synchronization
        this.lock = new ReentrantLock();

        // Create threads for each direction
        northThread = new Thread(() -> simulateTraffic("North"));
        southThread = new Thread(() -> simulateTraffic("South"));
        eastThread = new Thread(() -> simulateTraffic("East"));
        westThread = new Thread(() -> simulateTraffic("West"));

        // Start the threads
        northThread.start();
        southThread.start();
        eastThread.start();
        westThread.start();

        stage.setScene(scene);
        stage.setTitle("Traffic Simulator");
        stage.show();
    }

    private void simulateTraffic(String direction) {
        for (int i = 0; i < 12; i++) {
            try {
                Thread.sleep(500); // Simulate traffic light changes every 0.5 seconds
            } catch (InterruptedException e) {
                break; // Exit thread if interrupted
            }

            lock.lock(); // Acquire the lock to ensure thread-safe operations
            try {
                // Ensure UI updates are done on the JavaFX Application Thread
                int cycle = i / 3;
                Platform.runLater(() -> {
                    Rectangle rect = createTrafficRectangle(direction, cycle);
                    if (rect != null) {
                        pane.getChildren().add(rect);
                    }
                });
            } finally {
                lock.unlock(); // Always release the lock
            }
        }
    }

    private Rectangle createTrafficRectangle(String direction, int cycle) {
        Rectangle rect = null;
        switch (direction) {
            case "North":
                if (cycle % 4 == 0) { // North has green light every 4th cycle
                    rect = new Rectangle(100, 100 + cycle * 50, 20, 50);
                    rect.setFill(Color.GREEN);
                }
                break;
            case "South":
                if (cycle % 4 == 1) { // South has green light every 2nd cycle
                    rect = new Rectangle(100, HEIGHT - 150 - cycle * 50, 20, 50);
                    rect.setFill(Color.BLUE);
                }
                break;
            case "East":
                if (cycle % 4 == 2) { // East has green light every 3rd cycle
                    rect = new Rectangle(WIDTH - 150 - cycle * 50, HEIGHT / 2, 50, 20);
                    rect.setFill(Color.RED);
                }
                break;
            case "West":
                if (cycle % 4 == 3) { // West has green light every 4th cycle
                    rect = new Rectangle(WIDTH - 200 + cycle * 50, HEIGHT / 2 + 100, 50, 20);
                    rect.setFill(Color.YELLOW);
                }x²
                break;
        }
        return rect;
    }

    @Override
    public void stop() {
        // Interrupt all threads on application close
        northThread.interrupt();
        southThread.interrupt();
        eastThread.interrupt();
        westThread.interrupt();
    }
}
