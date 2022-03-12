package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import com.revrobotics.*;


public class Encoders extends CommandBase{
    PowerDistribution PDHub = new PowerDistribution(0, ModuleType.kCTRE);

}
