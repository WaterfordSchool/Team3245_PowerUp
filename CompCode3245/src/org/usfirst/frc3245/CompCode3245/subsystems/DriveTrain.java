// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;
import org.usfirst.frc3245.CompCode3245.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final WPI_TalonSRX leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final WPI_TalonSRX rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final DifferentialDrive tDrive = RobotMap.driveTrainTDrive;
    private final Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    private final AnalogGyro gyro1 = RobotMap.driveTrainGyro1;
    private final Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    
    double LEncoderPos = 0, REncoderPos = 0, desiredDistance = 5;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TankDrive());
        
        //Get the position of the Left Encoder (i.e left drive wheel) into left encoder position
     LEncoderPos = leftEncoder.get();
     
     if (LEncoderPos < desiredDistance) {
    	 
    	leftFrontMotor.set(.5);
    	leftRearMotor.set(.5);
     }
     
     else {
    	 leftFrontMotor.stopMotor();
    	 leftRearMotor.stopMotor();
     }

     	//Get the position of the Right Encoder (i.e right drive wheels) into the right encoder position
     
     REncoderPos = rightEncoder.get();
     
     if (REncoderPos < desiredDistance) {
    	 
    	 rightFrontMotor.set(-.5);
    	 rightRearMotor.set(-.5);
     } else {
    	 
    	 rightFrontMotor.stopMotor();
    	 rightRearMotor.stopMotor();
     }
     
     SmartDashboard.putNumber("Left Encoder is moving", LEncoderPos);
     SmartDashboard.putNumber("Right Encoder is Working", REncoderPos);
     
     
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double left, double right) {
    	tDrive.tankDrive(left, right);
    }
    public void drive(Joystick joy) {
    	drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
    }
    
    }