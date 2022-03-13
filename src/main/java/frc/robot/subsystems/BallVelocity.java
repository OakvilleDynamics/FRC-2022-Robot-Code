package frc.robot.subsystems;

public class BallVelocity {
    public static double deviance(double dist, double vr) {
        double angle = 1.22173; // #in radians
        double hoop = 2.4384; // #height of hood from ground
        double step = 5e-4; // #Euler's method delta x.  smaller values increase accuracy but raise calculation time
        double mass = .4; // mass of projectile
        double c = 0.47; // drag coefficent
        double p = 1.04; // air density?
        double a = Math.PI * (Math.pow(0.3, 2)); // cross-sectional area
        double mu = (c*p*a)/(2*mass); // drag force dont change
        double g = 9.807; // gravity constant dont change

        double x = -dist;
        double y = 0;
        double vx = Math.cos(angle)*vr;
        double vy = Math.sin(angle)*vr;
        double toggle = 0; // keeps track of when the ball passes the hoop vertically
        double error = -1; // used if ball doesnt reach hoop height

        while (y >= 0) {
            // system of differential equation, eulers method
            x = x + step*vx;
            y = y + step*vy;
            vx = vx + step*(-mu*vx*Math.sqrt((Math.pow(vx, 2))+(Math.pow(vy, 2))));
            vy = vy + step*((-g)-mu*vy*Math.sqrt((Math.pow(vx, 2))+(Math.pow(vy, 2))));
            
            // uses toggle to keep track of the ball passing the hoop height
            if (y <= hoop && toggle == 1) {
                toggle = toggle + 1;
                error = x;
            }
            if (y >= hoop && toggle == 0) {
                toggle = toggle + 1;
            }
        }

        return error; // negative if ball is short, positive if ball is far
    }

    public static double final_vr(double dist, double accuracy, double left_bound, double right_bound) { // determines best velocity through guessing
        double test_vr = (right_bound+left_bound)/2; // initial guess
        for (int i = 0; i < accuracy; ++i) { // accuracy is the number of guesses
            if (deviance(dist, test_vr) > 0) { // too large
                right_bound = (right_bound + left_bound)/2;
            } else { // too small
                left_bound = (right_bound + left_bound)/2;
            }
            test_vr = (right_bound + left_bound)/2;
        }
        return test_vr; // the best guess
    }
    //System.out.println(final_vr(dist, 25, 0, 150));
}
