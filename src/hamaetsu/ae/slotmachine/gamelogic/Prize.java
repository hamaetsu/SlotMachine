package hamaetsu.ae.slotmachine.gamelogic;

import java.util.Random;

public class Prize {
	
	private static final int    ALL = PrizeType.getAll();
	private static final Random RAND = new Random();
	
	public static void lotPrize() {
		if (Player.mode == ModeType.NORMAL) {
			lotPrizeNormal();
		} else {
			lotPrizeBonus();
		}
	}

	// 通常時の抽選
	public static void lotPrizeNormal() {
		int rnd = RAND.nextInt(ALL);
		
		int replay = PrizeType.REPLAY.getRandom();
		int bell   = replay + PrizeType.BELL.getRandom();
		int cheA   = bell   + PrizeType.CHERRY_A.getRandom();
		int sikA   = cheA   + PrizeType.SUIKA_A.getRandom();
		int bb1    = sikA    + PrizeType.BB1.getRandom();
		int rb1    = bb1   + PrizeType.RB1.getRandom();
				
		if (rnd<replay) {
			Player.prize = PrizeType.REPLAY;
		} else if(replay<=rnd && rnd< bell) {
			Player.prize = PrizeType.BELL;
		} else if(bell<=rnd && rnd<cheA) {
			Player.prize = PrizeType.CHERRY_A;
		} else if(rb1<=rnd && rnd<sikA) {
			Player.prize = PrizeType.SUIKA_A;
		} else if(sikA<=rnd && rnd<bb1) {
			Player.prize = PrizeType.BB1;
		} else if(bb1<=rnd && rnd<rb1) {
			Player.prize = PrizeType.RB1;
		} else {
			Player.prize = PrizeType.HAZURE;
		}
	}
	
	// ボーナス中に抽選
	public static void lotPrizeBonus() {

		int rnd = RAND.nextInt(100);
		
		if (rnd < 90) {
			Player.prize = PrizeType.BELL;
		} else if (90 <= rnd && rnd < 95) {
			Player.prize = PrizeType.SUIKA_A;
		} else {
			Player.prize = PrizeType.CHERRY_A;
		}
	}
	
	public static void getMedal(PrizeType pType) {
		int medal = 0;
		switch (pType) {
		case BELL:
			Player.win= 10;
			break;
		case CHERRY_A:
			Player.win = 4;
			break;
		case SUIKA_A:
			Player.win = 12;
			break;
		}
	}
}