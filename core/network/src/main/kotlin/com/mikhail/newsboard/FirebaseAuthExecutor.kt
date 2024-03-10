package com.mikhail.newsboard

import java.util.concurrent.Executor

internal class FirebaseAuthExecutor : Executor {
    override fun execute(command: Runnable) {
        command.run()
    }
}