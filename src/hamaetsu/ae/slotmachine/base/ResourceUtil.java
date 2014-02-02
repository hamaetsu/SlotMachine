package hamaetsu.ae.slotmachine.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ResourceUtil {

	// ���g�̃C���X�^���X
	private static ResourceUtil self;
	// Context
	private static BaseGameActivity gameActivity;
	// TextureRegio�̖��ʂȐ�����h���A�ė��p���邽�߂̈ꎞ�I�ȕۊǏꏊ
	private static HashMap<String, ITextureRegion> textureRegionPool;
	// TiledTextureRegion�̖��ʂȐ�����h���A�ė��p���邽�߂̈ꎞ�I�ȕۊǏꏊ
	private static HashMap<String, TiledTextureRegion> tiledTextureRegionPool;
	
	private ResourceUtil() {
	
	}
	
	// �C�j�V�����C�Y
	public static ResourceUtil getInstance(BaseGameActivity gameActivity) {
		if (self == null) {
			self = new ResourceUtil();
			ResourceUtil.gameActivity = gameActivity;
			BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
			
			textureRegionPool = new HashMap<String, ITextureRegion>();
			tiledTextureRegionPool = new HashMap<String, TiledTextureRegion>();
		}
		return self;
	}
	
	// �t�@�C������^����Sprite�𓾂�
	public Sprite getSprite(String fileName) {
		// �����̃t�@�C������ITextureRegion�������ς݂ł���΍ė��p
		if (textureRegionPool.containsKey(fileName)) {
			Sprite s = new Sprite(0, 0, textureRegionPool.get(fileName), gameActivity.getVertexBufferObjectManager());
			s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
			return s;
		}
		// �T�C�Y�������I�Ɏ擾���邽�߂�Bitmap�Ƃ��ēǂݍ���
		InputStream is = null;
		try {
			is = gameActivity.getResources().getAssets().open("gfx/" + fileName);
		} catch(IOException e) {
			e.printStackTrace();
		}
		Bitmap bm = BitmapFactory.decodeStream(is);
		// Bitmap�̃T�C�Y������2�ׂ̂���̒l���擾, BitmapTextureAtlas�̐���
		BitmapTextureAtlas bta = new BitmapTextureAtlas(gameActivity.getTextureManager(), getTwoPowerSize(bm.getWidth()), getTwoPowerSize(bm.getHeight()), TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		gameActivity.getEngine().getTextureManager().loadTexture(bta);
		ITextureRegion btr = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bta, gameActivity, fileName, 0, 0);
		Sprite s = new Sprite(0, 0, btr, gameActivity.getVertexBufferObjectManager());
		s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		textureRegionPool.put(fileName, btr);
		return s;
	}
	
	// �p���p���A�j���̂悤��Sprite�𐶐�
	// �摜��1���ɂ܂Ƃ߁A�}�X���Ƌ��Ɉ����Ƃ���
	public AnimatedSprite getAnimatedSprite(String fileName, int column, int row) {
		if (tiledTextureRegionPool.containsKey(fileName)) {
			AnimatedSprite s = new AnimatedSprite(0, 0, tiledTextureRegionPool.get(fileName), gameActivity.getVertexBufferObjectManager());
			s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		}
		InputStream is = null;
		try {
			is = gameActivity.getResources().getAssets().open("gfx/" + fileName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		Bitmap bm = BitmapFactory.decodeStream(is);
		BitmapTextureAtlas bta = new BitmapTextureAtlas(gameActivity.getTextureManager(), getTwoPowerSize(bm.getWidth()), getTwoPowerSize(bm.getHeight()), TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		gameActivity.getTextureManager().loadTexture(bta);
		
		// TiledTextureRegion (�^�C�����TextureRegion)���쐬
		// �}�X����^���A�����T�C�Y��TextureRegion��p��
		TiledTextureRegion ttr = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bta, gameActivity, fileName, 0, 0, column, row);
		// AnimatedSprite�𐶐�
		AnimatedSprite s = new AnimatedSprite(0, 0, ttr, gameActivity.getVertexBufferObjectManager());
		s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		tiledTextureRegionPool.put(fileName, ttr);
		
		return s;
	}
	
	// �^�b�v����Ɖ摜���؂�ւ��{�^���@�\������Sprite�𐶐�
	public ButtonSprite getButtonSprite(String normal, String pressed) {
		
		if (textureRegionPool.containsKey(normal) && textureRegionPool.containsKey(pressed)) {
			ButtonSprite s = new ButtonSprite(0, 0, textureRegionPool.get(normal), textureRegionPool.get(pressed), gameActivity.getVertexBufferObjectManager());
			s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
			return s;
		}
		
		InputStream is = null;
		try {
			is = gameActivity.getResources().getAssets().open("gfx/" + normal);
		} catch(IOException e) {
			e.printStackTrace();
		}
		Bitmap bm = BitmapFactory.decodeStream(is);
		//�@�{�^�������̂��߂�TextureRegion�����B
		// TiledTextureRegion�łȂ��ABuildBitmapTextureAtlas�𗘗p����B
		BuildableBitmapTextureAtlas bta = new BuildableBitmapTextureAtlas(gameActivity.getTextureManager(), getTwoPowerSize(bm.getWidth() * 2), getTwoPowerSize(bm.getHeight()));
		ITextureRegion trNormal = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bta, gameActivity, normal);
		ITextureRegion trPressed = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bta, gameActivity, pressed);
		
		try {
			bta.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			bta.load();
		} catch(TextureAtlasBuilderException e) {
			Debug.e(e);
		}
		
		textureRegionPool.put(normal, trNormal);
		textureRegionPool.put(pressed, trPressed);
		
		ButtonSprite s = new ButtonSprite(0, 0, trNormal, trPressed, gameActivity.getVertexBufferObjectManager());
		s.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		return s;
	}
	
	//�@�v�[�����J���A�V���O���g�����폜���邽�߂̊֐�
	public void resetAllTexture() {
		// Activity.finish()�������ƃV���O���g���ȃN���X��null�ɂȂ�Ȃ�����
		// �����I��null����
		self = null;
		textureRegionPool.clear();
		tiledTextureRegionPool.clear();
	}
	
	// 2�ׂ̂���̒l�����߂�
	public int getTwoPowerSize(float size) {
		int value = (int)(size + 1);
		int pow2value = 64;
		while (pow2value < value) {
			pow2value *= 2;
		}
		return pow2value;
	}
}







