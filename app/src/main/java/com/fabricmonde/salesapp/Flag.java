package com.fabricmonde.salesapp;


/**
 * @I'm Boo Boo the fool
 * This is beautifull!
 * Flagging Class!
 */

public class Flag {

    boolean boo;

    private ChangeListener listener;

    public  Flag()
    {
        this.boo = false;
    }

    public boolean getBoolean() {
        return boo;
    }

    public void setBoolean(boolean boo) {
        this.boo = boo;
        if (listener != null) listener.onChange(getBoolean());
    }
    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public interface ChangeListener {
        void onChange(boolean bool);
    }
}
