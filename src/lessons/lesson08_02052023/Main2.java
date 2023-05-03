package lessons.lesson08_02052023;

public class Main2 {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        Item[] items = {new Item("Гитара", 1, 1500),
                        new Item("Бензопила",4, 3000),
                        new Item("ноутбук", 3, 2000)};
//        Backpack[][] bp = new Backpack[n+1][m+1];
//        for (int i = 0; i < n+1; i++) {
//            for (int j = 0; j < m+1; j++) {
//                if( i== 0 || j == 0){
//                    bp[i][j] = new Backpack(new Item[]{},0);
//                }else if (i==1){
//                    bp[i][j] = items[0].getWeight() <= j ? new Backpack(new Item[]{items[0]}, items[0].getPrice()) :
//                            new Backpack(new Item[]{}, 0);
//                }else {
//                    if(items[i-1].getWeight()>j){
//                        bp[i][j] = bp[i-1][j];
//                    }else {
//                        int price = items[i-1].getPrice() + bp[i-1][j-items[i-1].getWeight()].getPrice();
//                        if ()
//                    }
//                }
//            }
//        }
    }
}
