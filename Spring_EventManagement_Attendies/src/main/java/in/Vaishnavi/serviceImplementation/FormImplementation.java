package in.Vaishnavi.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Vaishnavi.entity.Form;
import in.Vaishnavi.repository.FormRepo;
import in.Vaishnavi.serviceInterface.FormService;

@Service
public class FormImplementation implements FormService {
	@Autowired
	FormRepo repo;

	@Override
	public int save(Form form) {
		return repo.save(form).getId();
	}

}
