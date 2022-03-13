package com.cest.threadpool.mythreadpool;

public interface DenyPolicy {

    /**
     *
     * @Title reject
     * @param runnable
     * @Description 拒绝策略方法
     * @throws
     */
    void reject(Runnable runnable,Threadpool threadpool);

    class DiscardDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, Threadpool threadPoolP) {
            // TODO Auto-generated method stub
            System.out.println(" DiscardDenyPolicyP 直接放弃任务");
        }

    }

    class AbortDenyPolicyP implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, Threadpool threadPoolP) {
            System.out.println("AbortDenyPolicyP  队列已满，添加任务失败");
            throw new RunnableDenyException("队列已满，添加任务失败");
        }

    }

    class RunnerDenyPolicyP implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, Threadpool threadPoolP) {
            if(!threadPoolP.isShutdown()) {
                System.out.println("RunnerDenyPolicyP 在提交者的线程中执行");
                runnable.run();
            }
        }
    }
}
