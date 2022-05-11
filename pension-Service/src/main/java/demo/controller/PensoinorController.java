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
	
	

	@PostMapping(value = "/create")
	public Result create(@Valid @RequestBody PensionerDetails pensionerDetails) {
		return service.savePensioner(pensionerDetails);
	}

	@GetMapping
	public List<PensionerDetails> getPensioners() {
		return service.getPensioners();
	}

	@GetMapping({ "/{id}" })
	public ResponseEntity<PensionerDetails> getPensionersById(@PathVariable String id) {
		Optional<PensionerDetails> user = service.getById(id);
		return generateResponse(user);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void handleNonExistantUser() {

	}

	@DeleteMapping({ "/{id}" })
	public Result deletePensionersById(@PathVariable String id) {
		return service.deleteById(id);
	}

	@DeleteMapping({ "/deleteAll" })
	public Result deleteAll() {
		return service.deleteAllPensioners();
	}

	private ResponseEntity<PensionerDetails> generateResponse(Optional<PensionerDetails> user) {
		return user.isPresent() ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
