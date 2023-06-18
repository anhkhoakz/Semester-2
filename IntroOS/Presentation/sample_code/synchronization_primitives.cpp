#include <iostream>
#include <thread>
#include <mutex>

std::mutex mutex;
int counter = 0;

void increment() {
    std::lock_guard<std::mutex> lock(mutex);
    counter++;
    std::cout << "Counter: " << counter << std::endl;
}

int main() {
    std::thread thread1(increment);
    std::thread thread2(increment);
    
    thread1.join();
    thread2.join();
    
    return 0;
}
