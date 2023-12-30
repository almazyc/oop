class Product
{
    private String name;
    private double price;
    private int quantity;
    private String description;
    public Product(String name, double price, int quantity, String description)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public String getDescription()
    {
        return description;
    }
}