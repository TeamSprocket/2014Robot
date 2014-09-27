/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.sprocket.commands.shooter;

import team.sprocket.commands.CommandBase;

/**
 *
 * @author Forest
 */
public class Unharvest extends CommandBase {

    protected void initialize() {

    }

    protected void execute() {
        arm.rollOut();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
