package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MotorPair;
import org.firstinspires.ftc.teamcode.robotplus.hardware.TankDrive;

/**
 * Created by Alex on 8/12/2017.
 */

@TeleOp(name = "Driver", group = "Driver")
public class Driver extends LinearOpMode {
    private TankDrive drive;

    @Override
    public void runOpMode() {
        this.drive = new TankDrive(hardwareMap);

        while(opModeIsActive()) {
            this.drive.getLeftMotors().setPowers(gamepad1.left_stick_y);
            this.drive.getRightMotors().setPowers(gamepad1.right_stick_y);
            if (gamepad1.x) {
                this.drive.getLeftMotors().setPowers(0.25 * gamepad1.left_stick_y);
                this.drive.getRightMotors().setPowers(0.25 * gamepad1.right_stick_y);
            }
        }
    }
}
