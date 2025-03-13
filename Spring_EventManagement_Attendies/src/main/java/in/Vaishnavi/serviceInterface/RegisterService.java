package in.Vaishnavi.serviceInterface;

import java.util.List;

import in.Vaishnavi.entity.AttendiesEntity;
import in.Vaishnavi.entity.Form;
import in.Vaishnavi.entity.RegisterEntity;
import in.Vaishnavi.entity.TaskEntity;
import jakarta.servlet.http.HttpSession;

public interface RegisterService {

	Integer saveUser(RegisterEntity entity);

	String loginUser(String email, String password, HttpSession session);
	
	String AttendieLogin(String email, String password, HttpSession session);

	boolean isCodeAvailable(String useremail);

	boolean checkUser(String email);

	String forgotPassword(String userEmail, String userPassword);

	List<RegisterEntity> data();

	void deleteUser(Integer id);

	List<Form> getAllBookings();

	void deleteUserBookingByAdmin(Integer id);
	
	void acceptUserBookingByAdmin(Integer id);
	
	List<AttendiesEntity> getAllAttendies();
	
	void deleteAttendie(Integer id);
	
	Form findFormById(Integer id);

	int saveTask(TaskEntity task);

	void assignedUserBookingByAdmin(String bId);

	List<TaskEntity> getAllTasks();
	
	TaskEntity getTaskByBId(String id);

	AttendiesEntity getAttendisById(String id);

	List<TaskEntity> getTaskByIdEmail(int aId);

	

	


	
	

}
