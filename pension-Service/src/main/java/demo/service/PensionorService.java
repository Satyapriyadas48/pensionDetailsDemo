package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import demo.common.PensionRequest;
import demo.common.PensionResponse;
import demo.entity.Pensionor;
import demo.repository.PnsionorRepository;

@Service
public class PensionorService {
	@Autowired
	private PnsionorRepository repository;

	@Autowired
	private RestTemplate template;

	public PensionResponse savePensionor(PensionRequest request) {
		String response = "";
		Pensionor pensionor = request.getPensionor();


		//client-side load balancing
//	Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,
//				Payment.class);
//
//		response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful"
//				: "there is a failure";

		repository.save(pensionor);

//		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(),
//				response);
		return new PensionResponse();
	}

	public ResponseBody getPensionorDetails(int aadhaarNumber) {
		
		return (ResponseBody) repository.getById(aadhaarNumber);
	}

	
}
