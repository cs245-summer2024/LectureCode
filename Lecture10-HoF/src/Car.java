import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Car implements Comparable<Car>{

    public int price;
    public String model;
    public double mpg;

    static double COST_OF_GAS = 4.0;
    static double GAS_CAR_PRICE = 20000;
    static double GAS_CAR_MPG = 25;

    public static class CarComparator implements Comparator<Car> {
        public int compare(Car c1, Car c2) {
            double milesNeededForC1 = milesNeededTillCostRecovery(c1);
            double milesNeededForC2 = milesNeededTillCostRecovery(c2);

            if(milesNeededForC1 < milesNeededForC2) {
                return 1;
            } else if(milesNeededForC1 == milesNeededForC2) {
                return 0;
            }
            return -1;
        }

        public double milesNeededTillCostRecovery(Car c) {
            if(c.price < GAS_CAR_PRICE) {
                return 0;
            }
            double priceDelta = c.price - GAS_CAR_PRICE;
            double costPerMile = COST_OF_GAS / c.mpg;
            return priceDelta / costPerMile;
        }
    }
    public Car(){
    }

    public Car(String model, int price, int efficiency) {
        this.model = model;
        this.price = price;
        this.mpg = efficiency;
    }

    public int compareTo(Car other) {
        if(this.price < other.price) {
            return -1;
        } else if(this.price == other.price) {
            return 0;
        }
        return 1;
    }
    public String toString() {
        return model;
    }

    public static void main(String[] args) {
        Car prius = new Hybrid("prius", 30000, 52);
        Car accord = new Hybrid("accord", 29000, 46);
        Car crv = new Hybrid("crv", 36000, 43);
        Car audi = new Hybrid("audi q5", 68000, 29);

        Car[] cars = {audi, prius, crv, accord};
        Comparator c = new Car.CarComparator();
        Arrays.sort(cars, c);
        System.out.println(Arrays.toString(cars));

        Arrays.sort(cars);
        System.out.println(Arrays.toString(cars));
    }
}
