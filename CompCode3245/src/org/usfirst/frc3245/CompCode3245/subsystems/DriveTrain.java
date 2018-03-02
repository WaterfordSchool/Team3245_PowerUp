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

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final WPI_TalonSRX leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    
    private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final WPI_TalonSRX rightRearMotor = RobotMap.driveTrainRightRearMotor;
    
    private final DifferentialDrive tDrive = RobotMap.driveTrainTDrive;
    
    public final ADXRS450_Gyro gyro1 = RobotMap.driveTrainGyro1;
   
    public double motorSpeed;
    public int averagePos;
   
    public DriveTrain () {
	   leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
	   leftFrontMotor.setSensorPhase(false);
	   rightRearMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 4);
	   rightRearMotor.setSensorPhase(false);
   }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive(0.7));   
     }
    
    public void drive(double left, double right) {
    	tDrive.tankDrive(left, right);
    }

    public void drive(Joystick joy, double kSpeed) {
    	drive(-kSpeed*joy.getY(), -kSpeed*joy.getAxis(AxisType.kThrottle));
    	SmartDashboard.putNumber("Right Moter Speed", rightFrontMotor.get());
    	SmartDashboard.putNumber("Left Moter Speed", leftFrontMotor.get());
    }
    
    public void resetEncoders() {
    	leftFrontMotor.setSelectedSensorPosition(0, 0, 0);
    	rightFrontMotor.setSelectedSensorPosition(0, 0, 0);
    	averagePos = 0;
    }
    
    public void reportEncoders() {
    	SmartDashboard.putNumber("Right Encoder Position", rightFrontMotor.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Left Encoder Position", leftFrontMotor.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("Left Motor Speed", leftFrontMotor.get());
    	SmartDashboard.putNumber("Right Motor Speed", rightFrontMotor.get());
    	SmartDashboard.putNumber("Average Encoder Position", averagePos);
    }
    
    public double getDistance() {
    	averagePos = (rightFrontMotor.getSelectedSensorPosition(0)+leftFrontMotor.getSelectedSensorPosition(0))/2;
    	return averagePos;
    }
    
    public void stop() {
    	drive(0,0);
    }
}
