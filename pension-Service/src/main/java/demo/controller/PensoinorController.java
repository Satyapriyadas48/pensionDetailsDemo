package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.common.PensionRequest;
import demo.common.PensionResponse;
import demo.service.PensionorService;

@RestController
@RequestMapping("/ProcessDetail")
public class PensoinorController
{
	@Autowired
	private PensionorService service;
	
	@PostMapping("/save")
	public PensionResponse savePensionor(@RequestBody PensionRequest request)
	{
		System.out.println("Save pensionor");
		if(request.getPensionor().getName().isBlank()) {
			throw new IllegalArgumentException("Wrong input");
		}
		return service.savePensionor(request);
	}
	@GetMapping("/{aadhaarNumber}")
	public ResponseBody checkGetMapping(@RequestBody int aadhaarNumber) {
		System.out.println("");
		
		return service.getPensionorDetails(aadhaarNumber);
	}
}
