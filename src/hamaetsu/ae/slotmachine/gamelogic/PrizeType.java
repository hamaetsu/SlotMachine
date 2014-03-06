package hamaetsu.ae.slotmachine.gamelogic;

public enum PrizeType {
	HAZURE(102),
	REPLAY(55),
	BELL(32),
	CHERRY_A(4),
	SUIKA_A(3),
	BB1(3),
	RB1(1);
	
	private int random;
	
	private PrizeType(int random) {
		this.random = random;
	}
	
	public int getRandom() {
		return random;
	}
	public static int getAll() {
		return (HAZURE.random + 
			    REPLAY.random + 
			    BELL.random + 
			    CHERRY_A.random + 
			    SUIKA_A.random  +
			    BB1.random      +
			    RB1.random);
	}
	
}
