package lk.edu.ijse.metromanagement.common;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.util.Optional;

public class NotificationController {

    private static void create(String title,String text,String grafic){
        Notifications notifications = Notifications.create()
                .darkStyle()
                .title(title)
                .text(text)
                .position(Pos.BASELINE_RIGHT)
                .hideAfter(Duration.millis(5000))
                .graphic(new ImageView(grafic));
        notifications.show();
    }

    public static void createCustom(String title,String text,String grafic){
        create(title,text,grafic);
    }

    public static void createError(String title,String text){
        createCustom(title, text,"/lk/edu/ijse/metromanagement/assest/newError.png");
    }

    public static void createSuccesful(String title,String text){
        createCustom(title,text,"/lk/edu/ijse/metromanagement/assest/checked.png");
    }

    public static ButtonType createConfigAlert(){
        Alert remaining = new Alert(Alert.AlertType.CONFIRMATION);

        remaining.setGraphic(new ImageView(new Image("/lk/edu/ijse/metromanagement/assest/question.png")));
        remaining.setHeaderText("Warning");
        remaining.setContentText("Do you Want to continue that process");

        Optional<ButtonType> result = remaining.showAndWait();
        return result.get();
    }
}
