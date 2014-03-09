package hamaetsu.ae.slotmachine.base;


import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import android.view.KeyEvent;

public class SlotScene extends KeyListenScene  implements IOnSceneTouchListener, ButtonSprite.OnClickListener {

	private Sprite wheel1;
	private Sprite wheel2;
	private Sprite wheel3;
	
	
	public SlotScene(MultiSceneActivity baseActivity) {
		super(baseActivity);
		init();
	}

	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		attachChild(getBaseActivity().getResourceUtil().getSprite("universe_bg.png"));
		
		wheel1 = getBaseActivity().getResourceUtil().getSprite("wheel.png");
	
	}

	@Override
	public void prepareSoundAndMusic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		return false;
	}

}
