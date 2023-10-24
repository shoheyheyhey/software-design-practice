package org.tsurikichi.design.practice2.`practice2-2`.`application-service`
import org.tsurikichi.design.practice2.`practice2-2`.domain.WorkFlowTask

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
