// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. 
   * @return */
  final Spark driveLeftMotor = new Spark(0);
  final Spark driveRightMotor = new Spark(1);
  final Spark driveBackRightMotor = new Spark(2);
  final Spark driveBackLeftMotor = new Spark(3);
  final Encoder rightEncoder = new Encoder(0, 1);
  final Encoder leftEncoder = new Encoder(2, 3);
  final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;

  double getEncoderMeters() {
    return (leftEncoder.get() + -rightEncoder.get()) / 2 * kEncoderTick2Meter;
  }
  public DriveSubsystem() {
   driveRightMotor.setInverted(false);
   driveLeftMotor.setInverted(true);
   driveBackLeftMotor.setInverted(true);
   driveBackRightMotor.setInverted(false);
   leftEncoder.setReverseDirection(false);
   rightEncoder.setReverseDirection(true);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
  }
    public void setMotors(double leftSpeed, double rightSpeed){
      driveLeftMotor.set(leftSpeed);
      driveRightMotor.set(rightSpeed);
      driveBackRightMotor.set(leftSpeed);
      driveBackLeftMotor.set(rightSpeed);
    }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
