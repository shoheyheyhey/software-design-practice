package org.tsurikichi.design.practice2.practice2_2.domain

class WorkFlowTask(
    private var consumerCheck: Boolean = false,
    private var operatorCheck: Boolean = false,
    private var taskStatus: TaskStatus = TaskStatus.START) {

    fun taskUpdate(consumerCheck: Boolean, operatorCheck: Boolean) {
        this.consumerCheck = consumerCheck
        this.operatorCheck = operatorCheck
        taskStatusUpdate()
    }

    private fun taskStatusUpdate() {
        if(consumerCheck && operatorCheck) {
            taskStatus = TaskStatus.COMPLETE
        }
    }

    fun isComplete(): Boolean {
        return TaskStatus.COMPLETE == taskStatus
    }
}
