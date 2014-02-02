package hamaetsu.ae.slotmachine.base;

import hamaetsu.ae.slotmachine.base.KeyListenScene;
import hamaetsu.ae.slotmachine.base.ResourceUtil;

import java.util.ArrayList;

import org.andengine.ui.activity.SimpleLayoutGameActivity;


public abstract class MultiSceneActivity extends SimpleLayoutGameActivity {
	
	// ResourceUtil�̃C���X�^���X
	private ResourceUtil mResourceUtil;
	// �N���ς݂�Scene�̔z��
	private ArrayList<KeyListenScene> mSceneArray;
	
	@Override
	protected void onCreateResources() {
		mResourceUtil = ResourceUtil.getInstance(this);
		mSceneArray = new ArrayList<KeyListenScene>();
	}
	
	public ResourceUtil getResourceUtil() {
		return mResourceUtil;
	}
	
	public ArrayList<KeyListenScene> getSceneArray() {
		return mSceneArray;
	}
	
	// �N���ς݂�KeyListenScene���i�[����z��
	public abstract void appendScene(KeyListenScene scene);
	// �ŏ��̃V�[���ɖ߂邽�߂̊֐�
	public abstract void backToInitial();
	// �V�[���ƃV�[���i�[�z����X�V����֐�
	public abstract void refreshRunningScene(KeyListenScene scene);
	
}
