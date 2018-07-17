package com.zhxh.xhandler.simulation;

import java.util.Random;

/**
 * Created by zhxh on 2018/4/19.
 */

public class Simulator implements Runnable {

    private PostOffice mPostOffice;
    private Client.ClientCallback mCallback;
    private Random mRandom;
    private Thread mThread;
    private boolean controller;

    public Simulator(PostOffice postOffice, Client.ClientCallback callback) {
        mPostOffice = postOffice;
        mCallback = callback;
        mRandom = new Random(System.currentTimeMillis());
        mThread = new Thread(this);
        controller = true;
    }

    public Simulator createClients(int num) {
        for (int i = 0; i < num; i++) {
            try {
                mPostOffice.register(new Client("BOT " + i, mCallback));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public synchronized void start() {
        if (!mThread.isAlive())
            mThread.start();
    }

    @Override
    public void run() {
        controller = true;
        while (controller) {

            int client1Id = mRandom.nextInt(Client.sClientMap.size());
            int client2Id = mRandom.nextInt(Client.sClientMap.size());
            while (client1Id == client2Id) {
                client2Id = mRandom.nextInt(Client.sClientMap.size());
            }

            try {
                mPostOffice.sendPost(new PostData(client1Id, client2Id, getRandomMessage()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getRandomMessage() {
        int val = mRandom.nextInt(10);

        switch (val) {
            case 0:
                return "吃饭了吗!";
            case 1:
                return "我吃了要请客吗";
            case 2:
                return "呵呵!";
            case 3:
                return "那我请你吧";
            case 4:
                return "真的?";
            case 5:
                return "真的!";
            case 6:
                return "开心!";
            case 7:
                return "开玩笑的!";
            case 8:
                return "我去";
            case 9:
                return "哈哈";
            default:
                return "呵呵";
        }
    }

    public void stop() {
        controller = false;
        Client.disposeAll();
    }
}
