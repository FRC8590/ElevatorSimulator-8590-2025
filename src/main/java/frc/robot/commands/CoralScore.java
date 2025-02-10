// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

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
    /**
     * set the height point of the elevator
     * change light color eventualy
     * change x/y position depending on if it's left or right
     * CURRENTLY PLACEHOLDERS FOR TESTING, WILL CHANGE TO DO REAL STUFF LATER (hopefully)
     */

    if (isLeft && isTop)
    {                                           // Level 3 left side
      System.out.println("Running sequential command");
      
      new SequentialCommandGroup(
        new MoveToSetpoint(3.0), // Move elevator up 3
        new RunOuttake(Constants.intake),
        Commands.waitSeconds(3), // wait 3 seconds
        new StopIntake(Constants.intake), // Stop intake after 3 seconds
        new MoveToSetpoint(0) // move elevator down 0
      ).schedule();
    }
    else if (!isLeft && isTop)
    {                                           // Level 3 right side
      System.out.println("Running sequential command");
      new ParallelCommandGroup(
        new SequentialCommandGroup(
          new MoveToSetpoint(3.0), // Move elevator up 3
          Commands.waitSeconds(3), // wait 3 seconds
          new MoveToSetpoint(0) // move elevator down 0
        )
        /* Second part of command will go here. Part that will menuver the robot to the reef */
      ).schedule();
    }
    else if (isLeft && !isTop)
    {                                           // Level 2 left side
      System.out.println("Running sequential command");
      new ParallelCommandGroup(
        new SequentialCommandGroup(
          new MoveToSetpoint(2.0), // Move elevator up 3
          Commands.waitSeconds(3), // wait 3 seconds
          new MoveToSetpoint(0) // move elevator down 0
        )
        /* Second part of command will go here. Part that will menuver the robot to the reef */
      ).schedule();
    }
    else
    {                                           // Level 2 right side
      System.out.println("Running sequential command");
      new ParallelCommandGroup(
        new SequentialCommandGroup(
          new MoveToSetpoint(2.0), // Move elevator up 3
          Commands.waitSeconds(3), // wait 3 seconds
          new MoveToSetpoint(0) // move elevator down 0
        )
        /* Second part of command will go here. Part that will menuver the robot to the reef */
      ).schedule();
    }
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
  @Override
  public void end(boolean interrupted) {
    /**
    * Either reset to default pos, or just stay the same
    * Will change later
    * PLEASE
    */
    new MoveToSetpoint(0.0);
  }
  @Override
  public boolean isFinished() {
    return true;
  }
}
