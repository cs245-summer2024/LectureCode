public class Robot {
    String job;
    double chargeLeft;

    public Robot(String job, double chargeLeft) {
        this.job = job;
        this.chargeLeft = chargeLeft;
    }

    public void introduce() {
        System.out.println("I am a generic robot");
    }

    public void interact(Robot r) {
        System.out.println("Generic Robot Interacting with generic robot");
    }

    public void interact(WorkerRobot wr) {
        System.out.println("Generic Robot Interacting with worker robot");
    }
}
