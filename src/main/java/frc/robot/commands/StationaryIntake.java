package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingSystem;

public class StationaryIntake extends CommandBase {
    private final ShootingSystem m_shoot;
    private final double m_time;
    double startTime;
    double endTime;


    public StationaryIntake(double time, ShootingSystem shoot) {
        m_time = time;
        m_shoot = shoot;
        addRequirements(m_shoot);
    }

    // Called just before this command runs for the first time
    public void initialize() {
        m_shoot.autoClock(0.25);
        m_shoot.autoIntake(1);
        startTime = System.currentTimeMillis();
        endTime = startTime + m_time;
    }

    // Called repeatedly when this command is scheduled to run
    public void execute() {
        m_shoot.autoClock(0.25);
        m_shoot.autoIntake(1);
    }

    // Make this return true when you want the command to no longer run
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
        m_shoot.autoClock(0);
        m_shoot.autoIntake(0);
    }
}
