// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends Command {
  private final Shooter shooter;
  private final Intake intake;
  private final Timer timer;

  /** Creates a new AutoShoot. */
  public AutoShoot(Shooter shooter, Intake intake) {
    this. shooter = shooter;
    this.intake = intake;
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.shootSpeaker();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(shooter.isShooterAtSpeakerSpeed() && intake.isNoteLoaded()) {
      intake.moveIntakeChannel();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !intake.isNoteLoaded() && timer.hasElapsed(0.5);
  }
}
