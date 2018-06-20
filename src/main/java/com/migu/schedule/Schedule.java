package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.*;

/*
*类名和方法不能修改
 */
public class Schedule {

    private List<TaskInfo> tasks = new LinkedList<TaskInfo>();

    private Map<Integer, Integer> taskMap = new HashMap<Integer, Integer>();

    public int init() {
        tasks.clear();
        taskMap.clear();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if (nodeId == -1) {
            return ReturnCodeKeys.E004;
        }
        for (TaskInfo task : tasks) {
            if (nodeId == task.getNodeId())
                return ReturnCodeKeys.E005;
        }
        TaskInfo newTask = new TaskInfo();
        newTask.setNodeId(nodeId);
        tasks.add(newTask);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {
        Iterator it = tasks.iterator();
        while (it.hasNext()){
            TaskInfo task = (TaskInfo)it.next();
            if(task.getNodeId() == nodeId){
                it.remove();
                return ReturnCodeKeys.E006;
            }
        }
        return ReturnCodeKeys.E007;
    }


    public int addTask(int taskId, int consumption) {
        if (taskId <= 0){
            return ReturnCodeKeys.E009;
        }
        for(Integer id : taskMap.keySet()){
            if (id == taskId)
                return ReturnCodeKeys.E010;
        }
        taskMap.put(taskId, consumption);
        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        Iterator<Map.Entry<Integer, Integer>> it = taskMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getKey() == taskId){
                it.remove();
                return ReturnCodeKeys.E011;
            }
        }
        return ReturnCodeKeys.E012;
    }


    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

}
