package com.iamer.movies.core.network.usecase

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): DataState<Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = MainScope(),
        onResult: (DataState<Type>) -> Unit = {}
    ) {
        scope.launch {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}
