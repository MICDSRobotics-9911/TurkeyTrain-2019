package us.technoramic5190.turkeytrain;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Alex on 8/12/2017.
 */

@TeleOp(name = "Driver", group = "Driver")
public class Driver extends LinearOpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        while(opModeIsActive()) {
            leftMotor.setPower(gamepad1.left_stick_y);
            rightMotor.setPower(gamepad1.right_stick_y);
        }
    }
}
