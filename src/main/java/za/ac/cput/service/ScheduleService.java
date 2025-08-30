package za.ac.cput.service;
/* Schedule Service.java
     Schedule Service class
     Author: RI Onwutali (222369345)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Schedule;
import za.ac.cput.repository.ScheduleRepository;
import java.util.List;

@Service
public class ScheduleService implements IScheduleService {
    private ScheduleRepository repository;

    @Autowired
    ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Schedule create (Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public Schedule read (String id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Schedule update (Schedule schedule) {
        return this.repository.save(schedule);
    }

    @Override
    public boolean delete(String id){
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<Schedule> getAll(){
        return this.repository.findAll();
    }
}
