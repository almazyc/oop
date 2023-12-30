import java.util.ArrayList;

class OnlineShop
{
    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Order> orderHistory;
    private static final String ADMIN_USERNAME = "almazioandruslanio";
    private static final String ADMIN_PASSWORD = "ifyouhackminus100socgpa";
    private boolean adminLoggedIn;
    public OnlineShop()
    {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.adminLoggedIn = false;
        Product robotTransporter = new Product("Robot transporter T-1", 1245799.99, 40, "A robot that can transport anything");
        Product robotArm = new Product("Robot arm A-1", 755499.99, 160, "A robotic arm for factories");
        Product robotDancer = new Product("Robot dancer D-1", 2575000.99, 5, "A funny robot");
        products.add(robotTransporter);
        products.add(robotArm);
        products.add(robotDancer);
    }
    public void loginAsAdmin(String username, String password)
    {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD))
        {
            adminLoggedIn = true;
            System.out.println("Admin login");
        }
        else
        {
            System.out.println("Try again");
        }
    }
    public ArrayList<User> getUsers()
    {
        return users;
    }
    public ArrayList<Product> getProducts()
    {
        return products;
    }
    public ArrayList<Order> getOrderHistory()
    {
        return orderHistory;
    }
    public void showProductList()
    {
        System.out.println("Product list:");
        for (Product product : products)
        {
            System.out.println("Name: " + product.getName() +
                    ", Price: " + product.getPrice() +
                    ", Quantity: " + product.getQuantity() +
                    ", Description: " + product.getDescription());
        }
    }
    public void replenishBalance(int userId, double amount)
    {
        User user = findUserById(userId);
        if (user != null)
        {
            user.setBalance(user.getBalance() + amount);
            System.out.println("New balance: " + user.getBalance());
        } else
        {
            System.out.println("User not found");
        }
    }
    public void logoutAdmin()
    {
        adminLoggedIn = false;
        System.out.println("Admin logout");
    }
    public boolean isAdminLoggedIn()
    {
        return adminLoggedIn;
    }
    public void addProduct(Product product)
    {
        if (adminLoggedIn)
        {
            products.add(product);
            System.out.println("Product added");
        }
        else
        {
            System.out.println("You are not admin");
        }
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public void buyProduct(int userId, String productName, int quantity)
    {
        User user = findUserById(userId);
        Product product = findProductByName(productName);
        if (user != null && product != null && product.getQuantity() >= quantity)
        {
            double totalSum = product.getPrice() * quantity;

            if (user.getBalance() >= totalSum)
            {
                user.setBalance(user.getBalance() - totalSum);
                updateProductQuantity(product, quantity);
                Order order = new Order(userId, productName, quantity, totalSum);
                user.addOrder(order);
                orderHistory.add(order);
                System.out.println("You have purchased");
            }
            else
            {
                System.out.println("Not enough money");
            }
        }
        else
        {
            System.out.println("Error! Try again");
        }
    }
    public void returnProduct(int userId, String productName, int quantity) {
        User user = findUserById(userId);
        Product product = findProductByName(productName);

        if (user != null && product != null) {
            Order order = findOrder(user, productName, quantity);

            if (order != null && order.getQuantity() >= quantity) {
                double refundAmount = product.getPrice() * quantity;

                user.setBalance(user.getBalance() + refundAmount);
                updateProductQuantity(product, -quantity);

                if (order.getQuantity() > quantity) {
                    order.setQuantity(order.getQuantity() - quantity);
                } else {
                    user.getOrders().remove(order);
                }

                orderHistory.remove(order);

                System.out.println("Returned");
            } else {
                System.out.println("Invalid quantity for return");
            }
        } else {
            System.out.println("User or product not found");
        }
    }
    public void showAllUsers()
    {
        System.out.println("User List:");
        for (User user : users)
        {
            System.out.println("ID: " + user.getId() +
                    ", Name: " + user.getName() +
                    ", Balance: " + user.getBalance() + " Tenge");
        }
    }
    public void showUserOrders(int userId)
    {
        User user = findUserById(userId);
        if (user != null)
        {
            System.out.println("Orders for User " + user.getName() + ":");
            for (Order order : user.getOrders())
            {
                System.out.println("Product: " + order.getProductName() +
                        ", Quantity: " + order.getQuantity() +
                        ", Total Sum: " + order.getTotalSum() + " Tenge");
            }
        }
        else
        {
            System.out.println("We didnt find user!");
        }
    }
    private User findUserById(int userId)
    {
        for (User user : users)
        {
            if (user.getId() == userId)
            {
                return user;
            }
        }
        return null;
    }
    private Product findProductByName(String productName)
    {
        for (Product product : products)
        {
            if (product.getName().equalsIgnoreCase(productName))
            {
                return product;
            }
        }
        return null;
    }
    private Order findOrder(User user, String productName, int quantity) {
        for (Order order : user.getOrders()) {
            if (order.getProductName().equalsIgnoreCase(productName)) {
                return order;
            }
        }
        return null;
    }
    private void updateProductQuantity(Product product, int quantity) {
        product.setQuantity(product.getQuantity() - quantity);
    }
}