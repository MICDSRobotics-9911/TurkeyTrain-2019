package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robotplus.hardware.MotorPair;

/**
 * Created by Alex on 8/12/2017.
 */

@TeleOp(name = "PhysicsDriver", group = "Driver")
public class Driver extends OpMode {
    private MotorPair leftMotors;
    private MotorPair rightMotors;
    private boolean atZeroPos = false; // left position of ram
    private MediaPlayer songKodak;
    private MediaPlayer songThomas;
    private MediaPlayer songSicko;

    @Override
    public void init() {
        this.leftMotors = new MotorPair(hardwareMap, "front_left", "rear_left");
        this.rightMotors = new MotorPair(hardwareMap, "front_right", "rear_right");

        // motor config
        this.leftMotors.getMotor1().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.leftMotors.getMotor2().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.rightMotors.getMotor1().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.rightMotors.getMotor2().setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        this.songKodak = MediaPlayer.create(hardwareMap.appContext, R.raw.pattycake);
        this.songThomas = MediaPlayer.create(hardwareMap.appContext, R.raw.thomas);
        this.songSicko = MediaPlayer.create(hardwareMap.appContext, R.raw.sickomode);
    }

    @Override
    public void loop() {
        this.leftMotors.setPowers(-gamepad1.right_stick_y);
        this.rightMotors.setPowers(gamepad1.left_stick_y);
        
        if (gamepad1.a) {
            this.songThomas.start();
        }
        else if (gamepad1.b) {
            this.songKodak.start();
        }
        else if (gamepad1.y) {
            this.songSicko.start();
        }

        if (gamepad1.x) {
            this.songKodak.pause();
            this.songThomas.pause();
            this.songSicko.pause();
        }
    }
}
