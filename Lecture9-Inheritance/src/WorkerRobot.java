public class WorkerRobot extends Robot {
    public WorkerRobot(String job, double charge) {
        super(job, charge);
    }

    public void introduce() {
        System.out.println("I am a worker robot. I work as a " + job);
    }

    public void interact(Robot r) {
        System.out.println("Worker Robot Interacting with generic robot");
    }

    public void interact(WorkerRobot wr) {
        System.out.println("Worker Robot Interacting with worker robot");
    }

    public static void main(String[] args) {
        // Running Dynamic Method Selection Examples
//        Robot myRobot = new WorkerRobot("chef", 100);
//        myRobot.introduce();
//
//        Object r = new WorkerRobot("chef", 100);
//        Robot r2 = (Robot) r;
//        r2.introduce();
//
//        r = new WorkerRobot("chef", 100);
//        ((WorkerRobot) r).introduce();
//
//        r = new WorkerRobot("chef", 75);
//        ((Robot) r).introduce();

        // Running overloaded method examples
//        WorkerRobot wr = new WorkerRobot("chef", 75);
//        WorkerRobot wr2 = new WorkerRobot("driver", 100);
//        Robot r = new Robot("general", 50);
//        Robot r2 = new WorkerRobot("general2", 50);
//
//        wr.interact(r);
//        wr.interact(wr2);
//        ((Robot) r2).interact((Robot) wr2);
    }
}
