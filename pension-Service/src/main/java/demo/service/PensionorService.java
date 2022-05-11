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

	@Transactional(rollbackOn = Exception.class)
	public Result savePensioner(PensionerDetails pensionerDetails) {
		repository.save(pensionerDetails);
		return new Result(200, ErrorMessages.SAVE_SUCCESSFUL);
	}

	public List<PensionerDetails> getPensioners() {
		return repository.findAll();
	}

	public Optional<PensionerDetails> getById(String id) {
		return repository.findById(id);
	}

	public Result deleteById(String id) {
		repository.deleteById(id);
		return new Result(200, ErrorMessages.DELETE_SUCCESSFUL);
	}

	public Result deleteAllPensioners() {
		repository.deleteAll();
		return new Result(200, ErrorMessages.DELETE_SUCCESSFUL);
	}


	
}
