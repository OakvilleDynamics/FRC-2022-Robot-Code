package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.ShootBall;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ShootingSystem;

public class DriveShoot extends SequentialCommandGroup {
    public DriveShoot(Drivetrain autoDrive, ShootingSystem autoShoot) {
        addCommands(
            new ShootBall(1, 333, autoShoot),
            new DriveDistance(1000, -0.25, autoDrive)
        );
    }
}