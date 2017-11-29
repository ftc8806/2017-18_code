package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lleague on 11/17/2017.
 */

@TeleOp(name = "DRIVE PROGRAM")
public class HDrive_Nov_7_2017 extends OpMode {

    DcMotor fl ,fr, bl, br, liftMotor;
    Servo theClamp;
    double power = 1;

    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");
        liftMotor = hardwareMap.dcMotor.get("lift");
        theClamp = hardwareMap.servo.get("clamp");
    }

    @Override
    public void loop() {
        /*if(gamepad1.a){
            fl.setPower(1);
        } else if(gamepad1.b){
            fr.setPower(1);
        } else if(gamepad1.x){
            bl.setPower(1);
        } else if(gamepad1.y){
            br.setPower(1);
        } else {
            stop();
        }*/

        if(gamepad1.dpad_up){
            fl.setPower(-1);
            fr.setPower(1);
            bl.setPower(-1);
            br.setPower(1);
        } else if(gamepad1.dpad_down){
            fl.setPower(1);
            fr.setPower(-1);
            bl.setPower(1);
            br.setPower(-1);
        } else if(gamepad1.dpad_left){
            fr.setPower(1);
            br.setPower(-1);
            fl.setPower(1);
            bl.setPower(-1);
        } else if(gamepad1.dpad_right){
            fr.setPower(-1);
            br.setPower(1);
            fl.setPower(-1);
            bl.setPower(1);
        } else if(gamepad1.right_bumper){
            fr.setPower(-1);
            br.setPower(-1);
            fl.setPower(-1);
            bl.setPower(-1);
        } else if(gamepad1.left_bumper){
            fr.setPower(1);
            br.setPower(1);
            fl.setPower(1);
            bl.setPower(1);
        } else {
            stop();
        }

        if(gamepad2.dpad_up){
            liftMotor.setPower(0.5);
            telemetry.addData(">", "Lift going up");
        } else if (gamepad2.dpad_down){
            liftMotor.setPower(-0.25);
            telemetry.addData(">", "Lift going down");
        } else {
            telemetry.addData(">", "Lift going nowhere");
            liftMotor.setPower(0);
        }

        if(gamepad2.x) {
            telemetry.addData(">", "close da clamp");
            theClamp.setPosition(0.135);
        } else if (gamepad2.y){
            telemetry.addData(">", "open da clamp");
            theClamp.setPosition(0);
        }

        telemetry.addData("!", "Use the dpad to drive!");
        telemetry.addData("!", "Use the bumpers to turn!");
        telemetry.addData("!", "Use start/back the change power!");
        telemetry.update();

    }

    public void stop(){
        fl.setPower(0);
        br.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
    }
}
