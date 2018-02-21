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

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXL345_I2C.Axes;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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

	//Left side hardware
	private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
	private final WPI_TalonSRX leftRearMotor = RobotMap.driveTrainLeftRearMotor;
   // private final Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    //Right side hardware
    private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final WPI_TalonSRX rightRearMotor = RobotMap.driveTrainRightRearMotor;
   // private final Encoder rightEncoder = RobotMap.driveTrainRightEncoder;

    private final DifferentialDrive tDrive = RobotMap.driveTrainTDrive;
    public final ADXRS450_Gyro gyro1 = RobotMap.driveTrainGyro1;
 
	int LEncoderPos = 0, REncoderPos = 0, desiredDistance = 5000;

	public DriveTrain () {
		leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
    	leftFrontMotor.setSensorPhase(true);
    	rightRearMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	rightRearMotor.setSensorPhase(false);		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
    	setDefaultCommand(new TankDrive(0.7));
    }
    
    public void drive(double left, double right) {
    	tDrive.tankDrive(right, left);
    }
    public void drive(Joystick joy, double kSpeed) {
    	drive(kSpeed*joy.getY(), kSpeed*joy.getAxis(AxisType.kThrottle));
    	//SmartDashboard.putNumber("Right Motor Speed", rightFrontMotor.get());
       
    	
    }
    
      public double getPosition() {
    	
    	
        //Get the position of the Left Encoder (i.e left drive wheel) into left encoder position
    //	LEncoderPos = leftFrontMotor.getSelectedSensorPosition(0);
     	//Get the position of the Right Encoder (i.e right drive wheels) into the right encoder position
    	REncoderPos = rightRearMotor.getSelectedSensorPosition(0);
    	
   //  if (LEncoderPos < desiredDistance) {
    	 
    //	leftFrontMotor.set(.5);
    //	leftRearMotor.set(.5);
   //  }
     
   //  else {
   // 	 leftFrontMotor.stopMotor();
    //	 leftRearMotor.stopMotor();
    // }
   
   //  if (REncoderPos < desiredDistance) {
    	 
    //	 rightFrontMotor.set(-.5);
   // 	 rightRearMotor.set(-.5);
  //   } else {
  //  	 
    //	 rightFrontMotor.stopMotor();
    //	 rightRearMotor.stopMotor();
    // }
     
    // SmartDashboard.putNumber("Left Encoder position is ", LEncoderPos);
    // SmartDashboard.putNumber("Right Encoder position is ", REncoderPos);
     
  
     
	return ((leftFrontMotor.getSelectedSensorPosition(0) * -1.0) + rightRearMotor.getSelectedSensorPosition(0))/2;
    
    }
      public void ReportEncoders() {
    	  //Get the position of the Left Encoder (i.e left drive wheel) into left encoder position
    	  LEncoderPos = leftFrontMotor.getSelectedSensorPosition(0);
     	  //Get the position of the Right Encoder (i.e right drive wheels) into the right encoder position
    	  REncoderPos = rightRearMotor.getSelectedSensorPosition(0);
          SmartDashboard.putNumber("Left Encoder position is ", leftFrontMotor.getSelectedSensorPosition(0));
          SmartDashboard.putNumber("Left Encoder speed is ", -leftFrontMotor.get() );
        
          SmartDashboard.putNumber("Right Encoder position is ", REncoderPos);
          SmartDashboard.putNumber("Right Encoder speed is ", rightRearMotor.get());
      }
      
      public void resetEncoders() {
    	  leftFrontMotor.setSelectedSensorPosition(0,0,0);
    	  rightRearMotor.setSelectedSensorPosition(0, 0, 0);
      }
  }
