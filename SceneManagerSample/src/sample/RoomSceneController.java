package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class RoomSceneController
{
	@FXML
	public Label stackSizeLabel;
	@FXML
	public GridPane pane;

	public void initialize()
	{
		int stackSize = Main.sceneManager.getStackSize();
		stackSizeLabel.setText(stackSize + " " + (stackSize == 1 ? "scene" : "scenes") + " in stack behind this now");
		Platform.runLater(() -> pane.requestFocus());
	}

	public void enter(ActionEvent actionEvent) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("RoomScene.fxml"));
		root.setStyle("-fx-background-color: " + ((Button)actionEvent.getSource()).getUserData().toString() + ";");
		Main.sceneManager.pushScene(new ManagedScene(root));
	}

	public void back(ActionEvent actionEvent)
	{
		Main.sceneManager.popScene();
	}

	public void leave(ActionEvent actionEvent)
	{
		Main.sceneManager.popAllExceptFirst();
	}
}
