package ru.job4j.poly;

public class Bus implements Transport {
    int countPassengers = 0;
    int countFuel = 0;
    int price = 90;

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {
        this.countPassengers = count;
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int refuel(int countFuel) {
        this.countFuel = countFuel;
        return price * countFuel;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.passengers(50);
        bus.refuel(100);
        bus.drive();
    }
}
