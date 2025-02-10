/**
 * Simple class containing constants used throughout project
 */
package frc.robot;

import edu.wpi.first.math.util.Units;
import frc.robot.subsystems.Intake;

public class Constants {


	public final static class Passthrough{
		public static final int kIntakeMotorID = 3;
		public static final double kIntakeSpeed = 0.73;
	}
	
	public final static class OI{
		//OI Constants
		public static final int kDriverControllerPort = 0;
	}

	public final static class Elevator{
	//Elevator Constants
	public static final double kGearRatio = 10.0;  // 40:1 Reduction
	public static final double kPulleyRadius = Units.inchesToMeters(2);
	public static final double kCarriageMass = 6.803;  // in KG  (15 pounds)
	public static final double kMinHeight = 0;
	public static final double kMaxHeight = 3.35;  // SI Units is meters == 11 ft
	public static final double kTicksPerRevolution = 4096;//Think this might be 2048, need to check w/ Luke

	public static final double kDistancePerTick = 2 * Math.PI * kPulleyRadius / kTicksPerRevolution / kGearRatio;

	public static final double kP  = 1.0;
	public static final double kI = 0.5;
	public static final double kD = 0.2;

	public static final double kBottomSetpoint = 0;
	public static final double kMidSetpoint = 2;
	public static final double kHightSetpoint = 3;

	public static final int kElevatorMasterID = 1;
	public static final int kElevatorFollowerID = 2;

	

	}

	public static Intake intake = new Intake();
}