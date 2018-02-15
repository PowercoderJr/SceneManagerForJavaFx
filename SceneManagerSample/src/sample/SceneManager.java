package sample;

import javafx.stage.Stage;

import java.util.Stack;

/**
 * Contains stack of scenes. At putting/removing scenes to/from stack there calls Stage.setScene() with top scene in stack.
 * <br>Shared at https://github.com/PowercoderJr/SceneManagerForJavaFx
 */
public class SceneManager
{
	private Stage stage;
	private Stack<ManagedScene> scenes;
	private static final boolean RESIZE_STAGE_DEFAULT_VALUE = false;

	public SceneManager(Stage stage)
	{
		this.stage = stage;
		scenes = new Stack<ManagedScene>();
	}

	/**
	 * Puts the scene in stack and sets it for stage.
	 * @param scene New scene
	 * @param resizeStage Should the stage be resized to size of new scene?
	 *                    True - yes, it should. False - No, save current stage size. Default value is false.
	 * @return argument
	 */
	public ManagedScene pushScene(ManagedScene scene, boolean resizeStage)
	{
		double w = stage.getWidth(), h = stage.getHeight();
		stage.setScene(scene);
		scenes.push(scene);
		//scene.setManager(this);

		if (!resizeStage)
		{
			stage.setWidth(w);
			stage.setHeight(h);
		}
		return scene;
	}

	/**
	 * Puts the scene in stack and sets it for stage.
	 * @param scene New scene
	 * @return argument
	 */
	public ManagedScene pushScene(ManagedScene scene)
	{
		return pushScene(scene, RESIZE_STAGE_DEFAULT_VALUE);
	}

	/**
	 * Removes top scene from stack and sets previous scene for stage. If there is only one scene in stack there calls Stage.close().
	 * @param resizeStage Should the stage be resized to size of previous scene?
	 *                    True - yes, it should. False - No, save current stage size. Default value is false.
	 * @return top scene
	 */
	public ManagedScene popScene(boolean resizeStage)
	{
		ManagedScene removedScene = scenes.pop();
		if (scenes.empty())
			stage.close();
		else
		{
			double w = stage.getWidth(), h = stage.getHeight();
			stage.setScene(scenes.peek());

			if (!resizeStage)
			{
				stage.setWidth(w);
				stage.setHeight(h);
			}
		}
		return removedScene;
	}

	/**
	 * Removes top scene from stack and sets previous scene for stage. If there is only one scene in stack there calls Stage.close().
	 * @return top scene
	 */
	public ManagedScene popScene()
	{
		return popScene(RESIZE_STAGE_DEFAULT_VALUE);
	}

	/**
	 * Removes all scenes from the stack except the bottom one and sets it for stage.
	 * @param resizeStage Should the stage be resized to size of bottom scene?
	 *                    True - yes, it should. False - No, save current stage size. Default value is false.
	 */
	public void popAllExceptFirst(boolean resizeStage)
	{
		ManagedScene firstScene = scenes.firstElement();
		scenes.clear();
		pushScene(firstScene, resizeStage);
	}

	/**
	 * Removes all scenes from the stack except the bottom one and sets it for stage.
	 */
	public void popAllExceptFirst()
	{
		popAllExceptFirst(RESIZE_STAGE_DEFAULT_VALUE);
	}

	public ManagedScene peek()
	{
		return scenes.peek();
	}

	public ManagedScene getSceneAt(int index)
	{
		return scenes.get(index);
	}

	public int getStackSize()
	{
		return scenes.size();
	}

	public Stage getStage()
	{
		return stage;
	}
}
