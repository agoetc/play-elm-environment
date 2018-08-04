package services

import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Singleton

@Singleton
class AtomicCounter {
    private val atomicCounter = new AtomicInteger()
    def nextCount(): Int = atomicCounter.getAndIncrement()
}
