package vnnhnlm.count_view.model;

public class Count {
    private int count;

    public Count() {
    }

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
//    public void increment() {
//        count++;
//    }
    public int increment() {
        return count++;
    }
}
