package sort;

public class SortContext {
    SortStrategy strategy;

    public SortContext(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public SortStrategy getStrategy(){
        return strategy;
    }

    public int[] sort(int[] arr){
        return strategy.sort(arr.clone());
    }
}
