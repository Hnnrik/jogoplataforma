package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilz.CarregarSave;
import static utilz.Constantes.UI.PauseButtons.*;

public class SoundButton extends PauseButton {

  private BufferedImage[][] soundImgs;
  private boolean mouseOver, mousePressed;
  private boolean muted;
  private int rowIndex, colIndex;

  public SoundButton(int x, int y, int LARGURA, int ALTURA) {
    super(x, y, LARGURA, ALTURA);

    loadSoundImgs();
  }

  private void loadSoundImgs() {
    BufferedImage temp = CarregarSave.GetSpriteAtlas(CarregarSave.SOUND_BUTTONS);
    soundImgs = new BufferedImage[2][3];
    for (int j = 0; j < soundImgs.length; j++)
      for (int i = 0; i < soundImgs[j].length; i++)
        soundImgs[j][i] = temp.getSubimage(i * SOUND_SIZE_DEFAULT, j * SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT);
  }

  public void atualizar() {
    if (muted)
      rowIndex = 1;
    else
      rowIndex = 0;

    colIndex = 0;
    if (mouseOver)
      colIndex = 1;
    if (mousePressed)
      colIndex = 2;

  }

  public void resetBools() {
    mouseOver = false;
    mousePressed = false;
  }

  public void draw(Graphics g) {
    g.drawImage(soundImgs[rowIndex][colIndex], x, y, LARGURA, ALTURA, null);
  }

  public boolean isMouseOver() {
    return mouseOver;
  }

  public void setMouseOver(boolean mouseOver) {
    this.mouseOver = mouseOver;
  }

  public boolean isMousePressed() {
    return mousePressed;
  }

  public void setMousePressed(boolean mousePressed) {
    this.mousePressed = mousePressed;
  }

  public boolean isMuted() {
    return muted;
  }

  public void setMuted(boolean muted) {
    this.muted = muted;
  }

}