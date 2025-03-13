package in.Vaishnavi.serviceInterface;

import java.util.List;

import in.Vaishnavi.entity.TaskEntity;

public interface TaskService {

	
	public List<TaskEntity> getAllTask();
	
	//to get the specific task of the attendies 
	List<TaskEntity> findTasksByCategory(String category);
//metod to set the status as true
  //TaskEntity	updateStatus(Integer id);

	public Integer updateStatus(String taskId, String attendieId, String status);

	Integer updateStatus(String taskId, Integer attendieId, String status);

//Integer updateStatus(String id);
}
