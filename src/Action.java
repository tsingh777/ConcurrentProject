public class Action {
	public int actionCode;
	public long amount;
	public int transferTo;

	public Action(int actionCode) {
		this.actionCode = actionCode;
	}
	public Action(int actionCode, long amount) {
		this.actionCode = actionCode;
		this.amount = amount;
	}
	public Action(int actionCode, long amount, int transferTo) {
		this.actionCode = actionCode;
		this.amount = amount;
		this.transferTo = transferTo;
	}

}