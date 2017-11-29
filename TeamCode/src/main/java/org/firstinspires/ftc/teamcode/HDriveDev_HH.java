package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "HH Constructor")
@Disabled
public class HDriveDev_HH extends OpMode {

    DcMotor frontRight, frontLeft, backRight, backLeft, liftMotor;
    //Servo theClamp;

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

            hh.backwards(gamepad1.left_stick_y);

        } else if (gamepad1.left_stick_y < -0.1) {
            //Drive forward

            isDriving = true;

            telemetry.addData(">", "Driving forward");

            hh.forward(gamepad1.left_stick_y);
        }

        if (gamepad1.left_stick_x > 0.1) {
            //strafe right

            isDriving = true;

            telemetry.addData(">", "Strafe right");

            hh.right(gamepad1.left_stick_x);
        } else if (gamepad1.left_stick_x < -0.1) {
            //strafe left

            isDriving = true;

            telemetry.addData(">", "Strafe left");

            hh.left(gamepad1.left_stick_x);

        } else {
            hh.stop();
        }
        /*if (gamepad1.right_stick_x >= 0.1 ){
            //turn RIGHT

            isDriving = true;

            telemetry.addData(">", "Turn right");

            hh.turn(gamepad1.right_stick_x);
        } else if (gamepad1.right_stick_x <= -0.1){
            //turn left

            isDriving = true;

            telemetry.addData(">", "Turn left");

            hh.turn(gamepad1.right_stick_x);
        } else if (!isDriving) {
            //Do nothing
            hh.stop();
        }*/

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
            hh.stop();
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
}