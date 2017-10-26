package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MotorPair;
import org.firstinspires.ftc.teamcode.robotplus.hardware.TankDrive;

/**
 * Created by Alex on 8/12/2017.
 */

@TeleOp(name = "Driver", group = "Driver")
public class Driver extends OpMode {
    private TankDrive drive;

    @Override
    public void init() {
        this.drive = new TankDrive(hardwareMap);

        drive.getRightMotors().getMotor1().setDirection(DcMotorSimple.Direction.REVERSE);
        drive.getRightMotors().getMotor2().setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){
        this.drive.getLeftMotors().setPowers(gamepad1.left_stick_y);
        this.drive.getRightMotors().setPowers(gamepad1.right_stick_y);
        if (gamepad1.x) {
            this.drive.getLeftMotors().setPowers(0.25 * gamepad1.left_stick_y);
            this.drive.getRightMotors().setPowers(0.25 * gamepad1.right_stick_y);
        }
    }
}
