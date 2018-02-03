// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.IFollower;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainLeftFrontMotor, driveTrainLeftRearMotor, driveTrainRightFrontMotor, driveTrainRightRearMotor;
    public static DifferentialDrive driveTrainTDrive;
    public static Encoder driveTrainLeftEncoder, driveTrainRightEncoder;
    public static AnalogGyro driveTrainGyro1;
    
    public static SpeedController intakeIntakeMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new WPI_TalonSRX(4);
        //LiveWindow.addActuator("DriveTrain", "Left Front Motor", (WPI_TalonSRX) driveTrainLeftFrontMotor);
        //driveTrainLeftFrontMotor.setInverted(false);
        driveTrainLeftRearMotor = new WPI_TalonSRX(3);
        //LiveWindow.addActuator("DriveTrain", "Left Rear Motor", (WPI_TalonSRX) driveTrainLeftRearMotor);
        //driveTrainLeftRearMotor.follow(driveTrainLeftFrontMotor);
        SpeedControllerGroup m_left = new SpeedControllerGroup(driveTrainLeftFrontMotor, driveTrainLeftRearMotor);
        driveTrainRightFrontMotor = new WPI_TalonSRX(8);
        //LiveWindow.addActuator("DriveTrain", "Right Front Motor", (WPI_TalonSRX) driveTrainRightFrontMotor);
        //driveTrainRightFrontMotor.setInverted(false);
        driveTrainRightRearMotor = new WPI_TalonSRX(6);
        //LiveWindow.addActuator("DriveTrain", "Right Rear Motor", (WPI_TalonSRX) driveTrainRightRearMotor);
        //driveTrainRightRearMotor.follow(driveTrainRightFrontMotor);
        SpeedControllerGroup m_right = new SpeedControllerGroup(driveTrainRightFrontMotor, driveTrainRightRearMotor);

        
        driveTrainTDrive = new DifferentialDrive(m_left, m_right);
        

        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Left Encoder", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainGyro1 = new AnalogGyro(0);
        LiveWindow.addSensor("DriveTrain", "Gyro 1", driveTrainGyro1);
        driveTrainGyro1.setSensitivity(0.007);
        driveTrainRightEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Right Encoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        intakeIntakeMotor = new Talon(6);
        LiveWindow.addActuator("Intake", "Intake Motor", (Talon) intakeIntakeMotor);
        intakeIntakeMotor.setInverted(false);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}