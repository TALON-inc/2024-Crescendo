// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climb extends SubsystemBase {
  private final CANSparkMax m_leftFrontMotor = new CANSparkMax(ClimbConstants.kClimbLeftCanId, ClimbConstants.kMotorType);
  private final CANSparkMax m_rightFrontMotor = new CANSparkMax(ClimbConstants.kClimbRightCanId, ClimbConstants.kMotorType);

  /** Creates a new Climb. */
  public Climb() {
    // add initialization for motors
    m_rightFrontMotor.follow(m_leftFrontMotor);
    m_rightFrontMotor.setInverted(true);
  }

  public void climbUp() {
    m_leftFrontMotor.set(0.5);
  }

  public void climbDown() {
    m_leftFrontMotor.set(-0.5);
  }

  public void stopClimb() {
    m_leftFrontMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}