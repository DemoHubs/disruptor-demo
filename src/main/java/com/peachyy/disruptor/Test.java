package com.peachyy.disruptor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Xs.Tao
 */
public class Test {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
        for(int i=0;i<5;i++){
            final int cc=i;
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                        System.out.println("执行了"+cc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();



        }
    }
}
