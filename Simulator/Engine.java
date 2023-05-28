package Simulator;

/*
 * Contains methods required for the Engine.
 */

public class Engine {

    private double startVelocity;
    private double endVelocity;
    private double dTime;
    private double Gravity;
    private double rocketMass = 50000;
    private double specificImpulse;
    private double fuelConsumed;
    /*
     * when the distance between the titan and space probe is smaller that 300k euclidian distance, recalibrate the velocity of 
     * titan + orbiting velolcity ( that is calculated by newtwon gravity thing)  
     */
   
    public Engine(double sVelocity, double eVelocity, double dTime, double Gravity, double specificImpulse) {
        this.startVelocity = sVelocity;
        this.endVelocity = eVelocity;
        this.dTime = dTime;
        this.Gravity = Gravity;
        this.specificImpulse = specificImpulse;
    }

    public double getMomentum() {
        double momentum = rocketMass * endVelocity - rocketMass * startVelocity;
        return momentum;
    }

    public double getThrust() {
        double thrust = getMomentum() / dTime - Gravity * rocketMass;
        return thrust;
    }

    public double fuelConsumed() {
        double thrust = getThrust();
        double fuelConsumed = Math.abs(thrust) / (Gravity * specificImpulse) * dTime;
        return fuelConsumed;
    }
    //Incompleted!
    public double getVelocity(double t, double deltaTime) {
        double integral = 0.0;
        double time = t;
        double upperBound = t + deltaTime;
        double step = 0.001; //step size for numerical integration (adjust)

        while (time <= upperBound) {
            double force = calculateForce(time);
            integral += force;
            time += step;
        }

        double impulse = integral * step;
        double velocity = impulse / rocketMass + startVelocity;
        return velocity;
    }

    private double calculateForce(double time) {
        // TODO
        return 0.0;
    }
    

    // calculate the distance 
    //instead of y, use the current state I AM IN and j for the titan, i for the probe
    distance = Math.pow(((State) y).getPosition(i).euclideanDist(((State) y).getPosition(j)), 3);
    Vector3 positionalDifference = (Vector3)((((State) y).getPosition(j).subtract(((State) y).getPosition(i))));

     // a(i) = G * m(j) * pos(i) - pos(j) / (euler distance(pos(i) - pos(j))) ^ 3 
     //ORBITATION velocity all 3 
     Vector3 tempAcc = (Vector3) (positionalDifference.multiply(G*CelestialBody.celestialBodies[j].getMass()/distance));
                    
    // add the temporary acceleration to total acceleration of a planet
    acceleration.addAcceleration(i, tempAcc);
    //celocity desired = velocity titan + velocity orbit
}