package stor.src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.time.LocalDate;

public class  Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        Customer theUser = new Customer(
                1000,
                "Moaaz",
                20,
                "Damascus",
                null,
                1000
        );

        Books Book1 = new Books (
                1,
                "Harry-Potter",
                250.4,
                50,
                "J.K.Rowlaing",
                300,
                "It's a magical story"
        );

        Books Book2 = new Books (
                2,
                "Atomic-Habits",
                250.4,
                100,
                "james clear" ,
                300,
                "He talks about habits and their values"
        );

        Books Book3 = new Books (
                3,
                "Rich-Dad-And-Boor-Dad",
                233.4,
                20,
                "Robert T.kiyosaki" ,
                100,
                "He talks about money management"
        );

        Clothes Clothe1 = new Clothes(
                4,
                "T-shirt",
                50.5,
                50,
                "Blue",
                "F",
                5,
                "ZARA"
        );

        Clothes Clothe2 = new Clothes(
                5,
                "Hoodie",
                30.5,
                20,
                "Red",
                "M",
                3,
                "ZARA"
        );

        Clothes Clothe3 = new Clothes(
                6,
                "Shoes",
                70.5,
                15,
                "Black",
                "M",
                43,
                "ZARA"
        );

        Makeup Makeup1 = new Makeup(
                7,
                "Muskrat",
                100.2,
                70,
                "Cartier",
                "For Eyelashes"
        );

        Makeup Makeup2 = new Makeup(
                8,
                "Lipstick",
                90.2,
                20,
                "Cartier",
                "For Lips"
        );

        Makeup Makeup3 = new Makeup(
                9,
                "Nail-polish",
                50.7,
                200,
                "Cartier",
                "For Nails"
        );

        Books bookHeWont1 = new Books();
        Books bookHeWont2 = new Books();
        Books bookHeWont3 = new Books();
        Clothes clothesHeWont1 = new Clothes();
        Clothes clothesHeWont2 = new Clothes();
        Clothes clothesHeWont3 = new Clothes();
        Makeup makeupHeWont1 = new Makeup();
        Makeup makeupHeWont2 = new Makeup();
        Makeup makeupHeWont3 = new Makeup();

        AtomicReference<ArrayList<Books>> BookArrayList= new AtomicReference<>(new ArrayList<>());
        BookArrayList.get().add(Book1);
        BookArrayList.get().add(Book2);
        BookArrayList.get().add(Book3);

        AtomicReference<ArrayList<Clothes>> clotheArrayList = new AtomicReference<>(new ArrayList<>());
        clotheArrayList.get().add(Clothe1);
        clotheArrayList.get().add(Clothe2);
        clotheArrayList.get().add(Clothe3);

        AtomicReference<ArrayList<Makeup>> makeupsArrayList = new AtomicReference<>(new ArrayList<>());
        makeupsArrayList.get().add(Makeup1);
        makeupsArrayList.get().add(Makeup2);
        makeupsArrayList.get().add(Makeup3);

        ArrayList<Products> products = new ArrayList<>();

        products.add(Book1);
        products.add(Book2);
        products.add(Book3);
        products.add(Clothe1);
        products.add(Clothe2);
        products.add(Clothe3);
        products.add(Makeup1);
        products.add(Makeup2);
        products.add(Makeup3);

        ArrayList<Products> bill = new ArrayList<>();

        Bill bill1 = new Bill(
                1,
                theUser.getName(),
                "12/1/2024",
                null,
                0
        );

        int quantityBook1 = 0, quantityBook2 = 0, quantityBook3 = 0,
            quantityClothe1 = 0, quantityClothe2 = 0, quantityClothe3 = 0,
            quantityMakeup1 = 0, quantityMakeup2 = 0, quantityMakeup3 = 0;
        double pricesBook1 = 0.0 ,pricesBook2 = 0.0,pricesBook3 = 0.0,
               pricesClothe1 = 0.0 ,pricesClothe2 = 0.0,pricesClothe3 = 0.0,
               pricesMakeup1 = 0.0 ,pricesMakeup2 = 0.0 , pricesMakeup3 = 0.0;


        ArrayList<Products> theExpensive = new ArrayList<>();

        products.sort((p1, p2) -> (int) (p1.getPrice() - p2.getPrice())); // for chat GPT

        ArrayList<Products> theCheapest = new ArrayList<>(products); //for chat GPT to show products cheapest

        for (int i = theCheapest.size() - 1; i >= 0; i--) {
            theExpensive.add(theCheapest.get(i));
        }

        for( ; ; ) {

            int theListHeChose = 0;
            boolean validInput = true;

            do {
                validInput = false;
                try {
                    System.out.println(
                            "The amount of money you have is = "+ theUser.getBalance()+'\n'+
                            "Please choose a number :\n"+
                            "1 for show products :\n"+
                            "2 for search : \n"+
                            "3 In order from the most expensive to the cheapest :\n"+
                            "4 In order from the cheapest to the most expensive :\n"+
                            "5 To add money to your account :\n"+
                            "6 for exit :\n"
                    );

                    theListHeChose = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println(
                            "\nInvalid input. Please enter a number: \n"
                    );
                    scanner.next();
                    validInput = true;
                }
            } while (validInput);

            switch (theListHeChose) {
                case 1 -> {
                    products.forEach(System.out::println);

                    for (; ; ) {

                        int theIdHeChose = 0;
                        validInput = true;
                        do {
                            validInput = false;
                            try {
                                System.out.println(
                                        """
                                        \nEnter the ID of the product you want :\s
                                        if you Finished Enter : 10
                                        """
                                );
                                theIdHeChose = scanner.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println(
                                        "\nEnter the id number only : \n"
                                );
                                scanner.next();
                                validInput = true;
                            }
                        }while (validInput);
                        if( theIdHeChose == 10 ){
                            break;
                        }

                        int Quantity = 0 ;
                        do {
                            validInput = false;
                            try {
                                System.out.println(
                                        "\n Enter the amount you want : "
                                );
                                Quantity = scanner.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println(
                                        "\nPlease enter the quantity number\n"
                                );
                                scanner.next();
                                validInput = true;
                            }
                        }while (validInput);
                        if (theIdHeChose == Book1.getId()) {
                            quantityBook1 = Quantity ;
                            bookHeWont1 = Book1;
                            bookHeWont1.setQuantity(quantityBook1);
                            bookHeWont1.setPrice(quantityBook1*Book1.getPrice());
                            bill.add(bookHeWont1);
                        } else if (theIdHeChose == Book2.getId()) {
                            quantityBook2 = Quantity ;
                            bookHeWont2 = Book1;
                            bookHeWont2.setQuantity(quantityBook2);
                            bookHeWont2.setPrice(quantityBook2*Book2.getPrice());
                            bill.add(bookHeWont2);
                        } else if (theIdHeChose == Book3.getId()) {
                            quantityBook3 = Quantity ;
                            bookHeWont3 = Book1;
                            bookHeWont3.setQuantity(quantityBook3);
                            bookHeWont3.setPrice(quantityBook3*Book3.getPrice());
                            bill.add(bookHeWont3);

                        } else if (theIdHeChose == Clothe1.getId()) {
                            quantityClothe1 = Quantity ;
                            clothesHeWont1 = Clothe1;
                            clothesHeWont1.setQuantity(quantityClothe1);
                            clothesHeWont1.setPrice(quantityClothe1*Clothe1.getPrice());
                            bill.add(clothesHeWont1);

                        } else if (theIdHeChose == Clothe2.getId()) {
                            quantityClothe2 = Quantity ;
                            clothesHeWont2 = Clothe2;
                            clothesHeWont2.setQuantity(quantityClothe2);
                            clothesHeWont2.setPrice(quantityClothe2*Clothe2.getPrice());
                            bill.add(clothesHeWont2);
                        } else if (theIdHeChose == Clothe3.getId()) {
                            quantityClothe3 = Quantity ;
                            clothesHeWont3 = Clothe3;
                            clothesHeWont3.setQuantity(quantityClothe3);
                            clothesHeWont3.setPrice(quantityClothe3*Clothe3.getPrice());
                            bill.add(clothesHeWont3);
                        } else if (theIdHeChose == Makeup1.getId()) {
                            quantityMakeup1 = Quantity ;
                            makeupHeWont1 = Makeup1;
                            makeupHeWont1.setQuantity(quantityMakeup1);
                            makeupHeWont1.setPrice(quantityMakeup1*Makeup1.getPrice());
                            bill.add(makeupHeWont1);
                        } else if (theIdHeChose == Makeup2.getId()) {
                            quantityMakeup2 = Quantity ;
                            makeupHeWont2 = Makeup2;
                            makeupHeWont2.setQuantity(quantityMakeup2);
                            makeupHeWont2.setPrice(quantityMakeup2*Makeup2.getPrice());
                            bill.add(makeupHeWont2);
                        } else if (theIdHeChose == Makeup3.getId()) {
                            quantityMakeup3 = Quantity ;
                            makeupHeWont3 = Makeup3;
                            makeupHeWont3.setQuantity(quantityMakeup3);
                            makeupHeWont3.setPrice(quantityMakeup3*Makeup3.getPrice());
                            bill.add(makeupHeWont3);
                        } else {
                            System.out.println(
                                    " none of products !! "
                            );
                            continue;
                        }

                    }//for

                    double totalPrice = 0.0;

                    for (Products value : bill) {totalPrice += value.getPrice();}
                    bill1.setTotalPrice(totalPrice);
                    bill1.setProducts(bill);
                    break;

                }//case1
                case 2 -> {

                    for (; ; ) {
                        int theVarietyHeChose = 0;
                        validInput = true;
                        do {
                            validInput = false;
                            try {
                                System.out.println(
                                        """
                                        If you want to search for a book enter 1 :\s
                                        If you want to search for a clothes enter 2 :\s
                                        If you want to search for a makeup enter 3 :\s
                                        """
                                );
                                theVarietyHeChose = scanner.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println(
                                        "\nJust enter a number\n"
                                );
                                scanner.next();
                                validInput = true;
                            }

                        }while (validInput);

                        switch (theVarietyHeChose) {
                            case 1 -> {
                                System.out.println(
                                        "Enter the name of the book : "
                                );
                                String serBook = scanner.next();
                                if (Book1.getName().equals(serBook)) {

                                    int b = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Book1 +
                                                    "\nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            b = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }

                                    }while (validInput);
                                    if (b == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }

                                        }while (validInput);

                                        quantityBook1 = Quantity ;
                                        bookHeWont1 = Book1;
                                        bookHeWont1.setQuantity(quantityBook1);
                                        bookHeWont1.setPrice(quantityBook1*Book1.getPrice());
                                        bill.add(bookHeWont1);

                                    } else if (b == 2) {
                                        continue;
                                    }

                                } else if (Book2.getName().equals(serBook)) {
                                    int bb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Book2 +
                                                    "\nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "

                                            );
                                            bb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);

                                    if (bb == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);

                                        quantityBook2 = Quantity ;
                                        bookHeWont2 = Book1;
                                        bookHeWont2.setQuantity(quantityBook2);
                                        bookHeWont2.setPrice(quantityBook2*Book2.getPrice());
                                        bill.add(bookHeWont2);
                                    } else if (bb == 2) {
                                        continue;
                                    }

                                } else if (Book3.getName().equals(serBook)) {

                                    int bbb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Book3 +
                                                    " \nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            bbb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }

                                    }while (validInput);

                                    if (bbb == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);

                                        quantityBook3 = Quantity ;
                                        bookHeWont3 = Book1;
                                        bookHeWont3.setQuantity(quantityBook3);
                                        bookHeWont3.setPrice(quantityBook3*Book3.getPrice());
                                        bill.add(bookHeWont3);
                                    } else if (bbb == 2) {
                                        continue;
                                    }
                                } else {
                                    System.out.println(
                                            "There is no book by that name !! "
                                    );
                                }
                            }//case 1
                            case 2 -> {
                                System.out.println(
                                        " Enter name of clothes : "
                                );
                                String serClothes = scanner.next();
                                if (Clothe1.getName().equals(serClothes)) {

                                    int b = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Clothe1 +
                                                    "\nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            b = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);

                                    if (b == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);

                                        quantityClothe1 = Quantity ;
                                        clothesHeWont1 = Clothe1;
                                        clothesHeWont1.setQuantity(quantityClothe1);
                                        clothesHeWont1.setPrice(quantityClothe1*Clothe1.getPrice());
                                        bill.add(clothesHeWont1);
                                    } else if (b == 2) {
                                        continue;
                                    }

                                } else if (Clothe2.getName().equals(serClothes)) {
                                    int bb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Clothe2 +
                                                    "\nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            bb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);

                                    if (bb == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);

                                        quantityClothe2 = Quantity ;
                                        clothesHeWont2 = Clothe2;
                                        clothesHeWont2.setQuantity(quantityClothe2);
                                        clothesHeWont2.setPrice(quantityClothe2*Clothe2.getPrice());
                                        bill.add(clothesHeWont2);
                                    } else if (bb == 2) {
                                        continue;
                                    }

                                } else if (Clothe3.getName().equals(serClothes)) {

                                    int bbb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Clothe3 +
                                                    "\nIf you want to add it to the bill Enter 1 " +
                                                    "If you want to go back to the search Enter 2 \n"

                                            );
                                            bbb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);
                                    if (bbb == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);

                                        quantityClothe3 = Quantity ;
                                        clothesHeWont3 = Clothe3;
                                        clothesHeWont3.setQuantity(quantityClothe3);
                                        clothesHeWont3.setPrice(quantityClothe3*Clothe3.getPrice());
                                        bill.add(clothesHeWont3);
                                    } else if (bbb == 2) {
                                        continue;
                                    }
                                } else {
                                    System.out.println(
                                            "There is no clothe by that name !! "
                                    );
                                }

                            }//case 2

                            case 3 -> {
                                System.out.println(
                                        "Enter name of makeup : "
                                );
                                String serMakeup = scanner.next();
                                if (Makeup1.getName().equals(serMakeup)) {

                                    int b = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Makeup1 +
                                                    "\nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            b = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }

                                    }while (validInput);

                                    if (b == 1) {
                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);
                                        quantityMakeup1 = Quantity ;
                                        makeupHeWont1 = Makeup1;
                                        makeupHeWont1.setQuantity(quantityMakeup1);
                                        makeupHeWont1.setPrice(quantityMakeup1*Makeup1.getPrice());
                                        bill.add(makeupHeWont1);
                                    } else if (b == 2) {
                                        continue;
                                    }
                                } else if (Makeup2.getName().equals(serMakeup)) {

                                    int bb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Makeup2 +
                                                    " \nIf you want to add it to the bill Enter 1 \n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            bb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);

                                    if (bb == 1) {

                                        int Quantity = 0;
                                        validInput = true;
                                        do {
                                            validInput = false;
                                            try {
                                                System.out.println(
                                                        "Enter the amount you want : "
                                                );
                                                Quantity = scanner.nextInt();
                                            }catch (InputMismatchException e){
                                                System.out.println(
                                                        "\nPlease enter the quantity number\n"
                                                );
                                                scanner.next();
                                            }
                                        }while (validInput);
                                        quantityMakeup2 = Quantity ;
                                        makeupHeWont2 = Makeup2;
                                        makeupHeWont2.setQuantity(quantityMakeup2);
                                        makeupHeWont2.setPrice(quantityMakeup2*Makeup2.getPrice());
                                        bill.add(makeupHeWont2);
                                    } else if (bb == 2) {
                                        continue;
                                    }
                                } else if (Makeup3.getName().equals(serMakeup)) {

                                    int bbb = 0;
                                    validInput = true;
                                    do {
                                        validInput = false;
                                        try {
                                            System.out.println(
                                                    Makeup3 +
                                                    " \nIf you want to add it to the bill Enter 1\n" +
                                                    "If you want to go back to the search Enter 2 "
                                            );
                                            bbb = scanner.nextInt();
                                        }catch (InputMismatchException ee ){
                                            System.out.println(
                                                    "\nJust enter a number 1 or 2\n"
                                            );
                                            scanner.next();
                                            validInput = true;
                                        }
                                    }while (validInput);

                                    if (bbb == 1) {
                                        System.out.println(
                                                "Enter the amount you want : "
                                        );
                                        int Quantity = scanner.nextInt();
                                        quantityMakeup3 = Quantity ;
                                        makeupHeWont3 = Makeup3;
                                        makeupHeWont3.setQuantity(quantityMakeup3);
                                        makeupHeWont3.setPrice(quantityMakeup3*Makeup3.getPrice());
                                        bill.add(makeupHeWont3);
                                    } else if (bbb == 2) {
                                        continue;

                                    }
                                } else {
                                    System.out.println(
                                            "There is no makeup by that name !! "
                                    );

                                }

                            }//case 3

                        }//switch

                        int c = 0;
                        validInput = true;
                        do {
                            validInput = false;
                            try {
                                System.out.println(
                                        """
                                        if you 
                                        if you wont more Enter 1\s
                                        If you want to go to the bill Enter 2\s
                                        """
                                );
                                c = scanner.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println(
                                        "\nJust enter a number 1 or 2\n"
                                );
                            scanner.next();
                            validInput =true;
                            }
                        }while (validInput);

                        if (c == 1) {
                            continue ;
                        } else if (c == 2) {
                            break;
                        } else {
                            System.out.println(
                                    "Wrong"
                            );
                            System.exit(0);
                            break;
                        }
                    }//for
                    double totalPrice = 0.0;

                    for (Products value : bill) {
                        totalPrice += value.getPrice();
                    }

                    bill1.setTotalPrice(totalPrice);
                    bill1.setProducts(bill);

                    break;
                } //case 2
                case 3 -> {
                    theExpensive.forEach(System.out::println);
                    System.out.println(
                            "to back to menu Enter 1 : \n" +
                            "To exit, press a random number"
                    );
                    int yo = scanner.nextInt();

                    if (yo == 1) {
                        continue;
                    } else {
                        System.exit(0);
                    }
                }//case 3
                case 4 -> {
                    theCheapest.forEach(System.out::println);
                    System.out.println(
                            "to back to menu Enter 1 : \n" +
                            "To exit, press a random number");
                    int yo = scanner.nextInt();

                    if (yo == 1) {
                        continue;
                    } else {
                        System.exit(0);
                    }
                }//case 4
                case 5 -> {

                    double amountAdded =0.0;
                    validInput = true;
                    do {
                        validInput = false;
                        try {
                            System.out.println(
                                    " Enter the amount you would like to add : "
                            );
                            amountAdded = scanner.nextDouble();
                        }catch (InputMismatchException e) {
                            System.out.println(
                                    "\nPlease enter a number\n"
                            );
                            scanner.next();
                            validInput = true;
                        }
                    }while (validInput);

                    double a = theUser.getBalance();
                    theUser.setBalance(a + amountAdded);

                    continue;

                }//case 5
                case 6 -> {
                    System.out.println(
                            "GOOD BYE  (; (; (; "
                    );

                    System.exit(0);
                    break;
                }//case 6
                default -> {
                    continue;
                }
            }//switch

            int Finch = 0 ;
            validInput = true;
            do {
                validInput = false;
                try {
                    System.out.println(
                            "if you wont to bay more Enter 1 :\n"+
                            "if you wont to show Bill Enter 2 :"
                    );
                    Finch = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println(
                            "\nJust enter a number 1 or 2\n"
                    );
                    scanner.next();
                    validInput = true;
                }
            }while (validInput);

            if (Finch == 1 )
                continue;
            else if (Finch == 2 )
                break;
            else {
                System.out.println(
                        "Wrong"
                );
                System.exit(0);
            }
        }//for

        if (theUser.getBalance() > bill1.getTotalPrice()){
            String filePath = "D:\\111\\Bill.txt";
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write("Bill ID: " + bill1.getId() + "\n");
                writer.write("Customer Name: " + bill1.getCustomerName() + "\n");
                writer.write("Date: " + date + "\n");
                writer.write("Total Price: " + bill1.getTotalPrice() + "\n");
                writer.write("\nProducts:\n");
                for (Products product : bill1.getProducts()) {
                    writer.write(product.toString() + "\n");
                }

                System.out.println(
                        "Bill details have been written to: " +
                        filePath
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(
                    "You don't have enough cash :(  !! "
            );
            System.exit(0);
        }//else

        saveProductsToFile(products, "D:\\111\\products.txt");
    }//main

    public static void saveProductsToFile(ArrayList<Products> products, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Products product : products) {
                writer.write(product.toString() + "\n\n");
            }
            System.out.println(
                    "Product details have been written to: " +
                    filePath
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//saveProductsToFile

}