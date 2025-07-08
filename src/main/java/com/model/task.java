package com.model;

import java.util.ArrayList;
import java.util.List;

public class task {
    private int id;
    private List<String> tasks = new ArrayList<String>();
    private String status;

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

}
