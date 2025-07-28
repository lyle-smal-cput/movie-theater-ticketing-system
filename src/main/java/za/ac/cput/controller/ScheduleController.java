package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Schedule;
import za.ac.cput.service.ScheduleService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Schedule")
public class ScheduleController {
    private ScheduleService service;

    @Autowired
    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping("create")
    public Schedule create(@RequestBody Schedule schedule) {

        return service.create(schedule);
    }

    @GetMapping("/read/{scheduleId}")
    public Schedule read(@PathVariable String scheduleId) {

        return service.read(scheduleId);
    }

    @PutMapping("/update")
    public Schedule update(@RequestBody Schedule schedule) {

        return service.update(schedule);
    }

    @DeleteMapping("/delete/{scheduleId}")
    public void delete(@PathVariable String scheduleId) {

        service.delete(scheduleId);
    }

    @GetMapping("/getAll")
    public List<Schedule> getAll() {
        return service.getAll();
    }


}
