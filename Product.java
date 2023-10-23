package GitHub.Kiosk;



public class Product extends Menu{
    double Price;



    public Product(String Name, String Description, double Price){
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
    }





    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return Price;
    }




}
