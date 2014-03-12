package hamaetsu.ae.slotmachine.base;

//

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;

import android.util.Log;
import android.view.KeyEvent;

public class MainScene extends KeyListenScene{
		
	private Sprite wheel1;
	private Sprite wheel2;
	private Sprite wheel3;
	
	private final int scrollSpeed = 4;
	
	private final float wheelDistance = 10; 
	
	public MainScene(MultiSceneActivity baseActivity) {
		super(baseActivity);
		init();
	}
	
	public void init() {
		attachChild(getBaseActivity().getResourceUtil().getSprite("universe_bg.png"));

		wheel2 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel1_maharo.png");
		placeToCenter(wheel2);
		attachChild(wheel2);

		wheel1 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel1_maharo.png");
		placeToLeftNextToBaseSprite(wheel2, wheel1, wheelDistance);
		attachChild(wheel1);

		wheel3 = ResourceUtil.getInstance(getBaseActivity()).getSprite("wheel3_maharo.png");
		placeToRightNextToBaseSprite(wheel2, wheel3, wheelDistance);
		attachChild(wheel3);

		registerUpdateHandler(updateHandler);
	}
	
	
	// アップデートハンドラ。1秒間に60回呼び出される
	public TimerHandler updateHandler = new TimerHandler(1f / 60f, true, new ITimerCallback() {
																																																					
		@Override
		public void onTimePassed(TimerHandler pTimerHandler) {
			
			// リール回転
			wheel1.setY(wheel1.getY() - scrollSpeed);
			wheel2.setY(wheel1.getY() - scrollSpeed);
			wheel3.setY(wheel1.getY() - scrollSpeed);
		}
	});


	@Override
	public void prepareSoundAndMusic() {
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		return false;
	}
}
