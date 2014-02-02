package hamaetsu.ae.slotmachine.base;

import org.andengine.entity.scene.Scene;

import android.view.KeyEvent;

public class MainScene extends KeyListenScene{
	
	public MainScene(MultiSceneActivity baseActivity) {
		super(baseActivity);
		init();
	}
	
	public void init() {
		
		attachChild(getBaseActivity().getResourceUtil().getSprite("main_bg.png"));		
	}

	@Override
	public void prepareSoundAndMusic() {
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		return false;
	}
}
