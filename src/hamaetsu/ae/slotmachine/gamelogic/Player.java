package hamaetsu.ae.slotmachine.gamelogic;

public class Player {
	
	static int medal;
	static int win;
	static int bonusGame;
	static PrizeType prize;
	static ModeType  mode;
		
	public static void start() {
		// 現在の小役を取得
		// メダル投入。リプレイなら前Gリプレイなら何もしない。ボーナス中なら2枚掛け
		if ( mode == ModeType.NORMAL) {
			if (prize != PrizeType.REPLAY) {
				medal = medal - 3;
			}
		} else {
			medal = medal - 2;
		}
		// 現在のモードを取得
		// 小役抽選
		Prize.lotPrize();
		// 払い出し
		getMedal(win);
		// モード移行抽選
		Mode.changeMode(prize);
	}
	
	public static void getMedal(int win) {
		medal = medal + win;
	}
}
