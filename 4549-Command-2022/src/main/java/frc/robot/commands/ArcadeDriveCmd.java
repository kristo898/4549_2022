// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCmd extends CommandBase {
  /** Creates a new ArcadeDriveCmd. */
  private final DriveSubsystem driveSubsystem;
  private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDriveCmd(DriveSubsystem driveSubsystem,
      Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ArcadeDriveCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed - realTimeTurn;
    double right = realTimeSpeed + realTimeTurn;
    if (Math.abs(realTimeSpeed) > 0.05){
      realTimeSpeed = 0;
    }
    if (Math.abs(realTimeTurn) > 0.05){
      realTimeTurn = 0;
    }
    driveSubsystem.setMotors(left, right);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ArcadeDriveCmd ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
