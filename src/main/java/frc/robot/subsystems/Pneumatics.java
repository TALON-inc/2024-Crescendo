// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
  private PneumaticHub PneumaticHub = null;
  private DoubleSolenoid intake_Piston = null;
}
public Pneumatics(){
  PneumaticHub = new PneumaticHub();
  PneumaticHub.enableCompressor
  intake_Piston = PneumaticHub.makeDoublesolenoid(OPEN_CHANNEL, CLOSE_CHANNEL);
}

public void Open(){
intake_Piston.set(DoubleSolenoid.Value.kForward);
}

public void Close(){
intake_Piston.set(DoubleSolenoid.Value.kReverse);
}

public void OPEN2(){
 actuator_Piston.set(DoubleSolenoid.Value.kForward); 
}

public void close2(){
actuator_Piston.set(DoubleSolenoid.Value.kReverse); 
}
