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
		// サイズを指定し描画範囲をインスタンス化
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		// ゲームエンジンの初期化
		// 第一引数 タイトルバーを表示しないモード
		// 第二引数 画面は縦向き (幅480, 高さ800)
		// 第三引数 解像度の縦横比を保ったまま最大まで拡大する
		// 第四引数 描画範囲
		EngineOptions eo = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return eo;
	}

	@Override
	protected Scene onCreateScene() {
		// MainSceneをインスタンス化し、エンジンにセット
		MainScene mainScene = new MainScene(this);
		return mainScene;
	}

	@Override
	protected int getLayoutID() {
		// ActivityのレイアウトIDを返す
		return R.layout.activity_main;
	}

	@Override
	protected int getRenderSurfaceViewID() {
		// SceneがセットされるViewのIDを返す
		return R.id.renderview;
	}

	@Override
	public void appendScene(KeyListenScene scene) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backToInitial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshRunningScene(KeyListenScene scene) {
		// TODO Auto-generated method stub
		
	}

    
}
