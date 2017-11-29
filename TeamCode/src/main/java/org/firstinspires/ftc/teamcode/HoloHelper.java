package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.sun.tools.javac.jvm.ClassWriter;

/**
 * Created by lleague on 11/5/2017.
 */

public class HoloHelper {
    private DcMotor fl, fr, bl, br;

    public void setMotors(DcMotor nfl, DcMotor nfr, DcMotor nbl, DcMotor nbr){
        this.fl = nfl;
        this.fr = nfr;
        this.bl = nbl;
        this.br = nbr;
    }

    public void forward(double joyPower){
        fl.setPower(-joyPower);
        fr.setPower(joyPower);
        bl.setPower(-joyPower);
        br.setPower(joyPower);
    }

    public void backwards(double joyPower){
        br.setPower(joyPower);
        fl.setPower(-joyPower);
        fr.setPower(joyPower);
        bl.setPower(-joyPower);
    }

    public void left(double joyPower){
        fr.setPower(joyPower);
        br.setPower(-joyPower);
        fl.setPower(joyPower);
        bl.setPower(-joyPower);
    }

    public void right(double joyPower){
        fr.setPower(-joyPower);
        br.setPower(joyPower);
        fl.setPower(-joyPower);
        bl.setPower(joyPower);
    }

    public void turn(double joyPower){
        fl.setPower(joyPower*-1);
        br.setPower(joyPower);
        fr.setPower(joyPower*-1);
        bl.setPower(joyPower);
    }

    public void stop(){
        fl.setPower(0);
        br.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
    }

    public String startupTelemetry(){
        return "HoloHelper library loaded and ready!";
    }

}

