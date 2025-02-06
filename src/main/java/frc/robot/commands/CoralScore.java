// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Elevator;

/** An example command that uses an example subsystem. */
public class CoralScore extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final boolean isLeft, isTop;
  /**
   * Creates a new ExampleCommand. 
   *
   * @param subsystem The subsystem used by this command.
   */
  public CoralScore(boolean isItLeft, boolean isItTop)
  {
    isLeft = isItLeft;
    isTop = isItTop;
    
     //this is a comment
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // set the height point of the elevator
    // change light color eventualy
    // change x/y position depending on if it's left or right

    if (isLeft && isTop)
    {                                           // Level 3 left side
      System.out.println("Running sequential command");
      //                           Move to 3.0                       Wait 3 seconds                    Return to 0
      new SequentialCommandGroup(
        new MoveToSetpoint(3.0), 
        Commands.waitSeconds(3), 
        new MoveToSetpoint(0)
        ).schedule();
        /* Second part of command will go here. Part that will menuver the robot to the reef */
    
      }
    else if (!isLeft && isTop)
    {                                           // Level 3 right side
      Commands.parallel(
        new SequentialCommandGroup(new MoveToSetpoint(3.0), Commands.waitSeconds(3), new MoveToSetpoint(0))
        /* Second part of command will go here. Part that will menuver the robot to the reef */);
    }
    else if (isLeft && !isTop)
    {                                           // Level 2 left side
      Commands.parallel(
        new SequentialCommandGroup(new MoveToSetpoint(2.0), Commands.waitSeconds(3), new MoveToSetpoint(0))
        /* Second part of command will go here. Part that will menuver the robot to the reef */);
    }
    else
    {                                           // Level 2 right side
      Commands.parallel(
        new SequentialCommandGroup(new MoveToSetpoint(2.0), Commands.waitSeconds(3), new MoveToSetpoint(0))
        /* Second part of command will go here. Part that will menuver the robot to the reef */);
    }
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /**
    * Either reset to default pos, or just stay the same
    * Will change later
    * PLEASE
    */
    new MoveToSetpoint(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
