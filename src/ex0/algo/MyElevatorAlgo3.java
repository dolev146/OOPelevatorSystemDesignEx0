package ex0.algo;

import ex0.Building;
import ex0.CallForElevator;
import ex0.Elevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class MyElevatorAlgo3 implements ElevatorAlgo {
    private Building _building;
    private ArrayList[] arrOfAL;

    public MyElevatorAlgo3(Building b) {
        _building = b;
        arrOfAL = new ArrayList[this._building.numberOfElevetors()];
        for (int i = 0; i < arrOfAL.length; i++)
            arrOfAL[i] = new ArrayList();
    }

    @Override
    public Building getBuilding() {
        return _building;
    }

    @Override
    public String algoName() {
        return "Ex0_MY_ELEVATOR_ALGO";
    }

    @Override
    public int allocateAnElevator(CallForElevator c) {
        DoublePoint[] arrTimes = new DoublePoint[this._building.numberOfElevetors()];

        for (int i = 0; i < this._building.numberOfElevetors(); i++) {  //check all elveators time for get to the src
            double time = timeCaculateForLevel(i, c.getSrc());           //and take the best.
            arrTimes[i] = new DoublePoint(i, time);
        }
        Arrays.sort(arrTimes, new MyComparator());                       // sort the array,compare the time.

        for (int i = 0; i < arrTimes.length; i++) {

            Elevator e = this._building.getElevetor(arrTimes[i].I);
            if ((arrOfAL[arrTimes[i].I].size() <= 10) && ((e.getState() == 0&&arrOfAL[arrTimes[i].I].size() == 0) ||                                                                  //if the elevator not moving
                    (e.getPos() >= c.getSrc() && e.getState() == -1 && c.getSrc() >= c.getDest()) ||  //if go down and the src in the way of the elvator
                    (e.getPos() <= c.getSrc() && e.getState() == 1 && c.getSrc() <= c.getDest())))     //if go up and the src in the way of the elevator.
            {
                arrOfAL[arrTimes[i].I].add(c.getSrc());        //put the calls in the ArrayList of the elevator
                arrOfAL[arrTimes[i].I].add(c.getDest());
                System.out.println("    " + e.getPos());
                System.out.println(arrTimes[i].I + ": " + arrOfAL[arrTimes[i].I]);
                return (int)arrTimes[i].I;
            }
        }
        int fastest = fastestElevator();
        arrOfAL[fastest].add(c.getSrc());        //put the calls in the ArrayList of the elevator
        arrOfAL[fastest].add(c.getDest());
        System.out.println("    " + _building.getElevetor(fastest).getPos());
        System.out.println(fastest + ": " + arrOfAL[fastest]);
        return fastest;
    }
    @Override
    public void cmdElevator(int elev) {
        if (arrOfAL[elev].size() == 0) ;
        else {
            Elevator e = this.getBuilding().getElevetor(elev);
            ArrayList a = arrOfAL[elev];

            if (e.getState() == 0 && a.size() != 0) {           // if not moving and we have calls so go to the calls dest
                e.goTo((int) a.get(0));
                if (e.getPos() == (int) a.get(0))
                    a.remove(0);
            } else if (a.contains(e.getPos())) {             //if we are in floor we need to stop,so
                e.stop(e.getPos());       // stop and remove from list and go to the next dest
                a.remove((Integer) e.getPos());
                if(a.size() != 0) {
                    if (e.getState() == 0)
                        e.goTo((int) a.get(0));
                    else
                        e.stop((int) a.get(0));
                }
            }
            if ((a.size() != 0) && e.getPos() < (int) a.get(0)) {
                int min = (int) a.get(0);
                for (int i = 1; i < a.size(); i++)
                    if (e.getPos() <= (int) a.get(i) && (int) a.get(i) <= (int) a.get(0) && min > (int) a.get(i))
                        min = (int) a.get(i);
                if (min != (int) a.get(0))
                    e.stop(min);
            }

            if ((a.size() != 0) && e.getPos() > (int) a.get(0)) {
                int max = (int) a.get(0);
                for (int i = 1; i < a.size(); i++)
                    if (e.getPos() >= (int) a.get(i) && (int) a.get(i) >= (int) a.get(0) && max < (int) a.get(i))
                        max = (int) a.get(i);
                if (max != (int) a.get(0))
                    e.stop(max);
            }
        }
    }
    public double timeCaculateForLevel(int elev, int src) {
        Elevator thisElev = this._building.getElevetor(elev);
        double speed = this._building.getElevetor(elev).getSpeed();
        int floorDistance = Math.abs(thisElev.getPos() - src);
        double time = (floorDistance * speed) + thisElev.getTimeForOpen() +
                thisElev.getTimeForClose() + thisElev.getStartTime() + thisElev.getStopTime();
        return time;
    }

    private class DoublePoint {                          // class for elevator index and the speed to the src
        private int I;                               // so I could sort and save the elevator Index
        private double time;

        private DoublePoint(int I, double time) {
            this.I = I;
            this.time = time;
        }
    }

    public class MyComparator implements Comparator<DoublePoint> {
        @Override
        public int compare(DoublePoint o1, DoublePoint o2) {
            return (o2.time <= o1.time ? 0 : -1);
        }
    }

    public int fastestElevator() {
        int fastest = 0;
        for (int i = 1; i < _building.numberOfElevetors(); i++) {
            if (_building.getElevetor(i).getSpeed() > _building.getElevetor(fastest).getSpeed())
                fastest = i;
        }
        return fastest;
    }
}