package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

/**
 * Extends Scene from JavaFX. Has its SceneManager.
 * <br>Shared at https://github.com/PowercoderJr/SceneManagerForJavaFx
 * @see SceneManager
 */
public class ManagedScene extends Scene
{
	private SceneManager manager;

	public ManagedScene(Parent root)
	{
		super(root);
	}

	public ManagedScene(Parent root, double width, double height)
	{
		super(root, width, height);
	}

	public ManagedScene(Parent root, Paint fill)
	{
		super(root, fill);
	}

	public ManagedScene(Parent root, double width, double height, Paint fill)
	{
		super(root, width, height, fill);
	}

	public ManagedScene(Parent root, double width, double height, boolean depthBuffer)
	{
		super(root, width, height, depthBuffer);
	}

	public ManagedScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing)
	{
		super(root, width, height, depthBuffer, antiAliasing);
	}

	public SceneManager getManager()
	{
		return manager;
	}

	public void setManager(SceneManager manager)
	{
		this.manager = manager;
	}
}
