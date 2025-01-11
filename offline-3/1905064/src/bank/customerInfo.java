package bank;

class customerInfo {

    private int boothNo;
    private int entryTime;
    private int doneTime;
    private int serviceTime;

    public customerInfo(int entryTime, int serviceTime)
    {
        this.entryTime=entryTime;
        this.serviceTime=serviceTime;
    }

    public void setBoothNo(int boothNo) {
        this.boothNo = boothNo;
    }

    public void setDoneTime(int doneTime) {
        this.doneTime = doneTime;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public int getBoothNo() {
        return boothNo;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getDoneTime() {
        return doneTime;
    }

}
