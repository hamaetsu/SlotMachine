package hamaetsu.ae.slotmachine.base;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;

import biz.stachibana.se.base.R;

public class MainActivity extends MultiSceneActivity {
	
	private int CAMERA_WIDTH  = 480;
	private int CAMERA_HEIGHT = 800;

	public EngineOptions onCreateEngineOptions() {

		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions eo = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return eo;
	}

	@Override
	protected Scene onCreateScene() {
		MainScene mainScene = new MainScene(this);
		return mainScene;
	}

	@Override
	protected int getLayoutID() {
		return R.layout.activity_main;
	}

	@Override
	protected int getRenderSurfaceViewID() {
		return R.id.renderview;
	}

	@Override
	public void appendScene(KeyListenScene scene) {
	}

	@Override
	public void backToInitial() {
	}

	@Override
	public void refreshRunningScene(KeyListenScene scene) {
	}    
}
