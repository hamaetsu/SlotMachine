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
		// �T�C�Y���w�肵�`��͈͂��C���X�^���X��
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		// �Q�[���G���W���̏�����
		// ������ �^�C�g���o�[��\�����Ȃ����[�h
		// ������ ��ʂ͏c���� (��480, ����800)
		// ��O���� �𑜓x�̏c�����ۂ����܂܍ő�܂Ŋg�傷��
		// ��l���� �`��͈�
		EngineOptions eo = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		return eo;
	}

	@Override
	protected Scene onCreateScene() {
		// MainScene���C���X�^���X�����A�G���W���ɃZ�b�g
		MainScene mainScene = new MainScene(this);
		return mainScene;
	}

	@Override
	protected int getLayoutID() {
		// Activity�̃��C�A�E�gID��Ԃ�
		return R.layout.activity_main;
	}

	@Override
	protected int getRenderSurfaceViewID() {
		// Scene���Z�b�g�����View��ID��Ԃ�
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
