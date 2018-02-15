package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application
{
    public static SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        sceneManager = new SceneManager(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        primaryStage.setTitle("SceneManager sample");

        //Instead of
        //Scene scene = new Scene(root);
        //primaryStage.setScene(scene);
        //we will write
        ManagedScene scene = new ManagedScene(root);
        sceneManager.pushScene(scene, true);
        //And if there will be a necessity to know to which SceneManager does this scene belong
        scene.setManager(sceneManager);

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
