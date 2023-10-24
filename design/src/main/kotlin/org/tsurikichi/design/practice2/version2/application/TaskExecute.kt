package org.tsurikichi.design.practice2.version2.application
import org.tsurikichi.design.practice2.version2.domain.WorkFlowTask

class TaskExecute {
    fun taskExecute() {
        val task = WorkFlowTask()
        task.taskUpdate(consumerCheck = true, operatorCheck = true)
        // task.taskStatus = TaskStatus.COMPLETE コンパイル通らない
        task.isComplete()
    }

    // コンパイル通らない
//    fun taskCheck(task: WorkFlowTask): Boolean {
//        return TaskStatus.COMPLETE == task.taskStatus
//    }
}
