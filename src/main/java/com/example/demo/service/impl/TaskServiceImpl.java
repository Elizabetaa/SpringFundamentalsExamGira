package com.example.demo.service.impl;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.Task;
import com.example.demo.model.entities.enums.Progress;
import com.example.demo.model.service.TaskServiceModel;
import com.example.demo.repository.TaskRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.ClassificationService;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ClassificationService classificationService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel) {
        Task task = this.modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(this.classificationService.findByName(taskServiceModel.getClassification()));
        task.setProcess(Progress.OPEN);
        task.setUser(this.userService.findByUsername(this.currentUser.getUsername()));
        this.taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTask() {

        return this.taskRepository.findAll();
    }

    @Override
    public void changeProgress(Long id) {

        Task task = this.taskRepository.findById(id).orElse(null);
        switch (task.getProcess()) {
            case OPEN:
                task.setProcess(Progress.IN_PROGRESS);
                this.taskRepository.save(task);
                break;
            case IN_PROGRESS:
                task.setProcess(Progress.COMPLETED);
                this.taskRepository.save(task);
                this.taskRepository.delete(task);
                break;

        }

    }
}
