package lessons.lesson08_02052023;

public class Backpack {
    private Item[] items;
    private int price;

    public Backpack(Item[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public Item[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }
    public String getDescription(){
        if (items == null || items.length ==0){
            return  "";
        }
        String s = "";
        for (int i = 0; i<items.length; i++){
            s = s + ", "+ items[i].getName()+ " - "+items[i].getPrice();
        }
        return s;
    }
}
