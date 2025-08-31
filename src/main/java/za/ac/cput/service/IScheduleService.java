package za.ac.cput.service;
/* ISchedule Service.java
     Schedule Service class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import za.ac.cput.domain.Schedule;

import java.util.List;

public interface IScheduleService extends IService<Schedule, Long>{
    List<Schedule> getAll();
}
