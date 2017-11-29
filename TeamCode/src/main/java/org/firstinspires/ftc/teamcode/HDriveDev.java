package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//fl controller 1 port 2
//fr controller 0 port 1
//bl controller 0 port 2
//br controller 1 port 1

@TeleOp(name = "Li t G abber P ogrom")
@Disabled
public class HDriveDev extends OpMode {

    DcMotor frontRight, frontLeft, backRight, backLeft, liftMotor;
    Servo theClamp;

    double mSpeed = 1;
    boolean isDriving = false;

    HoloHelper hh = new HoloHelper();

    public void init() {
        frontLeft = hardwareMap.dcMotor.get("fl");
        frontRight = hardwareMap.dcMotor.get("fr");
        backLeft = hardwareMap.dcMotor.get("bl");
        backRight = hardwareMap.dcMotor.get("br");

        hh.setMotors(frontLeft, frontRight, backLeft, backRight);

        //liftMotor = hardwareMap.dcMotor.get("lift");
    }

    public void loop(){

        if(gamepad1.left_stick_y > 0.1){
            //Drive backward

            isDriving = true;

            telemetry.addData(">", "Driving backward");

            frontRight.setPower(gamepad1.left_stick_y*mSpeed);
            backLeft.setPower(gamepad1.left_stick_y*mSpeed);
            frontLeft.setPower(gamepad1.left_stick_y*mSpeed);
            backRight.setPower(gamepad1.left_stick_y*mSpeed);
        } else if (gamepad1.left_stick_y < -0.1) {
            //Drive forward

            isDriving = true;

            telemetry.addData(">", "Driving forward");

            frontRight.setPower(gamepad1.left_stick_y*mSpeed);
            backLeft.setPower(gamepad1.left_stick_y*mSpeed);
            frontLeft.setPower(gamepad1.left_stick_y*mSpeed);
            backRight.setPower(gamepad1.left_stick_y*mSpeed);
        }

        if (gamepad1.left_stick_x > 0.1) {
            //strafe right

            isDriving = true;

            telemetry.addData(">", "Strafe right");

            backRight.setPower(gamepad1.left_stick_x*-mSpeed);
            frontLeft.setPower(gamepad1.left_stick_x*mSpeed);
            frontRight.setPower(gamepad1.left_stick_x*-mSpeed);
            backLeft.setPower(gamepad1.left_stick_x*mSpeed);
        } else if (gamepad1.left_stick_x < -0.1) {
            //strafe left

            isDriving = true;

            telemetry.addData(">", "Strafe left");

            backRight.setPower(gamepad1.left_stick_x*-mSpeed);
            frontLeft.setPower(gamepad1.left_stick_x*mSpeed);
            frontRight.setPower(gamepad1.left_stick_x*-mSpeed);
            backLeft.setPower(gamepad1.left_stick_x*mSpeed);

        }
        if (gamepad1.right_stick_x >= 0.1 ){
            //turn RIGHT

            isDriving = true;

            telemetry.addData(">", "Turn right");

            frontLeft.setPower(gamepad1.right_stick_x*-mSpeed);
            backRight.setPower(gamepad1.right_stick_x*mSpeed);
            frontRight.setPower(gamepad1.right_stick_x*-mSpeed);
            backLeft.setPower(gamepad1.right_stick_x*mSpeed);
        } else if (gamepad1.right_stick_x <= -0.1){
            //turn left

            isDriving = true;

            telemetry.addData(">", "Turn left");

            frontLeft.setPower(gamepad1.right_stick_x*-mSpeed);
            backRight.setPower(gamepad1.right_stick_x*mSpeed);
            frontRight.setPower(gamepad1.right_stick_x*-mSpeed);
            backLeft.setPower(gamepad1.right_stick_x*mSpeed);
        } else if (!isDriving) {
            //Do nothing
            fullStop();
        }

        isDriving = false;


       /* if(gamepad1.dpad_up){
            liftMotor.setPower(0.2);
            telemetry.addData(">", "Lift going up");
        } else if (gamepad1.dpad_down){
            liftMotor.setPower(0.2);
            telemetry.addData(">", "Lift going down");
        } else {
            telemetry.addData(">", "Lift going nowhere");
            liftMotor.setPower(0);
        }

        if(gamepad1.x) {
            telemetry.addData(">", "Open da clamp");
            theClamp.setPosition(0.2);
        } else if (gamepad1.y){
            telemetry.addData(">", "Close da clamp");
            theClamp.setPosition(0);
        }*/


        if(gamepad1.guide){
            fullStop();
            telemetry.addData(">", "Robot is doing nothing");
        }


        if(gamepad1.atRest()){
            telemetry.addData(">", "Gamepad 1 is idle");
        }

        //telemetry.addData("Lift power", liftMotor.getPower());
        telemetry.addData("Backleft power", backLeft.getPower());
        telemetry.addData("Backright power", backRight.getPower());
        telemetry.addData("Frontleft power", frontLeft.getPower());
        telemetry.addData("Frontright power", frontRight.getPower());

        //telemetry.addData("theClamp", theClamp.getPosition());
        telemetry.addData("isDriving", isDriving);
        telemetry.addData("mSpeed", mSpeed);
        telemetry.addData("Left stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        telemetry.addData("Right stick x", gamepad1.right_stick_x);
        telemetry.addData("Right stick y", gamepad1.right_stick_y);

        telemetry.update();

    }

    public void fullStop() {
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
    }

}