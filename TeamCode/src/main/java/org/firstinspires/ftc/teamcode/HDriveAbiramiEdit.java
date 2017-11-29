package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "unstable????")
@Disabled
public class HDriveAbiramiEdit extends OpMode {

    DcMotor frontRight, frontLeft, backRight, backLeft;

    double mSpeed = 1;
    boolean isDriving = false;

    public void init() {
        frontLeft = hardwareMap.dcMotor.get("fl");
        frontRight = hardwareMap.dcMotor.get("fr");
        backLeft = hardwareMap.dcMotor.get("bl");
        backRight = hardwareMap.dcMotor.get("br");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void loop() {

        if (gamepad1.left_stick_y > 0.1) {
            //Drive backward

            isDriving = true;

            frontRight.setPower(gamepad1.left_stick_y * mSpeed);
            backLeft.setPower(gamepad1.left_stick_y * mSpeed);
            frontLeft.setPower(gamepad1.left_stick_y * -mSpeed);
            backRight.setPower(gamepad1.left_stick_y * -mSpeed);
        } else if (gamepad1.left_stick_y < -0.1) {
            //Drive forward

            isDriving = true;

            frontRight.setPower(gamepad1.left_stick_y * mSpeed);
            backLeft.setPower(gamepad1.left_stick_y * mSpeed);
            frontLeft.setPower(gamepad1.left_stick_y * -mSpeed);
            backRight.setPower(gamepad1.left_stick_y * -mSpeed);
        }

        if (gamepad1.left_stick_x > 0.1) {
            //strafe right

            isDriving = true;

            backRight.setPower(gamepad1.left_stick_x * mSpeed);
            frontLeft.setPower(gamepad1.left_stick_x * mSpeed);
            frontRight.setPower(gamepad1.left_stick_x * mSpeed);
            backLeft.setPower(gamepad1.left_stick_x * mSpeed);
        } else if (gamepad1.left_stick_x < -0.1) {
            //strafe left

            isDriving = true;

            frontRight.setPower(gamepad1.left_stick_x * mSpeed);
            backLeft.setPower(gamepad1.left_stick_x * mSpeed);
            frontLeft.setPower(gamepad1.left_stick_x * mSpeed);
            backRight.setPower(gamepad1.left_stick_x * mSpeed);

        }
        if (gamepad1.right_stick_x >= 0.1) {
            //turn RIGHT

            isDriving = true;

            frontLeft.setPower(gamepad1.right_stick_x * mSpeed);
            backRight.setPower(gamepad1.right_stick_x * -mSpeed);
            frontRight.setPower(gamepad1.right_stick_x * mSpeed);
            backLeft.setPower(gamepad1.right_stick_x * -mSpeed);
        } else if (gamepad1.right_stick_x <= -0.1) {
            //turn left

            isDriving = true;

            frontLeft.setPower(gamepad1.right_stick_x * mSpeed);
            backRight.setPower(gamepad1.right_stick_x * -mSpeed);
            frontRight.setPower(gamepad1.right_stick_x * mSpeed);
            backLeft.setPower(gamepad1.right_stick_x * -mSpeed);
        } else if (!isDriving) {
            //Do nothing
            fullStop();
        }

        isDriving = false;

        if (gamepad1.guide) {
            fullStop();
        }

    }

    public void fullStop() {
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
    }
}

