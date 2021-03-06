package frc.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveSystem {
    private Victor _motorDriveFL;
    private Victor _motorDriveRL;
    private Victor _motorDriveFR;
    private Victor _motorDriveRR;

    private double _driveCmd;
    private double _turnCmd;

    public DriveSystem() {
        this._motorDriveFL = new Victor(SheetOfKnowledge.MOTOR_DRIVE_FL);
        this._motorDriveRL = new Victor(SheetOfKnowledge.MOTOR_DRIVE_RL);
        this._motorDriveFR = new Victor(SheetOfKnowledge.MOTOR_DRIVE_FR);
        this._motorDriveRR = new Victor(SheetOfKnowledge.MOTOR_DRIVE_RR);

        this._motorDriveFL.setInverted(SheetOfKnowledge.MOTOR_DRIVE_INVERT_L);
        this._motorDriveRL.setInverted(SheetOfKnowledge.MOTOR_DRIVE_INVERT_L);
        this._motorDriveFR.setInverted(SheetOfKnowledge.MOTOR_DRIVE_INVERT_R);
        this._motorDriveRR.setInverted(SheetOfKnowledge.MOTOR_DRIVE_INVERT_R);

        this.init();
    }

    public void init() {
        this.setCmds(0.0, 0.0);
    }

    public void update() {
        double leftCmd = Utils.limit(
            -this._driveCmd + this._turnCmd,
            -1.0, 1.0);
        double rightCmd = Utils.limit(
            -this._driveCmd - this._turnCmd,
            -1.0, 1.0);
        
        this._motorDriveFL.set(leftCmd);
        this._motorDriveRL.set(leftCmd);
        this._motorDriveFR.set(rightCmd);
        this._motorDriveRR.set(rightCmd);
    }

    public void setCmds(double driveCmd, double turnCmd) {
        this._driveCmd = driveCmd;
        this._turnCmd = turnCmd;
    }
}