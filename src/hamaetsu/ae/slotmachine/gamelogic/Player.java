package hamaetsu.ae.slotmachine.gamelogic;

public class Player {
	
	private int medal;
	
	private int win;
	
	private Prize prize;
	
	private Mode mode;
	
	public Player() {
		// 初期値を設定
		prize = new Prize(this);
		mode  = new Mode(this);
	}
	
	public void start() {
		// 現在の小役を取得
		// メダル投入。リプレイなら前Gリプレイなら何もしない。ボーナス中なら2枚掛け
		if (mode.mode != ModeType.bonus) {
			if (prize.pType != PrizeType.REPLAY) {
				medal = medal - 3;
			}
		} else {
			medal = medal - 2;
		}
		// 現在のモードを取得
		// 小役抽選
		// モード移行抽選
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
