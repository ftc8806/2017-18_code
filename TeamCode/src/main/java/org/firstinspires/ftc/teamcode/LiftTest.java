package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lleague on 11/1/2017.
 */

@TeleOp(name = "LIFTER PROGRAM")
public class LiftTest extends OpMode {
    DcMotor liftMotor;
    Servo theClamp;

    @Override
    public void init() {
        liftMotor = hardwareMap.dcMotor.get("lift");
        theClamp = hardwareMap.servo.get("clamp");
        telemetry.addData("!", "Use the dpad to move the lift up and down!");
        telemetry.addData("!", "Use X to close the clamp!");
        telemetry.addData("!", "Use Y to open the clamp!");
    }

    @Override
    public void loop() {
        if(gamepad1.dpad_up){
            liftMotor.setPower(0.5);
            telemetry.addData(">", "Lift going up");
        } else if (gamepad1.dpad_down){
            liftMotor.setPower(-0.25);
            telemetry.addData(">", "Lift going down");
        } else {
            telemetry.addData(">", "Lift going nowhere");
            liftMotor.setPower(0);
        }

        if(gamepad1.x) {
            telemetry.addData(">", "close da clamp");
            theClamp.setPosition(0.135);
        } else if (gamepad1.y){
            telemetry.addData(">", "open da clamp");
            theClamp.setPosition(0);
        }

        telemetry.addData("!", "Use the dpad to move the lift up and down!");
        telemetry.addData("!", "Use X to close the clamp!");
        telemetry.addData("!", "Use Y to open the clamp!");

    }
}
