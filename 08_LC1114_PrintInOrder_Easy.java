import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore firstDone;
    private Semaphore secondDone;

    public Foo() {
        firstDone = new Semaphore(0);
        secondDone = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        printFirst.run();
        firstDone.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.acquire();
        
        printSecond.run();
        secondDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.acquire();
        
        printThird.run();
    }
}
