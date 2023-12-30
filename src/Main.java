import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        OnlineShop onlineShop = new OnlineShop();
        while(true) {
            System.out.println(" _    _      _                              _            _____ _   _     __   _______               _           _   _          _ \n" +
                    "| |  | |    | |                            | |          |  _  | \\ | |    \\ \\ / /  _  |             | |         | | (_)        | |\n" +
                    "| |  | | ___| | ___ ___  _ __ ___   ___    | |_ ___     | | | |  \\| |_____\\ V /| | | |    _ __ ___ | |__   ___ | |_ _  ___ ___| |\n" +
                    "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\    | | | | . ` |______\\ / | | | |   | '__/ _ \\| '_ \\ / _ \\| __| |/ __/ __| |\n" +
                    "\\  /\\  /  __/ | (_| (_) | | | | | |  __/   | || (_) |   \\ \\_/ / |\\  |      | | \\ \\_/ /   | | | (_) | |_) | (_) | |_| | (__\\__ \\_|\n" +
                    " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/     \\___/\\_| \\_/      \\_/  \\___/    |_|  \\___/|_.__/ \\___/ \\__|_|\\___|___(_)\n");
            System.out.println("List of available options:");
            System.out.println("1) Show product list / Purchace products");
            System.out.println("2) Add new users");
            System.out.println("3) Show all users");
            System.out.println("4) Show user's orders");
            System.out.println("5) Return products");
            System.out.println("6) Top up balance");
            System.out.println("7) About project");
            System.out.println("List of admin options:");
            System.out.println("8) Login or logout as admin");
            System.out.println("9) Add new products");
            System.out.print("\n" + "Enter choice (1-9, 0 to exit): ");

            int choice = scanner.nextInt();
            int choice2;
            scanner.nextLine();
            switch (choice) {

                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;

                case 1:
                    onlineShop.showProductList();

                    while(true) {
                        System.out.print("\n" + "Enter choice (2 to purchase, 1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 2) {
                            System.out.print("Enter user ID: ");
                            int userIdBuy = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter product name: ");
                            String productNameBuy = scanner.nextLine();
                            System.out.print("Enter quantitt: ");
                            int quantityBuy = scanner.nextInt();
                            onlineShop.buyProduct(userIdBuy, productNameBuy, quantityBuy);

                            while(true) {
                                System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                                choice2 = scanner.nextInt();
                                if (choice2 == 1) {
                                    break;
                                }
                                else if (choice2 == 0) {
                                    System.out.println("Goodbye");
                                    System.exit(0);
                                    break;
                                }
                                else{
                                    System.out.println("Invalid choice");
                                }
                            }
                        break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter user balance: ");
                    double userBalance = scanner.nextDouble();
                    //scanner.nextLine();
                    User newUser = new User(onlineShop.getUsers().size() + 1, userName, userBalance);
                    onlineShop.addUser(newUser);
                    System.out.println("User added, check list to find your ID");

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                    break;

                case 3:
                    onlineShop.showAllUsers();

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    int userIdOrders = scanner.nextInt();
                    onlineShop.showUserOrders(userIdOrders);

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                case 5:
                    System.out.print("Enter user ID: ");
                    int userIdReturn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productNameReturn = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantityReturn = scanner.nextInt();
                    onlineShop.returnProduct(userIdReturn, productNameReturn, quantityReturn);

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                case 6:
                    System.out.print("Enter user ID to replenish balance: ");
                    int userIdReplenish = scanner.nextInt();
                    System.out.print("Enter the amount to replenish: ");
                    double replenishAmount = scanner.nextDouble();
                    onlineShop.replenishBalance(userIdReplenish, replenishAmount);

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                case 7:
                    System.out.println(" _____ _   _     __   _______               _           _   _          \n" +
                            "|  _  | \\ | |    \\ \\ / /  _  |             | |         | | (_)         \n" +
                            "| | | |  \\| |_____\\ V /| | | |    _ __ ___ | |__   ___ | |_ _  ___ ___ \n" +
                            "| | | | . ` |______\\ / | | | |   | '__/ _ \\| '_ \\ / _ \\| __| |/ __/ __|\n" +
                            "\\ \\_/ / |\\  |      | | \\ \\_/ /   | | | (_) | |_) | (_) | |_| | (__\\__ \\\n" +
                            " \\___/\\_| \\_/      \\_/  \\___/    |_|  \\___/|_.__/ \\___/ \\__|_|\\___|___/\n" +
                            "                                                                       \n" +
                            "                                                                       \nis an innovative startup at the forefront of the autonomous delivery revolution, transforming the local delivery landscape with commercial service robots.\n" +
                            " → Our mission is to redefine how people receive their groceries, food takeaways, and packages. \n → Operating across all regions of Kazakhstan, ON-YO Robotics is changing the way you experience convenience and efficiency. Receive the seamless, futuristic, and eco-conscious delivery services with ON-YO Robotics.");

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                    break;

                case 8:
                    if (onlineShop.isAdminLoggedIn()) {
                        onlineShop.logoutAdmin();
                    } else {
                        System.out.print("Enter admin login: ");
                        String adminUsername = scanner.next();
                        System.out.print("Enter admin password: ");
                        String adminPassword = scanner.next();
                        onlineShop.loginAsAdmin(adminUsername, adminPassword);
                    }

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                case 9:
                    if (onlineShop.isAdminLoggedIn()) {
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double productPrice = scanner.nextDouble();
                        System.out.print("Enter product quantity: ");
                        int productQuantity = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter product description: ");
                        String productDescription = scanner.nextLine();
                        Product newProduct = new Product(productName, productPrice, productQuantity, productDescription);
                        onlineShop.addProduct(newProduct);
                    }
                    else {
                        System.out.println("You are not admin");
                    }

                    while(true) {
                        System.out.print("\n" + "Enter choice (1 to go back, 0 to exit): ");
                        choice2 = scanner.nextInt();
                        if (choice2 == 1) {
                            break;
                        }
                        else if (choice2 == 0) {
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        }
                        else{
                            System.out.println("Invalid choice");
                        }
                    }
                break;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
