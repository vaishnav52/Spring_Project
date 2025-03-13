package in.Vaishnavi.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Vaishnavi.entity.EventsEntity;
import in.Vaishnavi.entity.Form;
import in.Vaishnavi.repository.EventsRepo;
import in.Vaishnavi.repository.FormRepo;
import in.Vaishnavi.serviceInterface.EventServiceInterface;

@Service
public class EventServiceImplementation implements EventServiceInterface {

	@Autowired
	private EventsRepo repo;

	@Override
	public EventsEntity loadEventData(String eventCategory) {
		Optional<EventsEntity> data = repo.findByEventCategory(eventCategory);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Autowired
	private FormRepo fRepo;

	@Override
	public List<Form> getUserEvents(String email) {
		List<Form> list = fRepo.findEventByEmail(email);

		return list;
	}

	@Override
	public void deleteUserBooking(Integer id) {

		fRepo.cancelEventById(id);
	}

	@Override
	public Integer saveEvent(EventsEntity entity) {
		// TODO Auto-generated method stub
		return repo.save(entity).getEventId();

	}
	
	@Override
	public void deleteEvent(String eventCategory) {
		repo.deleteByEventCategory(eventCategory);
	}

}
