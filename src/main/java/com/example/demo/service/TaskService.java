package com.example.demo.service;

import com.example.demo.model.entities.Task;
import com.example.demo.model.service.TaskServiceModel;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel map);

    List<Task> findAllTask();

    void changeProgress(Long id);
}
