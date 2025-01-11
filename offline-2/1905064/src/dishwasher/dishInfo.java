package dishwasher;

class dishInfo {
    private int friend_info;
    private int pushing_time;
    private int cleaning_time;
    private int dish_no;
    public dishInfo(int friend_info,int pushing_time, int dish_no)
    {
        this.friend_info=friend_info;
        this.dish_no=dish_no;
        this.pushing_time=pushing_time;
        cleaning_time=-1;
    }

    public int getDish_no() {
        return dish_no;
    }

    public int getFriend_info() {
        return friend_info;
    }

    public int getPushing_time() {
        return pushing_time;
    }

    public int getCleaning_time() {
        if(cleaning_time==-1)
        {
            System.out.println("this dish is yet to be cleaned");
            return -1;
        }
        return cleaning_time;
    }

    public void setCleaning_time(int cleaning_time) {
        this.cleaning_time = cleaning_time;
    }
}
