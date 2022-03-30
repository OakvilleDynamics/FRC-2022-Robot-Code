package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

public class SimpleDrive extends SequentialCommandGroup {
    public SimpleDrive(Drivetrain autoDrive) {
        addCommands(
            new DriveDistance(1000, -0.25, autoDrive)
        );
    }
}
