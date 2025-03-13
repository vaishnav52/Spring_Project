package in.Vaishnavi.serviceInterface;

import java.util.List;

import in.Vaishnavi.entity.AttendiesEntity;
import in.Vaishnavi.entity.RegisterEntity;


public interface AttendiesService {
	Integer saveAttendie(AttendiesEntity entity);
	//boolean existsbyemail(String email);
	AttendiesEntity findbyEmail(String email);
	AttendiesEntity findbyEmailAndPassword(String email,String password);
	boolean existsByAEmail(String email);
//	

}
