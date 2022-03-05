// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. 
   * @return */
  final CANSparkMax driveLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  final CANSparkMax driveRightMotor = new CANSparkMax(11, MotorType.kBrushless);
  final CANSparkMax driveBackRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  final CANSparkMax driveBackLeftMotor = new CANSparkMax(6, MotorType.kBrushless);
  final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(driveLeftMotor, driveBackLeftMotor);
  final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(driveRightMotor, driveBackRightMotor);
  final DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  /*final Encoder rightEncoder = new Encoder(0, 1);
  final Encoder leftEncoder = new Encoder(2, 3);
  final Encoder backrightEncoder = new Encoder(4, 5);
  final Encoder backleftEncoder = new Encoder(6, 7);
  final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;

  public double getEncoderMeters() {
    return (leftEncoder.get() + -rightEncoder.get()) / 2 * kEncoderTick2Meter;
  }
  public double getbackEncoderMeters() {
    return (backleftEncoder.get() + -backrightEncoder.get()) / 2 * kEncoderTick2Meter;
  }*/
  public DriveSubsystem() {
   driveRightMotor.setInverted(false);
   driveLeftMotor.setInverted(true);
   driveBackRightMotor.follow(driveRightMotor);
   driveBackLeftMotor.follow(driveLeftMotor);
   driveLeftMotor.restoreFactoryDefaults();
   driveBackLeftMotor.restoreFactoryDefaults();
   driveRightMotor.restoreFactoryDefaults();
   driveBackRightMotor.restoreFactoryDefaults();
   /*leftEncoder.setReverseDirection(false);
   rightEncoder.setReverseDirection(true);
   backleftEncoder.setReverseDirection(false);
   backrightEncoder.setReverseDirection(true);*/
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    /*SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    SmartDashboard.putNumber("Drive back encoder value", getbackEncoderMeters());*/
    }
    
   
    public void setMotors(double leftSpeed, double rightSpeed){
      drive.arcadeDrive(leftSpeed, rightSpeed);
    }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
