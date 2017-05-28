package me.max.simplefirstgame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by max on 28-5-2017.
 */
public class LevelChooser extends MouseAdapter{

    private boolean level1pressed, level2pressed, level3pressed, level4pressed, level5pressed, level6pressed, level7pressed, level8pressed, level9pressed, level10pressed;

    public void mousePressed(MouseEvent e){
        if (Game.gameState == Game.STATE.LevelChooser) {
            if ((e.getButton() == 1)) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, 50, 100, 45, 45)) {
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level1pressed = true;
                }

                //level2
                else if (mouseOver(mx, my, 100, 100, 45, 45)) {
                    level1pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level2pressed = true;
                }

                //level3
                else if (mouseOver(mx, my, 150, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level3pressed = true;
                }

                //level4
                else if (mouseOver(mx, my, 200, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level4pressed = true;
                }

                //level5
                else if (mouseOver(mx, my, 250, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level5pressed = true;
                }

                //level6
                else if (mouseOver(mx, my, 300, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level6pressed = true;
                }

                //level7
                else if (mouseOver(mx, my, 350, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level7pressed = true;
                }

                //level8
                else if (mouseOver(mx, my, 400, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level9pressed = false;
                    level10pressed = false;
                    level8pressed = true;
                }

                //level9
                else if (mouseOver(mx, my, 450, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level10pressed = false;
                    level9pressed = true;
                }

                //level10
                else if (mouseOver(mx, my, 500, 100, 45, 45)) {
                    level1pressed = false;
                    level2pressed = false;
                    level3pressed = false;
                    level4pressed = false;
                    level5pressed = false;
                    level6pressed = false;
                    level7pressed = false;
                    level8pressed = false;
                    level9pressed = false;
                    level10pressed = true;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (Game.gameState == Game.STATE.LevelChooser) {
            int mx = e.getX();
            int my = e.getY();
            //level1
            if ((mouseOver(mx, my, 50, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level1;
                level1pressed = false;
            }

            //level2
            else if ((mouseOver(mx, my, 100, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level2;
                level2pressed = false;
            }

            //level3
            else if ((mouseOver(mx, my, 150, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level3;
                level3pressed = false;
            }

            //level4
            else if ((mouseOver(mx, my, 200, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level4;
                level4pressed = false;
            }

            //level5
            else if ((mouseOver(mx, my, 250, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level5;
                level5pressed = false;
            }

            //level6
            else if ((mouseOver(mx, my, 300, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level6;
                level6pressed = false;
            }

            //level7
            else if ((mouseOver(mx, my, 350, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level7;
                level7pressed = false;
            }

            //level8
            else if ((mouseOver(mx, my, 400, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level8;
                level8pressed = false;
            }

            //level9
            else if ((mouseOver(mx, my, 450, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level9;
                level9pressed = false;
            }

            //level10
            else if ((mouseOver(mx, my, 500, 100, 45, 45)) && (level1pressed)) {
                Game.gameState = Game.STATE.Level10;
                level10pressed = false;
            }
        }
    }

    public void tick(){
        if (Game.gameState == Game.STATE.LevelChooser) {
            //nothing to tick
        }

    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.LevelChooser) {
            //title
            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.gray);
            g.drawString("Levels", Game.WIDTH / 2 - 90, 60);

            //level font
            Font font2 = new Font("arial", 1, 25);
            g.setFont(font2);

            //level1
            g.setColor(Color.white);
            g.drawRect(50, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("1", 67, 132);

            //level2
            g.setColor(Color.white);
            g.drawRect(100, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("2", 117, 132);

            //level3
            g.setColor(Color.white);
            g.drawRect(150, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("3", 167, 132);

            //level4
            g.setColor(Color.white);
            g.drawRect(200, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("4", 217, 132);

            //level5
            g.setColor(Color.white);
            g.drawRect(250, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("5", 267, 132);

            //level6
            g.setColor(Color.white);
            g.drawRect(300, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("6", 317, 132);

            //level7
            g.setColor(Color.white);
            g.drawRect(350, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("7", 367, 132);

            //level8
            g.setColor(Color.white);
            g.drawRect(400, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("8", 417, 132);

            //level9
            g.setColor(Color.white);
            g.drawRect(450, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("9", 467, 132);

            //level10
            g.setColor(Color.white);
            g.drawRect(500, 100, 45, 45);
            g.setColor(Color.blue);
            g.drawString("10", 508, 132);


        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }
        }

        return false;
    }


}
