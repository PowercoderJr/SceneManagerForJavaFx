# SceneManager for JavaFX
Tool for JavaFX applications that allows to remember scenes path from initial scene to current and to step back through them with single command. So it's simple to manage multiple screens within one window. Can be useful for menu navigation etc.

## Usage
Manager is presented with stack of ManagedScene's. To set scene for Stage you are to use SceneManager.pushScene(), SceneManager.popScene() or SceneManager.popAllExceptFirst() instead of Stage.setScene(). All these commands are accompanied by Stage.setScene() with required scene, depending on which command you use.

- **pushScene(ManagedScene)** - puts the scene in stack and sets it for stage;
- **popScene()** - removes top scene from stack and sets previous scene for stage. If there is only one scene in stack there calls Stage.close();
- **popAllExceptFirst()** - removes all scenes from the stack except the bottom one and sets it for stage.

Also all described commands has optional boolean parameter that defines will or not the stage be resized to size of another scene.