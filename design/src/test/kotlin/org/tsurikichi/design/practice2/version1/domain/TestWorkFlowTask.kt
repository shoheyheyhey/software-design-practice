package org.tsurikichi.design.practice2.version1.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestWorkFlowTask {

    @Nested
    inner class TaskUpdate {

        @Test
        fun `operatorとconsumerのチェックが通ったらタスクが完了する`() {
            val task = WorkFlowTask()
            task.taskUpdate(consumerCheck = true, operatorCheck = true)

            Assertions.assertTrue(task.isComplete())
        }

        @Test
        fun `operatorとconsumerのチェックが通ってないためタスクが完了しない`() {
            val task = WorkFlowTask()
            task.taskUpdate(consumerCheck = false, operatorCheck = true)
            task.taskStatus = TaskStatus.COMPLETE

            Assertions.assertFalse(task.isComplete())
        }

        @Test
        fun `実装の詳細まで検証していてテストコードがリファクタリングの耐性を失う`() {
            val task = WorkFlowTask()
            task.taskUpdate(consumerCheck = true, operatorCheck = true)

            Assertions.assertEquals(TaskStatus.COMPLETE, task.taskStatus)
            Assertions.assertTrue(task.isComplete())
        }

        @Test
        fun `テスト対象を動かしただけで検証しておらず意味がない`() {
            val task = WorkFlowTask()
            task.taskUpdate(consumerCheck = true, operatorCheck = true)
        }
    }
}
