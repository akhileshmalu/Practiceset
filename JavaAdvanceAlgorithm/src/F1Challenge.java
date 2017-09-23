import java.util.ArrayList;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 9/4/17.
 */
public class F1Challenge {

    private List<Team> challengers = new ArrayList<>();

    public List<Double> positions = new ArrayList<>();

    private List<Team> winners = new ArrayList<>();

    //private double lengthTrack;

    F1Challenge(int numOfTeam, double lengthTrack) {

        for(int i = 1; i<= numOfTeam; i++) {
            challengers.add(new Team(lengthTrack));
        }

        //this.lengthTrack = lengthTrack;
    }

    public void startCompetition() {
        System.out.println("_________Start of Competition_________");
        int time = 0;
        while(winners.size() < challengers.size()) {
            assess(time);
            time = time+2;
        }
        System.out.println("_________End of Competition_________");
    }

    public void assess(int time) {

         List<Double> temp = new ArrayList<>();

        // Assess relative positions or winners;
         for(Team challenger : challengers) {

            if(!challenger.hasWon) {

                double distanceCovered = challenger.driver.calDistance(time);

                double winningDistance = challenger.driver.raceTrack;

                if (winningDistance - distanceCovered < 0) {

                    System.out.println("winner is team no: " + challenger.teamNum + " in time: " + time);

                    winners.add(challenger);
                    challenger.hasWon = true;
                }
                temp.add(distanceCovered);

            } else {
                temp.add(positions.get(challenger.teamNum -1));
            }
        }

        // all drivers will reset their speed as per their relative positions
        for(Team challenger : challengers) {
            challenger.driver.reAssessPos(temp, time);
            //System.out.print("Team "+challenger.teamNum+" Driving at: " +challenger.driver.getSpeed()+ "cover" + temp.get(challenger.teamNum-1));
        }

        positions = new ArrayList<>(temp);

        //System.out.println(positions);

    }

}

class Team {
    protected static int count = 0;
    protected int teamNum;

    Driver driver;

    public boolean hasWon;

    Team(double raceTrack) {
        teamNum = setTeamNum();
        this.driver = new Driver(teamNum, raceTrack);
        this.hasWon = false;
    }

    public static int setTeamNum() {
        return ++count;
    }
}

class Driver {

    private Car car;
    private int teamNum;
    private double speed;
    protected double raceTrack;

    public static final double handlingFactor = 0.8;

    private boolean nitroUsed;

    Driver(int teamNum, double raceTrack) {
        this.teamNum = teamNum;
        this.car = new Car(teamNum);
        this.nitroUsed = false;
        this.speed = 2 * car.getAcceleration();
        this.raceTrack = raceTrack + ((teamNum - 1) * 200);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double calDistance(int time) {
        // calculate distance = ut + 1/2 at*t ; converting speed km/h to m/s by 5/18
        return (getSpeed() * (5 / 18)) * time + (0.5) * (car.getAcceleration() * time * time);
    }

    public void reAssessPos(List<Double> pos, int time) {

        double myDistance = pos.get(teamNum-1);
        boolean aboutToPass = false;

        double minDis = myDistance;

        for(Double carPos : pos) {
            if(carPos <minDis) {
               minDis = carPos;
           }

           if(Math.abs(carPos - myDistance) <= 10) {
               aboutToPass = true;
           }
        }
        // check if I am at last position i.e. least distance covered;
        if(minDis == myDistance && !nitroUsed ) {
            double doubleSpeed = 2 * getSpeed();
            double topSpeed = car.getTopSpeed();

            // Boost use only if covered half of track ; to avoid using boost at start
//            if(calDistance(time) > (raceTrack*0.5)) {
                setSpeed((doubleSpeed < topSpeed) ? doubleSpeed : topSpeed);
                nitroUsed = true;
                System.out.println(teamNum+ " : Nitro Used");
//            } else {
//                double newSpeed = getSpeed() + car.getAcceleration()*time;
//                setSpeed((newSpeed < car.getTopSpeed())? newSpeed : car.getTopSpeed());
//            }

        } else {
            if(aboutToPass) {
                setSpeed(getSpeed() * handlingFactor);

            } else {
                // a = (v-u) / t; v = u + at;
                double newSpeed = getSpeed() + car.getAcceleration()*time;
               // System.out.println("normal Speed increase");
                setSpeed((newSpeed < car.getTopSpeed())? newSpeed : car.getTopSpeed());
            }
        }

    }



}

class Car {

    private double topSpeed;
    private double acceleration;


    public Car(int teamNum) {
        this.topSpeed = 150 + (10 * teamNum);
        this.acceleration = 2 * teamNum;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }
}

class test {
    public static void main(String[] args) {
        F1Challenge f1 = new F1Challenge(4,2000);
        f1.startCompetition();

    }
}

