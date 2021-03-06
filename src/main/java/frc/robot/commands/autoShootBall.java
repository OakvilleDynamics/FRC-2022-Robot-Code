package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingSystem;

public class autoShootBall extends CommandBase {
    private final ShootingSystem m_shoot;
    private final double m_speed;
    private final double m_clockTime;
    double startTime;
    double endTime;
    double delayTime;
    double reverseTime;
    String autoShootBallStage;


    public autoShootBall(double speed, double clockTime, ShootingSystem shoot) {
        m_shoot = shoot;
        m_clockTime = clockTime;
        m_speed = speed;
        addRequirements(m_shoot);
    }

    // Called just before this command runs for the first time
    public void initialize() {
        m_shoot.autoClock(0);
        m_shoot.autoShootMotor(m_speed);
        startTime = System.currentTimeMillis();
        reverseTime = startTime + m_clockTime;
        endTime = reverseTime + 3000;
        System.out.println("autoShootBall Init");
    }

    // Called repeatedly when this command is scheduled to run
    public void execute() {
        m_shoot.autoShootMotor(m_speed);
        if (System.currentTimeMillis() >= reverseTime) {
            m_shoot.autoClock(1.0);
        }
        System.out.println("autoShootBall Execute");
    }

    // Make this return true when you want the command to no longer run
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
        m_shoot.autoClock(0);
        m_shoot.autoShootMotor(0);
        System.out.println("autoShootBall End");
    }
}
