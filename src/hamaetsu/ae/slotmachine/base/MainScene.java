package hamaetsu.ae.slotmachine.base;

//

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;

import android.util.Log;
import android.view.KeyEvent;

public class MainScene extends KeyListenScene{
	
	private Sprite wheel1;
	private Sprite wheel2;
	private Sprite wheel3;
	
	private final float wheelDistance = 10; 
	
	public MainScene(MultiSceneActivity baseActivity) {
		super(baseActivity);
		String width = Float.toString(baseActivity.getEngine().getCamera().getWidth());
		String height = Float.toString(baseActivity.getEngine().getCamera().getHeight());		
		init();
	}
	
	public void init() {
		attachChild(getBaseActivity().getResourceUtil().getSprite("universe_bg.png"));

		wheel2 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel_140_294.png");
		placeToCenter(wheel2);
		attachChild(wheel2);

		wheel1 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel_140_294.png");
		placeToLeftNextToBaseSprite(wheel2, wheel1, wheelDistance);
		attachChild(wheel1);

		wheel3 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel_140_294.png");
		placeToRightNextToBaseSprite(wheel2, wheel3, wheelDistance);
		attachChild(wheel3);

		String wheel2_X = Float.toString(wheel2.getX());
		String wheel2_Y = Float.toString(wheel2.getY());
		String wheel1_X = Float.toString(wheel1.getX());
		String wheel1_Y = Float.toString(wheel1.getY());
		String wheel3_X = Float.toString(wheel3.getX());
		String wheel3_Y = Float.toString(wheel3.getY());

		String wheel_w = Float.toString(wheel1.getWidth());
		String wheel_h = Float.toString(wheel1.getHeight());
		
	}

	@Override
	public void prepareSoundAndMusic() {
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		return false;
	}
}
