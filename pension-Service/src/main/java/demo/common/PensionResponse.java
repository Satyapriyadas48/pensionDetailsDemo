package demo.common;


import demo.entity.Pensionor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class PensionResponse {
	private Pensionor pensionor;
	private String transactionId;
	private double amount;
	private String message;

	public Pensionor getOrder() {
		return pensionor;
	}

	public void setOrder(Pensionor pensionor) {
		this.pensionor = pensionor;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PensionResponse(Pensionor prnsionor, double amount, String transactionId, String message) {
		super();
		this.pensionor = prnsionor;
		this.transactionId = transactionId;
		this.amount = amount;
		this.message = message;
	}

	public PensionResponse() {

	}

}
