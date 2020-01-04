package com.ogaclejapan.smarttablayout;

public interface TabsCallback {

    void setCurrentIndex(int i);

    enum State {
        SCROLL_STATE_IDLE,
        SCROLL_STATE_DRAGGING,
        SCROLL_STATE_SETTLING
    }

    int getCurrentIndex();

    TabsAdapter getAdapter();

    void addOnTabChangeListener(OnTabContainerChangeListener tabClickListener);

    public interface OnTabContainerChangeListener {

        public void onContainerScrolled(int position, float positionOffset, int positionOffsetPixels);

        public void onContainerScrollStateChanged(State state);

        public void onContainerSelected(int position);

    }
}
