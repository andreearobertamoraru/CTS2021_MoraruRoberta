package ro.ase.acs.main;

import ro.ase.acs.decorator.Car;
import ro.ase.acs.decorator.Vehicle;
import ro.ase.acs.decorator.VehicleWithAlarm;
import ro.ase.acs.decorator.VehicleWithParkingSensors;

public class Main {
    public static void main(String[] args){
        Car car=new Car("red", 300, 4);
        car.start();
        car.stop();
        VehicleWithAlarm carWithAlarm=new VehicleWithAlarm(car);
        carWithAlarm.start();
        carWithAlarm.stop();
        carWithAlarm.activateAlarm();
        Vehicle carWithParkingSensors=new VehicleWithParkingSensors(car,5);
        carWithParkingSensors.start();


        Vehicle carWithAlarmAndParkingSensors=new VehicleWithParkingSensors(new VehicleWithAlarm(car),3);
        carWithAlarmAndParkingSensors.start();
        carWithAlarmAndParkingSensors.stop();


        //In cazul in care dorim sa folosim cream o clasa anonima
//        Vehicle vehicle=new Vehicle() {
//            @Override
//            public void start() {
//
//            }
//
//            @Override
//            public void stop() {
//
//            }
//        };
    }
}
