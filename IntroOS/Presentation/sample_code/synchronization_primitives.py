import threading

mutex = threading.Lock()
counter = 0


def increment():
    global counter
    mutex.acquire()
    counter += 1
    print("Counter:", counter)
    mutex.release()


thread1 = threading.Thread(target=increment)
thread2 = threading.Thread(target=increment)

thread1.start()
thread2.start()

thread1.join()
thread2.join()
