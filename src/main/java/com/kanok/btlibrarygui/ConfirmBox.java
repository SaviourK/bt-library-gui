package com.kanok.btlibrarygui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    static Button yesBtn;
    static Button noBtn;


    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        yesBtn = new Button("Yes");
        yesBtn.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noBtn = new Button("No");
        noBtn.setOnAction(e -> {
            answer = false;
            window.close();
        });

       VBox layout = new VBox(10);

        layout.getChildren().addAll(label, yesBtn, noBtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
