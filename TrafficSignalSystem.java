import java.util.*;

class Lane {
    private String name;
    private int vehicleCount;
    private double avgSpeed;

    public Lane(String name, int vehicleCount, double avgSpeed) {
        this.name = name;
        this.vehicleCount = vehicleCount;
        this.avgSpeed = avgSpeed;
    }

    public String getName() {
        return name;
    }

    public double calculateIntensity() {
        if (avgSpeed <= 0) return 0;
        return vehicleCount * (1.0 / avgSpeed);
    }
}

public class TrafficSignalSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Lane> lanes = new ArrayList<>();
        String[] directions = {"North", "South", "East", "West"};

        System.out.println("---- AI Traffic Signal Optimization ----");

        for (String direction : directions) {
            System.out.print("Enter number of vehicles in " + direction + " lane: ");
            int count = scanner.nextInt();

            System.out.print("Enter average speed (km/h) in " + direction + " lane: ");
            double speed = scanner.nextDouble();

            lanes.add(new Lane(direction, count, speed));
        }

        Lane busiestLane = lanes.get(0);
        for (Lane lane : lanes) {
            if (lane.calculateIntensity() > busiestLane.calculateIntensity()) {
                busiestLane = lane;
            }
        }

        System.out.println("\n🔎 Traffic Intensities:");
        for (Lane lane : lanes) {
            System.out.printf("%s lane: %.2f\n", lane.getName(), lane.calculateIntensity());
        }

        System.out.println("\n🚦 Green signal given to: " + busiestLane.getName() + " lane");
        scanner.close();
    }
}
