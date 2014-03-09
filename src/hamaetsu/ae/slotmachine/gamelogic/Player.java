package hamaetsu.ae.slotmachine.gamelogic;

public class Player {
	
	static int medal;
	static int win;
	static int bonusGame;
	static PrizeType prize;
	static ModeType  mode;
		
	public static void start() {

		if ( mode == ModeType.NORMAL) {
			if (prize != PrizeType.REPLAY) {
				medal = medal - 3;
			}
		} else if( mode == ModeType.BONUS){
			medal = medal - 2;
		}
		Prize.lotPrize();
		getMedal(win);
		Mode.changeMode(prize);
	}
	
	public static void getMedal(int win) {
		medal = medal + win;
	}
}
