package hamaetsu.ae.slotmachine.gamelogic;

public class Player {
	
	static int medal;
	static int win;
	static int bonusGame;
	static PrizeType prize;
	static ModeType  mode;
		
	public static void start() {
		// ���݂̏������擾
		// ���_�������B���v���C�Ȃ�OG���v���C�Ȃ牽�����Ȃ��B�{�[�i�X���Ȃ�2���|��
		if ( mode == ModeType.NORMAL) {
			if (prize != PrizeType.REPLAY) {
				medal = medal - 3;
			}
		} else {
			medal = medal - 2;
		}
		// ���݂̃��[�h���擾
		// ���𒊑I
		Prize.lotPrize();
		// �����o��
		getMedal(win);
		// ���[�h�ڍs���I
		Mode.changeMode(prize);
	}
	
	public static void getMedal(int win) {
		medal = medal + win;
	}
}
