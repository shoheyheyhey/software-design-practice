package org.tsurikichi.design.practice2.practice2_1.application_service

import org.tsurikichi.design.practice2.practice2_1.domain.TaskStatus
import org.tsurikichi.design.practice2.practice2_1.domain.WorkFlowTask

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
