package ex0.algo;

import ex0.Building;
import ex0.CallForElevator;
import ex0.simulator.Call_A;
import ex0.simulator.Simulator_A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyElevatorAlgo3Test {
    Building b0;
    MyElevatorAlgo3 myAlgorithm;

    @Test
    void getBuilding() {
        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(b0, myAlgorithm.getBuilding());
    }

    @Test
    void algoName() {
        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals("Ex0_MY_ELEVATOR_ALGO",  myAlgorithm.algoName() );
    }

    @Test
    void allocateAnElevator() {
        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        CallForElevator c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));

        Simulator_A.initData(1,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));

        Simulator_A.initData(2,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));

        Simulator_A.initData(3,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));

        Simulator_A.initData(4,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));

        Simulator_A.initData(5,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        c = new Call_A(0,1,1);
        Assertions.assertEquals(0, myAlgorithm.allocateAnElevator(c));
    }

    @Test
    void cmdElevator() {
        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getState());
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getPos());

        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getState());
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getPos());

        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getState());
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getPos());

        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getState());
        Assertions.assertEquals(0,myAlgorithm.getBuilding().getElevetor(0).getPos());

    }

    @Test
    void timeCaculateForLevel() {

        double time = 14;
        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(time,myAlgorithm.timeCaculateForLevel(0,4),0.1);

        time = 16;
        Simulator_A.initData(1,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(time,myAlgorithm.timeCaculateForLevel(0,4),0.1);


        time = 16;
        Simulator_A.initData(2,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(time,myAlgorithm.timeCaculateForLevel(0,4),0.1);

        time = 17;
        Simulator_A.initData(3,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(time,myAlgorithm.timeCaculateForLevel(0,4),0.1);

        time = 17;
        Simulator_A.initData(4,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(time,myAlgorithm.timeCaculateForLevel(0,4),0.1);

    }

    @Test
    void fastestElevator() {
        // checking which elevator is the fastest

        Simulator_A.initData(0,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.fastestElevator());
        Simulator_A.initData(2,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(0,myAlgorithm.fastestElevator());
        Simulator_A.initData(9,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(3,myAlgorithm.fastestElevator());
        Simulator_A.initData(8,null);
        b0 = Simulator_A.getBuilding();
        myAlgorithm = new MyElevatorAlgo3(b0);
        Assertions.assertEquals(1,myAlgorithm.fastestElevator());


    }
}