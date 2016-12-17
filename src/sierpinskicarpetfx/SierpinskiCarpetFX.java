/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sierpinskicarpetfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author hossein
 */
public class SierpinskiCarpetFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        drawCarpet(root, 0, 0, 600);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Sierpinski Carpet FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawCarpet(Group root, int x, int y, int side) {
        int subSide = side / 3;
        Rectangle rectangle = new Rectangle(x + subSide, y + subSide, subSide, subSide);

        if (subSide > 30) {
            rectangle.setFill(Color.BLACK);
        } else if (subSide > 10) {
            rectangle.setFill(Color.rgb(255, 223, 0));
        } else {
            rectangle.setFill(Color.rgb(160, 82, 45));
        }
        root.getChildren().add(rectangle);
        if (subSide >= 3) {
            drawCarpet(root, x, y, subSide);
            drawCarpet(root, x + subSide, y, subSide);
            drawCarpet(root, x + 2 * subSide, y, subSide);
            drawCarpet(root, x, y + subSide, subSide);
            drawCarpet(root, x + 2 * subSide, y + subSide, subSide);
            drawCarpet(root, x, y + 2 * subSide, subSide);
            drawCarpet(root, x + subSide, y + 2 * subSide, subSide);
            drawCarpet(root, x + 2 * subSide, y + 2 * subSide, subSide);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
