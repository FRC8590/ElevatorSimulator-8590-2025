// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  private SparkMax intakeMotor = new SparkMax(Constants.Passthrough.kIntakeMotorID, MotorType.kBrushless);
  private double intakeVelocity = 0;


  public Intake() {
    
  }

  public void run(){
    intakeVelocity = 0.79;    
  }

  public void runBackward(){
    intakeVelocity = -0.79;
    
    System.out.println("Subsystem velocity to -0.79");
  }

  public void stop(){
    intakeVelocity = 0;

    System.out.println("Subsystem velocity to 0");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    intakeMotor.set(intakeVelocity);
    log();
  }

  public void log(){
    SmartDashboard.putNumber("Intake/Outtake Speed", intakeMotor.get());
    
  }
}
