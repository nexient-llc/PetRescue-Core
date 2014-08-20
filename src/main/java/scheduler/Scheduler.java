package scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import com.systemsinmotion.util.DataBaseBackUpUtil;

public class Scheduler {

	@Autowired
	DataBaseBackUpUtil dataBaseBackUpUtil;

	@Bean
	public Scheduler getSchedule() {
		return new Scheduler();
	}

	@Scheduled(cron = "#{dataBaseBackUpUtil.getCronProperty()}")
	public void performDataBaseBackUp() {

		dataBaseBackUpUtil.updateDataBase();

	}

}
