package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class MainSceneController
{
	public void enter(ActionEvent actionEvent) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("RoomScene.fxml"));
		Main.sceneManager.pushScene(new ManagedScene(root));
	}

	public void back(ActionEvent actionEvent)
	{
		Main.sceneManager.popScene();
	}
}
