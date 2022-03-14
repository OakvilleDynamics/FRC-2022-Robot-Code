// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.CANSparkMaxSendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  // Inits motors
  private final CANSparkMaxSendable leftRear;
  private final CANSparkMaxSendable leftFront;
  private final CANSparkMaxSendable rightFront;
  private final CANSparkMaxSendable rightRear;

  // Inits encoders
  public Encoder leftFrontEncoder;
  public Encoder leftRearEncoder;
  public Encoder rightFrontEncoder;
  public Encoder rightRearEncoder;

  private final MecanumDrive drive;

  public double leftAmount;
  public double rightAmount;
  public boolean partyMode = false;
  

  public Drivetrain() {

    // Assigns motors
    leftFront = new CANSparkMaxSendable(Constants.controllerID[0], MotorType.kBrushed);
    addChild("leftFront", leftFront);
    leftFront.setInverted(false);

    leftRear = new CANSparkMaxSendable(Constants.controllerID[1], MotorType.kBrushed);
    addChild("leftRear", leftRear);
    leftFront.setInverted(false);

    rightFront = new CANSparkMaxSendable(Constants.controllerID[2], MotorType.kBrushed);
    addChild("rightFront", rightFront);
    leftFront.setInverted(false);

    rightRear = new CANSparkMaxSendable(Constants.controllerID[3], MotorType.kBrushed);
    addChild("rightRear", rightRear);
    leftFront.setInverted(false);

    drive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
    addChild("Drive", drive);
    drive.setSafetyEnabled(true);
    drive.setExpiration(0.1);
    drive.setMaxOutput(Constants.powerLimit);

    // Encoders
    leftFrontEncoder = new Encoder(Constants.encoderPorts[0], Constants.encoderPorts[1]);
    leftRearEncoder = new Encoder(Constants.encoderPorts[2], Constants.encoderPorts[3]);
    rightFrontEncoder = new Encoder(Constants.encoderPorts[4], Constants.encoderPorts[5]);
    rightRearEncoder = new Encoder(Constants.encoderPorts[6], Constants.encoderPorts[7]);

    
    //DRIVE_ENCODERS = new MedianPIDSource(LEFT_FRONT_DRIVE_ENCODER, LEFT_BACK_DRIVE_ENCODER, RIGHT_FRONT_DRIVE_ENCODER, RIGHT_BACK_DRIVE_ENCODER);

    // To change the max power, you need to change it in the Constants.java file
    // if (partyMode) {
    //   drive.setMaxOutput(Constants.partyModeLimit);
    // } else {
    //   drive.setMaxOutput(Constants.powerLimit);
    // }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation

  }

  // Drive method for driving
  public void drive(double mainx, double mainy, double rotate) {

    System.out.println(mainx+"X power");
    System.out.println(mainy+"Y power");
    System.out.println(mainy *= -1);
    System.out.println(rotate+"rotate power");
    System.out.println("the things printing");
    drive.driveCartesian(mainx, mainy, rotate);

  }

  public void getEncoderRate() {
    // This is how we get the velocity from the motors. For future use!
    leftFrontEncoder.getRate();
    leftRearEncoder.getRate();
    rightFrontEncoder.getRate();
    rightRearEncoder.getRate();
  }

  public void getMotorVoltage() {
    // This is how we get power draw from the motors I assume
    leftFront.getBusVoltage();
  }

  public void encoderTest() {
    System.out.println(leftFrontEncoder.getRate());
  }

  public double Test(double test) {
    return 0;
  }

  public boolean getPartyMode() {
    return partyMode;
  }

  public void setPartyMode(Boolean flag) {
    partyMode = flag;
  }
}
