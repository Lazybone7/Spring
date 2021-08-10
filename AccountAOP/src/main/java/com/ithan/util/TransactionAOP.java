package com.ithan.util;

public class TransactionAOP {

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void beforeTransaction(){
        transactionManager.beginTransaction();
    }

    public void afterReturningTransaction(){
        transactionManager.commit();
    }
    public void afterThrowingTransaction(){
        transactionManager.rollBack();
       // throw new RuntimeException();
    }
    public void afterTransaction(){
        transactionManager.close();
    }
}
