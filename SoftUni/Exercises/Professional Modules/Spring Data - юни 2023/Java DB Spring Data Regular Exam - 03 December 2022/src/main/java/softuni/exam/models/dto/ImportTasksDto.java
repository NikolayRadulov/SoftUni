package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)

public class ImportTasksDto {

	@XmlElement(name = "task")
	private List<ImportTaskDto> taskDtos;
	
	public ImportTasksDto() {
		// TODO Auto-generated constructor stub
	}

	public List<ImportTaskDto> getTaskDtos() {
		return taskDtos;
	}

	public void setTaskDtos(List<ImportTaskDto> taskDtos) {
		this.taskDtos = taskDtos;
	}

}
