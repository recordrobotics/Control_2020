package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.RobotMap;

public class XboxJoystick extends Controller{
    XboxController xbox;

    public XboxJoystick(){
        xbox = new XboxController(RobotMap.xboxPort);
    }
    
    public double getXAxis (){
        return xbox.getX(Hand.kLeft);
    }

    public double getZ (){
        return getXAxis();
    }

    public double getYAxis (){
        return -0.25*xbox.getY(Hand.kLeft);
    }

    public boolean getButtonState (String buttonName){
        buttonName.toUpperCase();

        switch (buttonName){
            case "X":
                return xbox.getXButton();
            case "Y":
                return xbox.getYButton();
            case "A":
                return xbox.getAButton();
            case "B":
                return xbox.getBButton();
            case "LB":
                return xbox.getBumper(Hand.kLeft);
            case "RB":
                return xbox.getBumper(Hand.kRight);
            default:
                return false;
        }

    }
    public double getCStickXAxis(){
        return xbox.getX(Hand.kRight);
    }
    public double getCStickYAxis(){
        return xbox.getY(Hand.kRight);
    }


}