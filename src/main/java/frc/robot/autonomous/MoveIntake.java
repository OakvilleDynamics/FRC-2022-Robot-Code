package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.MovingIntake;
import frc.robot.commands.ShootBall;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ShootingSystem;

public class MoveIntake extends SequentialCommandGroup {
    public MoveIntake(Drivetrain autoDrive, ShootingSystem autoShoot) {
        addCommands(
            new ShootBall(1, 333, autoShoot),
            new DriveDistance(1000, 0.45, autoDrive),
            new MovingIntake(1, 0.5, autoShoot, autoDrive),
            new ShootBall(1, 333, autoShoot)
        );
    }
}