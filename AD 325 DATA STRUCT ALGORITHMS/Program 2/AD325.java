package ad325;

public class AD325 {

    public static void main(String[] args) {
        //randomly generates 100,000 integers into an array
        Util.randomGenerater(100000);
        
        long nanoTime0 = System.nanoTime();
        Util.shellSort();
        long nanoTime1 = System.nanoTime();
        Util.insertionSort();
        long nanoTime2 = System.nanoTime();
        Util.selectionSort();
        long nanoTime3 = System.nanoTime();
        
        //report the timing of the execution of each sort algorithm
        Util.ReportWriter("shellSort", nanoTime1 - nanoTime0);
        Util.ReportWriter("insertionSort", nanoTime2 - nanoTime1);
        Util.ReportWriter("selectionSort", nanoTime3 - nanoTime2);
    }
}
