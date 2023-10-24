package org.tsurikichi.design.practice2.version1.application

import org.tsurikichi.design.practice2.version1.domain.TaskStatus
import org.tsurikichi.design.practice2.version1.domain.WorkFlowTask

class TaskExecute {
    fun taskExecute() {
        val task = WorkFlowTask()
        task.taskStatus = TaskStatus.COMPLETE
        task.isComplete()
    }

    fun taskCheck(task: WorkFlowTask): Boolean {
        return TaskStatus.COMPLETE == task.taskStatus
    }
}
