package cue.edu.co.threads;

import java.services.ToysServiceImpl;

import java.util.concurrent.Callable;

public class LoadSystem implements Callable<Void> {
    private final ToysServiceImpl toyStore;

    public LoadSystemThread (ToysServiceImpl toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public Void call() throws Exception {
        try {
            System.out.println("Starting system ...");
            Thread.sleep(1000);
            ToyStoreImpl.loadStore();
            System.out.println("system loaded successfully.");
        } catch (InterruptedException e) {
            System.err.println("System interrupted.");
        } catch (Exception e) {
            System.err.println("Error while loading the system: " + e.getMessage());
        }
        return null;
    }
}
