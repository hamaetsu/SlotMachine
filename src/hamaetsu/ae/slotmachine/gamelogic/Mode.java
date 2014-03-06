package hamaetsu.ae.slotmachine.gamelogic;

public class Mode {
	
	public static void changeMode(PrizeType prize) {
		if (prize == PrizeType.BB1 || prize == PrizeType.RB1) {
			Player.mode = ModeType.BONUS;
		} else if (Player.bonusGame == 0) {
			Player.mode = ModeType.NORMAL;
		}
	}
	
}
