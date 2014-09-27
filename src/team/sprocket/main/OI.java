//Contributors: HC, FH
package team.sprocket.main;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final Joystick jy_LeftAttack = new Joystick(RobotMap.leftJoystickUSBPort);
    public static final Joystick jy_RightAttack = new Joystick(RobotMap.rightJoystickUSBPort);
    public static final Joystick jy_Gamepad = new Joystick(RobotMap.gamepadUSBPort);

    public static final JoystickButton jb_GamepadX = new JoystickButton(jy_Gamepad, 1);
    public static final JoystickButton jb_GamepadA = new JoystickButton(jy_Gamepad, 2);
    public static final JoystickButton jb_GamepadB = new JoystickButton(jy_Gamepad, 3);
    public static final JoystickButton jb_GamepadY = new JoystickButton(jy_Gamepad, 4);
    public static final JoystickButton jb_LeftGamepadTrigger = new JoystickButton(jy_Gamepad, 5);
    public static final JoystickButton jb_RightGamepadTrigger = new JoystickButton(jy_Gamepad, 6);
    public static final JoystickButton jb_LeftGamepadThrottle = new JoystickButton(jy_Gamepad, 7);
    public static final JoystickButton jb_RightGamepadThrottle = new JoystickButton(jy_Gamepad, 8);
    public static final JoystickButton jb_Start = new JoystickButton(jy_Gamepad, 10);

    public static final JoystickButton jb_LeftAttackTrigger = new JoystickButton(jy_LeftAttack, 1);
    public static final JoystickButton jb_RightAttackTrigger = new JoystickButton(jy_RightAttack, 1);
    public static final JoystickButton jb_LeftAttackBottom = new JoystickButton(jy_LeftAttack, 2);
    public static final JoystickButton jb_RightAttackBottom = new JoystickButton(jy_RightAttack, 2);
    public static final JoystickButton jb_LeftAttackTop = new JoystickButton(jy_LeftAttack, 3);
    public static final JoystickButton jb_RightAttackTop = new JoystickButton(jy_RightAttack, 3);
    public static final JoystickButton jb_LeftAttack4 = new JoystickButton(jy_LeftAttack, 4);
    public static final JoystickButton jb_LeftAttack5 = new JoystickButton(jy_LeftAttack, 5);
    public static final JoystickButton jb_LeftAttack6 = new JoystickButton(jy_LeftAttack, 6);
    public static final JoystickButton jb_LeftAttack7 = new JoystickButton(jy_LeftAttack, 7);
    public static final JoystickButton jb_LeftAttack8 = new JoystickButton(jy_LeftAttack, 8);
    public static final JoystickButton jb_LeftAttack9 = new JoystickButton(jy_LeftAttack, 9);
    public static final JoystickButton jb_LeftAttack10 = new JoystickButton(jy_LeftAttack, 10);
    public static final JoystickButton jb_LeftAttack11 = new JoystickButton(jy_LeftAttack, 11);
    public static final JoystickButton jb_RightAttack4 = new JoystickButton(jy_RightAttack, 4);
    public static final JoystickButton jb_RightAttack5 = new JoystickButton(jy_RightAttack, 5);
    public static final JoystickButton jb_RightAttack6 = new JoystickButton(jy_RightAttack, 6);
    public static final JoystickButton jb_RightAttack7 = new JoystickButton(jy_RightAttack, 7);
    public static final JoystickButton jb_RightAttack8 = new JoystickButton(jy_RightAttack, 8);
    public static final JoystickButton jb_RightAttack9 = new JoystickButton(jy_RightAttack, 9);
    public static final JoystickButton jb_RightAttack10 = new JoystickButton(jy_RightAttack, 10);
    public static final JoystickButton jb_RightAttack11 = new JoystickButton(jy_RightAttack, 11);

    public static final ADXL345_I2C ac_main = new ADXL345_I2C(RobotMap.accelerometerDigitalModule, ADXL345_I2C.DataFormat_Range.k2G);
    public static final AnalogChannel u_leftPing = new AnalogChannel(1);
    public static final AnalogChannel u_rightPing = new AnalogChannel(2); //MaxBotix Ultrasonic Ping Sensor
    public static final AnalogChannel p_Arm = new AnalogChannel(3);

    public static final DigitalInput ls_rackLimit = new DigitalInput(1, 1);
    public static final DigitalInput ls_advanceLatchLimit = new DigitalInput(1, 2);
    public static final DigitalInput ls_withdrawLatchLimit = new DigitalInput(1, 3);
    public static final DigitalInput ls_harvesterRaiseLimit = new DigitalInput(1, 4);
    public static final DigitalInput ls_armLowerLimit = new DigitalInput(1, 5);
    public static final DigitalInput ls_armRaiseLimit = new DigitalInput(1, 6);
    public static final DigitalInput ls_harvesterLowerLimit = new DigitalInput(1, 7);
    public static final DigitalInput ls_pneumaticControlSwitch = new DigitalInput(1,8);
    
    
    public static final DigitalOutput rx_LeftPing = new DigitalOutput(1, 8);
    public static final DigitalOutput rx_RightPing = new DigitalOutput(1, 9);
    public static final Solenoid solenoid1 = new Solenoid(1);
    public static final Solenoid solenoid2 = new Solenoid(2);
    
    public static final Relay relay = new Relay(1);
    
    //bill's comment!!!!!!

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public OI() {
        //button binds go in here
    }

}
