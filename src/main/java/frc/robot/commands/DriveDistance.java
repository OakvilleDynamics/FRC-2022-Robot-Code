package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {
    private final Drivetrain m_drive;
    private final double m_time;
    private final double m_speed;
    double startTime;
    double endTime;
    double simpleDriveStatus;

    public DriveDistance(double time, double speed, Drivetrain drive) {
        m_time = time;
        m_drive = drive;
        m_speed = speed;
        addRequirements(m_drive);
    }

    // Called just before this command runs for the first time
    public void initialize() {
        m_drive.resetEncoders();
        m_drive.autoDrive(m_speed, 0, 0, 0);
        startTime = System.currentTimeMillis();
        endTime = startTime + m_time;
    }

    // Called repeatedly when this command is scheduled to run
    public void execute() {
        m_drive.autoDrive(m_speed, 0, 0, 0);
        simpleDriveStatus = 2;
    }

    // Make this return true when you want the command to no longer run
    public boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
        m_drive.autoStopDrive();
    }
}
