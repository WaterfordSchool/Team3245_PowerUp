package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.RobotMap;

<<<<<<< HEAD
=======
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

>>>>>>> origin/Zahara
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
<<<<<<< HEAD
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
=======
    private final WPI_TalonSRX ElevatorMotor = RobotMap.ElevatorMotor;
>>>>>>> origin/Zahara

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
<<<<<<< HEAD
    public void inSpin() {
    	intakeMotor.set(-1.0);
    }
    public void outSpin() {
    	intakeMotor.set(1.0);
    }
    public void stop() {
    	intakeMotor.set(0);
=======
    public void up() {
    	ElevatorMotor.set(.7);
    }
    public void down() {
    	ElevatorMotor.set(-.7);
    }
    public void stop() {
    	ElevatorMotor.set(0);
>>>>>>> origin/Zahara
    }
}
