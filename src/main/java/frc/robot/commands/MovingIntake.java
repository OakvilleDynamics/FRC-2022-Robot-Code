package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ShootingSystem;

public class MovingIntake extends CommandBase {
    private final ShootingSystem m_shoot;
    private final double m_time;
    private final double m_speed;
    private final Drivetrain m_drive;
    double startTime;
    double endTime;


    public MovingIntake(double time, double speed, ShootingSystem shoot, Drivetrain drive) {
        m_time = time;
        m_shoot = shoot;
        m_speed = speed;
        m_drive = drive;
        addRequirements(m_shoot);
    }

    // Called just before this command runs for the first time
    public void initialize() {
        m_shoot.autoClock(0.25);
        m_shoot.autoIntake(1);
        m_drive.autoDrive(1, 0, 0, m_speed);
        startTime = System.currentTimeMillis();
        endTime = startTime + m_time;
    }

    // Called repeatedly when this command is scheduled to run
    public void execute() {
        m_shoot.autoClock(0.25);
        m_shoot.autoIntake(1);
        m_drive.autoDrive(1, 0, 0, m_speed);
    }

    // Make this return true when you want the command to no longer run
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
        m_shoot.autoClock(0);
        m_shoot.autoIntake(0);
        m_drive.autoStopDrive();
    }
}
