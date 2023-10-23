package GitHub.Kiosk;


import java.util.*;

public class Menu {
    String Name;
    String Description;
    int sel;
    int check;

    ArrayList<Product> coffeList = new ArrayList<>();
    ArrayList<Product> decafeList = new ArrayList<>();
    ArrayList<Product> beverageList = new ArrayList<>();
    ArrayList<Product> dessertList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Order order = new Order();

    public void setProduct(){
        coffeList.add(new Product("IceAmericano", "향긋한 콜롬비아산 원두로 만든 커피", 4.0));
        coffeList.add(new Product("CafeLatte", "에스프레소와 우유", 4.5));
        coffeList.add(new Product("MocaLatte", "에스프레소와 초콜렛과 우유", 5.0));

        decafeList.add(new Product("decafeIceAmericano", "향긋한 디카페인 원두로 만든 커피", 4.3));
        decafeList.add(new Product("deCafeLatte", "디카페인 에스프레소와 우유", 4.8));
        decafeList.add(new Product("ChocoLatte", "초콜렛과 우유", 5.3));

        beverageList.add(new Product("YogurtSmoothie", "요거트스무디", 3.5));
        beverageList.add(new Product("StrawberrySmoothie", "딸기스무디", 3.5));
        beverageList.add(new Product("MangoSmoothie", "망고스무디", 3.5));

        dessertList.add(new Product("ChocoCake", "초코케이크", 4.0));
        dessertList.add(new Product("Coockie", "쿠키", 2.0));
        dessertList.add(new Product("Macaron", "마카롱", 1.0));
    }

    public void showCategory() {
        setProduct();
        while (true) {
            System.out.println("\"STARBUCKS COFFEE 에 오신걸 환영합니다.\"");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            System.out.println();
            System.out.println("[ STARBUCKS MENU ]");
            System.out.println("1. Coffe                | 칠레산 원두로 만든 커피");
            System.out.println("2. Decaffeinated Coffe  | 카페인 제로 커피");
            System.out.println("3. Beverage             | 에이드, 스무디 등등");
            System.out.println("4. Dessert              | 조각케이크와 쿠키 등");
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("5. Order                | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel               | 진행중인 주문을 취소합니다.");
            System.out.println();

            sel = sc.nextInt();
            selectCategory(sel);
        }
    }

    public void selectCategory(int sel){
            switch (sel) {
                case 1:
                    coffeCategory();
                    break;
                case 2:
                    decafeCategory();
                    break;
                case 3:
                    beverageCategory();
                    break;
                case 4:
                    dessertCategory();
                    break;
                case 5:
                    order.totalOderList();
                    break;
                case 6:
                    order.cancleOrder();
                    break;
                case 0:
                    order.totalSell();
                    break;
                default:
                    System.out.println("1~6숫자를 입력해주세요");
                    System.out.println();
            }
    }

    public void coffeCategory() {
        System.out.println("\"STARBUCKS COFFEE 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Coffee MENU ]");

        for (int i = 0; i < coffeList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-25s",coffeList.get(i).getName());
            System.out.println("  | W " + coffeList.get(i).getPrice() + " | " + coffeList.get(i).getDescription());
        }
        System.out.println();
        sel = sc.nextInt();


        System.out.print("\"");
        System.out.printf("%-25s",coffeList.get(sel-1).getName());
        System.out.println("  | W " + coffeList.get(sel-1).getPrice() + " | " + coffeList.get(sel-1).getDescription()+ "\"");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        check = sc.nextInt();
        if (check == 1){
            order.setOrderList(coffeList.get(sel-1));
            System.out.println(coffeList.get(sel-1).getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();
        }
    }

    public void decafeCategory() {
        System.out.println("\"STARBUCKS COFFEE 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Decafe MENU ]");

        for (int i = 0; i < decafeList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-25s",decafeList.get(i).getName());
            System.out.println("  | W " + decafeList.get(i).getPrice() + " | " + decafeList.get(i).getDescription());
        }
        System.out.println();
        sel = sc.nextInt();

        System.out.print("\"");
        System.out.printf("%-25s",decafeList.get(sel-1).getName());
        System.out.println("  | W " + decafeList.get(sel-1).getPrice() + " | " + decafeList.get(sel-1).getDescription()+ "\"");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        check = sc.nextInt();
        if (check == 1){
            order.setOrderList(decafeList.get(sel-1));
            System.out.println(decafeList.get(sel-1).getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();
        }
    }

    public void beverageCategory() {
        System.out.println("\"STARBUCKS COFFEE 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Beverage MENU ]");

        for (int i = 0; i < beverageList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-25s",beverageList.get(i).getName());
            System.out.println("  | W " + beverageList.get(i).getPrice() + " | " + beverageList.get(i).getDescription());
        }
        System.out.println();
        sel = sc.nextInt();

        System.out.print("\"");
        System.out.printf("%-25s",beverageList.get(sel-1).getName());
        System.out.println("  | W " + beverageList.get(sel-1).getPrice() + " | " + beverageList.get(sel-1).getDescription()+ "\"");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        check = sc.nextInt();
        if (check == 1){
            order.setOrderList(beverageList.get(sel-1));
            System.out.println(beverageList.get(sel-1).getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();
        }
    }

    public void dessertCategory() {
        System.out.println("\"STARBUCKS COFFEE 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Dessert MENU ]");

        for (int i = 0; i < dessertList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-25s",dessertList.get(i).getName());
            System.out.println("  | W " + dessertList.get(i).getPrice() + " | " + dessertList.get(i).getDescription());
        }
        System.out.println();
        sel = sc.nextInt();

        System.out.print("\"");
        System.out.printf("%-25s",dessertList.get(sel-1).getName());
        System.out.println("  | W " + dessertList.get(sel-1).getPrice() + " | " + dessertList.get(sel-1).getDescription()+ "\"");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println();

        check = sc.nextInt();
        if (check == 1){
            order.setOrderList(dessertList.get(sel-1));
            System.out.println(dessertList.get(sel-1).getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
        } else {
            System.out.println("1 혹은 2만 입력해주세요");
            System.out.println();
        }
    }




}
