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

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;
import org.usfirst.frc3245.CompCode3245.commands.*;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Wrist extends Subsystem {
	
	private final SpeedController WM = RobotMap.WristMotor;
	
    public void initDefaultCommand() {
        setDefaultCommand(new FlickOfTheWrist());

    }
    
    public void LiftWrist () {
    	WM.set(-.35*Robot.oi.operator.getAxis(AxisType.kThrottle));

    }
    
    public void DropWrist() {
    	WM.set(-.2*Robot.oi.operator.getAxis(AxisType.kThrottle));
    }
    
    public void DontMove() {
    	WM.set(0);
    }
}

