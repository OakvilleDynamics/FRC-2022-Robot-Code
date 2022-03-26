package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSystem;

public class IntakeRamp extends CommandBase {

    private final XboxController auxController = 
        new XboxController(Constants.auxControllerPort);

        private final IntakeSystem m_intakesystem;
    
        public IntakeRamp(IntakeSystem subsystem) {
            m_intakesystem = subsystem;
            addRequirements(m_intakesystem);
        }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_intakesystem.intake(auxController.getRawAxis(2), auxController.getRawAxis(3), auxController.getAButton());
        System.out.print("executing intake system");
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
