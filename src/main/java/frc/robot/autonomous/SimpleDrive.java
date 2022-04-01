package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

public class SimpleDrive extends SequentialCommandGroup {
    public SimpleDrive(Drivetrain autoDrive) {
        addCommands(
            new DriveDistance(2500, 0.45, autoDrive),
            new DriveDistance(200, -0.5, autoDrive),
            new DriveDistance(200, 0.5, autoDrive)
        );
    }
}
