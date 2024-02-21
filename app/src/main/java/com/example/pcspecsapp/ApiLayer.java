package com.example.pcspecsapp;

import android.app.appsearch.observer.ObserverCallback;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import retrofit2.Call;
import retrofit2.Response;

public class ApiLayer {
    public static List<PcSpecs> getAllPcSpecs() {
        FutureTask<List<PcSpecs>> futureTask = new FutureTask<>(new Callable<List<PcSpecs>>() {
            @Override
            public List<PcSpecs> call() {
                List<PcSpecs> pcSpecs = new ArrayList<>();
                IPcSpecsService service = ServiceBuilder.buildService(IPcSpecsService.class);
                Call<List<PcSpecs>> request = service.getAllPcSpecs();
                try {
                    Response<List<PcSpecs>> response = request.execute();
                    if (response.isSuccessful() && response.body() != null) {
                        pcSpecs = response.body(); // Execute the request in a separate thread
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return pcSpecs;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();

        List<PcSpecs> pcSpecs = new ArrayList<>();
        try {
            pcSpecs = futureTask.get(); // Wait for the asynchronous completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }

        return pcSpecs;
    }

    public static PcSpecs getPcSpecsById(int id) {
        FutureTask<PcSpecs> futureTask = new FutureTask<>(new Callable<PcSpecs>() {
            @Override
            public PcSpecs call() {
                PcSpecs f = null;
                IPcSpecsService pcSpecs = ServiceBuilder.buildService(IPcSpecsService.class);
                Call<PcSpecs> request = pcSpecs.getPcSpecsById(id);
                try {
                    f = request.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return f;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        PcSpecs pcSpecs = null;
        try {
            pcSpecs = futureTask.get();// will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }
        return pcSpecs;
    }

    public static PcSpecs addPcSpecs(PcSpecs newPcSpecs) {
        FutureTask<PcSpecs> futureTask = new FutureTask<>(new Callable<PcSpecs>() {
            @Override
            public PcSpecs call() {
                IPcSpecsService pcSpecs = ServiceBuilder.buildService(IPcSpecsService.class);
                Call<PcSpecs> request = pcSpecs.addPcSpecs(newPcSpecs);
                try {
                    Response<PcSpecs> response = request.execute();
                    if (response.isSuccessful() && response.body() != null) {
                        return response.body(); // Execute the POST request in a separate thread
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();

        try {
            return futureTask.get(); // Wait for the asynchronous completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }

        return null; // Handle any errors and return null as needed
    }

    public static PcSpecs updatePcSpecs(int id, PcSpecs updatedPcSpecs) {
        FutureTask<PcSpecs> futureTask = new FutureTask<>(new Callable<PcSpecs>() {
            @Override
            public PcSpecs call() {
                IPcSpecsService pcSpecs = ServiceBuilder.buildService(IPcSpecsService.class);
                Call<PcSpecs> request = pcSpecs.updatePcSpecs(id, updatedPcSpecs);
                try {
                    Response<PcSpecs> response = request.execute();
                    if (response.isSuccessful() && response.body() != null) {
                        return response.body(); // Execute the PUT request in a separate thread
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();

        try {
            return futureTask.get(); // Wait for the asynchronous completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }

        return null; // Handle any errors and return null as needed
    }

    public static PcSpecs deletePcSpecs(int id) {
        FutureTask<PcSpecs> futureTask = new FutureTask<>(new Callable<PcSpecs>() {
            @Override
            public PcSpecs call() {
                IPcSpecsService pcSpecs = ServiceBuilder.buildService(IPcSpecsService.class);
                Call<PcSpecs> request = pcSpecs.deletePcSpecs(id);
                try {
                    Response<PcSpecs> response = request.execute();
                    if (response.isSuccessful() && response.body() != null) {
                        return response.body(); // Execute the DELETE request in a separate thread
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();

        try {
            return futureTask.get(); // Wait for the asynchronous completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }

        return null; // Handle any errors and return null as needed
    }
}
