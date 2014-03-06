package hamaetsu.ae.slotmachine.gamelogic;

public class Player {
	
	private int medal;
	
	private int win;
	
	private Prize prize;
	
	private Mode mode;
	
	public Player() {
		// �����l��ݒ�
		prize = new Prize(this);
		mode  = new Mode(this);
	}
	
	public void start() {
		// ���݂̏������擾
		// ���_�������B���v���C�Ȃ�OG���v���C�Ȃ牽�����Ȃ��B�{�[�i�X���Ȃ�2���|��
		if (mode.mode != ModeType.bonus) {
			if (prize.pType != PrizeType.REPLAY) {
				medal = medal - 3;
			}
		} else {
			medal = medal - 2;
		}
		// ���݂̃��[�h���擾
		// ���𒊑I
		// ���[�h�ڍs���I
	}

	public int getMedal() {
		return medal;
	}

	public void setMedal(int medal) {
		this.medal = medal;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
